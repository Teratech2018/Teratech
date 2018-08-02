/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Intervenant;
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
@Table(name = "T_INPREGM")
public class IntervenantPrevu extends BaseElement implements Serializable,Comparable<IntervenantPrevu>{

    @ManyToOne
    @JoinColumn(name = "INT_ID")
    @Predicate(label = "Intervenant",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant intervenant ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date acceptée",type = Date.class,target = "date",optional = false,search = true)
    private Date accepte ;
    
    @Predicate(label = "Heure",target = "time",optional = false,search = true)
    private String heure ;
    
    @Predicate(label = "Temps M.O",type = Double.class,optional = false,search = true)
    private Double tempsmo ;

    @Predicate(label = "Responsable(?)",type = Boolean.class,target = "checkbox",search = true)
    private Boolean principal = Boolean.FALSE;
    /**
     * 
     */
    public IntervenantPrevu() {
    }

    /**
     * 
     * @param intervenant
     * @param accepte
     * @param heure
     * @param tempsmo
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public IntervenantPrevu(Intervenant intervenant, Date accepte, String heure, Double tempsmo, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.intervenant = intervenant;
        this.accepte = accepte;
        this.heure = heure;
        this.tempsmo = tempsmo;
    }

    /**
     * 
     * @param entity 
     */
    public IntervenantPrevu(IntervenantPrevu entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.intervenant!=null){
            this.intervenant = new Intervenant(entity.intervenant);
        }//end if(entity.intervenant!=null){
        this.accepte = entity.accepte;
        this.heure = entity.heure;
        this.tempsmo = entity.tempsmo;
    }
    
    
    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public Date getAccepte() {
        return accepte;
    }

    public void setAccepte(Date accepte) {
        this.accepte = accepte;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public Double getTempsmo() {
        return tempsmo;
    }

    public void setTempsmo(Double tempsmo) {
        this.tempsmo = tempsmo;
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Intervenants prévus"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Intervenant prévu"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(IntervenantPrevu o) {
        return intervenant.compareTo(o.intervenant); //To change body of generated methods, choose Tools | Templates.
    }
    
}
