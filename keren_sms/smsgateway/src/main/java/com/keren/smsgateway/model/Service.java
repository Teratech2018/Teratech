/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import com.keren.smsgateway.balancing.LoadBalancer;
import com.keren.smsgateway.balancing.RoundRobinLoadBalancer;
import com.keren.smsgateway.helper.Logger;
import com.keren.smsgateway.model.AGateway.GatewayStatuses;
import com.keren.smsgateway.model.InboundMessage.MessageClasses;
import com.keren.smsgateway.model.OutboundMessage.FailureCauses;
import com.keren.smsgateway.model.OutboundMessage.MessageStatuses;
import com.keren.smsgateway.routing.Router;
import com.keren.smsgateway.scheduler.ASchedulerTask;
import com.keren.smsgateway.scheduler.Scheduler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.smslib.GatewayException;
import org.smslib.crypto.KeyManager;


/**
 *This is main library class. Your primary interface with SMSLib is via methods
 * defined in this class.
 * @author BEKO
 */
public class Service {
    public enum ServiceStatus
	{
		STARTED, STOPPED
	}

	private Logger logger;

	private List<AGateway> gatewayList;

	private Router router;

	private LoadBalancer loadBalancer;

	private WatchDog watchDog;

	private Scheduler scheduler;

	private IInboundMessageNotification inboundNotification;

	private IOutboundMessageNotification outboundNotification;

	private ICallNotification callNotification;

	private IGatewayStatusNotification gatewayStatusNotification;

	private IQueueSendingNotification queueSendingNotification;

	protected QueueManager queueManager;

	private long startMillis;

	private Collection<Group> groups;

	private volatile ServiceStatus serviceStatus;

	private KeyManager keyManager;

	/**
	 * Configuration settings.
	 * 
	 * @see Settings
	 */
	private Settings S;

	/**
	 * Default Service constructor. Will set SMSLib to use its own logger.
	 */
	public Service()
	{
		setSettings(new Settings());
		logger = new Logger(getSettings()) ;
		initializeService();
	}

	/**
	 * Service constructor. Will set SMSLib to use the provided log4j logger.
	 * 
	 * @param myLogger
	 *            A ready Apache log4j object to use.
	 */
	public Service(org.slf4j.Logger myLogger)
	{
		setSettings(new Settings());
		logger = new Logger(myLogger);
		initializeService();
	}

	protected void initializeService()
	{
		startMillis = System.currentTimeMillis();
		setServiceStatus(ServiceStatus.STOPPED);
		groups = new ArrayList<Group>();
		listSystemInformation();
		gatewayList = new ArrayList<AGateway>();
		keyManager = KeyManager.getInstance();
		setRouter(new Router(this));
		setLoadBalancer(new RoundRobinLoadBalancer(this));
		setWatchDog(new WatchDog("WatchDog", this));
		setQueueManager(new QueueManager(this));
	}

	private void listSystemInformation()
	{
		getLogger().logInfo(Library.getLibraryDescription(), null, null);
		getLogger().logInfo("Version: " + Library.getLibraryVersion(), null, null);
		getLogger().logInfo("JRE Version: " + System.getProperty("java.version"), null, null);
		getLogger().logInfo("JRE Impl Version: " + System.getProperty("java.vm.version"), null, null);
		getLogger().logInfo("O/S: " + System.getProperty("os.name") + " / " + System.getProperty("os.arch") + " / " + System.getProperty("os.version"), null, null);
	}

	/**
	 * Returns the logger used by SMSLib.
	 * 
	 * @return The logger in use.
	 */
	public Logger getLogger()
	{
		return logger;
	}

	/**
	 * Adds a gateway to the list of gateways managed by the Service class. The
	 * Service should be stopped in order to add gateways.
	 * 
	 * @param gateway
	 *            The gateway to be added.
	 * @throws GatewayException
	 *             You tried to add a gateway while the Service is started.
	 * @see #getGateways()
	 */
	public void addGateway(AGateway gateway) throws GatewayException
	{
		if (getServiceStatus() == ServiceStatus.STARTED) throw new GatewayException("Cannot add gateway while Service is running!");
		gateway.setService(this);
		getGateways().add(gateway);
	}

