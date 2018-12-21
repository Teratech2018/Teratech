/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.operations;

import com.megatim.common.annotations.Connector;
import com.megatim.common.annotations.Include;
import com.megatim.common.annotations.Predicate;
import com.megatimgroup.model.referentiels.Devise;
import com.megatimgroup.model.referentiels.Motif;
import com.megatimgroup.model.referentiels.Pays;
import com.megatimgroup.model.referentiels.SensOperation;
import com.megatimgroup.model.referentiels.TypeOperation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="D_FINANCIERE")
public class DeclarationFinanciere  implements Serializable , Comparable<DeclarationFinanciere> {
    
    /**
    * 
    */
   private static final long serialVersionUID = 1L;

   @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected long id ;
    
    //Reference interne de l'agent economique
    @Column(name="C_REF")
    @Predicate(max=15,nullable=false,optional=false,label="Reference interne de l'agent economique")
    @Include(classes={DeclarationPP.class,DeclarationPM.class},
            champs={"reference","reference"},connector= Connector.OR,value="")
    protected String reference ;    
    

    @Column(name="C_DESIGN")
    @Predicate(max=50,nullable=false,optional=false,label="Designation agent économique")
    private String designation ;
    
    @Column(name="N_MONTANT")
    @Predicate(nullable=false,optional=false,type=BigDecimal.class,label="Montant de l'opération")
    private BigDecimal montant ;
    
    @ManyToOne
    @JoinColumn(name="C_SENS")
    @Predicate(nullable=false,optional=false,entry=true,type=SensOperation.class,label="Sens de l'opération")
    private SensOperation sens ;
    
    @ManyToOne
    @JoinColumn(name="C_DEVISE")
    @Predicate(nullable=false,optional=false,entry=true,type=Devise.class,label="Dévise")
    private Devise devise ;
    
    @Column(name="D_OPER")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(nullable=false,optional=false,type=Date.class,label="Date de l'opération")
    private Date dateOperation ;
    
    @ManyToOne
    @JoinColumn(name="C_TYPE")
    @Predicate(nullable=false,optional=false,type=TypeOperation.class,label="Type de l'opération")
    private TypeOperation type ;
    
    @ManyToOne
    @JoinColumn(name="C_PAYS")
    @Predicate(nullable=false,optional=false,type=Pays.class,label="Code pays transaction")
    private Pays pays ;
    
    @ManyToOne
    @JoinColumn(name="C_MOTIF")
    @Predicate(nullable=false,optional=false,type=Motif.class,label="Code motif")
    private Motif motif ;
    
    @Column(name="C_COMM")
    @Predicate(max=150,label="Commentaire")
    private String commentaire ;
   
    @Column(name="N_MTCN")
    @Predicate(label="MTCN")
    private String mtcn ;
    
    @Column(name="ID_OPERATION")
    @Predicate(label="NUM_OPERATION")
    private String idOperation;
    
    @ManyToOne
    @JoinColumn(name="PP_ID")
    private DeclarationPP pysique ;
    
    @ManyToOne
    @JoinColumn(name="PM_ID")
    private DeclarationPM morale;
    /**
     * 
     */
    public DeclarationFinanciere() {
    }

    
//    /**
//     * 
//     * @param reference 
//     */
//    public DeclarationFinanciere(String reference) {
//        super(reference);
//    }

    
    /**
     * 
     * @param designation
     * @param montant
     * @param sens
     * @param devise
     * @param dateOperation
     * @param type
     * @param pays
     * @param motif
     * @param commentaire
     * @param reference 
     */
    public DeclarationFinanciere(String designation, BigDecimal montant, SensOperation sens, Devise devise, Date dateOperation, TypeOperation type, Pays pays, Motif motif, String commentaire, String reference) {
        this.reference = reference;
        this.designation = designation;
        this.montant = montant;
        this.sens = sens;
        this.devise = devise;
        this.dateOperation = dateOperation;
        this.type = type;
        this.pays = pays;
        this.motif = motif;
        this.commentaire = commentaire;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public SensOperation getSens() {
        return sens;
    }

    public void setSens(SensOperation sens) {
        this.sens = sens;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public TypeOperation getType() {
        return type;
    }

    public void setType(TypeOperation type) {
        this.type = type;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    } 

    public String getMtnc() {
        return mtcn;
    }

    public void setMtcn(String mtnc) {
        this.mtcn = mtnc;
    }

    public DeclarationPP getPysique() {
        return pysique;
    }

    public void setPysique(DeclarationPP pysique) {
        this.pysique = pysique;
    }

    public DeclarationPM getMorale() {
        return morale;
    }

    public void setMorale(DeclarationPM morale) {
        this.morale = morale;
    } 

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }
    

    
    
    /**
     * 
     * @param o
     * @return 
     */
    public int compareTo(DeclarationFinanciere o) {
        return Long.compare(id, o.id);
    }
    
    
    
}
