/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 * Configuration/settings class. This class holds information about all the
 * parameters which affect SMSLib operation.
 * @author BEKO
 */
public class Settings {
    /**
	 * Size of scheduler thread pool.
	 */
	public int SCHEDULER_POOL = 10;

	/**
	 * Specifies whether the serial port flashing is disabled or enabled.
	 */
	public boolean SERIAL_NOFLUSH = false;

	/**
	 * Specifies whether the serial port will be polled or SMSLib will be
	 * notified by port interrupts.
	 */
	public boolean SERIAL_POLLING = false;

	/**
	 * Specifies the polling interval (milliseconds).
	 */
	public int SERIAL_POLLING_INTERVAL = 200;

	/**
	 * Specifies the serial ports' timeout (milliseconds).15000
	 */
	public int SERIAL_TIMEOUT = 60000;

	/**
	 * Specifies the serial ports' keep-alive interval (seconds).
	 */
	public int SERIAL_KEEPALIVE_INTERVAL = 60;

	/**
	 * Specifies the buffer size (bytes).
	 */
	public int SERIAL_BUFFER_SIZE = 16384;

	/**
	 * Wait time before clearing the queues (milliseconds).
	 */
	public int SERIAL_CLEAR_WAIT = 1000;

	/**
	 * Specifies whether hardware handshake should be enabled for outbound port
	 * traffic.
	 */
	public boolean SERIAL_RTSCTS_OUT = false;

	/**
	 * Specifies the number of retries the background queue should give to an
	 * outbound message before it classifies it as failed.
	 */
	public int QUEUE_RETRIES = 3;

	/**
	 * Wait time for generic AT commands (milliseconds).
	 */
	public int AT_WAIT = 200;

	/**
	 * Wait time after issuing a RESET command (milliseconds).
	 */
	public int AT_WAIT_AFTER_RESET = 10000;

	/**
	 * Wait time to give the modem after entring COMMAND mode (milliseconds).
	 */
	public int AT_WAIT_CMD = 1100;

	/**
	 * Wait time after issuing a SEND command (milliseconds).
	 */
	public int AT_WAIT_CGMS = 200;

	/**
	 * Wait time before retrying the network status command (milliseconds).
	 */
	public int AT_WAIT_NETWORK = 5000;

	/**
	 * Wait time after entering the PIN (milliseconds).
	 */
	public int AT_WAIT_SIMPIN = 5000;

	/**
	 * Wait time before retrying a failed CNMI command (milliseconds).
	 */
	public int AT_WAIT_CNMI = 3000;

	/**
	 * Number of retries for sending a message.
	 */
	public int OUTBOUND_RETRIES = 3;

	/**
	 * Wait time between retries for sending a message (milliseconds).
	 */
	public int OUTBOUND_RETRY_WAIT = 3000;

	/**
	 * Watchdog - SMSLib background monitoring thread interval (seconds).
	 */
	public int WATCHDOG_INTERVAL = 15;

	/**
	 * Sync message processor interval: If CNMI detection fails, SMSLib will
	 * emulate and still act as an asynchronous reader, by implementing a
	 * background polling technique and pushing the read messages via the
	 * callback methods.
	 */
	public int CNMI_EMULATOR_INTERVAL = 30;

	/**
	 * Mask or show the IMSI string.
	 */
	public boolean MASK_IMSI = true;

	public boolean DISABLE_CMTI = false;

	/**
	 * Should all defined gateways start up concurrently?
	 */
	public boolean CONCURRENT_GATEWAY_START = true;

	Settings()
	{
		if (System.getProperty("smslib.serial.noflush") != null) this.SERIAL_NOFLUSH = true;
		if (System.getProperty("smslib.serial.polling") != null) this.SERIAL_POLLING = true;
		if (System.getProperty("smslib.scheduler.pool") != null) this.SCHEDULER_POOL = Integer.parseInt(System.getProperty("smslib.scheduler.pool"));
		if (System.getProperty("smslib.serial.pollinginterval") != null) this.SERIAL_POLLING_INTERVAL = Integer.parseInt(System.getProperty("smslib.serial.pollinginterval"));
		if (System.getProperty("smslib.serial.timeout") != null) this.SERIAL_TIMEOUT = Integer.parseInt(System.getProperty("smslib.serial.timeout"));
		if (System.getProperty("smslib.serial.keepalive") != null) this.SERIAL_KEEPALIVE_INTERVAL = Integer.parseInt(System.getProperty("smslib.serial.keepalive"));
		if (System.getProperty("smslib.serial.buffer") != null) this.SERIAL_BUFFER_SIZE = Integer.parseInt(System.getProperty("smslib.serial.buffer"));
		if (System.getProperty("smslib.serial.clearwait") != null) this.SERIAL_CLEAR_WAIT = Integer.parseInt(System.getProperty("smslib.serial.clearwait"));
		if (System.getProperty("smslib.queue.retries") != null) this.QUEUE_RETRIES = Integer.parseInt(System.getProperty("smslib.queue.retries"));
		if (System.getProperty("smslib.outbound.retries") != null) this.OUTBOUND_RETRIES = Integer.parseInt(System.getProperty("smslib.outbound.retries"));
		if (System.getProperty("smslib.outbound.retrywait") != null) this.OUTBOUND_RETRY_WAIT = Integer.parseInt(System.getProperty("smslib.outbound.retrywait"));
		if (System.getProperty("smslib.at.wait") != null) this.AT_WAIT = Integer.parseInt(System.getProperty("smslib.at.wait"));
		if (System.getProperty("smslib.at.resetwait") != null) this.AT_WAIT_AFTER_RESET = Integer.parseInt(System.getProperty("smslib.at.resetwait"));
		if (System.getProperty("smslib.at.cmdwait") != null) this.AT_WAIT_CMD = Integer.parseInt(System.getProperty("smslib.at.cmdwait"));
		if (System.getProperty("smslib.at.cmgswait") != null) this.AT_WAIT_CGMS = Integer.parseInt(System.getProperty("smslib.at.cmgswait"));
		if (System.getProperty("smslib.at.networkwait") != null) this.AT_WAIT_NETWORK = Integer.parseInt(System.getProperty("smslib.at.networkwait"));
		if (System.getProperty("smslib.at.simpinwait") != null) this.AT_WAIT_SIMPIN = Integer.parseInt(System.getProperty("smslib.at.simpinwait"));
		if (System.getProperty("smslib.at.cnmiwait") != null) this.AT_WAIT_CNMI = Integer.parseInt(System.getProperty("smslib.at.cnmiwait"));
		if (System.getProperty("smslib.watchdog") != null) this.WATCHDOG_INTERVAL = Integer.parseInt(System.getProperty("smslib.watchdog"));
		if (System.getProperty("smslib.disable.concurrent.gateway.startup") != null) this.CONCURRENT_GATEWAY_START = false;
		// Temporary Switch - disable inbound message unsolicited notifications (CMTI).
		if (System.getProperty("smslib.nocmti") != null) this.DISABLE_CMTI = true;
	}
}
