/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.referentiel;

import com.core.base.BaseElement;
import com.keren.courrier.model.workflow.WorkflowAction;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_TYCOUGC")
public class TypeCourrier extends BaseElement implements Serializable,Comparable<TypeCourrier>{

    @Predicate(label = "Code",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
//    @Predicate(label = "Activer la date limite",type = Boolean.class,target = "checkbox",search = true)
    private Boolean dcontrole ;
    
    @Predicate(label = "Durée Max de traitement(nombre de jour)",type = Short.class,search = true)
    private Short duree ;
    
    @ManyToOne
    @JoinColumn(name = "WOFL_ID")
    @Predicate(label = "Circuit de traitement",type = WorkflowAction.class,target = "many-to-one")
    private WorkflowAction workflow ;

    public TypeCourrier() {
    }
    
    public TypeCourrier(TypeCourrier entity) {
        
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.getCode();
        this.intitule = entity.getCode();
        this.dcontrole = entity.getDcontrole();
        this.duree = entity.getDuree();
        
        if(entity.getWorkflow() != null){
            this.workflow = new WorkflowAction(entity.getWorkflow());
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

    public Boolean getDcontrole() {
        return dcontrole;
    }

    public void setDcontrole(Boolean dcontrole) {
        this.dcontrole = dcontrole;
    }

    public Short getDuree() {
        return duree;
    }

    public void setDuree(Short duree) {
        this.duree = duree;
    }

    public WorkflowAction getWorkflow() {
        return workflow;
    }

    public void setWorkflow(WorkflowAction workflow) {
        this.workflow = workflow;
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
        return "Types de courriers"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Type de courriers"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(TypeCourrier o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
