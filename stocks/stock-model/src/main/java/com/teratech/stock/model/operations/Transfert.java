/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
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
@DiscriminatorValue("ST_TRA")
public class Transfert extends DocumentStock implements Serializable{

    @ManyToOne
    @JoinColumn(name = "EMCI_ID")
    @Predicate(label = "Emplacement cible",type = Emplacement.class,target = "many-to-one",optional = false,nullable = false)
    private  Emplacement emplcible ;
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Transfert(String code, Date date, Emplacement depot, String reference, String commentaire) {
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
    public Transfert(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
        this.state = "etabli";
    }

    public Transfert(Transfert doc) {
        super(doc);
        this.emplcible = new Emplacement(doc.emplcible);
        this.state = doc.getState();
    }
    
    

    /**
     * 
     */
    public Transfert() {
        this.state = "etabli";
    }

    public Emplacement getEmplcible() {
        return emplcible;
    }

    public void setEmplcible(Emplacement emplcible) {
        this.emplcible = emplcible;
    }

    @Override
    public String getEditTitle() {
        return "Transfert"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Transferts"; //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
