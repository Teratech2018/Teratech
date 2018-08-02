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
@Table(name = "T_CRITGM")
public class Criticite extends BaseElement implements Serializable,Comparable<Criticite>{
    
    @Predicate(label = "Désignation",optional = false ,search = true)
     private String code ;
     
    @Predicate(label = "Niveau",type = Short.class,optional = false , search = true)
     private Short niveau =0 ;

    
    
    public Criticite() {
    }

    
    
    /**
     * 
     * @param code 
     */
    public Criticite(String code) {
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
    public Criticite(String code, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
    }
    
     public Criticite(Criticite entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Short getNiveau() {
        return niveau;
    }

    public void setNiveau(Short niveau) {
        this.niveau = niveau;
    }

    @Override
    public String getDesignation() {
        return code ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Niveaux de Criticité"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
         return "Niveau de Criticité";  //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Criticite o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
