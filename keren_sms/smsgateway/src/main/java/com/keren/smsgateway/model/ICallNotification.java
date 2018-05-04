/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Interface of the callback class used by SMSLib. SMSLib will call this method
 * when it detects an inbound voice call.
 * 
 * @see Service#setCallNotification(ICallNotification)
 * @author BEKO
 */
public interface ICallNotification {
    
	/**
	 * This method will be called by SMSLib upon a voice call reception.
	 * 
	 * @param gatewayId
	 *            The id of the gateway which received the voice call.
	 * @param callerId
	 *            The caller-id of the call.
	 */
	void process(String gatewayId, String callerId);
}
