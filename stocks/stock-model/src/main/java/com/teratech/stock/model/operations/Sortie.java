/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.State;
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
@DiscriminatorValue("OUT")
public class Sortie extends DocumentStock implements Serializable{

    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt cible ",type = Entrepot.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Entrepot entrepot ;
    
    @Predicate(label = "Référence",search = true)
    private String reference ;    
    
    
//    @Predicate(label = "Type document",target = "combobox",values = "")
    private String nature = "0";
    
     @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",optional = false,search = true)
//    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    private Tier fournisseur;
    
     @Predicate(label = "Location ?",type = Boolean.class,target = "checkbox",search = true ,hide = true)
    private Boolean location = Boolean.FALSE ;
     
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "OUT_ID")
    @Predicate(label = " ",type = LigneSortie.class,target = "one-to-many",group =true ,groupName = "group1",groupLabel = "Articles",edittable = true)
    private List<LigneSortie> lignes = new ArrayList<LigneSortie>();
    
//    @ManyToOne
//    @JoinColumn(name = "INPUT_ID")
//    private Entree entree ;
    
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Sortie(String code, Date date, Emplacement depot, String reference, String commentaire) {
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
    public Sortie(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "etabli";
    }

    /**
     * 
     * @param doc 
     */
    public Sortie(Sortie doc) {
        super(doc);
        this.state = doc.state;
        if(doc.entrepot!=null){
            this.entrepot = new Entrepot(doc.entrepot);
        }
        if(doc.fournisseur!=null){
            this.fournisseur = new Tier(doc.fournisseur);
        }
//        if(doc.entree!=null){
//            this.entree = new Entree(doc.entree);
//        }
        this.nature = doc.nature;
        this.reference = doc.reference;
        this.location = doc.location;
    }  
    
    /**
     * 
     */
    public Sortie() {
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

    public List<LigneSortie> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneSortie> lignes) {
        this.lignes = lignes;
    }

//    public Entree getEntree() {
//        return entree;
//    }
//
//    public void setEntree(Entree entree) {
//        this.entree = entree;
//    }

    public Boolean getLocation() {
        return location;
    }

    public void setLocation(Boolean location) {
        this.location = location;
    }
    
    

    @Override
    public String getEditTitle() {
        return "SORTIE"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "SORTIES"; //To change body of generated methods, choose Tools | Templates.
    }

        
    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return false; //To change body of generated methods, choose Tools | Templates.
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
        if(this.state.equalsIgnoreCase("etabli")){
            states.add(new State("etabli","Brouillon"));
            states.add(new State("valide","Confirmer"));
        }else if(this.state.equalsIgnoreCase("valide")){
            if(location.equals(Boolean.TRUE)){
                states.add(new State("attente","Attente Retour"));
                states.add(new State("retourne","Retourné"));
            }else{
               states.add(new State("valide","Confirmer"));            
            }//end  if(location.equals(Boolean.TRUE)){
        }else if(this.state.equalsIgnoreCase("attente")){
            states.add(new State("attente","Attente Retour"));
            states.add(new State("retourne","Retourné"));
        }else if(this.state.equalsIgnoreCase("retourne")){
            states.add(new State("retourne","Retourné"));
        }
        return states; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
