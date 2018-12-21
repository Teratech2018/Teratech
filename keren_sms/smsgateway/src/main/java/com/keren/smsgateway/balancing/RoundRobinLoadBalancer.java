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
 * RoundRobinLoadBalancer is forwarding messages via each gateway in turns. This
 * is the default SMSLib load balancer.
 * @author BEKO
 */
public class RoundRobinLoadBalancer extends LoadBalancer{
        private int currentGateway;

	public RoundRobinLoadBalancer(Service myService)
	{
		super(myService);
		this.currentGateway = 0;
	}

	/**
	 * This Load Balancing implementation returns every other available gateway
	 * on each invocation.
     * @return 
	 */
	@Override
	public AGateway balance(OutboundMessage msg, ArrayList<AGateway> candidates)
	{
                 for(int i=0;i<candidates.size();i++){    
                        AGateway gateway = candidates.get(i);
                        System.out.println(RoundRobinLoadBalancer.class.toString()+"   "+gateway.getClass().toString());
                 }//end for(int i=0;i<candidates.size();i++){                 
		if (this.currentGateway >= candidates.size()) this.currentGateway = 0;
                AGateway gateway = candidates.get(this.currentGateway++);
                gateway.setFrom("BKD");
		return (gateway);
	}
}
