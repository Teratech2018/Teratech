/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
@Entity
@DiscriminatorValue("REG")
public class RegulInventaire extends BaseInventaire implements Serializable{

    @OneToMany
    @JoinColumn(name = "LIIN_ID")
    @Predicate(label = "inv",type = LigneInventaire.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Lignes inventaire",updatable = false,editable = false)
    private List<LigneInventaire> lignes = new ArrayList<LigneInventaire>();
    
    public RegulInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement) {
        super(code, date, fentrepot, femplacement);
    }

    public RegulInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement, long id, String designation, String moduleName) {
        super(code, date, fentrepot, femplacement, id, designation, moduleName);
    }

    public RegulInventaire() {
    }

    public RegulInventaire(RegulInventaire base) {
        super(base);
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
    
    
}
