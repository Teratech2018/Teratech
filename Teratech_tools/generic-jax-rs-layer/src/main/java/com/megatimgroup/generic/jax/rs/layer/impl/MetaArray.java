/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Commercial_2
 */
@XmlRootElement
public class MetaArray implements Serializable{
    
    private String type ;
    
    private boolean search = false;
    
    private String target ;   
    
    private String fieldName ;
    
    private String fieldLabel ; 
    
    private MetaData metaData ;
    
    private boolean optional = true ;
    
    private boolean unique = false ; 
    
    private boolean updatable = true ;
     
    private boolean customfooter = false ;
    
    private String footerScript = null ;
    
    private String[] searchfields = new String[]{};
    
    private String filter ;
    
     private String hidden =null;
     
    private boolean editable = true ; 
    
    private boolean edittable = false ;
    
    private String method = null;
    
     private Observer observer;
     
     private String frozen = null;
    /**
     * 
     */
    public MetaArray() {
    }

    /**
     * 
     * @param type
     * @param fieldName
     * @param fieldLabel
     * @param search
     * @param target
     * @param metaData 
     */
    public MetaArray(String type, String fieldName, String fieldLabel,boolean search,String target, MetaData metaData) {
        this.type = type;
        this.fieldName = fieldName;
        this.fieldLabel = fieldLabel;
        this.metaData = metaData;
        this.target = target;
    }

    public MetaArray(MetaArray entity) {
        this.type = entity.type;
        this.fieldName = entity.fieldName;
        this.fieldLabel = entity.fieldLabel;
        this.metaData = entity.metaData;
        this.target = entity.target;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
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

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public boolean isUnique() {
        return unique;
    }

    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    public boolean isUpdatable() {
        return updatable;
    }

    public void setUpdatable(boolean updatable) {
        this.updatable = updatable;
    }

    public boolean isCustomfooter() {
        return customfooter;
    }

    public void setCustomfooter(boolean customfooter) {
        this.customfooter = customfooter;
    }

    public String[] getSearchfields() {
        return searchfields;
    }

    public void setSearchfields(String[] searchfields) {
        this.searchfields = searchfields;
    }

    public String getFooterScript() {
        return footerScript;
    }

    public void setFooterScript(String footerScript) {
        this.footerScript = footerScript;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getHidden() {
        return hidden;
    }

    public void setHidden(String hidden) {
        this.hidden = hidden;
    }

    public Observer getObserver() {
        return observer;
    }

    public void setObserver(Observer observer) {
        this.observer = observer;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isEdittable() {
        return edittable;
    }

    public void setEdittable(boolean edittable) {
        this.edittable = edittable;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String mothod) {
        this.method = mothod;
    }

    public String getFrozen() {
        return frozen;
    }

    public void setFrozen(String frozen) {
        this.frozen = frozen;
    }
    
    

    @Override
    public String toString() {
        return "MetaArray{" + "type=" + type + ", search=" + search + ", fieldName=" + fieldName + ", fieldLabel=" + fieldLabel + ", metaData=" + metaData + '}';
    }
    
    
}
