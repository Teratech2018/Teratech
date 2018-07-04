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
    
    private String pattern ;
    
    private int length =-1 ;
    
    private int min ;
    
    private int max ;
    
    private Boolean unique = Boolean.FALSE;
    
    private Boolean nullable = Boolean.TRUE;

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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public String toString() {
        return "ImportLigne{" + "id=" + id + ", selected=" + selected + ", code=" + code + ", description=" + description + ", optional=" + optional + ", className=" + className + ", pattern=" + pattern + ", length=" + length + ", min=" + min + ", max=" + max + ", unique=" + unique + ", nullable=" + nullable + '}';
    }
    
    
    
    @Override
    public int compareTo(ImportLigne o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
