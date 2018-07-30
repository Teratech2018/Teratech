/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.workflow;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_WOFLGC")
public class WorkflowAction extends BaseElement implements Serializable,Comparable<WorkflowAction>{

    @Predicate(label = "Workflow",optional = false,unique = true,search = true)
    private String code;    
    
    @Predicate(label = "Niveau",target = "combobox",values = "Unique;Initial;Intermédiaire;Final",optional = false,search = true)
    private String type ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "SERV_ID")
    @Predicate(label = "Service destinataire",type = StructureCompany.class,target = "many-to-one",optional = false,search = true)
    private StructureCompany service ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "WOFL_ID")
    @Predicate(label = "",type = WorkflowLigne.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "Workflow")
    private List<WorkflowLigne> lignes = new ArrayList<WorkflowLigne>();

    /**
     * 
     */
    public WorkflowAction() {
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param type
     * @param service
     * @param suivant
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public WorkflowAction(String code, String intitule, String type, StructureCompany service, WorkflowAction suivant, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.type = type;
        
    }

    public WorkflowAction(WorkflowAction entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.type = entity.type;
        if(entity.service!=null){
            this.service = new StructureCompany(entity.service);
        }
        
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<WorkflowLigne> getLignes() {
        return lignes;
    }

    public void setLignes(List<WorkflowLigne> lignes) {
        this.lignes = lignes;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
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
        return "Workflows"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Workflow"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(WorkflowAction o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
