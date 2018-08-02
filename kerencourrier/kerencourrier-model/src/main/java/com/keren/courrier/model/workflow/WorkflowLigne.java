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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_WOLIGC")
public class WorkflowLigne extends BaseElement implements Serializable,Comparable<WorkflowLigne>{
 
    @ManyToOne
    @JoinColumn(name = "ACT_ID")
    @Predicate(label = "Action sur courrier",type = ActionCourrier.class,target = "many-to-one",optional = false,search = true)
    private ActionCourrier action ;
    
    @ManyToOne
    @JoinColumn(name = "STEP_ID")
    @Predicate(label = "Traitement suivant",type = WorkflowAction.class,target = "many-to-one",optional = false,search = true)
    private WorkflowAction step ;
    
    

    public WorkflowLigne() {
    }

    /**
     * 
     * @param action
     * @param step
     * @param service
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public WorkflowLigne(ActionCourrier action, WorkflowAction step, StructureCompany service, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.action = action;
        this.step = step;
        
    }
    
    public WorkflowLigne(WorkflowLigne entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.action = entity.action;
        if(entity.step!=null){
            this.step = new WorkflowAction(entity.step);
        }
//        if(entity.service!=null){
//            this.service = new StructureCompany(entity.service);
//        }
    }

    public ActionCourrier getAction() {
        return action;
    }

    public void setAction(ActionCourrier action) {
        this.action = action;
    }

    public WorkflowAction getStep() {
        return step;
    }

    public void setStep(WorkflowAction step) {
        this.step = step;
    }

//    public StructureCompany getService() {
//        return service;
//    }
//
//    public void setService(StructureCompany service) {
//        this.service = service;
//    }

    @Override
    public String getDesignation() {
        return action.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Etapes Lié"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Etapes Liés";//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(WorkflowLigne o) {
         //To change body of generated methods, choose Tools | Templates.
        return action.compareTo(o.action);
    }
    
}
