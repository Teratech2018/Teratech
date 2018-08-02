/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.referentiel.ClasseurCourrier;
import com.keren.courrier.model.referentiel.CompartimentClasseur;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
public class ClassementAction extends BaseElement implements Serializable,Comparable<ClassementAction>{

    @ManyToOne
    @Predicate(label = "Courrier à classer",type = CourrierClone.class,target = "many-to-one",editable = false,optional = false)
    private CourrierClone courrier ;
    
    @Predicate(label = "Date de classement",type = Date.class,target = "date",optional = false)
    private Date  dclassement ;
    
    @ManyToOne
    @JoinColumn(name = "ORD_ID")
    @Predicate(label = "Ordonateur",type = UtilisateurCourrier.class,target = "many-to-one",search = true,optional = false,observable = true)
    private UtilisateurCourrier ordonateur ;    
     
    @ManyToOne
    @Predicate(label = "Service Ordonateur",type = StructureCompany.class,target = "many-to-one",editable = false)
    @Observer(observable = "ordonateur",source = "field:service")
    private StructureCompany service ;
    
    
     @ManyToOne
    @JoinColumn(name = "CLAS_ID")
    @Predicate(label = "Classeur Concerné",type = ClasseurCourrier.class,target = "many-to-one",search = true,optional = false)
    private ClasseurCourrier classeur ;
    
      @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compartiment",type = CompartimentClasseur.class,target = "many-to-one",search = true,optional = false)
    private CompartimentClasseur compartiment ;
    
    @Predicate(label = "Motif du classement",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = "")
    private String motif ;

    public ClassementAction() {
    }

    public UtilisateurCourrier getOrdonateur() {
        return ordonateur;
    }

    public void setOrdonateur(UtilisateurCourrier ordonateur) {
        this.ordonateur = ordonateur;
    }

    public Date getDclassement() {
        return dclassement;
    }

    public void setDclassement(Date dclassement) {
        this.dclassement = dclassement;
    }

    public ClasseurCourrier getClasseur() {
        return classeur;
    }

    public void setClasseur(ClasseurCourrier classeur) {
        this.classeur = classeur;
    }

    public CompartimentClasseur getCompartiment() {
        return compartiment;
    }

    public void setCompartiment(CompartimentClasseur compartiment) {
        this.compartiment = compartiment;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public CourrierClone getCourrier() {
        return courrier;
    }

    public void setCourrier(CourrierClone courrier) {
        this.courrier = courrier;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
    }
    
    

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Classement Courrier"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ClassementAction o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
