/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.budget;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Division;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
public class LigneBudgetSaisie extends BaseElement implements Serializable,Comparable<LigneBudgetSaisie>{

    @ManyToOne
    @JoinColumn(name = "DIV_ID")
    @Predicate(label = "Division",type = Division.class,target = "many-to-one",editable = false)
    private Division division;
    
    @Predicate(label = "Exercice",editable = false)
    private String annee ;
    
    @Predicate(label = "Mois",target = "combobox",values = "Janvier;Février;Mars;Avril;Mai;Juin;Juillet;Août;Septembre,Octobre;Novembre;Decembre",optional = false)
    private String mois ;
    
    @Predicate(label = "Montant",type = Double.class,optional = false)
    private Double montant ;

    public LigneBudgetSaisie() {
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    @Override
    public String getEditTitle() {
        return "Saisie du Budget"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LigneBudgetSaisie o) {
        return division.compareTo(o.division); //To change body of generated methods, choose Tools | Templates.
    }
    
}
