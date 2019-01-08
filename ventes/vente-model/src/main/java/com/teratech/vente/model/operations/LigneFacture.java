/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.operations;

import com.teratech.vente.model.base.Article;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("FV")
public class LigneFacture extends LigneDocumentVente implements Serializable{

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht 
     */
    public LigneFacture(Article article, Date prevue, Double quantite, Double puht, Double totalht) {
        super(article, prevue, quantite, puht, totalht);
    }

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneFacture(Article article, Date prevue, Double quantite, Double puht, Double totalht, long id, String designation, String moduleName) {
        super(article, prevue, quantite, puht, totalht, id, designation, moduleName);
    }

    /**
     * 
     * @param ligne 
     */
    public LigneFacture(LigneDocumentVente ligne) {
        super(ligne);
    }

    /**
     * 
     */
    public LigneFacture() {
    }
    
   
}
