/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.comptabilite.Taxe;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("CMDE")
public class LigneCommande extends LigneDocumentAchat implements Serializable{

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht 
     */
    public LigneCommande(Article article, Date prevue, Double quantite, Double puht, Double totalht) {
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
    public LigneCommande(Article article, Date prevue, Double quantite, Double puht, Double totalht, long id, String designation, String moduleName) {
        super(article, prevue, quantite, puht, totalht, id, designation, moduleName);
    }

    /**
     * 
     * @param ligne 
     */
    public LigneCommande(LigneDocumentAchat ligne) {
        super(ligne);
    }

    /**
     * 
     */
    public LigneCommande() {
    }
    
    /**
     * 
     * @param ligne 
     */
    public LigneCommande(LigneReponseDP ligne) {
        this.id = -1 ;
        if(ligne.getArticle()!=null){
            this.article = new Article(ligne.getArticle());
        }
        this.quantite = ligne.getQuantite();
        this.puht = ligne.getPuht();
        this.remise = ligne.getRemise();
        this.totalht = ligne.getTotalht();
        if(ligne.getTaxes()!=null){
            for(Taxe taxe:ligne.getTaxes()){
                this.taxes.add(new Taxe(taxe));
            }
        }//end if(ligne.getTaxes()!=null){
    }
}
