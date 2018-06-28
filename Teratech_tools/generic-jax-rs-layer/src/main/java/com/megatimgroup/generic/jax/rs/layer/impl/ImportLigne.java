/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;

/**
 *
 * @author BEKO
 */
public class ImportLigne implements Serializable,Comparable<ImportLigne>{

    private long id =-1 ;
    
    private Boolean selected = Boolean.FALSE;
    
    private String code ;    
    
    private String description ;
    
    private Boolean optional = Boolean.TRUE;
    
    private String className ;

    /**
     * 
     */
    public ImportLigne() {
    }

    
    
    /**
     * 
     * @param code
     * @param description 
     */
    public ImportLigne(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getOptional() {
        return optional;
    }

    public void setOptional(Boolean optional) {
        this.optional = optional;
    }   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "ImportLigne{" + "id=" + id + ", selected=" + selected + ", code=" + code + ", description=" + description + ", optional=" + optional + ", className=" + className + '}';
    }
    
      
    
    @Override
    public int compareTo(ImportLigne o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
