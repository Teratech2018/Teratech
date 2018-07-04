/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.rules;

import com.megatimgroup.mgt.commons.tools.RuleValidator;
import com.megatimgroup.mgt.commons.tools.ValidatorError;
import java.io.Serializable;

/**
 *
 * @author BEKO
 */
public class LengthRule implements RuleValidator , Serializable{

    private short length =0;
    
    private String value =null;
    

    /**
     * 
     * @param length
     * @param value 
     */
    public LengthRule(short length, String value) {
        this.length = length;
        this.value = value;
    }

    public short getLength() {
        return length;
    }

    public String getValue() {
        return value;
    }
    
    
    
    @Override
    public ValidatorError execute() {
         //To change body of generated methods, choose Tools | Templates.
        if(value==null || value.length()==length){
            return null;
        }else{
            ValidatorError validator = new ValidatorError(value, "Taile Texte : "+length);
            return validator;
        }
    }

    @Override
    public void setValue(String value) {
        //To change body of generated methods, choose Tools | Templates.
        this.value = value;
    }
    
}
