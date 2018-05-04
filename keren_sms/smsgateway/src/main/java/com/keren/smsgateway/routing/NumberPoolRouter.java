/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.routing;

import com.keren.smsgateway.model.AGateway;
import com.keren.smsgateway.model.OutboundMessage;
import com.keren.smsgateway.model.Service;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author BEKO
 */
public class NumberPoolRouter extends Router{
    /**
	 * Map number prefixes to gateways string identifiers
	 */
	protected HashMap<String, String> assignments;

	public NumberPoolRouter(Service service)
	{
		super(service);
		this.assignments = new HashMap<String, String>();
	}

	/**
	 * Create assignment of recipient number prefix to gateway.
	 * 
	 * @param prefix
	 *            Phone number prefix
	 * @param gw
	 *            Gateway to be assigned.
	 */
	public void assign(String prefix, AGateway gw)
	{
		this.assignments.put(prefix, gw.getGatewayId());
	}

	@Override
	public void customRouting(OutboundMessage msg)
	{
		// iterate over all defined prefixes when message recipient does not match,
		// remove gateway from candidate list
		Iterator<String> it = this.assignments.keySet().iterator();
		while (it.hasNext())
		{
			String prefix = it.next();
			if (msg.getRecipient().startsWith(prefix)) getAllowed().add(getService().findGateway(this.assignments.get(prefix)));
		}
	}
}
