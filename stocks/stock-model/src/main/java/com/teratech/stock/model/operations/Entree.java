/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import com.teratech.stock.model.base.Tier;
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
@DiscriminatorValue("IN")
public class Entree extends DocumentStock implements Serializable{
    
    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt cible ",type = Entrepot.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Entrepot entrepot ;
    
    @Predicate(label = "Référence",search = true)
    private String reference ;
    
//    @Predicate(label = "Type document",target = "combobox",values = "Retour location;Autres")
    private String nature = "0";
    
     @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",optional = false,search = true)
//    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    private Tier fournisseur;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "IN_ID")
    @Predicate(label = " ",type = LigneEntree.class,target = "one-to-many",group =true ,groupName = "group1",groupLabel = "Articles",customfooter = true,edittable = true)
    private List<LigneEntree> lignes = new ArrayList<LigneEntree>();
     
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Entree(String code, Date date, Emplacement depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
        this.state = "etabli";
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
    public Entree(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "etabli";
    }

    public Entree(Entree doc) {
        super(doc);
        this.state = doc.state;
        if(doc.entrepot!=null){
            this.entrepot = new Entrepot(doc.entrepot);
        }
        if(doc.fournisseur!=null){
            this.fournisseur = new Tier(doc.fournisseur);
        }
        this.nature = doc.nature;
        this.reference = doc.reference;
    }

     /**
     * 
     */
    public Entree() {
        this.state = "etabli";
    }
    
    
    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneEntree> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneEntree> lignes) {
        this.lignes = lignes;
    }
    
    

    @Override
    public boolean isDesableupdate() {
        return !state.equalsIgnoreCase("etabli")
                &&!state.equalsIgnoreCase("qualite"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return !state.equalsIgnoreCase("etabli")
                &&!state.equalsIgnoreCase("qualite")
                &&!state.equalsIgnoreCase("transfere"); //To change body of generated methods, choose Tools | Templates.
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
        List<State> states = new ArrayList<State>();
        State state = null;
        if(this.state.equalsIgnoreCase("etabli")){
             state = new State("etabli", "Brouillon");
             states.add(state);
            state = new State("transfere", "Disponible");
            states.add(state);        
        }else if(this.state.equalsIgnoreCase("qualite")){
            state = new State("qualite", "Brouillon");
            states.add(state);
            state = new State("controle", "Qualité controlée");
            states.add(state);
        }else if(this.state.equalsIgnoreCase("transfere")){
             state = new State("transfere", "Attente de transfert");
            states.add(state);
            state = new State("disponible", "Disponible en stock");
            states.add(state);
//            state = new State("annule", "Annulé");
//            states.add(state);
        }else if(this.state.equalsIgnoreCase("disponible")){
            state = new State("disponible", "Disponible en stock");
            states.add(state);
        }      
        return states; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
