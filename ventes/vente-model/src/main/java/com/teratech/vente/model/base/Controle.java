/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.base;

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
@Table(name = "T_CONTR_ACH")
public class Controle extends BaseElement implements Serializable,Comparable<Controle>{

    @Predicate(label = "Code Analyse",optional = false,search = true)
    private String code ;
    
    @Predicate(label = "Libelle Analyse",optional = false,search = true)
    private String libelle ;
    
    @Predicate(label = "Type resultat",target = "combobox",optional = false,values = "Numéric;Liste de valeurs",search = true)
    private String type ="0" ;
    
    @Predicate(label = "Valeurs",search = true)
    private String valeur ;
    
    @Predicate(label = "Valeur Min",type = Double.class,search = true)
    private Double valMin ;
    
    @Predicate(label = "Valeur Max",type = Double.class,search = true)
    private Double valMax ; 

    public Controle() {
    }

    /**
     * 
     * @param code
     * @param libelle
     * @param type
     * @param valeur
     * @param valMin
     * @param valMax
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Controle(String code, String libelle, String type, String valeur, Double valMin, Double valMax, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.libelle = libelle;
        this.type = type;
        this.valeur = valeur;
        this.valMin = valMin;
        this.valMax = valMax;
    }
    
    /**
     * 
     * @param entity 
     */
    public Controle(Controle entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.libelle = entity.libelle;
        this.type = entity.type;
        this.valeur = entity.valeur;
        this.valMin = entity.valMin;
        this.valMax = entity.valMax;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Double getValMin() {
        return valMin;
    }

    public void setValMin(Double valMin) {
        this.valMin = valMin;
    }

    public Double getValMax() {
        return valMax;
    }

    public void setValMax(Double valMax) {
        this.valMax = valMax;
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
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Contrôle qualité"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Controle o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
