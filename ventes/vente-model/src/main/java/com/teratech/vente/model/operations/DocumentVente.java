/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.vente.model.base.Entrepot;
import com.teratech.vente.model.base.Tier;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
@Table(name="T_DOC_VE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("TMP")
public class DocumentVente extends BaseElement implements Serializable,Comparable<DocumentVente>{

    @Predicate(label = "N° de Pièce",optional = false,search = true)
    protected String code ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date date ;
    
    @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Client",type = Tier.class,target = "many-to-one",optional = false,search = true)
    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"0\"}]")
    protected Tier client ;
    
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date ",type = Date.class,target = "date",optional = false,search = true)    
    protected Date datecommande ;
    
    @Predicate(label = "Reference")
    protected String codeclient;
    
    @Predicate(label = "Lieu de livraison",search = true)
    protected String lieu;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Livraison",type = Date.class,target = "date",search = true)
    protected Date livraison ;
       
    
    

//    protected DocumentAchatState typedocument ;
    
    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public DocumentVente(String code, Date date, Tier fornisseur, Date datecommande, String codefourni) {
        this.code = code;
        this.date = date;
        this.client = fornisseur;
        this.datecommande = datecommande;
        this.codeclient = codefourni;
//        this.lieu = emplacement;
       
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
    public DocumentVente(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.date = date;
        this.client = fornisseur;
        this.datecommande = datecommande;
        this.codeclient = codefourni;
//        this.emplacement = emplacement;
        
    }
    
    /**
     * 
     * @param da 
     */
    public DocumentVente(DocumentVente da) {
        super(da.id, da.designation, da.moduleName,da.compareid);
        this.code = da.code;
        this.date = da.date;
        if(da.client!=null){
            this.client = new Tier(da.client);
        }
        this.datecommande = da.datecommande;
        this.codeclient = da.codeclient;
        this.lieu = da.lieu;
        this.livraison = da.livraison;
//        if(da.emplacement!=null){
//            this.emplacement = new Entrepot(da.emplacement);
//        }
//        this.state = da.getState();
//        this.typedocument = da.typedocument;
    }

    public DocumentVente() {
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

    public Tier getClient() {
        return client;
    }

    public void setClient(Tier client) {
        this.client = client;
    }  

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public String getCodeclient() {
        return codeclient;
    }

    public void setCodeclient(String codefourni) {
        this.codeclient = codefourni;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public Date getLivraison() {
        return livraison;
    }

    public void setLivraison(Date livraison) {
        this.livraison = livraison;
    }

    
//    public List<LigneDocumentAchat> getLignes() {
//        return lignes;
//    }
//
//    public void setLignes(List<LigneDocumentAchat> lignes) {
//        this.lignes = lignes;
//    }

   

//    public DocumentAchatState getTypedocument() {
//        return typedocument;
//    }
//
//    public void setTypedocument(DocumentAchatState typedocument) {
//        this.typedocument = typedocument;
//    }
       
    

    @Override
    public String getModuleName() {
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnermodule() {
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "docvte040120191050"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        StringBuilder builder = new StringBuilder(code);
        builder.append("/").append(client.getDesignation());
        return builder.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    @Override
    public int compareTo(DocumentVente o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
