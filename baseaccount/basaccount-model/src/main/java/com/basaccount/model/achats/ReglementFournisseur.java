/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.basaccount.model.tiers.Tier;
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
@Table(name = "T_REGFO_COM")
public class ReglementFournisseur extends BaseElement implements Serializable,Comparable<ReglementFournisseur>{

    @Predicate(label = "numero.piece",optional = false,unique = true,search = true)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "fournisseur",type = Tier.class,target = "many-to-one",search = true,optional = false)
    private Tier fournisseur;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "date",type = Date.class,target = "date",optional = false,search = true)
    private Date date ;
    
    @ManyToOne
    @JoinColumn(name = "MOREG_ID")
    @Predicate(label = "mode.reglement",type = Tier.class,target = "many-to-one",search = true,optional = false)
    private ModeReglement modereglement ;
    
    @Predicate(label = "montant.reglement" ,type = Double.class,search = true,editable = false)
    private Double montant ;
    
    @Predicate(label = "reference",search = true)
    private String source;

    /**
     * 
     */
    public ReglementFournisseur() {
    }

    /**
     * 
     * @param code
     * @param fournisseur
     * @param date
     * @param modereglement
     * @param montant
     * @param source
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ReglementFournisseur(String code, Tier fournisseur, Date date, ModeReglement modereglement, Double montant, String source, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.fournisseur = fournisseur;
        this.date = date;
        this.modereglement = modereglement;
        this.montant = montant;
        this.source = source;
    }

    /**
     * 
     * @param entity 
     */
     public ReglementFournisseur(ReglementFournisseur entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.fournisseur!=null){
            this.fournisseur = new Tier(entity.fournisseur);
        }
        this.date = entity.date;
        this.modereglement = entity.modereglement;
        this.montant = entity.montant;
        this.source = entity.source;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ModeReglement getModereglement() {
        return modereglement;
    }

    public void setModereglement(ModeReglement modereglement) {
        this.modereglement = modereglement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
    

    
    
    @Override
    public int compareTo(ReglementFournisseur o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
