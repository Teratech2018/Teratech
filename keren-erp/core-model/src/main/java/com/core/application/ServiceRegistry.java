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
@Table(name = "T_SERVREG")
public class ServiceRegistry extends BaseElement implements Serializable,Comparable<ServiceRegistry>{

    @Column(unique = true)
    private String code ;
    
    private String name;
    
    private String modele ;
    
    private String entity;

    public ServiceRegistry() {
    }

    /**
     * 
     * @param code
     * @param name
     * @param modele
     * @param entity 
     */
    public ServiceRegistry(String code, String name, String modele, String entity) {
        super(-1, null, null, -1);
        this.code = code;
        this.name = name;
        this.modele = modele;
        this.entity = entity;
    }

   
    
    /**
     * 
     * @param entity 
     */
    public ServiceRegistry(ServiceRegistry entity) {
        super(entity.id,entity. designation, entity.moduleName, entity.compareid);
        this.name = entity.name;
        this.modele = entity.modele;
        this.entity = entity.entity;
        this.code = entity.code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    @Override
    public String getOwnerentity() {
        return "serviceregistry"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getOwnermodule() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ServiceRegistry o) {
        //To change body of generated methods, choose Tools | Templates.
        return name.compareTo(o.name);
    }
    
}
