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
public class MinRule implements RuleValidator , Serializable{

    private double min=0  ;
    
    private  String value ;

    /**
     * 
     * @param min
     * @param value 
     */
    public MinRule(double min, String value) {
        this.min = min;
        this.value = value;
    }
    
    
    @Override
    public ValidatorError execute() {
        //To change body of generated methods, choose Tools | Templates.
        try{
            double numb = Double.parseDouble(value);
            if(numb>=min){
                return null;
            }//end if(numb>=min){
            return new ValidatorError(value, "Minimum : "+min) ;
        }catch(NumberFormatException ex){
            return new ValidatorError(value, "Number format exception") ;
        }
    }

    public double getMin() {
        return min;
    }

    public String getValue() {
        return value;
    }

    public void setMin(double min) {
        this.min = min;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
    
    
    
}
