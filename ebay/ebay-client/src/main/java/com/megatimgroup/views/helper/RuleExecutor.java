/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.views.helper;

/**
 * Execute une regle 
 * @author DEV_4
 */
public interface RuleExecutor {
    
    public boolean execute();
    
    public void setExcludeFields(String... excludes);
    
}
