/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.Entrepot;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("ST_IN")
public class Entree extends DocumentStock implements Serializable{

    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Entree(String code, Date date, Entrepot depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
        this.state = "etabli";
    }

    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire
     * @param id
     * @param designation
     * @param moduleName 
     */
    public Entree(String code, Date date, Entrepot depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "etabli";
    }

    public Entree(Entree doc) {
        super(doc);
        this.state = doc.state;
    }
    
     public Entree(BonReception doc) {
        super(doc.getCode(), new Date(), doc.getEntrepot(), doc.getOrigine(), null, -1, doc.getDesignation(), doc.getModuleName());
        this.state = "etabli";
//        for(LigneDocumentAchat ligne:doc.lignes){
//            this.lignes.add(new LigneDocumentStock(ligne));
//        }//end for(LigneDocumentAchat ligne:doc.lignes)
    }

    @Override
    public boolean isDesabledelete() {
        if(state.equalsIgnoreCase("valider")){
            return true;
        }
        return super.isDesabledelete(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    /**
     * 
     */
    public Entree() {
        this.state = "etabli";
    }
    
    
}
