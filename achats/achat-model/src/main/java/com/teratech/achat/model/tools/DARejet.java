/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.tools;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Tier;
import com.teratech.achat.model.operations.ExprBesion;
import java.io.Serializable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
public class DARejet extends BaseElement implements Serializable,Comparable<DARejet>{

    @ManyToOne
    @Predicate(label = "DEMANDE",type = ExprBesion.class,target = "many-to-one",search = true,editable = false)
    private ExprBesion demande ;
    
    @ManyToOne
    @Predicate(label = "DEMANDEUR",type = Tier.class,target = "many-to-one",editable = false)
    private Tier emetteur;
    @Lob
    @Predicate(label = " " , target = "richeditor" ,group = true,groupName = "group1",groupLabel = "MOTIVATION")
    private String motif ;

    public DARejet() {
    }

    public ExprBesion getDemande() {
        return demande;
    }

    public void setDemande(ExprBesion demande) {
        this.demande = demande;
    }

    public Tier getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Tier emetteur) {
        this.emetteur = emetteur;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    @Override
    public String getOwnermodule() {
        return super.getOwnermodule(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "REJETDA"; //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(DARejet o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
