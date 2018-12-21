/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.ConditionPaiement;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("BC")
public class BonCommande extends DocumentAchat implements Serializable{

     @Predicate(label = "Méthode de facturation",target = "combobox",values = "Basé sur le bon de commande;Basé sur les receptions",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private String method="0";
    
    @Predicate(label = "Facture recue",type = Boolean.class,editable = false,group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private Boolean facturerecue = false;
    
    @ManyToOne
    @JoinColumn(name = "APOF_ID")
    @Predicate(label = "Appel d'offres",type = AppelOffre.class,target = "many-to-one",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private AppelOffre appeloffre ;
    
    @ManyToOne
    @JoinColumn(name = "CORE_ID")
    @Predicate(label = "Conditions de règlement",type = ConditionPaiement.class,target = "many-to-one",group = true,groupName = "group3",groupLabel = "Livraison&Factures")
    private ConditionPaiement condreglement ;
    
    @OneToMany(mappedBy = "docachat",fetch = FetchType.LAZY)
//    @Predicate(label = "Factures",type = Facture.class,target = "one-to-many",editable = false,group = true,groupName = "group4",groupLabel = "Factures")
    private List<Facture> factures = new ArrayList<Facture>();
    
    
    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public BonCommande(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement);
        this.typedocument = DocumentAchatState.BONCOMMANDE;
    }

    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement
     * @param id
     * @param designation
     * @param moduleName 
     */
    public BonCommande(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement, id, designation, moduleName);
        this.typedocument = DocumentAchatState.BONCOMMANDE;
    }

    /**
     * 
     * @param da 
     */
    public BonCommande(DocumentAchat da) {
        super(da);
        this.typedocument = da.typedocument;
    }
    
     public BonCommande(DemandePrix da) {
        super(da);
        this.method = da.getMethod();
        this.facturerecue = da.getFacturerecue();
        if(da.getAppeloffre()!=null){
            this.appeloffre = new AppelOffre(da.getAppeloffre());
        }
        this.condreglement = da.getCondreglement();
        this.typedocument = DocumentAchatState.BONCOMMANDE;
    }
     
     public BonCommande(BonCommande da) {
        super(da);
        this.method = da.getMethod();
        this.facturerecue = da.getFacturerecue();
        if(da.getAppeloffre()!=null){
            this.appeloffre = new AppelOffre(da.getAppeloffre());
        }
        this.condreglement = da.getCondreglement();
        this.typedocument = da.getTypedocument();
    }
     

    /**
     * 
     */
    public BonCommande() {
        this.typedocument = DocumentAchatState.BONCOMMANDE;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getFacturerecue() {
        return facturerecue;
    }

    public void setFacturerecue(Boolean facturerecue) {
        this.facturerecue = facturerecue;
    }

    public AppelOffre getAppeloffre() {
        return appeloffre;
    }

    public void setAppeloffre(AppelOffre appeloffre) {
        this.appeloffre = appeloffre;
    }

    public ConditionPaiement getCondreglement() {
        return condreglement;
    }

    public void setCondreglement(ConditionPaiement condreglement) {
        this.condreglement = condreglement;
    }

   
    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
         List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Broullion");
        states.add(state);
        state = new State("confirme", "Confirmé");
        states.add(state);
        state = new State("annule", "Annulé");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "bc270220181144"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "BONS DE COMMANDES"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "BON DE COMMANDE"; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
    
    
    
}
