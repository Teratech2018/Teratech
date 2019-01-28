/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.application;

import com.core.base.BaseElement;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name="T_RESREG")
public class ResourceRegistry extends BaseElement implements Serializable,Comparable<ResourceRegistry>{

    @Column(name = "SRC")
    private String srcname;
    
    @Column(name = "STORE")
    private String storename;
    
    @Column(name = "ENTITY")
    private String ownerentity;
    
    @Column(name = "MODELE")
    private String ownermodele;
    
    @Column(name = "instance")
    private Long _instance ;

    public ResourceRegistry() {
    }
    
    /**
     * 
     * @param srcname
     * @param storename
     * @param ownerentity
     * @param ownermodele
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ResourceRegistry(String srcname, String storename, String ownerentity, String ownermodele, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.srcname = srcname;
        this.storename = storename;
        this.ownerentity = ownerentity;
        this.ownermodele = ownermodele;
    }

    public ResourceRegistry(String srcname, String storename, String ownerentity, String ownermodele,long _instance) {
        super(-1, null, null, -1);
        this.srcname = srcname;
        this.storename = storename;
        this.ownerentity = ownerentity;
        this.ownermodele = ownermodele;
        this._instance = _instance;
    }
    public ResourceRegistry(ResourceRegistry entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.srcname = entity.srcname;
        this.storename = entity.storename;
        this.ownerentity = entity.ownerentity;
        this.ownermodele = entity.ownermodele;
        this._instance = entity._instance;
    }
    
    public String getSrcname() {
        return srcname;
    }

    public void setSrcname(String srcname) {
        this.srcname = srcname;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getOwnerentity() {
        return ownerentity;
    }

    public void setOwnerentity(String ownerentity) {
        this.ownerentity = ownerentity;
    }

    public String getOwnermodele() {
        return ownermodele;
    }

    public void setOwnermodele(String ownermodele) {
        this.ownermodele = ownermodele;
    }

    public Long getInstance() {
        return _instance;
    }

    public void setInstance(Long _instance) {
        this._instance = _instance;
    }
    
    

    @Override
    public String getOwnermodule() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return super.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return super.getEditTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(ResourceRegistry o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
