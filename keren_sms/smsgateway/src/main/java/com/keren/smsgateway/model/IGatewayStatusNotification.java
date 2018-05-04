/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import com.keren.smsgateway.model.AGateway.GatewayStatuses;

/**
 *Interface of the callback class used by SMSLib. SMSLib will call this method
 * whenever a gateway changes status.
 * 
 * @author BEKO
 */
public interface IGatewayStatusNotification {
    /**
	 * This method will be called by SMSLib whenever a gateway changes its
	 * status.
	 * 
	 * @param gtwId
	 *            The Gateway Id.
	 * @param oldStatus
	 *            The old status.
	 * @param newStatus
	 *            The new status.
	 */
	void process(String gtwId, GatewayStatuses oldStatus, GatewayStatuses newStatus);
}
