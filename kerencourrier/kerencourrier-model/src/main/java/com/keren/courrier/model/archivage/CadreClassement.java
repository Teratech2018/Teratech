/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CADCLAGC")
public class CadreClassement extends BaseElement implements Serializable,Comparable<CadreClassement>{

    @Predicate(label = "Numéro de série",optional = false,search = true)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "PAR_ID")
    @Predicate(label = "Cadre Parent",type = CadreClassement.class,target = "many-to-one",search = true)
    private CadreClassement parent ;
    
    @Predicate(label = "Description",optional = false,search = true)
    private String description ;

    public CadreClassement() {
    }

    public CadreClassement(String code, CadreClassement parent, String description, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.parent = parent;
        this.description = description;
    }
    
    
    public CadreClassement(CadreClassement entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.parent!=null){
            this.parent = new CadreClassement(entity.parent);
        }
        this.description = entity.description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CadreClassement getParent() {
        return parent;
    }

    public void setParent(CadreClassement parent) {
        this.parent = parent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Cadres de classement"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Cadre de classement"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(CadreClassement o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
