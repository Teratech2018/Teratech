/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.routing;

import com.keren.smsgateway.model.AGateway;
import com.keren.smsgateway.model.AGateway.GatewayStatuses;
import com.keren.smsgateway.model.OutboundMessage;
import com.keren.smsgateway.model.OutboundMessage.FailureCauses;
import com.keren.smsgateway.model.OutboundMessage.MessageStatuses;
import com.keren.smsgateway.model.Service;
import java.util.ArrayList;

/**
 *Base message routing class. Service owns instance of Router (or its
 * subclass), and uses its member functions to designate gateway(s) to send
 * particular outgoing message. It is allowed that router designates more than
 * modem to send message. It is responsibility of Router to decide which gateway
 * will send the message. Custom routing rules are possible by creating
 * subclass.
 * 
 * @author BEKO
 */
public class Router {
    /** List of candidate gateways */
	private ArrayList<AGateway> candidates;

	/** List of gateways that are allowed to send message */
	private ArrayList<AGateway> allowed;

	private Service srv;

	public Router(Service mySrv)
	{
		this.candidates = new ArrayList<AGateway>();
		this.allowed = new ArrayList<AGateway>();
		this.srv = mySrv;
	}

	protected Service getService()
	{
		return this.srv;
	}

	protected ArrayList<AGateway> getCandidates()
	{
		return this.candidates;
	}

	protected ArrayList<AGateway> getAllowed()
	{
		return this.allowed;
	}

	/**
	 * Perform early-stage routing, pick gateways that meet minimal requirements
	 * to send message (for example are set to handle outbound messages).
	 * 
	 * @param msg
	 *            Message to be routed
	 */
	protected void preroute(OutboundMessage msg)
	{
		for (AGateway gtw : getService().getGateways())
			if ((gtw.isOutbound()) && (gtw.getStatus() == GatewayStatuses.STARTED))
			{
				if (msg.getGatewayId().equalsIgnoreCase("*")) getCandidates().add(gtw);
				else if (msg.getGatewayId().equalsIgnoreCase(gtw.getGatewayId())) getCandidates().add(gtw);
			}
	}

	/**
	 * Heart of routing & load balancing mechanism
	 * 
	 * @param msg
	 */
	public AGateway route(OutboundMessage msg)
	{
		AGateway gtw = null;
		beginRouting();
		preroute(msg);
		// perform custom routing
		customRouting(msg);
		// check if there are any gateways designated to send?
		if (getAllowed().size() > 0) gtw = getService().getLoadBalancer().balance(msg, getAllowed());
		else
		{
			msg.setMessageStatus(MessageStatuses.FAILED);
			msg.setFailureCause(FailureCauses.NO_ROUTE);
		}
		// finish
		finishRouting();
		return gtw;
	}

	/**
	 * Place for custom routing performed by specialized subclass. A "positive"
	 * approach is taken. Method has to copy references to gateways from
	 * <code>candidates</code> list to <code>allowed</code>. So, default
	 * behavior is to copy all references. Another possibility is to take
	 * "negative" approach, where method should delete unwanted gateways from
	 * list. This approach was found difficult to use at this time.
	 * 
	 * @param msg
	 *            Message to be routed
	 */
	public void customRouting(OutboundMessage msg)
	{
		getAllowed().addAll(getCandidates());
	}

	/**
	 * Prepare internal data for routing (clean internal data structures). Must
	 * be called when new message is routed.
	 */
	protected final void beginRouting()
	{
		getCandidates().clear();
		getAllowed().clear();
	}

	/**
	 * Cleanup after routing
	 */
	protected final void finishRouting()
	{
		getCandidates().clear();
		getAllowed().clear();
	}
}
