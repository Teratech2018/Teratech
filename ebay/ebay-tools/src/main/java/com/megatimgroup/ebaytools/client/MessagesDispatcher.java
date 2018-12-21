/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.util.List;

/**
 *Centre de diffusion des messages
 * @author Commercial_2
 */
public class MessagesDispatcher {
    
    private static List<EbayMessage> messages ;

    private MessagesDispatcher() {
    }
    
    /**
     * Enregistrement d'un nouveau message
     * @param message 
     */
    public synchronized void register(EbayMessage message){
        messages.add(message);
    }
    
    /**
     * 
     * @param message 
     */
    public  synchronized  void unregister(EbayMessage message){
        messages.remove(message);
    }
}
