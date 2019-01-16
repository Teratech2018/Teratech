/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.ventes;

import com.basaccount.model.achats.*;
import com.basaccount.model.comptabilite.Compte;
import com.basaccount.model.comptabilite.Taxe;
import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LINOFR_ACH")
public class LigneNoteFraisVente extends BaseElement implements Serializable,Comparable<LigneNoteFraisVente>{

    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compte",type = Compte.class,target = "many-to-one",optional = false,search = true)
    private Compte compte ;
    
    @Predicate(label = "Description",search = true)
    private String libelle ;
    
    @Predicate(label = "Montant",type = Double.class,optional = false,search = true)
    private Double montant =0.0;
    
    @ManyToOne
    @JoinColumn(name = "TAX_ID")
    @Predicate(label = "Taxes",type = Taxe.class,target = "many-to-one",search = true)
    private Taxe taxe ;
    
    @Predicate(label = "Total HT",type = Double.class,editable = false)
    private Double total ;

    public LigneNoteFraisVente(Compte compte, String libelle) {
        this.compte = compte;
        this.libelle = libelle;
    }

    public LigneNoteFraisVente(Compte compte, String libelle, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.compte = compte;
        this.libelle = libelle;
    }
    
    /**
     * 
     * @param ligne 
     */
    public LigneNoteFraisVente(LigneNoteFraisVente ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
        if(ligne.compte!=null){
            this.compte = new Compte(ligne.compte);
        }
        this.libelle = ligne.libelle;
        this.total = ligne.total;
    }

    /**
     * 
     */
    public LigneNoteFraisVente() {
    }
    
    

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String getDesignation() {
        return compte.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Note de frais"; //To change body of generated methods, choose Tools | Templates.
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
    
    @Override
    public int compareTo(LigneNoteFraisVente o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
