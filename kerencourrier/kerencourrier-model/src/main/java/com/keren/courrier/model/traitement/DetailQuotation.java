/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.traitement;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author BEKO
 */
public class DetailQuotation extends BaseElement implements Serializable,Comparable<DetailQuotation>{

    
    @ManyToOne
    @Predicate(label = "Service Quoté",type = StructureCompany.class,target = "many-to-one",search = true)
    private StructureCompany service ;    
    
    @Predicate(label = "Date butoir",type = Date.class,optional = false,target = "date",search = true)
    private Date limite ;
    
    @ManyToOne
    @Predicate(label = "Quoté",type = UtilisateurCourrier.class,target = "many-to-one",search = true)    
    private UtilisateurCourrier quote ;
   

    @Lob
    @Predicate(label = "Instruction",target = "textarea",optional = false,group = true,groupName = "group1",groupLabel = " ",search = true)
    private String note ;

    
    /**
     * 
     */
    public DetailQuotation() {
    }

    public UtilisateurCourrier getQuote() {
        return quote;
    }

    public void setQuote(UtilisateurCourrier quote) {
        this.quote = quote;
    }

    public StructureCompany getService() {
        return service;
    }

    public void setService(StructureCompany service) {
        this.service = service;
    }


    public Date getLimite() {
        return limite;
    }

    public void setLimite(Date limite) {
        this.limite = limite;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String getModuleName() {
        return "teratechcourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Saisir Une Quotation"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(DetailQuotation o) {
         //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
