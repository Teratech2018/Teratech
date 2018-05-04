/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import com.megatim.common.annotations.Predicate;
import java.io.Serializable;

/**
 *
 * @author BEKO
 */
public class KerenElement implements Serializable,Comparable<KerenElement>{
   
    @Predicate(label = "Nom du champs",editable = false)
    private String fieldName ;
    
    @Predicate(label = "Intitulé du champs",editable = false)
    private String fieldLabel;  
    
    @Predicate(label = "Concerné",type = Boolean.class)
    private Boolean  status = Boolean.FALSE;

    public KerenElement() {
    }

    /**
     * 
     * @param fieldName
     * @param fieldLabel 
     */
    public KerenElement(String fieldName, String fieldLabel) {
        super();
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
    
    @Override
    public int compareTo(KerenElement o) {
        //To change body of generated methods, choose Tools | Templates.
        return fieldName.compareTo(o.fieldName);
    }
    
}
