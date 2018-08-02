/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

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
@Table(name = "T_ETEQGM")
public class EtatEquipement extends BaseElement implements Serializable,Comparable<EtatEquipement>{

    @Predicate(label = "Etat equipement",optional = true,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = true,search = true)
    private String intitule;
    
    @Predicate(label = "Statut equipement",target = "combobox",values = "Arrêt;Mode dégradé;En service",optional = false)
    private String etat = "0";
    
    @Predicate(label = "Panne",type =Boolean.class)
    private Boolean panne ;

    public EtatEquipement() {
    }

    public EtatEquipement(String code, String intitule, Boolean panne) {
        this.code = code;
        this.intitule = intitule;
        this.panne = panne;
    }

    public EtatEquipement(String code, String intitule, Boolean panne, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.etat = etat;
        this.panne = panne;
    }
    
    public EtatEquipement(EtatEquipement entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.etat = entity.etat;
        this.panne = entity.panne;
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

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Boolean getPanne() {
        return panne;
    }

    public void setPanne(Boolean panne) {
        this.panne = panne;
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
        return "Etats equipements"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Etat equipement";//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(EtatEquipement o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
