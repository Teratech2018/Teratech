/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.util.Date;

/**
 *
 * @author Commercial_2
 */
public class EbayMessageItem {
    
     private String message ;
    
    private Date dateMessage ;   
    
    //-1 = erreur
    private MessageType statut  ;

    
    /**
     * 
     */
    public EbayMessageItem() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public MessageType getStatut() {
        return statut;
    }

    public void setStatut(MessageType statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return message ;
    }
    
    
}
