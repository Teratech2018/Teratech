/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_COMPGM")
public class Compteur extends BaseElement implements Serializable,Comparable<Compteur>{

    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label ="Equipement" ,type = Equipement.class,target = "many-to-one",optional = false ,search = true)
    private Equipement equipement ;
    
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label ="Organe" ,type = Organe.class,target = "many-to-one" ,search = true)
    private Organe organe ;
    
    @ManyToOne
    @JoinColumn(name = "UGE_ID")
    @Predicate(label ="Unité" ,type = UniteGestion.class,optional = false,target = "many-to-one" ,search = true)
    private UniteGestion unite ;
    
    @Predicate(label = "Valeur absolue",type = Double.class,editable = false ,search = true)
    private Double valeur =0.0;
    
    @Predicate(label = "Valeur Initial",type = Double.class )
    private Double initial =0.0;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date Initialisation",type = Date.class ,target = "date")
    private Date debut ;
    
    @Predicate(label = "Valeur maxi quotidienne",type = Double.class )
    private Double maximun =0.0;
    
    @Predicate(label = "Saisie valeur par incrément",type = Boolean.class )
    private Boolean increment = Boolean.FALSE;

    /**
     * 
     * @param equipement
     * @param organe
     * @param unite
     * @param debut 
     */
    public Compteur(Equipement equipement, Organe organe, UniteGestion unite, Date debut) {
        this.equipement = equipement;
        this.organe = organe;
        this.unite = unite;
        this.debut = debut;
    }

    /**
     * 
     * @param equipement
     * @param organe
     * @param unite
     * @param debut
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Compteur(Equipement equipement, Organe organe, UniteGestion unite, Date debut, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.equipement = equipement;
        this.organe = organe;
        this.unite = unite;
        this.debut = debut;
    }

    public Compteur() {
    }
    
    
    
    public Compteur(Compteur entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.equipement!=null){
            this.equipement = new Equipement(entity.equipement);
        }
        if(entity.organe!=null){
            this.organe = new Organe(entity.organe);
        }
        this.unite = entity.unite;
        this.debut = entity.debut;
        this.valeur = entity.valeur;
        this.initial = entity.initial;
        this.increment = entity.increment;
        this.debut = entity.debut;
        this.maximun = entity.maximun;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

    public UniteGestion getUnite() {
        return unite;
    }

    public void setUnite(UniteGestion unite) {
        this.unite = unite;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
    }

    public Double getInitial() {
        return initial;
    }

    public void setInitial(Double initial) {
        this.initial = initial;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Double getMaximun() {
        return maximun;
    }

    public void setMaximun(Double maximun) {
        this.maximun = maximun;
    }

    

    public Boolean getIncrement() {
        return increment;
    }

    public void setIncrement(Boolean increment) {
        this.increment = increment;
    }

    @Override
    public String getDesignation() {
        return equipement.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Compteurs"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Compteur"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }    
    
    @Override
    public int compareTo(Compteur o) {
         //To change body of generated methods, choose Tools | Templates.
        return equipement.compareTo(equipement);
    }
    
}
