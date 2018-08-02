/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.preventif;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.Organe;
import com.teratech.gmao.model.base.UniteGestion;
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
@Table(name = "T_MIJRCOGM")
public class MiseAJourCompteur extends BaseElement implements Serializable,Comparable<MiseAJourCompteur>{

    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",optional = false,search = true)
    private Equipement equipement ;
    
     @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",optional = false,search = true)
    private Organe organe ;
    
     @ManyToOne
    @JoinColumn(name = "UNI_ID")
    @Predicate(label = "Unité",type = UniteGestion.class,target = "many-to-one",optional = false,search = true)
    private UniteGestion unite ;
    
    @Predicate(label = "Dernière valeur",type = Double.class,editable = false,search = true)
    private Double oldvalue ;
    
    @Predicate(label = "Date",target = "date",type = Date.class,editable = false,search = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date olddate ;
    
    @Predicate(label = "Valeur",type = Double.class,optional = false,search = true)
    private Double newvalue;
    
    @Predicate(label = "Date",target = "date",type = Date.class,optional = false,search = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date newdate ;
    
    @Predicate(label = "Heure",target = "time",optional = false,search = true)
    private String heure ;

    public MiseAJourCompteur() {
    }

    /**
     * 
     * @param equipement
     * @param organe
     * @param unite
     * @param oldvalue
     * @param olddate
     * @param newvalue
     * @param newdate
     * @param heure 
     */
    public MiseAJourCompteur(Equipement equipement, Organe organe, UniteGestion unite, Double oldvalue, Date olddate, Double newvalue, Date newdate, String heure) {
        this.equipement = equipement;
        this.organe = organe;
        this.unite = unite;
        this.oldvalue = oldvalue;
        this.olddate = olddate;
        this.newvalue = newvalue;
        this.newdate = newdate;
        this.heure = heure;
    }

    /**
     * 
     * @param equipement
     * @param organe
     * @param unite
     * @param oldvalue
     * @param olddate
     * @param newvalue
     * @param newdate
     * @param heure
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public MiseAJourCompteur(Equipement equipement, Organe organe, UniteGestion unite, Double oldvalue, Date olddate, Double newvalue, Date newdate, String heure, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.equipement = equipement;
        this.organe = organe;
        this.unite = unite;
        this.oldvalue = oldvalue;
        this.olddate = olddate;
        this.newvalue = newvalue;
        this.newdate = newdate;
        this.heure = heure;
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

    public Double getOldvalue() {
        return oldvalue;
    }

    public void setOldvalue(Double oldvalue) {
        this.oldvalue = oldvalue;
    }

    public Date getOlddate() {
        return olddate;
    }

    public void setOlddate(Date olddate) {
        this.olddate = olddate;
    }

    public Double getNewvalue() {
        return newvalue;
    }

    public void setNewvalue(Double newvalue) {
        this.newvalue = newvalue;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    @Override
    public String getDesignation() {
        return super.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Mises à jour compteur"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Mise à jour compteur";//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(MiseAJourCompteur o) {
        return equipement.compareTo(o.equipement); //To change body of generated methods, choose Tools | Templates.
    }
    
}
