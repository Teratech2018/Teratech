/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.BorderoCourrier;
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
@Table(name = "T_QUOTGC")
public class QuotationAction extends BaseElement implements Serializable,Comparable<QuotationAction>{

    @ManyToOne
    @JoinColumn(name = "COU_ID")
    @Predicate(label = "Courrier concerné",type = CourrierClone.class,optional = false,target = "many-to-one",search = true,editable = false)
    private CourrierClone courrier ;     
    
    @Predicate(label = "Date",type = Date.class,target = "date",optional = false,search = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dquotation;
    
    @ManyToOne
    @JoinColumn(name = "QUOT_ID")
    @Predicate(label = "Quoteur",type = UtilisateurCourrier.class,optional = false,target = "many-to-one",search = true)
    private UtilisateurCourrier quoteur ;  
    
     @ManyToOne
     @JoinColumn(name = "SQUOT_ID")
//    @Predicate(label = "Service Du Quoteur",type = StructureCompany.class,target = "many-to-one",editable = false)
    @Observer(observable = "quoteur",source = "field:service")
    private StructureCompany service ;
    
    @Predicate(label = "Date butoir",type = Date.class,optional = false,target = "date",search = true)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date limite ;
    
    @ManyToOne
    @JoinColumn(name = "DEST_ID")
    @Predicate(label = "Quoté",type = UtilisateurCourrier.class,target = "many-to-one",search = true,observable = true)    
    private UtilisateurCourrier quote ;
   
    
     @ManyToOne
     @JoinColumn(name = "SDEST_ID")
    @Predicate(label = "Service Quoté",type = StructureCompany.class,target = "many-to-one",search = true)
     @Observer(observable = "quote",source = "field:service")
    private StructureCompany squote ;    
    
    @Lob
    @Predicate(label = "Instruction",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = "",search = true)
    private String note ;
    

    @ManyToOne
    @JoinColumn(name = "BORD_ID")
    private BorderoCourrier bordero ;
        
    

    public QuotationAction() {
    }

    /**
     * 
     * @param entity 
     */
    public QuotationAction(QuotationAction entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.courrier!=null){
            this.courrier = new CourrierClone(entity.courrier);
        }
        this.dquotation = entity.dquotation;
        if(entity.quoteur!=null){
            this.quoteur = new UtilisateurCourrier(entity.quoteur);
        }
        if(entity.service!=null){
            this.service = new StructureCompany(entity.service);
        }
        if(entity.squote!=null){
            this.squote = new StructureCompany(entity.squote);
        }
        this.limite = entity.limite;
        if(entity.quote!=null){
            this.quote = new UtilisateurCourrier(entity.quote);
        } 
//        if(entity.bordero!=null){
//            this.bordero = new BorderoCourrier(entity.bordero);
//        }
        this.note = entity.note;
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

    public BorderoCourrier getBordero() {
        return bordero;
    }

    public void setBordero(BorderoCourrier bordero) {
        this.bordero = bordero;
    }    
    
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
    public String getDesignation() {
        return courrier.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Quotations"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(QuotationAction o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
