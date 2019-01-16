/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.basaccount.model.comptabilite.Compte;
import com.basaccount.model.comptabilite.JournalComptable;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotations.TableFooter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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

    @Predicate(label = "Type de facture",target = "combobox",values = "Facture Achats;Facture Avoirs;Facture Retour")
    @Column(name = "TYPE_FACTURE")
    private String type = "0";
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "LIFAC_ID")
    @Predicate(label = " ",type = LigneFacture.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Articles",customfooter = true,edittable = true)
    @TableFooter(value = "<tr style='border:none;'><td></td><td></td><td></td><td'></td><td style='font-weight: bold;'>Total HT</td> <td class='text-center'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td><td></td></tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td  class='text-center'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td><td></td> </tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td  class='text-center'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td><td></td></tr>")
    protected List<LigneFacture> lignes = new ArrayList<LigneFacture>();    
    
    @Predicate(label = "Document origine")
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
    
    
    @Predicate(label = "Total HT",type = Double.class,search = true,hide = true)
    private Double totalht = 0.0;
    
    private Double totalescompte = 0.0;
    
    @Predicate(label = "Total TTC",type = Double.class,search = true,hide = true)
    private Double totalttc = 0.0;
    
    private Double totalacompte;
    
    private Double totaltaxes = 0.0;
    
    @Predicate(label = "Net à payer",type = Double.class,search = true,hide = true)
    private Double netapayer = 0.0;    
          
    @Predicate(label = " ",target = "state",hide = true,search = true)
     protected String state ="etabli" ;
    
    /**
     * 
     */
    public Facture() {
        this.typedocument = DocumentAchatState.FACTURE;
//        this.state = "etabli";
    }

   

    

  
    
    public Facture(Facture da) {
        super(da);
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
        if(da.getCompte()!=null){
            this.compte = new Compte(da.getCompte());
        }
        this.journal = da.getJournal();
        this.escompte = da.escompte;
        this.type = da.type;
        this.totalttc = da.totalttc;
        this.totalht = da.totalht;
        this.totalescompte = da.totalescompte;
        this.totalacompte = da.totalacompte;
        this.netapayer = da.netapayer;
        this.totaltaxes = da.totaltaxes;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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

    public List<LigneFacture> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneFacture> lignes) {
        this.lignes = lignes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Double getTotalescompte() {
        return totalescompte;
    }

    public void setTotalescompte(Double totalescompte) {
        this.totalescompte = totalescompte;
    }

    public Double getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(Double totalttc) {
        this.totalttc = totalttc;
    }

    public Double getTotalacompte() {
        return totalacompte;
    }

    public void setTotalacompte(Double totalacompte) {
        this.totalacompte = totalacompte;
    }

    public Double getTotaltaxes() {
        return totaltaxes;
    }

    public void setTotaltaxes(Double totaltaxes) {
        this.totaltaxes = totaltaxes;
    }

   

    public Double getNetapayer() {
        return netapayer;
    }

    public void setNetapayer(Double netapayer) {
        this.netapayer = netapayer;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }   

    @Override
    public List<State> getStates() {
         List<State> states = new ArrayList<State>();
        State state = null;
        if(this.state.equalsIgnoreCase("etabli")){
            state =new State("etabli", "Pro-forma");
            states.add(state);
            state = new State("confirme", "Confirmé");
            states.add(state);
        }else if(this.state.equalsIgnoreCase("confirme")){
             state = new State("confirme", "Confirmé");
            states.add(state);
            state = new State("transfere", "Transféré en comptabilité");
            states.add(state);
        }else if(this.state.equalsIgnoreCase("transfere")){
            state = new State("transfere", "Transféré en comptabilité");
            states.add(state);
            state = new State("reception", "Attente prise en compte");
            states.add(state);
        }        
        
//         state = new State("annule", "Annulé");
//         states.add(state);
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
    public boolean isDesableupdate() {
        return !this.state.equalsIgnoreCase("etabli"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "fa281220181602"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return !this.state.equalsIgnoreCase("etabli"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return super.isDesablecreate(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     @Override
    public String getListTitle() {
        return "FACTURES FOURNISSEURS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "FACTURE FOURNISSEUR"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnermodule() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
