/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.vente.model.base.Entrepot;
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
@DiscriminatorValue("BL")
public class BonLivraison extends DocumentStock implements Serializable{

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "BL_ID")
    @Predicate(label = " ",type = LIgneBonLivraison.class,target = "one-to-many",group =true ,groupName = "group1",groupLabel = "Articles",edittable = true)
    private List<LIgneBonLivraison> lignes = new ArrayList<LIgneBonLivraison>();
   
    @ManyToOne
    @JoinColumn(name = "CMD_ID")
    @Predicate(label = "Document source",type = Commande.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Complément",hidden = "currentObject.commande==null")
    private Commande commande ;
    
    @ManyToOne
    @JoinColumn(name = "DVS_ID")
    @Predicate(label = "Document source",type = Devis.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Complément",hidden = "currentObject.devis==null")
    private Devis devis ;
    
    @Predicate(label = "Total HT",type = Double.class,search = true,hide = true,editable = false)
    private Double totalht = 0.0;
    
    
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public BonLivraison(String code, Date date, Entrepot depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
    }

    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire
     * @param id
     * @param designation
     * @param moduleName 
     */
    public BonLivraison(String code, Date date, Entrepot depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
    }

    /**
     * 
     * @param doc 
     */
    public BonLivraison(DocumentStock doc) {
        super(doc);
    }

    /**
     * 
     * @param doc 
     */
    public BonLivraison(BonLivraison doc) {
        super(doc);
        if(doc.commande!=null){
            this.commande = new Commande(doc.commande);
        }
        if(doc.devis!=null){
            this.devis = new Devis(doc.devis);
        }
        this.state = doc.state;
        this.totalht = doc.totalht;
    }

    /**
     * 
     */
    public BonLivraison() {
    }

    public List<LIgneBonLivraison> getLignes() {
        return lignes;
    }

    public void setLignes(List<LIgneBonLivraison> lignes) {
        this.lignes = lignes;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Devis getDevis() {
        return devis;
    }

    public void setDevis(Devis devis) {
        this.devis = devis;
    }

    
    
    @Override
    public String getOwnermodule() {
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return this.state.equalsIgnoreCase("confirme"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return this.state.equalsIgnoreCase("confirme"); //To change body of generated methods, choose Tools | Templates.
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
    public List<State> getStates() {
        List<State> states  = new ArrayList<State>();
        states.add(new State("etabli", "Brouillon"));
        states.add(new State("confirme", "Livraison Confirmé"));
        return states; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
