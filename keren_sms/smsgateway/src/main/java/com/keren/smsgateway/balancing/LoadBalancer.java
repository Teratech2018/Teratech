/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.balancing;

import com.keren.smsgateway.model.AGateway;
import com.keren.smsgateway.model.OutboundMessage;
import com.keren.smsgateway.model.Service;
import java.util.ArrayList;

/**
 *Load Balancing base class. Implements default trivial Load Balancing - just
 * picking first available Gateway to send message. Create subclasses to
 * implement custom functionality.
 * 
 * @author BEKO
 */
public class LoadBalancer {
        protected Service service;

	public LoadBalancer(Service myService)
	{
		this.service = myService;
	}

	/**
	 * Core of Load Balancing. Default is trivial selection of first candidate.
	 * 
	 * @param msg
	 *            Message to be sent.
	 * @param candidates
	 *            List of candidate gateways to choose from
         * @return 
	 */
	public AGateway balance(OutboundMessage msg, ArrayList<AGateway> candidates)
	{
		return candidates.get(0);
	}
}
