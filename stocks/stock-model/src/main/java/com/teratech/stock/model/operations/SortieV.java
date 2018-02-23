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
@DiscriminatorValue("ST_OUTV")
public class SortieV extends Sortie implements Serializable{

    public SortieV(String code, Date date, Emplacement depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
        this.state = "valider";
    }

    public SortieV(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "valider";
    }

    public SortieV(Sortie doc) {
        super(doc);
        this.state = "valider";
    }

    public SortieV() {
        this.state = "valider";
    }
    
    
}
