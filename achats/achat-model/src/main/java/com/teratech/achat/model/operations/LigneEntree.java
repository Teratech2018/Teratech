/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.UniteGestion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("IN")
public class LigneEntree extends LigneDocumentStock implements Serializable{

     
    @Predicate(label = "N° lot/série",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Péremption",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date peremption ;
    
    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date fabrication ;
    
    @Predicate(label = "Total HT",type = Double.class,optional = false,search = true,hide = true,compute = true,values ="this.puht,*,this.quantite" )
    private Double totalht ;    
    
    private Double qteretourne =0.0;
    
    @OneToOne
    private Lot lot ;
    
    public LigneEntree(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht);
    }

    public LigneEntree(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht, long id, String designation, String moduleName) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht, id, designation, moduleName);
    }

    public LigneEntree(LigneEntree ligne) {
        super(ligne);
        this.code = ligne.code;
        this.peremption = ligne.peremption;
        this.fabrication = ligne.fabrication;
        this.totalht = ligne.totalht;
        this.qteretourne = ligne.qteretourne;
        if(ligne.lot!=null){
            this.lot = new Lot(ligne.lot);
        }
    }

    public LigneEntree(LigneDocumentAchat ligne) {
        super(ligne);
    }

    public LigneEntree() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getPeremption() {
        return peremption;
    }

    public void setPeremption(Date peremption) {
        this.peremption = peremption;
    }

    public Date getFabrication() {
        return fabrication;
    }

    public void setFabrication(Date fabrication) {
        this.fabrication = fabrication;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Double getQteretourne() {
        return qteretourne;
    }

    public void setQteretourne(Double qteretourne) {
        this.qteretourne = qteretourne;
    }
    
    public Double disponible(){
        return this.quantite-(qteretourne==null ? 0.0:qteretourne);
    }
    
    /**
     * 
     * @param qte
     * @return 
     */
    public Double addQteRetourne(Double qte){
        Double quantite = qteretourne!=null ? qteretourne:0.0;        
        this.qteretourne = quantite+qte;
        return qteretourne; 
    }
    
}
