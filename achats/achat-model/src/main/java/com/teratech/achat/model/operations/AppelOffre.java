/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_APOF")
public class AppelOffre extends BaseElement implements Serializable,Comparable<AppelOffre>{

    @Predicate(label = "Réference de l'appel",optional = false,search = true)
    private String code ;
    
    @Predicate(label = "Document  d'origine",optional = false,search = true)
    private String reference;
    
    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    @Predicate(label = "Responsable",type = Tier.class,target = "many-to-one",optional = false,search = true)
    private Tier responsable ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date limite de soumission",type = Date.class,target = "date",search = true)
    private Date deadline ;
    
    @Predicate(label = "Type de sélection",target = "combobox" ,updatable = false,values = "Choisir une seule demande de prix(exclusive);Choisir plusieurs demandes de prix")
    private String typeselection = "0";
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date de commande prevue",type = Date.class,target = "date",search = true)
    private Date datecommande ;
    
//    private String typepreparation = "0";
    
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    @JoinColumn(name = "APOF_ID")
    @Predicate(label = "AP",type = LigneAppeloffre.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Produits",edittable = true)
    private List<LigneAppeloffre> lignes = new ArrayList<LigneAppeloffre>();
    
    @Predicate(label = "COND",target = "textarea",group = true,groupName = "group3",groupLabel = "Conditions générales")
    private String commentaire ;
    
//    @ManyToOne
//    @JoinColumn(name = "DEPR_ID")
//    @Predicate(label = "Demande de prix",type = DemandePrix.class,target = "many-to-one",hidden = "currentObject.typeselection=='1' || currentObject.state=='etabli'")
//    @Filter(value = "[{\"fieldName\":\"state\",\"value\":\"confirme\"}]")
//    private DemandePrix offre ;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "appeloffre")
    @Predicate(label ="AP",type = DemandePrix.class,target = "many-to-many-list",editable = false,group = true,groupName = "group2",groupLabel = "Offres ",hidden = "currentObject.state=='etabli' || currentObject.state=='' || currentObject.state==null")
    @Filter(value = "[{\"fieldName\":\"state\",\"value\":\"confirme\"}]")
    private List<DemandePrix> offres = new ArrayList<DemandePrix>();
    
    
    private String state="etabli";

    
    /**
     * 
     * @param code
     * @param reference
     * @param responsable
     * @param deadline
     * @param datecommande
     * @param condition 
     */
    public AppelOffre(String code, String reference, Tier responsable, Date deadline, Date datecommande, String condition) {
        this.code = code;
        this.reference = reference;
        this.responsable = responsable;
        this.deadline = deadline;
        this.datecommande = datecommande;
        this.commentaire = condition;
    }

    /**
     * 
     * @param code
     * @param reference
     * @param responsable
     * @param deadline
     * @param datecommande
     * @param condition
     * @param id
     * @param designation
     * @param moduleName 
     */
    public AppelOffre(String code, String reference, Tier responsable, Date deadline, Date datecommande, String condition, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.reference = reference;
        this.responsable = responsable;
        this.deadline = deadline;
        this.datecommande = datecommande;
        this.commentaire = condition;
    }
    
     public AppelOffre(AppelOffre ap) {
        super(ap.id, ap.designation, ap.moduleName,ap.compareid);
        this.code = ap.code;
        this.reference = ap.reference;
        if(ap.responsable!=null){
            this.responsable = new Tier(ap.responsable);
        }//end if(ap.responsable!=null)
//        if(ap.offre!=null){
//            this.offre = new DemandePrix(ap.offre);
//        }
        this.deadline = ap.deadline;
        this.datecommande = ap.datecommande;
        this.commentaire = ap.commentaire;
        this.state = ap.state;
    }

    public AppelOffre() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Tier getResponsable() {
        return responsable;
    }

    public void setResponsable(Tier responsable) {
        this.responsable = responsable;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTypeselection() {
        return typeselection;
    }

    public void setTypeselection(String typeselection) {
        this.typeselection = typeselection;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DemandePrix> getOffres() {
        return offres;
    }

    public void setOffres(List<DemandePrix> offres) {
        this.offres = offres;
    }

//    public DemandePrix getOffre() {
//        return offre;
//    }
//
//    public void setOffre(DemandePrix offre) {
//        this.offre = offre;
//    }
    
    

//    public String getTypepreparation() {
//        return typepreparation;
//    }
//
//    public void setTypepreparation(String typepreparation) {
//        this.typepreparation = typepreparation;
//    }

    public List<LigneAppeloffre> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneAppeloffre> lignes) {
        this.lignes = lignes;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

   
    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Broullion");
        states.add(state);
//        state = new State("etabli", "Broullion");
//        states.add(state);
        state = new State("confirme", "Confirmé");
        states.add(state);
        state = new State("selection", "Sélection des offres");
        states.add(state);
        state = new State("boncommande", "Bon commande crée");
        states.add(state);
        state = new State("annule", "Annuler");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "APPELS D'OFFRES"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "APPEL D'OFFRE"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(AppelOffre o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
