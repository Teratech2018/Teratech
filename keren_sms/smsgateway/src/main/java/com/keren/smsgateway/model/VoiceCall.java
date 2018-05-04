/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "SMS_CALL")
public class VoiceCall implements Serializable,Comparable<VoiceCall>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = -1L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CALL_D",nullable = false)
    private Date callDate ;
    
    @Column(name = "GAWA_D",nullable = false)
    private String gatewayId ;
    
    @Column(name = "CALL_ID",nullable = false)
    private String callerId ;

    /**
     * 
     */
    public VoiceCall() {
    }

    /**
     * 
     * @param callDate
     * @param gatewayId
     * @param callerId 
     */
    public VoiceCall(Date callDate, String gatewayId, String callerId) {
        this.callDate = callDate;
        this.gatewayId = gatewayId;
        this.callerId = callerId;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }
    
    
    @Override
    public int compareTo(VoiceCall o) {
        //To change body of generated methods, choose Tools | Templates.
        return id.compareTo(o.id);
    }
}
