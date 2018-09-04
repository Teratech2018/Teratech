/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.application;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author BEKO
 */
@MessageDriven(name = "CoreHub",activationConfig = {
      @ActivationConfigProperty(propertyName = "destinationType" ,propertyValue = "javax.jms.Topic"),
      @ActivationConfigProperty(propertyName = "destination",propertyValue = "topic/coreTopic"),
      @ActivationConfigProperty(propertyName = "acknowledgeMode" , propertyValue = "Auto-acknowledge")
})
public class KerenMDB implements MessageListener{

    @Override
    public void onMessage(Message message) {
        //To change body of generated methods, choose Tools | Templates.
        System.out.println(KerenMDB.class.toString()+" ========================== "+message);
    }
    
}
