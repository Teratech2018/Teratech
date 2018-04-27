/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Interface of the callback class used by SMSLib. SMSLib will call this method
 * whenever a gateway retrieves a message from the Queue and before it tries to
 * send it out.
 * 
 * @see Service#setQueueSendingNotification(IQueueSendingNotification)
 * @author BEKO
 */
public interface IQueueSendingNotification {
    /**
	 * This method will be called by SMSLib whenever a gateway retrieves a
	 * message from the Queue and before it tries to send it out.
	 * 
	 * @param gatewayId
	 *            The id of the gateway from which the message is about to be
	 *            sent from.
	 * @param msg
	 *            The outbound message ready to be sent.
	 */
	void process(final String gatewayId, final OutboundMessage msg);
}
