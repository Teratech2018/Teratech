/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.rules;

import com.megatimgroup.mgt.commons.tools.RuleValidator;
import com.megatimgroup.mgt.commons.tools.ValidatorError;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 *
 * @author BEKO
 */
public class PatternRule implements RuleValidator , Serializable{

    private final String pattern ;
    
    private  String value ;

    
    /**
     * 
     * @param pattern
     * @param value 
     */
    public PatternRule(String pattern, String value) {
        this.pattern = pattern;
        this.value = value;
    }
    
    
    
    @Override
    public ValidatorError execute() {
        //To change body of generated methods, choose Tools | Templates.
        if(pattern==null || value==null){
            return null;
        }//end if(pattern==null || value==null){
        if(Pattern.matches(pattern, value)==true){
            return null;
        }else{
           return new ValidatorError(value, "No match pattern");
        }//end if(Pattern.matches(pattern, value)==true){
    }

    public String getPattern() {
        return pattern;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
         //To change body of generated methods, choose Tools | Templates.
        this.value = value;
    }
    
    
    
}
