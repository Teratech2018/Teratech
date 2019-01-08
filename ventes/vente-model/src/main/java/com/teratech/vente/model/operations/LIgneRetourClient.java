/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.vente.model.base.Article;
import com.teratech.vente.model.base.UniteGestion;
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
@DiscriminatorValue("IN")
public class LIgneRetourClient extends LigneDocumentStock implements Serializable{

     @ManyToOne
    @JoinColumn(name = "LOT_ID")
    @Predicate(label = "N° lot/série",type = Lot.class,target = "many-to-one",optional = true,search = true,editable = false)
    @Filter(value = "[{\"fieldName\":\"lien\",\"value\":\"object.emplacement\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner l'emplacement\"}]")
    private Lot lot ;
    
    @Predicate(label = "Total HT",type = Double.class,search = true,hide = true,compute = true,values ="this.puht;*;this.quantite" )
    private Double totalht ;  
     
    @ManyToOne
    @JoinColumn(name = "LBL_ID")
    private LIgneBonLivraison source ;
    
    /**
     * 
     * @param article
     * @param unite
     * @param puht
     * @param quantite
     * @param punet
     * @param code
     * @param peremption
     * @param fabrication
     * @param totalht 
     */
    public LIgneRetourClient(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht);
    }

    /**
     * 
     * @param article
     * @param unite
     * @param puht
     * @param quantite
     * @param punet
     * @param code
     * @param peremption
     * @param fabrication
     * @param totalht
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LIgneRetourClient(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht, long id, String designation, String moduleName) {
        super(article, unite, puht, quantite, punet, code, peremption, fabrication, totalht, id, designation, moduleName);
    }

    /**
     * 
     * @param ligne 
     */
    public LIgneRetourClient(LigneDocumentStock ligne) {
        super(ligne);
    }
    
    public LIgneRetourClient(LIgneBonLivraison ligne) {
        super(ligne);
        this.id = -1L;
        if(ligne.getLot()!=null){
            this.lot = new Lot(ligne.getLot());
        }
        this.totalht = ligne.getTotalht();
        this.source = ligne;
    }
    
    public LIgneRetourClient(LIgneRetourClient ligne) {
        super(ligne);
        if(ligne.getLot()!=null){
            this.lot = new Lot(ligne.getLot());
        }
        this.totalht = ligne.getTotalht();
        if(ligne.source!=null){
            this.source = new LIgneBonLivraison(ligne.source);
        }
    }

    /**
     * 
     * @param ligne 
     */
    public LIgneRetourClient(LigneDocumentVente ligne) {
        super(ligne);
        this.totalht = ligne.getTotalht();
    }

    public LIgneRetourClient() {
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public LIgneBonLivraison getSource() {
        return source;
    }

    public void setSource(LIgneBonLivraison source) {
        this.source = source;
    }
    
    

    @Override
    public String getListTitle() {
        return "Articles"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
