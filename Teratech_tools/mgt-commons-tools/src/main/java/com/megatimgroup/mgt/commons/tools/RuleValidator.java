/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.mgt.commons.tools;

/**
 *Interface of rule executor
 * @author BEKO
 */
public interface RuleValidator {
    
    public ValidatorError execute();
    
    public void setValue(String value);
}
