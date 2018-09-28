/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.discussions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BEKO
 */
public class DiscusionSession implements Serializable,Comparable<DiscusionSession>{

    private Long maxid = 0L ;
    
    private List<KMessage> messages = new ArrayList<KMessage>();

    /**
     * 
     */
    public DiscusionSession() {
    }

    public Long getMaxid() {
        return maxid;
    }

    public void setMaxid(Long maxid) {
        this.maxid = maxid;
    }

    public List<KMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<KMessage> messages) {
        this.messages = messages;
    }

    
    
    
    
    @Override
    public int compareTo(DiscusionSession o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
