/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import com.keren.smsgateway.model.Message.MessageTypes;

/**
 *Interface of the callback class used by SMSLib. SMSLib will call this method
 * when it detects an inbound message.
 * 
 * @see Service#setInboundNotification(IInboundMessageNotification)
 * @author BEKO
 */
public interface IInboundMessageNotification {
    /**
	 * This method will be called by SMSLib upon receiving an sms message.
	 * 
	 * @param gatewayId
	 *            The id of the gateway which received the message.
	 * @param msgType
	 *            The message type.
	 * @param msg
	 *            The message received.
	 */
	void process(final String gatewayId, final MessageTypes msgType, final InboundMessage msg);
}
