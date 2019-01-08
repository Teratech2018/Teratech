/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("REG")
public class RegulInventaire extends BaseInventaire implements Serializable{

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "REIN_ID")
    @Predicate(label = "inv",type = LigneInventaire.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Lignes inventaire",updatable = false,editable = false,edittable = true)
    private List<LigneInventaire> lignes = new ArrayList<LigneInventaire>();
    
    public RegulInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement) {
        super(code, date, fentrepot, femplacement);
        state = "confirme";
    }

    public RegulInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement, long id, String designation, String moduleName) {
        super(code, date, fentrepot, femplacement, id, designation, moduleName);
        state = "confirme";
    }

    public RegulInventaire() {
        state = "confirme";
    }

    public RegulInventaire(RegulInventaire base) {
        super(base);
        state = base.getState();
    }
    
    public RegulInventaire(BaseInventaire base) {
        super(base);
        this.id = -1;
        state = "confirme";
    }

    public List<LigneInventaire> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneInventaire> lignes) {
        this.lignes = lignes;
    }

    @Override
    public String getEditTitle() {
        return "Regularisation"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Inventaires à régulariser"; //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return this.state.equalsIgnoreCase("termine"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return this.state.equalsIgnoreCase("termine");  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        State state = new State("etabli", "Brouillon");
        states.add(state);
        state = new State("confirme", "En cours");
        states.add(state);
        state = new State("termine", "Terminé");
        states.add(state);
        return states; //To change body of generated methods, choose Tools | Templates.
    }
}
