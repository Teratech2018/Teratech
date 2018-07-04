/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.tools;

import java.io.Serializable;

/**
 *Contains the secification of validation error
 * @author BEKO
 */
public class ValidatorError implements Serializable,Comparable<ValidatorError>{
    private String value ;
    private String message ;

    /**
     * 
     */
    public ValidatorError() {
    }

    /**
     * 
     * @param value
     * @param message 
     */
    public ValidatorError(String value, String message) {
        this.value = value;
        this.message = message;
    }

   
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
    @Override
    public int compareTo(ValidatorError o) {
        //To change body of generated methods, choose Tools | Templates.
        return o.value.compareTo(value);
    }
          
}
