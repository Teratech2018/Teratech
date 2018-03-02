/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("FA")
public class Facture extends DocumentAchat implements Serializable{

    @ManyToOne
    @JoinColumn(name = "DOAC_ID")
    @Predicate(label = "Document source",type = DocumentAchat.class,target = "many-to-one")
    private BonCommande docachat;
    
    @Predicate(label = "Document d'origine")
    private String source;
    
    
    /**
     * 
     */
    public Facture() {
        this.typedocument = DocumentAchatState.FACTURE;
    }

    /**
     * 
     * @param code
     * @param date
     * @param fornisseur
     * @param datecommande
     * @param codefourni
     * @param emplacement 
     */
    public Facture(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement);
        this.typedocument = DocumentAchatState.FACTURE;
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
    public Facture(String code, Date date, Tier fornisseur, Date datecommande, String codefourni, Emplacement emplacement, long id, String designation, String moduleName) {
        super(code, date, fornisseur, datecommande, codefourni, emplacement, id, designation, moduleName);
        this.typedocument = DocumentAchatState.FACTURE;
    }

    /**
     * 
     * @param da 
     */
    public Facture(BonCommande da) {
        super(da);
        this.id = -1;
        this.docachat = new BonCommande(da);
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
       
    }


   
    
    public Facture(Facture da) {
        super(da);
        if(da.getDocachat()!=null){
            this.docachat = new BonCommande(da.getDocachat());
        }//end if(da.getDocachat()!=null)
        this.source = da.getCode();
        this.typedocument = DocumentAchatState.FACTURE;
        
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BonCommande getDocachat() {
        return docachat;
    }

    public void setDocachat(BonCommande docachat) {
        this.docachat = docachat;
    }
    
    

    @Override
    public String getState() {
        return super.getState(); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public String getListTitle() {
        return "FACTURES FOURNISSEURS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "FACTURE FOURNISSEUR"; //To change body of generated methods, choose Tools | Templates.
    }
    
}
