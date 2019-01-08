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
@DiscriminatorValue("DEVIS")
public class LigneDevis extends LigneDocumentVente implements Serializable{

    public LigneDevis(Article article, Date prevue, Double quantite, Double puht, Double totalht) {
        super(article, prevue, quantite, puht, totalht);
    }

    public LigneDevis(Article article, Date prevue, Double quantite, Double puht, Double totalht, long id, String designation, String moduleName) {
        super(article, prevue, quantite, puht, totalht, id, designation, moduleName);
    }

    public LigneDevis(LigneDocumentVente ligne) {
        super(ligne);
    }

    public LigneDevis(LigneDevis ligne) {
        super(ligne);
        this.totalht = ligne.getTotalht();
    }
    
    public LigneDevis() {
    }
    
    
    
}