	/**
	 * Initializes all gateways. This should be the first call before you use
	 * the Service class for sending/receiving messages. The call will try to
	 * start all defined gateways.
	 * 
	 * @throws SMSLibException
	 *             No Gateways are defined.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #stopService()
	 */
	public synchronized void startService() throws SMSLibException, TimeoutException, GatewayException, IOException, InterruptedException, com.keren.smsgateway.model.TimeoutException
	{
		setServiceStatus(ServiceStatus.STARTED);
		scheduler = new Scheduler(this, getLogger(), getGateways().size() * 5);
		getScheduler().scheduleAtFixedRate(getWatchDog(), getSettings().WATCHDOG_INTERVAL, getSettings().WATCHDOG_INTERVAL, TimeUnit.SECONDS);
		getWatchDog().enable();
		startService(true);
	}

	/**
	 * Initializes all gateways. This should be the first call before you use
	 * the Service class for sending/receiving messages. The call will try to
	 * start all or some of the defined gateways, depending on the parameter.
	 * 
	 * @param startAll
	 *            True if it is imperative that all defined gateways start
	 *            without errors. False if some gateways are allowed to fail
	 *            during startup.
	 * @throws SMSLibException
	 *             No Gateways are defined.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #stopService()
	 */
	public synchronized void startService(boolean startAll) throws SMSLibException, TimeoutException, GatewayException, IOException, InterruptedException, com.keren.smsgateway.model.TimeoutException
	{
		class ExceptionPair
		{
			public Throwable e;

			public AGateway src;
		}
		class Starter extends Thread
		{
			AGateway gateway;

			List<ExceptionPair> eList;

			List<AGateway> gList;

			public Starter(AGateway gateway, List<ExceptionPair> eList, List<AGateway> gList)
			{
				this.gateway = gateway;
				this.eList = eList;
				this.gList = gList;
			}

			@Override
			public void run()
			{
				try
				{
					gateway.startGateway();
					gList.add(gateway);
				}
				catch (Exception e)
				{
					ExceptionPair exc = new ExceptionPair();
					exc.e = e;
					exc.src = gateway;
					eList.add(exc);
				}
			}
		}
		if (getSettings().CONCURRENT_GATEWAY_START)
		{
			List<ExceptionPair> eList;
			List<AGateway> gList;
			eList = new LinkedList<ExceptionPair>();
			gList = new LinkedList<AGateway>();
			if (getGateways().size() == 0) throw new SMSLibException("No gateways are defined.");
			for (AGateway gateway : getGateways())
				new Starter(gateway, eList, gList).start();
			while ((gList.size() != getGateways().size()) && (eList.size() == 0))
				Thread.sleep(1000);
			for (ExceptionPair e : eList)
				e.src.setStatus(GatewayStatuses.RESTART);
			if (startAll)
			{
				if (eList.size() != 0)
				{
					ExceptionPair e = eList.get(0);
					if (e.e instanceof TimeoutException) throw (TimeoutException) e.e;
					if (e.e instanceof GatewayException) throw (GatewayException) e.e;
					if (e.e instanceof SMSLibException) throw (SMSLibException) e.e;
					if (e.e instanceof IOException) throw (IOException) e.e;
					if (e.e instanceof InterruptedException) throw (InterruptedException) e.e;
				}
				else
				{
					eList.clear();
					gList.clear();
				}
			}
		}
		else
		{
			if (getGateways().size() == 0) throw new SMSLibException("No gateways are defined.");
			for (AGateway gateway : getGateways())
				gateway.startGateway();
		}
	}

	/**
	 * Stops all gateways - does not remove them from Service's internal list.
	 * Once stopped, all SMSLib operations will fail. You need to start the
	 * gateways again before proceeding.
	 * 
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #startService()
	 */
	public synchronized void stopService() throws TimeoutException, GatewayException, IOException, InterruptedException, com.keren.smsgateway.model.TimeoutException
	{
		setServiceStatus(ServiceStatus.STOPPED);
		if (getScheduler() != null)
		{
			if (getWatchDog() != null) getScheduler().remove(getWatchDog());
		}
		for (AGateway gateway : getGateways())
			gateway.stopGateway();
		if (getScheduler() != null) getScheduler().shutdown();
	}

