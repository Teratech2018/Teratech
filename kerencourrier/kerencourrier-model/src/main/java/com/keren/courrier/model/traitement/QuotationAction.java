/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author BEKO
 */
public class QuotationAction extends BaseElement implements Serializable,Comparable<QuotationAction>{

    @ManyToOne
    @Predicate(label = "Courrier concerné",type = CourrierClone.class,optional = false,target = "many-to-one",search = true,editable = false)
    private CourrierClone courrier ;     
    
    @Predicate(label = "Date",type = Date.class,target = "date",optional = false,search = true)
    private Date dquotation;
    
    @ManyToOne
    @Predicate(label = "Quoteur",type = UtilisateurCourrier.class,optional = false,target = "many-to-one",search = true)
    private UtilisateurCourrier quoteur ;  
    
     @ManyToOne
//    @Predicate(label = "Service Du Quoteur",type = StructureCompany.class,target = "many-to-one",editable = false)
    @Observer(observable = "quoteur",source = "field:service")
    private StructureCompany service ;
    
     @ManyToOne
    @Predicate(label = "Service Quoté",type = StructureCompany.class,target = "many-to-one",search = true)
    private StructureCompany squote ;    
    
    @Predicate(label = "Date butoir",type = Date.class,optional = false,target = "date",search = true)
    private Date limite ;
    
    @ManyToOne
    @Predicate(label = "Quoté",type = UtilisateurCourrier.class,target = "many-to-one",search = true)    
    private UtilisateurCourrier quote ;
   

    @Lob
    @Predicate(label = "Instruction",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = "",search = true)
    private String note ;
    
//    @OneToMany
//    @Predicate(label = "",type = LigneDiffusion.class,target = "one-to-many",group = true,groupName = "group2",groupLabel = "Diffusions",search = true)
//    private List<LigneDiffusion> intervenants = new ArrayList<LigneDiffusion>();
//    @OneToMany
//    @Predicate(label ="",type = DetailQuotation.class,target = "one-to-many",group = true,groupName = "group1",groupLabel = "Informations sur la Quotation")
//    private List<DetailQuotation> lignes = new ArrayList<DetailQuotation>();
    

    public QuotationAction() {
    }

    public CourrierClone getCourrier() {
        return courrier;
    }

    public void setCourrier(CourrierClone courrier) {
        this.courrier = courrier;
    }

    public UtilisateurCourrier getQuoteur() {
        return quoteur;
    }

    public void setQuoteur(UtilisateurCourrier quoteur) {
        this.quoteur = quoteur;
    }

//    public List<DetailQuotation> getLignes() {
//        return lignes;
//    }
//
//    public void setLignes(List<DetailQuotation> lignes) {
//        this.lignes = lignes;
//    }

//    public List<LigneDiffusion> getIntervenants() {
//        return intervenants;
//    }
//
//    public void setIntervenants(List<LigneDiffusion> intervenants) {
//        this.intervenants = intervenants;
//    }

    
    
    public Date getDquotation() {
        return dquotation;
    }

    public void setDquotation(Date dquotation) {
        this.dquotation = dquotation;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
    }

    public StructureCompany getSquote() {
        return squote;
    }

    public void setSquote(StructureCompany squote) {
        this.squote = squote;
    }

    public Date getLimite() {
        return limite;
    }

    public void setLimite(Date limite) {
        this.limite = limite;
    }

    public UtilisateurCourrier getQuote() {
        return quote;
    }

    public void setQuote(UtilisateurCourrier quote) {
        this.quote = quote;
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
        return "Quotation Courrier"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(QuotationAction o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
