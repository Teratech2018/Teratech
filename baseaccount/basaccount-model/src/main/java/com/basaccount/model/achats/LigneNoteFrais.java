/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.basaccount.model.comptabilite.Compte;
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
@Table(name = "T_LINOFR")
public class LigneNoteFrais extends BaseElement implements Serializable,Comparable<LigneNoteFrais>{

    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compte",type = Compte.class,target = "many-to-one",optional = false,search = true)
    private Compte compte ;
    
    @Predicate(label = "Description",search = true)
    private String libelle ;
    
    @Predicate(label = "Montant",type = Double.class,optional = false,search = true)
    private Double montant =0.0;

    public LigneNoteFrais(Compte compte, String libelle) {
        this.compte = compte;
        this.libelle = libelle;
    }

    public LigneNoteFrais(Compte compte, String libelle, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.compte = compte;
        this.libelle = libelle;
    }
    
    /**
     * 
     * @param ligne 
     */
    public LigneNoteFrais(LigneNoteFrais ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName);
        if(ligne.compte!=null){
            this.compte = new Compte(ligne.compte);
        }
        this.libelle = ligne.libelle;
    }

    /**
     * 
     */
    public LigneNoteFrais() {
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
    
    
    
    @Override
    public int compareTo(LigneNoteFrais o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
