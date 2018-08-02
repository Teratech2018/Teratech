/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.courrier;

import com.keren.courrier.model.referentiel.*;
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
@Table(name = "T_SERDIGC")
public class ServiceDiffusion extends BaseElement implements Serializable,Comparable<ServiceDiffusion>{

    
    
    @ManyToOne
    @JoinColumn(name = "SER_ID")
    @Predicate(label = "Service",type = StructureCompany.class,target = "many-to-one",search = true)
    @Observer(observable = "user",source = "field:service")
    private StructureCompany service ;    
    
    
    @Predicate(label = "Rôle",target = "combobox",values = "En copie;Avis",search = true)
    private String role ;
    
//    @ManyToOne
//    @JoinColumn(name="LIDI_ID")
//    @JsonIgnore
//    private StructureCompany structureCompany ;

    public ServiceDiffusion() {
    }

    public ServiceDiffusion(UtilisateurCourrier user, String role, long id, String designation, String moduleName, long comparedid, StructureCompany structure) {
        super(id, designation, moduleName, comparedid);
//        this.user = user;
        this.role = role;
//        this.structureCompany = structure;
    }

    public ServiceDiffusion(ServiceDiffusion entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);        
//        if(entity.user!=null){
//            this.user = new UtilisateurCourrier(entity.user);
//        }  
        if(entity.service!=null){
            service = new StructureCompany(entity.service);
        }
        this.role = entity.role;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
    }   
    
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getDesignation() {
        return service.getDesignation();       
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Liste de diffusion"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Joindre un destinataire"; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int compareTo(ServiceDiffusion o) {
        return service.compareTo(o.service); //To change body of generated methods, choose Tools | Templates.
    }
    
}
