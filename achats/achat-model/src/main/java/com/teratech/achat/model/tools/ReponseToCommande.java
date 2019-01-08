/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.tools;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.ConditionPaiement;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.Entrepot;
import com.teratech.achat.model.base.Tier;
import com.teratech.achat.model.operations.ReponseFournisseur;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
public class ReponseToCommande extends BaseElement implements Serializable,Comparable<ReponseToCommande>{

    @Predicate(label = "Date Commande",type = Date.class,target = "date",search = true)
    private Date date ;
    
    @ManyToOne
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",editable = false)
    private Tier fournisseur ;
    @ManyToOne
    @Predicate(label = "Entrepôt de Livraison",type = Entrepot.class,target = "many-to-one")
    private Entrepot entrepot;
    
    @ManyToOne
    @Predicate(label = "Lieu livraison",type = Emplacement.class,target = "many-to-one")
    private Emplacement emplacement ;
    
   @Predicate(label = "Méthode de facturation",target = "combobox",values = "Basé sur le bon de commande;Basé sur les receptions",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private String method="0";
   
    @ManyToOne
    @JoinColumn(name = "CORE_ID")
    @Predicate(label = "Condition règlement",type = ConditionPaiement.class,target = "many-to-one",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private ConditionPaiement condreglement ;
    
    @ManyToOne
    @Predicate(label = "Reponse Fournisseur",type = ReponseFournisseur.class,target = "many-to-one",editable = false)
    private ReponseFournisseur reponse ;

    public ReponseToCommande() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public ConditionPaiement getCondreglement() {
        return condreglement;
    }

    public void setCondreglement(ConditionPaiement condreglement) {
        this.condreglement = condreglement;
    }

    public ReponseFournisseur getReponse() {
        return reponse;
    }

    public void setReponse(ReponseFournisseur reponse) {
        this.reponse = reponse;
    }

    
    
    @Override
    public String getOwnermodule() {
        return "teratechacht"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return super.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechacht"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Generation Commande"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(ReponseToCommande o) {
        return fournisseur.compareTo(o.fournisseur); //To change body of generated methods, choose Tools | Templates.
    }
    
}
