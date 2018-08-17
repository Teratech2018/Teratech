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
@Table(name = "T_ARMARCHGC")
public class ArmoireArchivage extends BaseElement implements Serializable,Comparable<ArmoireArchivage>{

    @Predicate(label = "Réference",optional = false,unique = true,search = true)
    private String code;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "PARE_ID")
    @Predicate(label = "Local Parent",type = ArmoireArchivage.class,target = "many-to-one",search = true)    
    private ArmoireArchivage parent ;
    
    @ManyToOne
    @JoinColumn(name = "LOC_ID")
    @Predicate(label = "Local",type = LocalArchivage.class,target = "many-to-one",optional = false,search = true)
    private LocalArchivage locale;
    
    @Predicate(label = "Description",target = "textarea",group = true,groupName = "group1",groupLabel = " ")
    private String description ;

    
    /**
     * 
     */
    public ArmoireArchivage() {
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
    public ArmoireArchivage(String code, String intitule, ArmoireArchivage parent, String emplacement, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.parent = parent;
//        this.emplacement = emplacement;
    }
    
    
     public ArmoireArchivage(ArmoireArchivage entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.parent!=null){
            this.parent = new ArmoireArchivage(entity.parent);
        }
        if(entity.locale!=null){
            this.locale = new LocalArchivage(entity.locale);
        }
        this.description = entity.description;
//        this.emplacement = entity.emplacement;
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

    public ArmoireArchivage getParent() {
        return parent;
    }

    public void setParent(ArmoireArchivage parent) {
        this.parent = parent;
    }

    public LocalArchivage getLocale() {
        return locale;
    }

    public void setLocale(LocalArchivage locale) {
        this.locale = locale;
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
        return "Armoires Archives"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Armoire Archive"; //To change body of generated methods, choose Tools | Templates.
    }

   
    
    @Override
    public int compareTo(ArmoireArchivage o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
