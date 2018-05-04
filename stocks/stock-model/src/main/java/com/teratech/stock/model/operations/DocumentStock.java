/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
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
@Table(name = "T_DOCBA")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "OP",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("DC")
public class DocumentStock extends BaseElement implements Serializable,Comparable<DocumentStock>{

    @Predicate(label = "N° de pièce",optional = false,unique = true,search = true)
    protected String code ;
    
    @Predicate(label = "Date document",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    protected Date date ;
    
    @ManyToOne
    @JoinColumn(name = "EN_ID")
    @Predicate(label = "Emplacement ",type = Emplacement.class,target = "many-to-one",optional = false,nullable = false,search = true)
    protected Emplacement emplacement ;
    
    @Predicate(label = "Référence",search = true)
    protected String reference ;    
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "DOST_ID")
    @Predicate(label = "Ligne Doc",type = LigneDocumentStock.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Détails opération",edittable = true)
    protected List<LigneDocumentStock> lignes = new ArrayList<LigneDocumentStock>();
    
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group2",groupLabel = "Commentaire")
    protected String commentaire ;
    
    protected String state ="etabli";

    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public DocumentStock(String code, Date date, Emplacement depot, String reference, String commentaire) {
        this.code = code;
        this.date = date;
        this.emplacement = depot;
        this.reference = reference;
        this.commentaire = commentaire;
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
    public DocumentStock(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.code = code;
        this.date = date;
        this.emplacement = depot;
        this.reference = reference;
        this.commentaire = commentaire;
    }
    
    /**
     * 
     * @param doc 
     */
    public DocumentStock(DocumentStock doc) {
        super(doc.id, doc.designation, doc.moduleName);
        this.code = doc.code;
        this.date = doc.date;
        if(doc.getEmplacement()!=null){
            this.emplacement = new Emplacement(doc.emplacement);
        }
        this.reference = doc.reference;
        this.commentaire = doc.commentaire;
    }

    public DocumentStock() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    
    
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<LigneDocumentStock> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneDocumentStock> lignes) {
        this.lignes = lignes;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
        state = new State("valider", "Valider");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "docstock200220181214"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Mouvements d'entrées"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
         return "Entrée "; //To change body of generated methods, choose Tools | Templates.
    }  
    
    
    @Override
    public int compareTo(DocumentStock o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return "DocumentStock{" +id+" ==== "+ "code=" + code + ", date=" + date + ", emplacement=" + emplacement + ", reference=" + reference + ", lignes=" + lignes + ", commentaire=" + commentaire + ", state=" + state + '}';
    }
    
    
    
}
