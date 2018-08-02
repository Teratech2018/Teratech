/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_QUAFGM")
public class Qualification extends BaseElement implements Serializable,Comparable<Qualification>{
    
    @Predicate(label = "Qualification",optional = false,unique = true ,search = true)
     private String code ;
     
    @Predicate(label = "Désignation",optional = false ,search = true)
     private String intitule ;

    
    
    public Qualification() {
    }

    
    
    /**
     * 
     * @param code 
     */
    public Qualification(String code) {
        this.code = code;
    }

    /**
     * 
     * @param code
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Qualification(String code, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
    }
    
    /**
     * 
     * @param entity 
     */
     public Qualification(Qualification entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    
   
    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Qualifications"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
         return "Qualification";  //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Qualification o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
