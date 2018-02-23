/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.teratech.stock.model.base.Emplacement;
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
    public Entree(String code, Date date, Emplacement depot, String reference, String commentaire) {
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
    public Entree(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "etabli";
    }

    public Entree(Entree doc) {
        super(doc);
        this.state = doc.state;
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
