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
import com.teratech.achat.model.comptabilite.Acompte;
import com.teratech.achat.model.comptabilite.Compte;
import com.teratech.achat.model.comptabilite.EcheanceReglement;
import com.teratech.achat.model.comptabilite.JournalComptable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
@DiscriminatorValue("FA")
public class Facture extends DocumentAchat implements Serializable{

    @ManyToOne
    @JoinColumn(name = "DOAC_ID")
    @Predicate(label = "Document source",type = BonCommande.class,target = "many-to-one")
    private BonCommande docachat;
    
    @Predicate(label = "Document d'origine")
    private String source;
    
    @Predicate(label = "Escompte(%)",type = Double.class,group = true,groupName = "group2",groupLabel = "Valorisation/Comptabilité")
    private Double escompte =0.0;
    
    @ManyToOne
    @JoinColumn(name = "JOCO_ID")
    @Predicate(label = "Journal Comptable",type = JournalComptable.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Valorisation/Comptabilité")
    private JournalComptable journal ;
    
    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compte",type = Compte.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Valorisation/Comptabilité")
    private Compte compte ;
    
    private Double transport=0.0;
    
    @Predicate(label = "Acomptes",type = Acompte.class,target = "one-to-many",group = true,groupName = "group3",groupLabel = "ACOMPTES",edittable = true)
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "FAC_ID")
    private List<Acompte> acomptes = new ArrayList<Acompte>();
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "ECRE_ID")
    @Predicate(label = "Echeances",type = EcheanceReglement.class,target = "one-to-many",group = true,groupName = "group4",groupLabel = "ECHEANCES",edittable = true)
    private List<EcheanceReglement> echeances = new ArrayList<EcheanceReglement>();
    
    
    /**
     * 
     */
    public Facture() {
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";
    }

    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public Facture(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement);
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";
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
    public Facture(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement, id, designation, moduleName);
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";
    }

    /**
     * 
     * @param da 
     */
    public Facture(BonCommande da) {
        super(da);
        this.id = -1;
        this.docachat = new BonCommande(da);
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";
       
    }


    public Facture(BonReception da) {
        super(da);
        this.id = -1;
        this.docachat = new BonCommande(da);
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";       
    }

   
    
    public Facture(Facture da) {
        super(da);
        if(da.getDocachat()!=null){
            this.docachat = new BonCommande(da.getDocachat());
        }//end if(da.getDocachat()!=null)
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
        if(da.getCompte()!=null){
            this.compte = new Compte(da.getCompte());
        }
        this.journal = da.getJournal();
        this.escompte = da.escompte;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BonCommande getDocachat() {
        return docachat;
    }

    public void setDocachat(BonCommande docachat) {
        this.docachat = docachat;
    }

    public Double getEscompte() {
        return escompte;
    }

    public void setEscompte(Double escompte) {
        this.escompte = escompte;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public List<Acompte> getAcomptes() {
        return acomptes;
    }

    public void setAcomptes(List<Acompte> acomptes) {
        this.acomptes = acomptes;
    }

    public List<EcheanceReglement> getEcheances() {
        return echeances;
    }

    public void setEcheances(List<EcheanceReglement> echeances) {
        this.echeances = echeances;
    }

    public JournalComptable getJournal() {
        return journal;
    }

    public void setJournal(JournalComptable journal) {
        this.journal = journal;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

   

    @Override
    public List<State> getStates() {
         List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Broullion");
        states.add(state);
        state = new State("confirme", "Confirmé");
        states.add(state);
        state = new State("transfere", "Transfert en comptabilité");
        states.add(state);
        state = new State("annule", "Annulé");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
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
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     @Override
    public String getListTitle() {
        return "FACTURES FOURNISSEURS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "FACTURE FOURNISSEUR"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
