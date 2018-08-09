/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ANNOACGC")
public class AnnotationAction extends BaseElement implements Serializable,Comparable<AnnotationAction>{

    
     @ManyToOne
     @JoinColumn(name = "COU_ID")
    @Predicate(label = "Courrier concerné",type = Courrier.class,target = "many-to-one",editable = false,search = true)
    private CourrierClone courrier ;
    
      
    @Predicate(label = "Date Annotation",type = Date.class,target = "date",optional = false,search = true)
     @Temporal(javax.persistence.TemporalType.DATE)
    private Date dvisa;
     
    @ManyToOne
    @JoinColumn(name = "QUOT_ID")
    @Predicate(label = "Le Viseur",type = UtilisateurCourrier.class,target = "many-to-one",optional = false,search = true,observable = true)
    private UtilisateurCourrier quoteur ;
    
     @ManyToOne
     @JoinColumn(name = "SERV_ID")
    @Predicate(label = "Service Du Viseur",type = StructureCompany.class,target = "many-to-one",editable = false)
    @Observer(observable = "quoteur",source = "field:service")
    private StructureCompany service ;
     
    @Lob
    @Predicate(label = "Objet ou Visa",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = " ")
    private String note ;

    public AnnotationAction() {
    }

    /**
     * 
     * @param entity 
     */
    public AnnotationAction(AnnotationAction entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.courrier!=null){
            this.courrier = new CourrierClone(entity.courrier);
        }
        this.dvisa = entity.dvisa;
        if(entity.quoteur!=null){
            this.quoteur = new UtilisateurCourrier(entity.quoteur);
        }
        if(entity.service!=null){
            this.service = new StructureCompany(entity.service);
        }
        this.note = entity.note;
    }
    
    

    public CourrierClone getCourrier() {
        return courrier;
    }

    public void setCourrier(CourrierClone courrier) {
        this.courrier = courrier;
    }

    public Date getDvisa() {
        return dvisa;
    }

    public void setDvisa(Date dvisa) {
        this.dvisa = dvisa;
    }

    public UtilisateurCourrier getQuoteur() {
        return quoteur;
    }

    public void setQuoteur(UtilisateurCourrier quoteur) {
        this.quoteur = quoteur;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    
    
    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Annotation Courrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return courrier.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Annotations Courriers"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int compareTo(AnnotationAction o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
