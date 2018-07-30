/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.courrier;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.NatureCourrier;
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
@Table(name = "T_LIBORGC")
public class LigneBorderoCourrier extends BaseElement implements Serializable,Comparable<LigneBorderoCourrier>{

    @ManyToOne
    @JoinColumn(name = "COUR_ID")
    @Predicate(label = "Courrier Concerné",type = CourrierClone.class,target = "many-to-one",search = true,observable = true)
    private CourrierClone courrier ;
    
    @ManyToOne
    @JoinColumn(name = "NACO_ID")
    @Predicate(label = "Nature courrier",type = NatureCourrier.class,target = "many-to-one",editable = false,search = true)
    @Observer(observable = "courrier",source = "field:nature")
    private NatureCourrier naturecourrier ;
    
    @Predicate(label = "Objet",target = "textarea",editable = false,search = true)
    @Observer(observable = "courrier",source = "field:objet")
    private String objet ;
    
    @Predicate(label = "Nature",target = "combobox",values = "Original;Copie",search = true)
    private String nature;

    public LigneBorderoCourrier() {
    }

    /**
     * 
     * @param courrier
     * @param naturecourrier
     * @param objet
     * @param nature
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public LigneBorderoCourrier(CourrierClone courrier, NatureCourrier naturecourrier, String objet, String nature, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.courrier = courrier;
        this.naturecourrier = naturecourrier;
        this.objet = objet;
        this.nature = nature;
    }
    
    /**
     * 
     * @param entity 
     */
     public LigneBorderoCourrier(LigneBorderoCourrier entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.courrier!=null){
            this.courrier = new CourrierClone(entity.courrier);
        }
        if(entity.naturecourrier!=null){
            this.naturecourrier = new NatureCourrier(entity.naturecourrier);
        }else if(entity.getCourrier().getNature()!=null){
            this.naturecourrier = new NatureCourrier(entity.getCourrier().getNature());
        }
        this.objet = entity.objet;
        
        if(entity.objet==null||entity.objet.trim().isEmpty()){
            this.objet = entity.getCourrier().getObjet();
        }
        this.nature = entity.nature;
    }

    public CourrierClone getCourrier() {
        return courrier;
    }

    public void setCourrier(CourrierClone courrier) {
        this.courrier = courrier;
        this.naturecourrier = courrier.getNature();
        this.objet = courrier.getObjet();
    }

    public NatureCourrier getNaturecourrier() {
        return naturecourrier;
    }

    public void setNaturecourrier(NatureCourrier naturecourrier) {
        this.naturecourrier = naturecourrier;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
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
    public String getListTitle() {
        return super.getListTitle(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Courrier"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int compareTo(LigneBorderoCourrier o) {
         //To change body of generated methods, choose Tools | Templates.
        return courrier.compareTo(o.courrier);
    }
    
}
