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
public class MaxRule implements RuleValidator , Serializable{

    private double max=0  ;
    
    private  String value ;

    /**
     * 
     * @param max
     * @param value 
     */
    public MaxRule(double max, String value) {
        this.max = max;
        this.value = value;
    }
    
    
    @Override
    public ValidatorError execute() {
        //To change body of generated methods, choose Tools | Templates.
        try{
            double numb = Double.parseDouble(value);
            if(numb<=max){
                return null;
            }//end if(numb>=min){
            return new ValidatorError(value, "Maximum : "+max) ;
        }catch(NumberFormatException ex){
            return new ValidatorError(value, "Number format exception") ;
        }
    }

    public double getMax() {
        return max;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
