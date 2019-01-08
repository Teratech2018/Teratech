/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Controle;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LICOQU_ACH")
public class LigneControleQualite extends BaseElement implements Serializable,Comparable<LigneControleQualite>{

    @Predicate(label = "Code ",search = true,optional = false,nullable = false)
    private String code;
    
    @Predicate(label = "Intitulé ",search = true,optional = false,nullable = false)
    private String intitule;
    
    @Predicate(label = "Type resultat",target = "combobox",optional = false,values = "Numéric;Liste de valeurs",search = true)
    private String type ="0" ;
    
    @Predicate(label = "Resultat",search = true)
    private String valeur ;
    
    @Predicate(label = "Avis",target = "combobox",values = "Excellent;Bon;Moyen;Passable;Mauvais")
    private String avis ="0";
    
    @Predicate(label = "Couleur",optional = false,search = true,target = "color")
    private String color ;
   
    
    public LigneControleQualite() {
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param valeur
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public LigneControleQualite(String code, String intitule, String valeur, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.valeur = valeur;
    }
    
    public LigneControleQualite(LigneControleQualite entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.valeur = entity.valeur;
        this.type = entity.type;
    }
    
     public LigneControleQualite(Controle entity) {
        super(-1, entity.getDesignation(), entity.getModuleName(), entity.getCompareid());
        this.code = entity.getCode();
        this.intitule = entity.getLibelle();
        this.valeur = null;
        this.type = entity.getType();
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

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    

    @Override
    public String getOwnermodule() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Contrôle Qualité"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Contrôle Qualité"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
    @Override
    public int compareTo(LigneControleQualite o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
