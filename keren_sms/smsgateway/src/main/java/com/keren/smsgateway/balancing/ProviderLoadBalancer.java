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
 *ProviderLoadBalancer is forwarding message via each gateway 
 * @author BEKO*
 * 26/11/2018
 */
public class ProviderLoadBalancer  extends LoadBalancer{

    
    /**
     * 
     * @param myService 
     */
    public ProviderLoadBalancer(Service myService) {
        super(myService);
    }

    /**
     * 
     * @param msg
     * @param candidates
     * @return 
     */
    @Override
    public AGateway balance(OutboundMessage msg, ArrayList<AGateway> candidates) {      
        return super.balance(msg, candidates); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
