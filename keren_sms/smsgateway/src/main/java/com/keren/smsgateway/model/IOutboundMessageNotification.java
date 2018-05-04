/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Interface of the callback class used by SMSLib. SMSLib will call this method
 * when it sends (or fails to send) an outbound message from its queue.
 * 
 * @see Service#setOutboundNotification(IOutboundMessageNotification)
 * @author BEKO
 */
public interface IOutboundMessageNotification {
    
    /**
	 * This method will be called by SMSLib upon sending or when it failed to
	 * send a message. Please note that this method is only called when you send
	 * messages via SMSLib queue manager.
	 * 
	 * @param gatewayId
	 *            The id of the gateway from which the message was sent.
	 * @param msg
	 *            The actual outbound message. This messages has its fields
	 *            updated according to whether SMSLib has manage to send it or
	 *            failed to send it.
	 */
	void process(final String gatewayId, final OutboundMessage msg);
}
