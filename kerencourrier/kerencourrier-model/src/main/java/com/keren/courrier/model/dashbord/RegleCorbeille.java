/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.dashbord;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "T_RECOGC")
public class RegleCorbeille extends BaseElement implements Serializable , Comparable<RegleCorbeille>{    
    @Predicate(label = "Champ concerné",optional = false,search = true)
    private String fieldName ;
    
    private String fieldLabel ;
    
    @Predicate(label = "Opérateur",optional = false,search = true)
    private String type ;
    
    @Predicate(label = "Type",optional = false,search = true)
    private String target ;
    
    @Predicate(label = "Valeur",optional = false,search = true)
    private String value ;
    
    private String[] searchfields = null ;
    

    public RegleCorbeille() {
    }
    
    public RegleCorbeille(String value) {
        
//        System.out.println(FilterPredicat.class.getName()+" ::::  "+value);
    }

    /**
     * 
     * @param fieldName
     * @param oper
     * @param value 
     */
    public RegleCorbeille(String fieldName, String oper, String value) {
        this.fieldName = fieldName;
        this.type = oper;
        this.value = value;
    }
    
    /**
     * 
     * @param filter 
     */
    public RegleCorbeille(RegleCorbeille filter) {
        this.fieldName = filter.fieldName;
        this.type = filter.type;
        this.value = filter.value;
        this.fieldLabel = filter.fieldLabel;
        this.searchfields = filter.searchfields;
        this.target = filter.target;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String fieldValue) {
        this.value = fieldValue;
    }   

    public String getFieldLabel() {
        return fieldLabel;
    }

    public void setFieldLabel(String fieldLabel) {
        this.fieldLabel = fieldLabel;
    }

    public String[] getSearchfields() {
        return searchfields;
    }

    public void setSearchfields(String[] searchfields) {
        this.searchfields = searchfields;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    
    

    @Override
    public String toString() {
        return "FilterPredicat{" + "fieldName=" + fieldName + ", fieldLabel=" + fieldLabel + ", type=" + type + ", target=" + target + ", value=" + value + ", searchfields=" + Arrays.toString(searchfields) + '}';
    }

    @Override
    public int compareTo(RegleCorbeille o) {
        return fieldName.compareTo(o.fieldName); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
