/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.budget;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Division;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_BUDGETGM")
public class BudgetDivision extends BaseElement implements Serializable,Comparable<BudgetDivision>{

    private static final long serialVersionUID = 7591118344084563684L;
    
    @ManyToOne
    @JoinColumn(name = "DIV_ID")
    @Predicate(label = "Division",type = Division.class,target = "many-to-one",updatable = false,optional = false,search = true,observable = true)
    private Division division ;
    
    @Predicate(label = "Exercice",optional = false,updatable = false,search = true)
    private String annee;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BUD_ID")
    @Predicate(label = "",type = LigneBudget.class,target = "one-to-many",edittable = false,group = true,groupName = "group1",groupLabel = "Détails du Budget")
    @Observer(observable = "division",source = "method:budget",parameters = "annee")
    private List<LigneBudget> lignes = new ArrayList<LigneBudget>();

    @Predicate(label = "Statut",search = true,hide=true)
    private String state ="etabli";
    /**
     * 
     */
    public BudgetDivision() {
        state ="etabli";
    }

    /**
     * 
     * @param division
     * @param annee
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public BudgetDivision(Division division, String annee, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.division = division;
        this.annee = annee;
    }
    
    /**
     * 
     * @param entity 
     */
     public BudgetDivision(BudgetDivision entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.division!=null){
            this.division = new Division(entity.division);
        }
        this.annee = entity.annee;
        this.state = entity.state;
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

    public List<LigneBudget> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneBudget> lignes) {
        this.lignes = lignes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Brouillon");
        states.add(state);
        state = new State("valide", "Valider");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getDesignation() {
        return division.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Budgets Divisions"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        //To change body of generated methods, choose Tools | Templates.
         return "Budget Division"; 
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return Long.toString(serialVersionUID); //To change body of generated methods, choose Tools | Templates.
    }     
    
    @Override
    public int compareTo(BudgetDivision o) {
         //To change body of generated methods, choose Tools | Templates.
        return division.compareTo(o.division);
    }
    
}
