/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.comptabilite;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ACOM")
public class Acompte extends BaseElement implements Serializable,Comparable<Acompte>{

    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date",type = Date.class,target = "date",search = true)
    private Date date ;
    
    @Predicate(label = "N° Pièce",optional = false,search = true)
    private String code ;
    
    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compte",type = Compte.class,target = "many-to-one",optional = false,search = true)
    private Compte compte;
    
    @ManyToOne
    @JoinColumn(name = "JOCO_ID")
     @Predicate(label = "Journal",type = JournalComptable.class,target = "many-to-one",optional = false,search = true)
    private JournalComptable journal;
    
    @Predicate(label = "Montant",type = Double.class,optional = false,search = true)
    private Double montant = 0.0;
    
    @ManyToOne
    @JoinColumn(name = "MORE_ID")
    @Predicate(label = "Mode de règlement",type = ModeReglement.class,target = "many-to-one",optional = false,search = true)
    private ModeReglement mode ;

    
    /**
     * 
     * @param date
     * @param code
     * @param compte
     * @param journal
     * @param mode 
     */
    public Acompte(Date date, String code, Compte compte, JournalComptable journal, ModeReglement mode) {
        this.date = date;
        this.code = code;
        this.compte = compte;
        this.journal = journal;
        this.mode = mode;
    }

    /**
     * 
     * @param date
     * @param code
     * @param compte
     * @param journal
     * @param mode
     * @param id
     * @param designation
     * @param moduleName 
     */
    public Acompte(Date date, String code, Compte compte, JournalComptable journal, ModeReglement mode, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.date = date;
        this.code = code;
        this.compte = compte;
        this.journal = journal;
        this.mode = mode;
    }
    
    public Acompte(Acompte acompte) {
        super(acompte.id, acompte.designation, acompte.moduleName);
        this.date = acompte.date;
        this.code = acompte.code;
        if(acompte.compte!=null){
            this.compte = new Compte(acompte.compte);
        }
        this.journal = acompte.journal;
        this.mode = acompte.mode;
        this.montant = acompte.montant;
    }

    public Acompte() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public JournalComptable getJournal() {
        return journal;
    }

    public void setJournal(JournalComptable journal) {
        this.journal = journal;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public ModeReglement getMode() {
        return mode;
    }

    public void setMode(ModeReglement mode) {
        this.mode = mode;
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
        return "Acomptes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Acompte"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(Acompte o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
