/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.budget;

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
@Table(name = "T_LIBUGM")
public class LigneBudget extends BaseElement implements Serializable,Comparable<LigneBudget>{

   @Predicate(label = "Mois",editable = false,updatable = false,hide = true,search = true)
     private String code ;
     
    @Predicate(label = "Initial",type = Double.class,updatable = true,hidden = "temporalData.initial>0",search = true)
     private Double initial ;
     
    @Predicate(label = "Actualisé",type = Double.class,hidden = "temporalData.initial<=0",search = true)
     private Double actualise ;
     
    @Predicate(label = "En cours",type = Double.class,editable = false,hide = true,updatable = false,search = true)
     private Double encours ;
     
    @Predicate(label = "Réalisé",type = Double.class,editable = false,hide = true,updatable = false,search = true)
     private Double realise ; 
     
    @Predicate(label = "Solde",type = Double.class,editable = false,hide = true,updatable = false,search = true)
     private Double solde ;
     
    @Predicate(label = "% engagé",type = Double.class,editable = false,hide = true,updatable = false,search = true)
     private Double pourcent ;

    public LigneBudget(String code, Double initial, Double actualise, Double encours, Double realise, Double solde, Double pourcent) {
        this.code = code;
        this.initial = initial;
        this.actualise = actualise;
        this.encours = encours;
        this.realise = realise;
        this.solde = solde;
        this.pourcent = pourcent;
    }

    public LigneBudget(String code, Double initial, Double actualise, Double encours, Double realise, Double solde, Double pourcent, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.initial = initial;
        this.actualise = actualise;
        this.encours = encours;
        this.realise = realise;
        this.solde = solde;
        this.pourcent = pourcent;
    }
    
    public LigneBudget(LigneBudget entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.initial = entity.initial;
        this.actualise = entity.actualise;
        this.encours = entity.encours;
        this.realise = entity.realise;
        this.solde = entity.solde;
        this.pourcent = entity.pourcent;
    }

    public LigneBudget() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getInitial() {
        return initial;
    }

    public void setInitial(Double initial) {
        this.initial = initial;
    }

    public Double getActualise() {
        return actualise;
    }

    public void setActualise(Double actualise) {
        this.actualise = actualise;
    }

    public Double getEncours() {
        return encours;
    }

    public void setEncours(Double encours) {
        this.encours = encours;
    }

    public Double getRealise() {
        return realise;
    }

    public void setRealise(Double realise) {
        this.realise = realise;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Double getPourcent() {
        return pourcent;
    }

    public void setPourcent(Double pourcent) {
        this.pourcent = pourcent;
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Saisie Budget"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }   
    

    @Override
    public boolean isDesableupdate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LigneBudget o) {
         //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
