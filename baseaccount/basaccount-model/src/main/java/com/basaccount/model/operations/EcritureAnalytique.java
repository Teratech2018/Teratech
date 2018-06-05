/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.operations;

import com.basaccount.model.comptabilite.CompteAnalytique;
import com.basaccount.model.comptabilite.ExerciceComptable;
import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "T_ECRIT_ANAL")
public class EcritureAnalytique extends BaseElement implements Serializable,Comparable<EcritureAnalytique>{

    @Temporal(TemporalType.DATE)
    @Predicate(label = "DATE ECRITURE",target = "date",optional = false,updatable = false,type = Date.class,search = true,colsequence = 1,sequence = 0)
    private Date dateEcriture ;
    
    @Predicate(label = "REFERENCE",search = true,colsequence = 2,sequence = 2)
    private String refPiece ;
    
    @Predicate(label = "LIBELLE",search = true,colsequence = 3,sequence = 3)
    private String libelle ;
    
       
    @ManyToOne
    @JoinColumn(name = "CPTE_ID")
    @Predicate(label = "COMPTE ANALYTIQUE",type = CompteAnalytique.class,updatable = false,optional = false,target = "many-to-one",search = true,colsequence = 4,sequence = 4)
    private CompteAnalytique compte ;
    
   
    @Predicate(label = "DEBIT",type = BigDecimal.class,search = true,colsequence = 6,sequence = 6,updatable = false)
    private BigDecimal debit =BigDecimal.ZERO;
    
    @Predicate(label = "CREDIT",type = BigDecimal.class,search = true,colsequence = 7,sequence = 7,updatable = false)
    private BigDecimal credit = BigDecimal.ZERO;
    
    @ManyToOne
    @JoinColumn(name = "EXER_ID")
    private ExerciceComptable exercice;

    /**
     * 
     * @param dateEcriture
     * @param refPiece
     * @param libelle
     * @param compte 
     */
    public EcritureAnalytique(Date dateEcriture, String refPiece, String libelle, CompteAnalytique compte) {
        this.dateEcriture = dateEcriture;
        this.refPiece = refPiece;
        this.libelle = libelle;
        this.compte = compte;
    }

    /**
     * 
     * @param dateEcriture
     * @param refPiece
     * @param libelle
     * @param compte
     * @param id
     * @param designation
     * @param moduleName 
     */
    public EcritureAnalytique(Date dateEcriture, String refPiece, String libelle, CompteAnalytique compte, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.dateEcriture = dateEcriture;
        this.refPiece = refPiece;
        this.libelle = libelle;
        this.compte = compte;
    }
    
    /**
     * 
     * @param data 
     */
    public EcritureAnalytique(EcritureAnalytique data) {
        super(data.id, data.designation, data.moduleName,data.compareid);
        this.dateEcriture = data.dateEcriture;
        this.refPiece = data.refPiece;
        this.libelle = data.libelle;
        this.compte = data.compte;
        this.debit = data.debit;
        this.credit = data.credit;
        this.exercice = data.exercice;
    }
    
   /**
    * 
    * @param data
    * @param compte
    * @param debit
    * @param credit 
    */
    public EcritureAnalytique(EcritureComptable data,CompteAnalytique compte , BigDecimal debit , BigDecimal credit) {
        this.dateEcriture = data.getDateEcriture();
        this.refPiece = data.getRefPiece();
        this.libelle = data.getLibelle();
        this.debit = debit ;
        this.credit = credit ;
        this.compte =compte;
        this.exercice = data.getExercice();
    }

    public EcritureAnalytique() {
    }

    public Date getDateEcriture() {
        return dateEcriture;
    }

    public void setDateEcriture(Date dateEcriture) {
        this.dateEcriture = dateEcriture;
    }

    public String getRefPiece() {
        return refPiece;
    }

    public void setRefPiece(String refPiece) {
        this.refPiece = refPiece;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public CompteAnalytique getCompte() {
        return compte;
    }

    public void setCompte(CompteAnalytique compte) {
        this.compte = compte;
    }

    public BigDecimal getDebit() {
        return debit;
    }

    public void setDebit(BigDecimal debit) {
        this.debit = debit;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }

    @Override
    public String getDesignation() {
        return libelle; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "INTERROGATION ANALYTIQUE"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "INTERROGATION ANALYTIQUE"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    public ExerciceComptable getExercice() {
        return exercice;
    }

    public void setExercice(ExerciceComptable exercice) {
        this.exercice = exercice;
    }
    
    
    
    @Override
    public int compareTo(EcritureAnalytique o) {
        //To change body of generated methods, choose Tools | Templates.
        return refPiece.compareTo(o.refPiece);
    }
    
}
