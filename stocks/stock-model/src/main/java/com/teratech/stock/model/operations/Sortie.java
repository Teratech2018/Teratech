/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Tier;
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
@DiscriminatorValue("ST_OUT")
public class Sortie extends DocumentStock implements Serializable{

    @ManyToOne
    @JoinColumn(name = "CIBL_ID")
    @Predicate(label = "Destinataire" ,type = Tier.class,target = "many-to-one")
    private Tier cible ;
    
    /**
     * 
     * @param code
     * @param date
     * @param depot
     * @param reference
     * @param commentaire 
     */
    public Sortie(String code, Date date, Emplacement depot, String reference, String commentaire) {
        super(code, date, depot, reference, commentaire);
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
    public Sortie(String code, Date date, Emplacement depot, String reference, String commentaire, long id, String designation, String moduleName) {
        super(code, date, depot, reference, commentaire, id, designation, moduleName);
    }

    /**
     * 
     * @param doc 
     */
    public Sortie(Sortie doc) {
        super(doc);
        this.cible = new Tier(doc.cible);
    }
    
    

    public Tier getCible() {
        return cible;
    }

    public void setCible(Tier cible) {
        this.cible = cible;
    }

    
    
    /**
     * 
     */
    public Sortie() {
    }

    @Override
    public String getEditTitle() {
        return "SORTIE"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "SORTIES"; //To change body of generated methods, choose Tools | Templates.
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
