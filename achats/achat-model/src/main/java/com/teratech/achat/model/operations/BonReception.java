/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("BR")
public class BonReception extends DocumentAchat implements Serializable{

    @Predicate(label = "Document d'origine")
    private String origine ;
    
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
    public BonReception(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement);
        this.typedocument = DocumentAchatState.BONLIVRAISON;
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
    public BonReception(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement, id, designation, moduleName);
        this.typedocument = DocumentAchatState.BONLIVRAISON;
    }

    /**
     * 
     * @param da 
     */
    public BonReception(DocumentAchat da) {
        super(da);
        this.typedocument = DocumentAchatState.BONLIVRAISON;
        
    }

    /**
     * 
     */
    public BonReception() {
        this.typedocument = DocumentAchatState.BONLIVRAISON;
    }
    
    /**
     * 
     * @param da 
     */
    public BonReception(BonReception da) {
        super(da);
        this.origine = da.origine;
    }

    /**
     * 
     * @return 
     */
    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }
    
     @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
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
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Brouillon");
        states.add(state);
         state = new State("confirme", "Qualité contrôlée");
        states.add(state);        
        state = new State("rejete", "Rejeter");
        states.add(state);
       state = new State("transfere", "Transferer");
        states.add(state);
        state = new State("annule", "Annulée");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String getListTitle() {
        return "BONS DE RECEPTIONS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "BON DE RECEPTION"; //To change body of generated methods, choose Tools | Templates.
    }

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
    
    
    
}
