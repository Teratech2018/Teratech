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
public class NotNullRule implements RuleValidator,Serializable{

    private String value ;

    /**
     * 
     * @param value 
     */
    public NotNullRule(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
    @Override
    public ValidatorError execute() {
        //To change body of generated methods, choose Tools | Templates.
        if(value==null){
            return null;
        }//end if(value==null){
        return new ValidatorError(value, "Not null");
    }
    
}
