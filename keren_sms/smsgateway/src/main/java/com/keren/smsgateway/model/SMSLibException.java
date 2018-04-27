/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Custom SMSLib Exception. Its the parent of all SMSLib defined exceptions
 * @author BEKO
 */
public class SMSLibException extends Exception{
    private static final long serialVersionUID = 8429822255371346673L;

    public SMSLibException(String errorMessage)
    {
            super(errorMessage);
    }

    public SMSLibException()
    {
            super();
    }
}
