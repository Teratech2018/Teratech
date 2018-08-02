/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LICLAGM")
public class LigneClasse extends BaseElement implements Serializable,Comparable<LigneClasse>{

    @Predicate(label = "Jour",target = "combobox",values = "Lundi;Mardi;Mercredi;Jeudi;Vendredi;Samedi;Dimanche",optional = false,search = true)
    private String code ;
    
    @Predicate(label = "Heure debut",target = "time",optional = true,search = true)
    private String hdebut ;
    
    @Predicate(label = "Heure de fin",target = "time",optional = true,search = true)
    private String hfin ;
    
    @Predicate(label = "Durée",type = Double.class,editable = false,search = true)
    private Double duree;

    public LigneClasse(String code, Double duree) {
        this.code = code;
        this.duree = duree;
    }

    public LigneClasse(String code, Double duree, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.duree = duree;
    }
    
    public LigneClasse(LigneClasse entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.duree = entity.duree;
        this.hdebut = entity.hdebut;
        this.hfin = entity.hfin;
    }

    public LigneClasse() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDuree() {
        return duree;
    }

    public void setDuree(Double duree) {
        this.duree = duree;
    }

    public String getHdebut() {
        return hdebut;
    }

    public void setHdebut(String hdebut) {
        this.hdebut = hdebut;
    }

    public String getHfin() {
        return hfin;
    }

    public void setHfin(String hfin) {
        this.hfin = hfin;
    }
    
    

    @Override
    public String getDesignation() {
        return super.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Détails"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Détail"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LigneClasse o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
