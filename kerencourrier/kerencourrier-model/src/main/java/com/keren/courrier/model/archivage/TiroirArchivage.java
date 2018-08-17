/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Observer;
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
@Table(name = "T_TIRARCHGC")
public class TiroirArchivage extends BaseElement implements Serializable,Comparable<TiroirArchivage>{

    @Predicate(label = "Réference",optional = false,unique = true,search = true)
    private String code;
    
    @Predicate(label = "Intitulé",optional = false,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "ARM_ID")
    @Predicate(label = "Armoire Parent",type = ArmoireArchivage.class,target = "many-to-one",search = true,observable = true)    
    private ArmoireArchivage armoire ;
    
    @ManyToOne
    @JoinColumn(name = "LOC_ID")
    @Predicate(label = "Local",type = LocalArchivage.class,target = "many-to-one",optional = true,editable = false,search = true)
    @Observer(observable = "armoire",source = "field:locale")
    private LocalArchivage locale;
    
    @Predicate(label = "Description",target = "textarea",group = true,groupName = "group1",groupLabel = " ")
    private String description ;

    
    /**
     * 
     */
    public TiroirArchivage() {
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
    public TiroirArchivage(String code, String intitule, TiroirArchivage parent, String emplacement, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
//        this.parent = parent;
//        this.emplacement = emplacement;
    }
    
    
     public TiroirArchivage(TiroirArchivage entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.armoire!=null){
            this.armoire = new ArmoireArchivage(entity.armoire);
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

    public ArmoireArchivage getArmoire() {
        return armoire;
    }

    public void setArmoire(ArmoireArchivage armoire) {
        this.armoire = armoire;
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
        return "Tiroirs Archives"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Tiroir Archive"; //To change body of generated methods, choose Tools | Templates.
    }

         
    
    @Override
    public int compareTo(TiroirArchivage o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
