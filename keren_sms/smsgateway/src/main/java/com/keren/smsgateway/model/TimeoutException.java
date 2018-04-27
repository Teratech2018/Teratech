/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.smsgateway.model;

/**
 *Exception class specific to timeout errors.
 * @author BEKO
 */
public class TimeoutException extends SMSLibException{
    private static final long serialVersionUID = -8130455779245416309L;

    public TimeoutException(String errorMessage)
    {
            super(errorMessage);
    }
}
