/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.vente.model.comptabilite;

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
@Table(name = "T_MORE")
public class ModeReglement extends BaseElement implements Serializable,Comparable<ModeReglement>{

    @Predicate(label = "Code règlement",optional = false )
    private String code ;
    
    @Predicate(label = "Intitulé")
    private String label ;
    
    @Predicate(label = "Type de règlement",target = "combobox",values = "Aucun;Espèces;Chèque;Carte bancaire")
    private String type ="0";

    public ModeReglement(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public ModeReglement(String code, String label, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.label = label;
    }

    public ModeReglement() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDesignation() {
        return code+" - "+label; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechvente"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Modes de reglements"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Mode de règlement"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ModeReglement o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
