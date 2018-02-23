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
@DiscriminatorValue("ST_TRAV")
public class TransfertV extends Transfert implements Serializable{

    public TransfertV(String code, Date date, Emplacement depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
        this.state = "valider";
    }

    public TransfertV(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "valider";
    }

    public TransfertV(Transfert doc) {
        super(doc);
        this.state = "valider";
    }

    public TransfertV() {
        this.state = "valider";
    }
    
    
    
}
