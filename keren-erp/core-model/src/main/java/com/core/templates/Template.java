/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.templates;

import com.core.base.BaseElement;
import com.core.menus.MenuModule;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_TPLE")
public class Template extends BaseElement implements Serializable,Comparable<Template>{
    
    private String code ;
    
    private String name ;
    
    private String type ;
    
    @Column(name = "NUM")
    private boolean index = false;
    
    private String entityRef ;
    
    private String methodRef ;
    
    private String varRef ;
    
    @Lob
    private String script ;

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "MOD_ID")
    protected MenuModule module;
    
    /**
     * 
     */
    public Template() {
    }

    /**
     * 
     * @param name
     * @param type
     * @param entityRef
     * @param modelRef
     * @param methodRef
     * @param varRef
     * @param script
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Template(String name, String type, String entityRef, String modelRef, String methodRef, String varRef, String script, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.name = name;
        this.type = type;
        this.entityRef = entityRef;
        this.methodRef = methodRef;
        this.varRef = varRef;
        this.script = script;
    }

    /**
     * 
     * @param entity 
     */
    public Template(Template entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.name = entity.name;
        this.type = entity.type;
        this.entityRef = entity.entityRef;
        this.methodRef = entity.methodRef;
        this.varRef = entity.varRef;
        this.script = entity.script;
    }

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIndex() {
        return index;
    }

    public void setIndex(boolean index) {
        this.index = index;
    }

    public String getEntityRef() {
        return entityRef;
    }

    public void setEntityRef(String entityRef) {
        this.entityRef = entityRef;
    }

    
    public String getMethodRef() {
        return methodRef;
    }

    public void setMethodRef(String methodRef) {
        this.methodRef = methodRef;
    }

    public String getVarRef() {
        return varRef;
    }

    public void setVarRef(String varRef) {
        this.varRef = varRef;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MenuModule getModule() {
        return module;
    }

    public void setModule(MenuModule module) {
        this.module = module;
    }
    
    
    @Override
    public String getDesignation() {
        return name; //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public String getModuleName() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Templates"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Template"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(Template o) {
         //To change body of generated methods, choose Tools | Templates.
        return name.compareTo(o.name);
    }
    
}
