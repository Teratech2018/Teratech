/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CONTRATGM")
public class Contrat extends BaseElement implements Serializable,Comparable<Contrat>{

    @Predicate(label = "Contrat",optional = false,unique = true ,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false ,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "FAM_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one",optional = false ,search = true)
    private FamilleArticle famille ;
    
    @ManyToOne
    @JoinColumn(name = "FOU_ID")
    @Predicate(label = "Fournisseur",type = Intervenant.class,target = "many-to-one",optional = false ,search = true)
    private Intervenant fournisseur ;
    
    @Predicate(label = "Reférence du contrat")
    private String ref ;
    
    @ManyToOne
    @JoinColumn(name = "CON_ID")
    @Predicate(label = "Contact",type = Contact.class,target = "many-to-one",optional = false ,search = true)
    private Contact contact ;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date début",type = Date.class,target = "date",group = true,groupName = "group1",groupLabel = "Compléments")
    private Date debut ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date de fin prévisionnelle",type = Date.class,target = "date",group = true,groupName = "group1",groupLabel = "Compléments")
    private Date fin ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Prochaine échéance",type = Date.class,target = "date",group = true,groupName = "group1",groupLabel = "Compléments")
    private Date echeance ;
    
    @Predicate(label = "Durée reconduction(Mois)",type = Short.class,group = true,groupName = "group1",groupLabel = "Compléments")
    private Short reconduction;
    
    @Predicate(label = "Durée préavis(jours)",type = Short.class,group = true,groupName = "group1",groupLabel = "Compléments")
    private Short preavis ;
    
    @Predicate(label = "Reconduction tacite",type = Short.class,group = true,groupName = "group1",groupLabel = "Compléments")
    private Boolean tactile ;
    
    public Contrat() {
    }    
    
    public Contrat(String code, String intitule, FamilleArticle famille, Intervenant fournisseur, String ref, Contact contact) {
        this.code = code;
        this.intitule = intitule;
        this.famille = famille;
        this.fournisseur = fournisseur;
        this.ref = ref;
        this.contact = contact;
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param famille
     * @param fournisseur
     * @param ref
     * @param contact
     * @param debut
     * @param fin
     * @param echeance
     * @param reconduction
     * @param preavis
     * @param tactile
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Contrat(String code, String intitule, FamilleArticle famille, Intervenant fournisseur, String ref, Contact contact, Date debut, Date fin, Date echeance, Short reconduction, Short preavis, Boolean tactile, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.famille = famille;
        this.fournisseur = fournisseur;
        this.ref = ref;
        this.contact = contact;
        this.debut = debut;
        this.fin = fin;
        this.echeance = echeance;
        this.reconduction = reconduction;
        this.preavis = preavis;
        this.tactile = tactile;
    }

     public Contrat(Contrat entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.famille!=null){
            this.famille = new FamilleArticle(entity.famille);
        }
        if(entity.fournisseur!=null){
            this.fournisseur = new Intervenant(entity.fournisseur);
        }
        this.ref = entity.ref;
        this.contact = entity.contact;
        this.debut = entity.debut;
        this.fin = entity.fin;
        this.echeance = entity.echeance;
        this.reconduction = entity.reconduction;
        this.preavis = entity.preavis;
        this.tactile = entity.tactile;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }

    public Intervenant getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Intervenant fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public Short getReconduction() {
        return reconduction;
    }

    public void setReconduction(Short reconduction) {
        this.reconduction = reconduction;
    }

    public Short getPreavis() {
        return preavis;
    }

    public void setPreavis(Short preavis) {
        this.preavis = preavis;
    }

    public Boolean getTactile() {
        return tactile;
    }

    public void setTactile(Boolean tactile) {
        this.tactile = tactile;
    }
    
    

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Contrats"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Contrat"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Contrat o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
