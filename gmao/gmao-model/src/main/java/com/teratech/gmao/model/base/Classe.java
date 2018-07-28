/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.teratech.gmao.model.base.LigneClasse;
import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CLASSEGM")
public class Classe extends BaseElement implements Serializable,Comparable<Classe>{

    @Predicate(label = "Classe",optional = false,unique = true ,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "CLAS_ID")
    @Predicate(label = "",type = LigneClasse.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Planning",edittable = true)
    private List<LigneClasse> lignes = new ArrayList<LigneClasse>();

    public Classe(String code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    public Classe(String code, String intitule, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
    }
    
    public Classe(Classe entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
    }

    public Classe() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public List<LigneClasse> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneClasse> lignes) {
        this.lignes = lignes;
    }

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Classes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Classe"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Classe o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
