/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.ebaytools.client;

import java.io.Serializable;
import com.megatim.common.annotations.IncludeObject;

/**
 *
 * @author DEV_4
 */
public class NodeObject implements Serializable,Comparable<NodeObject>{

    private Class<?> parentClazz;
    
    private Class<?> clazz ;
    
    private String name ;
    
    private String label ;
    
    private String pattern ;
    
    private int length ;
    
    //Impose de verifier l'existance 
    private boolean entry = Boolean.FALSE;

    private boolean nullable = Boolean.TRUE;
    
    private boolean unique = Boolean.FALSE;
    
    private boolean optional = Boolean.TRUE;
    
    private Object value ;
    
    private IncludeObject include ;
    
    private IncludeObject exclude ;
    
    /**
     * 
     */
    public NodeObject() {
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public Class<?> getParentClazz() {
        return parentClazz;
    }

    public void setParentClazz(Class<?> parentClazz) {
        this.parentClazz = parentClazz;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
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

    public boolean isEntry() {
        return entry;
    }

    public void setEntry(boolean entry) {
        this.entry = entry;
    }
    

    public boolean isNullable() {
        return nullable;
    }

    public void setNullable(boolean nullable) {
        this.nullable = nullable;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }    

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }  

    public IncludeObject getInclude() {
        return include;
    }

    public void setInclude(IncludeObject include) {
        this.include = include;
    }

    public IncludeObject getExclude() {
        return exclude;
    }

    public void setExclude(IncludeObject exclude) {
        this.exclude = exclude;
    }
    
    

    @Override
    public String toString() {
        return label;
    }
    
    


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeObject other = (NodeObject) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }
    
    
    
    
    @Override
    public int compareTo(NodeObject o) {
       //To change body of generated methods, choose Tools | Templates.
        return label.compareTo(o.label);
    }
    
}
