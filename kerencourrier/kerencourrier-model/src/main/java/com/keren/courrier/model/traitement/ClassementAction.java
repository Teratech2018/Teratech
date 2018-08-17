/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.referentiel.ClasseurCourrier;
import com.keren.courrier.model.referentiel.CompartimentClasseur;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CLASACGC")
public class ClassementAction extends BaseElement implements Serializable,Comparable<ClassementAction>{

    @ManyToOne
    @JoinColumn(name = "COU_ID")
    @Predicate(label = "Courrier à classer",type = CourrierClone.class,target = "many-to-one",editable = false,optional = false)
    private CourrierClone courrier ;
    
    @Predicate(label = "Date de classement",type = Date.class,target = "date",optional = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date  dclassement ;
    
    @ManyToOne
    @JoinColumn(name = "ORD_ID")
    @Predicate(label = "Ordonateur",type = UtilisateurCourrier.class,target = "many-to-one",search = true,optional = false,observable = true)
    private UtilisateurCourrier ordonateur ;    
     
    @ManyToOne
    @JoinColumn(name = "SERV_ID")
//    @Predicate(label = "Service Ordonateur",type = StructureCompany.class,target = "many-to-one",editable = false)
//    @Observer(observable = "ordonateur",source = "field:service")
    private StructureCompany service ;
    
    @Predicate(label = "Nature du classement",target = "combobox",values = "Sans suite;Fond de dossier",optional = false)
    private String nature ="0";
    
     @ManyToOne
    @JoinColumn(name = "CLAS_ID")
    @Predicate(label = "Classeur Concerné",type = ClasseurCourrier.class,target = "many-to-one",search = true,optional = false, observable=true)
    private ClasseurCourrier classeur ;
    
      @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @Predicate(label = "Compartiment",type = CompartimentClasseur.class,target = "many-to-one",search = true,optional = false)
    @Filter(value="[{\"fieldName\":\"idclasseur\",\"value\":\"object.classeur\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner un classeur\"}]")
    private CompartimentClasseur compartiment ;
    
    @Predicate(label = "Motif du classement",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = "")
    private String motif ;
    
 

    public ClassementAction() {
    }

    public ClassementAction(ClassementAction entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.courrier!=null){
            this.courrier = new CourrierClone(entity.courrier);
        }
        this.dclassement = entity.dclassement;
        if(entity.ordonateur!=null){
            this.ordonateur = new UtilisateurCourrier(entity.ordonateur);
        }
        if(entity.service!=null){
            this.service = new StructureCompany(entity.service);
        }
        if(entity.classeur!=null){
            this.classeur = new ClasseurCourrier(entity.classeur);
        }
        if(entity.compartiment!=null){
            this.compartiment = new CompartimentClasseur(entity.compartiment);
        }
        this.motif = entity.motif;
        this.nature = entity.nature;
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

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
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
        return courrier.compareTo(o.courrier);
    }
    
}
