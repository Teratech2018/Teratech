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
import com.teratech.gmao.model.base.Equipement;
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
public class BudgetEquipement extends BaseElement implements Serializable,Comparable<BudgetEquipement>{

    private static final long serialVersionUID = 7591118344084563684L;
    
    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",updatable = false,optional = false,search = true,observable = true)
    private Equipement equipement ;
    
    @Predicate(label = "Exercice",optional = false,updatable = false,search = true)
    private String annee;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BUD_ID")
    @Predicate(label = "",type = LigneBudget.class,target = "one-to-many",edittable = false,group = true,groupName = "group1",groupLabel = "Détails du Budget")
    @Observer(observable = "equipement",source = "method:budget",parameters = "annee")
    private List<LigneBudget> lignes = new ArrayList<LigneBudget>();

    @Predicate(label = "Statut",search = true,hide=true)
    private String state ="etabli";
    /**
     * 
     */
    public BudgetEquipement() {
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
    public BudgetEquipement(Equipement division, String annee, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.equipement = division;
        this.annee = annee;
    }
    
    /**
     * 
     * @param entity 
     */
     public BudgetEquipement(BudgetEquipement entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.equipement!=null){
            this.equipement = new Equipement(entity.equipement);
        }
        this.annee = entity.annee;
        this.state = entity.state;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
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
        return equipement.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Budgets Equipements"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        //To change body of generated methods, choose Tools | Templates.
         return "Budget Equipement"; 
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
    public int compareTo(BudgetEquipement o) {
         //To change body of generated methods, choose Tools | Templates.
        return equipement.compareTo(o.equipement);
    }
    
}
