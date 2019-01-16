/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.model.achats;

import com.basaccount.model.tiers.Tier;
import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Table(name="T_DOAC_ACH")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("TMP")
public class DocumentAchat extends BaseElement implements Serializable,Comparable<DocumentAchat>{

    @Predicate(label = "Reference",optional = false,search = true)
    protected String code ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date date ;
    
    @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",optional = false,search = true)
    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    protected Tier fournisseur ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date ",type = Date.class,target = "date",optional = false,search = true)    
    protected Date datecommande ;
    
    @Predicate(label = "Reference du fournisseur")
    protected String codefourni;
    
    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt livraison",type = Entrepot.class,target = "many-to-one",optional = true,search = true)
    protected Entrepot emplacement;
    
//    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
//    @JoinColumn(name = "LIDOAC_ID")
//    @Predicate(label = "AC",type = LigneDocumentAchat.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Articles",customfooter = true)
//    @TableFooter(value = "<tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total HT</td><td></td> <td class='text-right'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td> </tr> <tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td><td></td> <td  class='text-right'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td> </tr> <tr style='border:none;'> <td></td><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td></td><td  class='text-right'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td> </tr>")
//    protected List<LigneDocumentAchat> lignes = new ArrayList<LigneDocumentAchat>();
   
    

    protected DocumentAchatState typedocument ;
    
    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public DocumentAchat(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Entrepot emplacement) {
        this.code = code;
        this.date = date;
        this.fournisseur = fornisseur;
        this.datecommande = datecommande;
        this.codefourni = codefourni;
        this.emplacement = emplacement;
       
    }

    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement
     * @param id
     * @param designation
     * @param moduleName 
     */
    public DocumentAchat(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Entrepot emplacement, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.date = date;
        this.fournisseur = fornisseur;
        this.datecommande = datecommande;
        this.codefourni = codefourni;
        this.emplacement = emplacement;
        
    }
    
    /**
     * 
     * @param da 
     */
    public DocumentAchat(DocumentAchat da) {
        super(da.id, da.designation, da.moduleName,da.compareid);
        this.code = da.code;
        this.date = da.date;
        if(da.fournisseur!=null){
            this.fournisseur = new Tier(da.fournisseur);
        }
        this.datecommande = da.datecommande;
        this.codefourni = da.codefourni;
        if(da.emplacement!=null){
            this.emplacement = new Entrepot(da.emplacement);
        }
        this.typedocument = da.typedocument;
    }

    public DocumentAchat() {
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

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fornisseur) {
        this.fournisseur = fornisseur;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public String getCodefourni() {
        return codefourni;
    }

    public void setCodefourni(String codefourni) {
        this.codefourni = codefourni;
    }

    public Entrepot getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Entrepot emplacement) {
        this.emplacement = emplacement;
    }

//    public List<LigneDocumentAchat> getLignes() {
//        return lignes;
//    }
//
//    public void setLignes(List<LigneDocumentAchat> lignes) {
//        this.lignes = lignes;
//    }
  
    public DocumentAchatState getTypedocument() {
        return typedocument;
    }

    public void setTypedocument(DocumentAchatState typedocument) {
        this.typedocument = typedocument;
    }
       
    

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public int compareTo(DocumentAchat o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