	/**
	 * Reads inbound messages from ALL gateways with the Inbound attribute set.
	 * When successful, the message list will contain all messages read.
	 * 
	 * @param msgList
	 *            A (probably empty) list that will be populated with Inbound
	 *            messages read.
	 * @param msgClass
	 *            Filtering: Class of messages that need to be read.
	 * @return The number of messages read.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see MessageClasses
	 */
	public int readMessages(Collection<InboundMessage> msgList, MessageClasses msgClass) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		for (AGateway gateway : getGateways())
		{
			if (gateway.isInbound())
			{
				try
				{
					readMessages(msgList, msgClass, gateway);
				}
				catch (TimeoutException e)
				{
					getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
					gateway.setStatus(GatewayStatuses.RESTART);
				}
				catch (IOException e)
				{
					getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
					gateway.setStatus(GatewayStatuses.RESTART);
				}
			}
		}
		return msgList.size();
	}

	/**
	 * .NET bridge method.
	 */
	public InboundMessage[] readMessages(MessageClasses msgClass) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		ArrayList<InboundMessage> messageList = new ArrayList<InboundMessage>();
		readMessages(messageList, msgClass);
		return messageList.toArray(new InboundMessage[0]);
	}

	/**
	 * Reads inbound messages from the SPECIFIC gateway. When successful, the
	 * message list will contain all messages read.
	 * 
	 * @param msgList
	 *            A (probably empty) list that will be populated with Inbound
	 *            messages read.
	 * @param msgClass
	 *            Filtering: Class of messages that need to be read.
	 * @param gatewayId
	 *            The identifier of the gateway from which to read messages.
	 * @return The number of messages read.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see MessageClasses
	 * @see AGateway
	 */
	public int readMessages(Collection<InboundMessage> msgList, MessageClasses msgClass, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		AGateway gateway = findGateway(gatewayId);
		if ((gateway != null) && (gateway.isInbound()))
		{
			try
			{
				readMessages(msgList, msgClass, gateway);
			}
			catch (TimeoutException e)
			{
				getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
			}
			catch (IOException e)
			{
				getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
			}
		}
		return msgList.size();
	}

	/**
	 * .NET bridge method.
	 */
	public InboundMessage[] readMessages(MessageClasses msgClass, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		ArrayList<InboundMessage> messageList = new ArrayList<InboundMessage>();
		readMessages(messageList, msgClass, gatewayId);
		return messageList.toArray(new InboundMessage[0]);
	}

	/**
	 * Reads inbound messages from the SPECIFIC gateway. When successful, the
	 * message list will contain all messages read.
	 * 
	 * @param msgList
	 *            A (probably empty) list that will be populated with inbound
	 *            messages read.
	 * @param msgClass
	 *            Filtering: Class of messages that need to be read.
	 * @param gateway
	 *            The gateway object from which to read messages.
	 * @return The number of messages read.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see MessageClasses
	 * @see AGateway
	 */
	public int readMessages(Collection<InboundMessage> msgList, MessageClasses msgClass, AGateway gateway) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		try
		{
			gateway.readMessages(msgList, msgClass);
		}
		catch (com.keren.smsgateway.model.TimeoutException e)
		{
			getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
			gateway.setStatus(GatewayStatuses.RESTART);
		}
		catch (IOException e)
		{
			getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
			gateway.setStatus(GatewayStatuses.RESTART);
		}
		return msgList.size();
	}

	/**
	 * .NET bridge method.
	 */
	public InboundMessage[] readMessages(MessageClasses msgClass, AGateway gateway) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		ArrayList<InboundMessage> messageList = new ArrayList<InboundMessage>();
		readMessages(messageList, msgClass, gateway);
		return messageList.toArray(new InboundMessage[0]);
	}

	/**
	 * Reads a specific gateway for a message matching the given Memory Location
	 * and Memory Index.
	 * <p>
	 * This is a "dummy" approach. It does not implement the CGMR command,
	 * rather it reads all messages and searches for a match.
	 * 
	 * @param gatewayId
	 *            The Gateway ID of the gateway to read from.
	 * @param memLoc
	 *            The memory location string.
	 * @param memIndex
	 *            The memory index.
	 * @return The message read. Null if no relevant message is found or if the
	 *         Gateway ID given is invalid.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 */
	public InboundMessage readMessage(String gatewayId, String memLoc, int memIndex) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return null;
		InboundMessage msg = null;
		AGateway gateway = findGateway(gatewayId);
		if ((gateway != null) && (gateway.isInbound()))
		{
			try
			{
				msg = gateway.readMessage(memLoc, memIndex);
			}
			catch (TimeoutException e)
			{
				getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
			}
			catch (IOException e)
			{
				getLogger().logWarn("readMessages(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
			}
		}
		return msg;
	}

	/**
	 * Sends a single message. The following logic is applied in order for
	 * SMSLib to decide from which gateway it will send the message:<br>
	 * 1. If the message holds gateway information (member field "gatewayId"),
	 * SMSLib will try to send it from that gateway.<br>
	 * 2. If the message does not hold gateway information (member field
	 * "gatewayId" is empty or "*") then if router and load balancer is defined,
	 * then message is processed by these classes.<br>
	 * 3. Otherwise the method selects the first outbound-capable gateway
	 * defined and sends the message from it.<br>
	 * The method blocks until the message is actually sent (synchronous
	 * operation).
	 * 
	 * @param msg
	 *            An OutboundMessage object.
	 * @return True if the message is sent.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #queueMessage(OutboundMessage)
	 */
	public boolean sendMessage(OutboundMessage msg) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		AGateway gateway = routeMessage(msg);
		if (gateway != null)
		{
			try
			{
				List<String> recipients = expandGroup(msg.getRecipient());
				if (recipients.size() == 0) return gateway.sendMessage(msg);
				else
				{
					List<OutboundMessage> groupMessages = new ArrayList<OutboundMessage>();
					for (String to : recipients)
					{
						OutboundMessage newMessage = new OutboundMessage();
						msg.copyTo(newMessage);
						newMessage.setRecipient(to);
						groupMessages.add(newMessage);
					}
					sendMessages(groupMessages);
					return true;
				}
			}
			catch (TimeoutException e)
			{
				getLogger().logWarn("sendMessage(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
				msg.setMessageStatus(MessageStatuses.FAILED);
				msg.setFailureCause(FailureCauses.GATEWAY_FAILURE);
				return false;
			}
			catch (IOException e)
			{
				getLogger().logWarn("sendMessage(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
				msg.setMessageStatus(MessageStatuses.FAILED);
				msg.setFailureCause(FailureCauses.GATEWAY_FAILURE);
				return false;
			}
		}
		else return false;
	}

	/**
	 * Sends a single message from the specified gateway.
	 * 
	 * @param msg
	 *            An OutboundMessage object.
	 * @param gatewayId
	 *            The id of the gateway that will be used for sending.
	 * @return True if the message is sent.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #sendMessage(OutboundMessage)
	 */
	public boolean sendMessage(OutboundMessage msg, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		msg.setGatewayId(gatewayId);
		return sendMessage(msg);
	}

	/**
	 * Sends a list of messages.
	 * 
	 * @param msgList
	 *            A list of OutboundMessage objects.
	 * @return The number of messages sent.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #sendMessage(OutboundMessage)
	 */
	public int sendMessages(Collection<OutboundMessage> msgList) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		int counter = 0;
		for (OutboundMessage msg : msgList)
			if (sendMessage(msg)) counter++;
		return counter;
	}

	/**
	 * .NET bridge method.
	 */
	public int sendMessages(OutboundMessage[] msgArray) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		int counter = 0;
		for (int i = 0; i < msgArray.length; i++)
			if (sendMessage(msgArray[i])) counter++;
		return counter;
	}

	/**
	 * Sends a list of messages from the specified gateway.
	 * 
	 * @param msgList
	 *            A list of OutboundMessage objects.
	 * @param gatewayId
	 *            The id of the gateway that will be used for sending.
	 * @return The number of messages sent.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 * @see #sendMessage(OutboundMessage)
	 */
	public int sendMessages(Collection<OutboundMessage> msgList, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		int counter = 0;
		for (OutboundMessage msg : msgList)
		{
			msg.setGatewayId(gatewayId);
			if (sendMessage(msg)) counter++;
		}
		return counter;
	}

	/**
	 * .NET bridge method.
	 */
	public int sendMessages(OutboundMessage[] msgArray, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		int counter = 0;
		for (int i = 0; i < msgArray.length; i++)
		{
			msgArray[i].setGatewayId(gatewayId);
			if (sendMessage(msgArray[i])) counter++;
		}
		return counter;
	}

	/**
	 * Queues a message for sending. The gateway selection logic is the same as
	 * for sendMessage(). The method does not block - returns immediately. If
	 * you wish to be alerted about the fate of the message, you may implement a
	 * IOutboundMessageNotification listener.
	 * 
	 * @param msg
	 *            Message to be sent
	 * @return True if the message is accepted in the Queue.
	 * @see #sendMessage(OutboundMessage)
	 * @see IOutboundMessageNotification
	 */
	public boolean queueMessage(OutboundMessage msg)
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		List<String> recipients = expandGroup(msg.getRecipient());
		if (recipients.size() == 0) return getQueueManager().queueMessage(msg);
		else
		{
			for (String to : recipients)
			{
				OutboundMessage newMessage = new OutboundMessage();
				msg.copyTo(newMessage);
				newMessage.setRecipient(to);
				getQueueManager().queueMessage(msg);
			}
			return true;
		}
	}

	/**
	 * Queues a message for sending from the specific gateway.
	 * 
	 * @param msg
	 *            A OutboundMessage object.
	 * @param gatewayId
	 *            The id of the gateway that will be used for sending.
	 * @return True if the message is accepted in the Queue.
	 * @see #queueMessage(OutboundMessage)
	 */
	public boolean queueMessage(OutboundMessage msg, String gatewayId)
	{       
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		msg.setGatewayId(gatewayId);
		return queueMessage(msg);
	}

	/**
	 * Queues a list of messages for sending.
	 * 
	 * @param msgList
	 *            A list of OutboundMessage objects.
	 * @return The number of messages accepted in the Queue.
	 * @see #queueMessage(OutboundMessage)
	 */
	public int queueMessages(Collection<OutboundMessage> msgList)
	{
		int counter = 0;
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		for (OutboundMessage msg : msgList)
			if (queueMessage(msg)) counter++;
		return counter;
	}

	/**
	 * .NET bridge method.
	 */
	public int queueMessages(OutboundMessage[] msgArray)
	{
		int counter = 0;
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		for (int i = 0; i < msgArray.length; i ++)
			if (queueMessage(msgArray[i])) counter++;
		return counter;
	}

	/**
	 * Queues a list of messages for sending from the specific gateway.
	 * 
	 * @param msgList
	 *            A list of OutboundMessage objects.
	 * @param gatewayId
	 *            The id of the gateway to be used for sending.
	 * @return The number of messages accepted in the Queue.
	 * @see #queueMessage(OutboundMessage)
	 */
	public int queueMessages(Collection<OutboundMessage> msgList, String gatewayId)
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		int counter = 0;
		for (OutboundMessage msg : msgList)
		{
			msg.setGatewayId(gatewayId);
			if (queueMessage(msg)) counter++;
		}
		return counter;
	}

	/**
	 * .NET bridge method.
	 */
	public int queueMessages(OutboundMessage[] msgArray, String gatewayId)
	{
		int counter = 0;
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		for (int i = 0; i < msgArray.length; i ++)
		{
			msgArray[i].setGatewayId(gatewayId);
			if (queueMessage(msgArray[i])) counter++;
		}
		return counter;
	}

	/**
	 * Attempts to remove the specified message from the background sending
	 * queue. Can only be used for messages previously queued up with the
	 * queueMessage() calls.
	 * 
	 * @param msg
	 *            The outbound message to be removed.
	 * @return true if the message is indeed removed from the respective
	 *         background queue.
	 */
	public boolean removeMessage(OutboundMessage msg)
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		return getQueueManager().removeMessage(msg);
	}

	/**
	 * Deletes the specified message. The operation is not supported by all
	 * gateways.
	 * 
	 * @param msg
	 *            The message to be deleted. It must be a valid InboundMessage
	 *            object. <b>DO NOT PASS invalid objects to the method!</b>
	 * @return True if the message is deleted.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 */
	public boolean deleteMessage(InboundMessage msg) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return false;
		AGateway gateway = findGateway(msg.getGatewayId());
		if (gateway != null)
		{
			try
			{
				return gateway.deleteMessage(msg);
			}
			catch (TimeoutException e)
			{
				getLogger().logWarn("deleteMessage(): Gateway " + gateway.getGatewayId() + " does not respond, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
				return false;
			}
			catch (IOException e)
			{
				getLogger().logWarn("deleteMessage(): Gateway " + gateway.getGatewayId() + " throws IO errors, marking for restart.", null, null);
				gateway.setStatus(GatewayStatuses.RESTART);
				return false;
			}
		}
		return false;
	}

	/**
	 * Loads the phonebook from the specified gateway into a Phonebook class.
	 * 
	 * @param phonebook
	 *            An already instantiated, empty Phonebook class.
	 * @param gatewayId
	 *            The gateway id for which the phonebook should be loaded
	 * @return The number of phonebook entries read.
	 * @throws TimeoutException
	 *             The gateway did not respond in a timely manner.
	 * @throws GatewayException
	 *             A Gateway error occurred.
	 * @throws IOException
	 *             An IO error occurred.
	 * @throws InterruptedException
	 *             The call was interrupted.
	 */
	public int readPhonebook(Phonebook phonebook, String gatewayId) throws TimeoutException, GatewayException, IOException, InterruptedException
	{
		if (getServiceStatus() == ServiceStatus.STOPPED) return 0;
		AGateway gateway = findGateway(gatewayId);
		if (gateway != null) { return gateway.readPhonebook(phonebook); }
		return 0;
	}

	/**
	 * Returns the total number of messages received by the specified gateway.
	 * 
	 * @param gatewayId
	 *            The id of the gateway to query.
	 * @return The number of received messages or -1 on error.
	 */
	public int getInboundMessageCount(String gatewayId)
	{
		return getInboundMessageCount(findGateway(gatewayId));
	}

	/**
	 * Returns the total number of messages received by the specified gateway.
	 * 
	 * @param gateway
	 *            The AGateway object to query.
	 * @return The number of received messages or -1 on error.
	 */
	public int getInboundMessageCount(AGateway gateway)
	{
		return (gateway != null ? gateway.getInboundMessageCount() : -1);
	}

	/**
	 * Returns the total number of messages sent via the specified gateway.
	 * 
	 * @param gatewayId
	 *            The id of the gateway to query.
	 * @return The number of sent messages or -1 on error.
	 */
	public int getOutboundMessageCount(String gatewayId)
	{
		return getOutboundMessageCount(findGateway(gatewayId));
	}

	/**
	 * Returns the total number of messages sent via the specified gateway.
	 * 
	 * @param gateway
	 *            The AGateway object to query.
	 * @return The number of sent messages or -1 on error.
	 */
	public int getOutboundMessageCount(AGateway gateway)
	{
		return (gateway != null ? gateway.getOutboundMessageCount() : -1);
	}

	/**
	 * Returns the total number of messages received by all gateways.
	 * 
	 * @return The number of received messages.
	 */
	public int getInboundMessageCount()
	{
		int total = 0;
		for (AGateway gateway : getGateways())
			total += gateway.getInboundMessageCount();
		return total;
	}

	/**
	 * Returns the total number of messages sent via all gateways.
	 * 
	 * @return The number of sent messages.
	 */
	public int getOutboundMessageCount()
	{
		int total = 0;
		for (AGateway gateway : getGateways())
			total += gateway.getOutboundMessageCount();
		return total;
	}

	/**
	 * Find and return a gateway by its ID.
	 * 
	 * @param gatewayId
	 *            The ID of gateway to find.
	 * @return Gateway object bearing given name, or NULL if not found.
	 */
	public AGateway findGateway(String gatewayId)
	{
		for (AGateway gateway : getGateways())
			if (gateway.getGatewayId().equals(gatewayId)) return gateway;
		return null;
	}

	/**
	 * Returns the list of defined gateways.
	 * 
	 * @return The list of gateways.
	 */
	public Collection<AGateway> getGateways()
	{
		return gatewayList;
	}

	/**
	 * .NET bridge method.
	 */
	public AGateway[] getGatewaysNET()
	{
		return getGateways().toArray(new AGateway[0]);
	}

	/**
	 * Returns the active Load Balancer class.
	 * 
	 * @return The active LoadBalancer class.
	 * @see LoadBalancer
	 */
	public LoadBalancer getLoadBalancer()
	{
		return loadBalancer;
	}

	/**
	 * Sets a new Load Balancer.
	 * 
	 * @param loadBalancer
	 *            The Load Balancer that will take effect.
	 * @see LoadBalancer
	 */
	public void setLoadBalancer(LoadBalancer loadBalancer)
	{
		this.loadBalancer = loadBalancer;
	}

	/**
	 * Returns the active Router class.
	 * 
	 * @return The active Router class.
	 * @see Router
	 */
	public Router getRouter()
	{
		return router;
	}

	/**
	 * Sets a new Router.
	 * 
	 * @param router
	 *            The Router that will take effect.
	 * @see Router
	 */
	public void setRouter(Router router)
	{
		this.router = router;
	}

	/**
	 * Find best suitable gateway to send specific message through Router and
	 * Load Balancer.
	 * 
	 * @param msg
	 *            Message to be routed
	 * @return Reference to gateway or <code>null</code> if no suitable gateway
	 *         is found.
	 */
	synchronized AGateway routeMessage(OutboundMessage msg)
	{
		return getRouter().route(msg);
	}

	/**
	 * Returns the notification method set for inbound messages. Returns null if
	 * no such method is set.
	 * 
	 * @return The notification method.
	 * @see #setInboundNotification(IInboundMessageNotification)
	 */
	public IInboundMessageNotification getInboundNotification()
	{
		return inboundNotification;
	}

	/**
	 * Sets the inbound message notification method. The method must adhere to
	 * the IInboundMessageNotification interface. If set, SMSLib will call this
	 * method upon arrival of a new inbound message.
	 * 
	 * @param inboundNotification
	 *            The method to be called.
	 * @see #getInboundNotification()
	 * @see IInboundMessageNotification
	 */
	public void setInboundNotification(IInboundMessageNotification inboundNotification)
	{
		this.inboundNotification = inboundNotification;
	}

	/**
	 * Returns the notification method set for outbound messages. Returns null
	 * if no such method is set.
	 * 
	 * @return The notification method.
	 * @see #setOutboundNotification(IOutboundMessageNotification)
	 */
	public IOutboundMessageNotification getOutboundNotification()
	{
		return outboundNotification;
	}

	/**
	 * Sets the outbound notification method. The method must adhere to the
	 * IOutboundMessageNotification interface. If set, SMSLib will call this
	 * method upon dispatch of a message through the queueing (asyncronous)
	 * calls.
	 * 
	 * @param outboundNotification
	 * @see #getOutboundNotification()
	 * @see IOutboundMessageNotification
	 */
	public void setOutboundNotification(IOutboundMessageNotification outboundNotification)
	{
		this.outboundNotification = outboundNotification;
	}

	/**
	 * Returns the call notification method. Returns null if no such method is
	 * set.
	 * 
	 * @return The notification method.
	 * @see #setCallNotification(ICallNotification)
	 */
	public ICallNotification getCallNotification()
	{
		return callNotification;
	}

	/**
	 * Sets the call notification method. The method must adhere to the
	 * ICallNotification interface. If set, SMSLib will call this method upon
	 * detection of an inbound call.
	 * 
	 * @param callNotification
	 * @see #getCallNotification()
	 * @see ICallNotification
	 */
	public void setCallNotification(ICallNotification callNotification)
	{
		this.callNotification = callNotification;
	}

	/**
	 * Returns the gateway status notification method. Returns null if no such
	 * method has been set.
	 * 
	 * @return The notification method.
	 * @see #setGatewayStatusNotification(IGatewayStatusNotification)
	 */
	public IGatewayStatusNotification getGatewayStatusNotification()
	{
		return gatewayStatusNotification;
	}

	/**
	 * Sets the gateway status notification method. The method must adhere to
	 * the IGatewayStatusNotification interface. If set, SMSLib will call this
	 * method upon every gateway status change.
	 * 
	 * @param gatewayStatusNotification
	 * @see #getGatewayStatusNotification()
	 * @see IGatewayStatusNotification
	 */
	public void setGatewayStatusNotification(IGatewayStatusNotification gatewayStatusNotification)
	{
		this.gatewayStatusNotification = gatewayStatusNotification;
	}

	/**
	 * Returns the notification method set for Queue sending operation. Returns
	 * null if no such method is set.
	 * 
	 * @return The notification method.
	 * @see #setQueueSendingNotification(IQueueSendingNotification)
	 */
	public IQueueSendingNotification getQueueSendingNotification()
	{
		return queueSendingNotification;
	}

	/**
	 * Sets the Queue sending notification method. The method must adhere to the
	 * IQueueSendingNotification interface. If set, SMSLib will call this
	 * method upon dispatch of a message through the queueing (asyncronous)
	 * calls.
	 * 
	 * @param queueSendingNotification
	 * @see #getQueueSendingNotification()
	 * @see IQueueSendingNotification
	 */
	public void setQueueSendingNotification(IQueueSendingNotification queueSendingNotification)
	{
		this.queueSendingNotification = queueSendingNotification;
	}

	public long getStartMillis()
	{
		return startMillis;
	}

	public Scheduler getScheduler()
	{
		return scheduler;
	}

	void setSettings(Settings settings)
	{
		this.S = settings;
	}

	public ServiceStatus getServiceStatus()
	{
		return serviceStatus;
	}

	void setServiceStatus(ServiceStatus serviceStatus)
	{
		this.serviceStatus = serviceStatus;
	}

	/**
	 * Returns the Settings object, holding SMSLib run-time values.
	 * 
	 * @return The Settings object.
	 * @see Settings
	 */
	public Settings getSettings()
	{
		return S;
	}

	/**
	 * Creates a destination group. A group can hold an unlimited number of
	 * recipients. Sending a message to a predefined group expands and sends the
	 * message to all numbers defined by the group. A group is valid for as long
	 * as this instance of SMSLib is active.
	 * 
	 * @param groupName
	 *            The group name.
	 * @return True if the group creation succeded.
	 * @see #removeGroup(String)
	 */
	public boolean createGroup(String groupName)
	{
		groups.add(new Group(groupName));
		return true;
	}

	/**
	 * Removes a group.
	 * 
	 * @param groupName
	 *            The name of the group to be removed.
	 * @return True if the removal was a success.
	 * @see #createGroup(String)
	 */
	public boolean removeGroup(String groupName)
	{
		for (Group a : groups)
		{
			if (a.getName().equalsIgnoreCase(groupName))
			{
				a.clear();
				groups.remove(a);
				return true;
			}
		}
		return false;
	}

	/**
	 * Expands a group to its recipient numbers.
	 * 
	 * @param groupName
	 *            The group name to be expanded.
	 * @return A list of the numbers that this group represents. If the group is
	 *         not defined, an empty list is returned.
	 * @see #addToGroup(String, String)
	 * @see #removeFromGroup(String, String)
	 */
	public ArrayList<String> expandGroup(String groupName)
	{
		for (Group a : groups)
		{
			if (a.getName().equalsIgnoreCase(groupName)) { return new ArrayList<String>(a.getNumbers()); }
		}
		return new ArrayList<String>();
	}

	/**
	 * Adds a number to the specified group.
	 * 
	 * @param groupName
	 *            The group to which the number is to be added.
	 * @param number
	 *            The number to add.
	 * @return True if the number is added. False if the group is not found.
	 * @see #createGroup(String)
	 * @see #removeFromGroup(String, String)
	 */
	public boolean addToGroup(String groupName, String number)
	{
		for (Group a : groups)
		{
			if (a.getName().equalsIgnoreCase(groupName))
			{
				a.addNumber(number);
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes a number from the specified group.
	 * 
	 * @param groupName
	 *            The group from which the number is to be removed.
	 * @param number
	 *            The number to remove.
	 * @return True if the number was removed. False if the group or the number
	 *         is not found.
	 * @see #removeGroup(String)
	 * @see #addToGroup(String, String)
	 */
	public boolean removeFromGroup(String groupName, String number)
	{
		for (Group a : groups)
		{
			if (a.getGroupName().equalsIgnoreCase(groupName)) { return a.removeNumber(number); }
		}
		return false;
	}

	void setQueueManager(QueueManager queueManager)
	{
		this.queueManager = queueManager;
	}

	public QueueManager getQueueManager()
	{
		return queueManager;
	}

	public KeyManager getKeyManager()
	{
		return keyManager;
	}

	WatchDog getWatchDog()
	{
		return watchDog;
	}

	void setWatchDog(WatchDog watchDog)
	{
		this.watchDog = watchDog;
	}

	private class WatchDog extends ASchedulerTask
	{
		public WatchDog(String myName, Service myService)
		{
			super(myName, myService);
		}

		public void process()
		{
			if (getServiceStatus() == ServiceStatus.STOPPED) return;
			try
			{
				for (AGateway gateway : getGateways())
				{
					if (gateway.getStatus() == GatewayStatuses.RESTART)
					{
						getLogger().logWarn("WatchDog: Gateway: " + gateway.getGatewayId() + " restarting.", null, null);
						try
						{
							gateway.stopGateway();
							gateway.setStatus(GatewayStatuses.RESTART);
						}
						catch (Exception e)
						{
							getLogger().logWarn("WatchDog: error while shutting down Gateway: " + gateway.getGatewayId(), e, null);
						}
						try
						{
							gateway.startGateway();
						}
						catch (Exception e)
						{
							getLogger().logError("WatchDog: error while starting Gateway: " + gateway.getGatewayId(), e, null);
						}
					}
				}
			}
			catch (Exception e)
			{
				getLogger().logError("WatchDog error. ", e, null);
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println(Library.getLibraryDescription());
		System.out.println("\nSMSLib API Version: " + Library.getLibraryVersion());
	}
}
