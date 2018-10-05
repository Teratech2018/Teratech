/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LOCARCHGC")
public class LocalArchivage extends BaseElement implements Serializable,Comparable<LocalArchivage>{

    @Predicate(label = "Réference",optional = false,unique = true,search = true)
    private String code;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "PARE_ID")
    @Predicate(label = "Local Parent",type = LocalArchivage.class,target = "many-to-one",search = true)    
    private LocalArchivage parent ;
    
    @Predicate(label = "Emplacement",optional = true,unique = false,search = true)
    private String emplacement;

    @Predicate(label = "Description",target = "textarea",group = true,groupName = "group1",groupLabel = " ")
    private String description ;
    /**
     * 
     */
    public LocalArchivage() {
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param parent
     * @param emplacement
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public LocalArchivage(String code, String intitule, LocalArchivage parent, String emplacement, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.parent = parent;
        this.emplacement = emplacement;
    }
    
    
     public LocalArchivage(LocalArchivage entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.parent!=null){
            this.parent = new LocalArchivage(entity.parent);
        }
        this.emplacement = entity.emplacement;
        this.description = entity.description;
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

    public LocalArchivage getParent() {
        return parent;
    }

    public void setParent(LocalArchivage parent) {
        this.parent = parent;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Locaux Archives"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Local Archive"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long getId() {
        return super.getId(); //To change body of generated methods, choose Tools | Templates.
    }
     
     
    
    @Override
    public int compareTo(LocalArchivage o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
