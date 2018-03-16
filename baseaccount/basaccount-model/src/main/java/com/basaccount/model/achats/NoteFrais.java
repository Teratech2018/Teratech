/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.basaccount.model.comptabilite.Compte;
import com.basaccount.model.comptabilite.JournalComptable;
import com.basaccount.model.comptabilite.Taxe;
import com.basaccount.model.tiers.Tier;
import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "T_NOFR")
public class NoteFrais extends BaseElement implements Serializable,Comparable<NoteFrais>{
    
    @Predicate(label = "N° de Référence",optional = false,unique = true,search = true)
    private String code ;
    
    @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",optional = false,search = true)
    private Tier fournisseur ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date Facturation",type = Date.class,optional = false,search = true)
    private Date date ;
    
    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compte",type = Compte.class,target = "many-to-one",optional = false,search = true)
    private Compte compte ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date d'échéance",type = Date.class,optional = false,search = true)
    private Date decheance;
    
    @Predicate(label = "Mémo",search = true)
    private String memo;
    
    @ManyToOne
    @JoinColumn(name = "JOUR_ID")
    @Predicate(label = "Journal Comptable",type = JournalComptable.class,target = "many-to-one",optional = false,search = true)
    private JournalComptable journal ;
    
    @ManyToOne
    @JoinColumn(name = "TAX_ID")
    @Predicate(label = "Taxe",type = Taxe.class,target = "many-to-one",search = true)
    private Taxe taxe ;
    
    @OneToMany(orphanRemoval = false,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "NOFR_ID")
    @Predicate(label = "Lignes",type = LigneNoteFrais.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "NOTES DE FRAIS")
    private List<LigneNoteFrais> notes = new ArrayList<LigneNoteFrais>();

    @Predicate(label = "Notes",target = "textarea",group = true,groupName = "group2",groupLabel = "Commentaire")
    private String commentaire ;
    
    
    /**
     * 
     * @param code
     * @param fournisseur
     * @param date
     * @param compte
     * @param decheance
     * @param memo
     * @param journal 
     */
    public NoteFrais(String code, Tier fournisseur, Date date, Compte compte, Date decheance, String memo, JournalComptable journal) {
        this.code = code;
        this.fournisseur = fournisseur;
        this.date = date;
        this.compte = compte;
        this.decheance = decheance;
        this.memo = memo;
        this.journal = journal;
    }

    /**
     * 
     * @param code
     * @param fournisseur
     * @param date
     * @param compte
     * @param decheance
     * @param memo
     * @param journal
     * @param id
     * @param designation
     * @param moduleName 
     */
    public NoteFrais(String code, Tier fournisseur, Date date, Compte compte, Date decheance, String memo, JournalComptable journal, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.code = code;
        this.fournisseur = fournisseur;
        this.date = date;
        this.compte = compte;
        this.decheance = decheance;
        this.memo = memo;
        this.journal = journal;
    }
    
    /**
     * 
     * @param note 
     */
    public NoteFrais(NoteFrais note) {
        super(note.id, note.designation, note.moduleName);
        this.code = note.code;
        if(note.fournisseur!=null){
            this.fournisseur = new Tier(note.fournisseur);
        }
        this.date = note.date;
        if(note.compte!=null){
            this.compte = new Compte(note.compte);
        }
        if(note.taxe!=null){
            this.taxe = new Taxe(note.taxe);
        }
        this.decheance = note.decheance;
        this.memo = note.memo;
        this.journal = note.journal;
        this.commentaire = note.commentaire;
    }

    public NoteFrais() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Date getDecheance() {
        return decheance;
    }

    public void setDecheance(Date decheance) {
        this.decheance = decheance;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public JournalComptable getJournal() {
        return journal;
    }

    public void setJournal(JournalComptable journal) {
        this.journal = journal;
    }

    public Taxe getTaxe() {
        return taxe;
    }

    public void setTaxe(Taxe taxe) {
        this.taxe = taxe;
    }    

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }    
    

    public List<LigneNoteFrais> getNotes() {
        return notes;
    }

    public void setNotes(List<LigneNoteFrais> notes) {
        this.notes = notes;
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        return super.getStates(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "160320180913NF"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "baseaccount"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Reçus d'achats"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Reçu d'achat";//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(NoteFrais o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
