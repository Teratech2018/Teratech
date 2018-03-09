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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("DP")
public class DemandePrix extends DocumentAchat implements Serializable{

    @Temporal(TemporalType.DATE)
    @Predicate(label = "Offre recue le",type = Date.class,target = "date",group = true,groupName = "group2",groupLabel = "Offres")
    private Date dateoffre ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Offre valable jusqu'au",type = Date.class,target = "date",group = true,groupName = "group2",groupLabel = "Offres")
    private Date validiteoffre;
    
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
    
    
    public DemandePrix() {
        this.typedocument = DocumentAchatState.DEMANDE_PRIX;
    }

    /**
     * 
     * @param dateoffre
     * @param validiteoffre
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public DemandePrix(Date dateoffre, Date validiteoffre, String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement);
        this.dateoffre = dateoffre;
        this.validiteoffre = validiteoffre;
        this.typedocument = DocumentAchatState.DEMANDE_PRIX;
    }

    /**
     * 
     * @param dateoffre
     * @param validiteoffre
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
    public DemandePrix(Date dateoffre, Date validiteoffre, String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement, id, designation, moduleName);
        this.dateoffre = dateoffre;
        this.validiteoffre = validiteoffre;
        this.typedocument = DocumentAchatState.DEMANDE_PRIX;
    }

    /**
     * 
     * @param dateoffre
     * @param validiteoffre
     * @param da 
     */
    public DemandePrix(Date dateoffre, Date validiteoffre, DocumentAchat da) {
        super(da);
        this.dateoffre = dateoffre;
        this.validiteoffre = validiteoffre;
        this.typedocument = DocumentAchatState.DEMANDE_PRIX;
    }

   public DemandePrix(DocumentAchat da) {
        super(da);      
        this.typedocument = da.typedocument;
    }
    
     public DemandePrix(DemandePrix da) {
        super(da);
        this.dateoffre = da.dateoffre;
        this.validiteoffre = da.validiteoffre;
        this.method = da.method;
        this.facturerecue = da.facturerecue;
        if(da.appeloffre!=null){
            this.appeloffre = new AppelOffre(da.appeloffre);
        }
        this.condreglement = da.getCondreglement();
        this.state = da.getState();
        this.typedocument = da.typedocument;
    }

    public Date getDateoffre() {
        return dateoffre;
    }

    public void setDateoffre(Date dateoffre) {
        this.dateoffre = dateoffre;
    }

    public Date getValiditeoffre() {
        return validiteoffre;
    }

    public void setValiditeoffre(Date validiteoffre) {
        this.validiteoffre = validiteoffre;
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
        State state = new State("etabli", "Pro-Forma");
        states.add(state);
//        state = new State("envoye", "Envoyée au fornisseur");
//        states.add(state);
        state = new State("confirme", "Confirmé");
        states.add(state);
        state = new State("annule", "Annulée");
        states.add(state);
//        state = new State("termine", "Terminée");
//        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "dp270220181057"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "DEMANDES DE PRIX"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "DEMANDE DE PRIX"; //To change body of generated methods, choose Tools | Templates.
    }
     
     
    
}
