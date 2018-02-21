/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.base;

import com.core.base.BaseElement;
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
@Table(name = "T_LIEM")
public class LienEmplacement extends BaseElement implements Serializable,Comparable<LienEmplacement>{

    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    @Predicate(label = "Emplacement",type = Emplacement.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Emplacement emplacement ;
    
    @Predicate(label = "Stock réel",type = Double.class,optional = false,search = true)
    private Double stock ;
    
    @Predicate(label = "Prévision",type = Double.class,optional = false,search = true,editable = false)
    private Double prevision ;
    
    @Predicate(label = "A terme",type = Double.class,optional = false,search = true,editable = false)
    private Double terme ;

    /**
     * 
     * @param emplacement
     * @param stock
     * @param prevision
     * @param terme 
     */
    public LienEmplacement(Emplacement emplacement, Double stock, Double prevision, Double terme) {
        this.emplacement = emplacement;
        this.stock = stock;
        this.prevision = prevision;
        this.terme = terme;
    }

    
    /**
     * 
     * @param emplacement
     * @param stock
     * @param prevision
     * @param terme
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LienEmplacement(Emplacement emplacement, Double stock, Double prevision, Double terme, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.emplacement = emplacement;
        this.stock = stock;
        this.prevision = prevision;
        this.terme = terme;
    }
    
    public LienEmplacement(LienEmplacement empl) {
        super(empl.id, empl.designation, empl.moduleName);
        this.emplacement = new Emplacement(empl.emplacement);
        this.stock = empl.stock;
        this.prevision = empl.prevision;
        this.terme = empl.terme;
    }

    public LienEmplacement() {
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public Double getPrevision() {
        return prevision;
    }

    public void setPrevision(Double prevision) {
        this.prevision = prevision;
    }

    public Double getTerme() {
        return terme;
    }

    public void setTerme(Double terme) {
        this.terme = terme;
    }

    

    @Override
    public String getEditTitle() {
        return "Espace de stockage"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int compareTo(LienEmplacement o) {
        //To change body of generated methods, choose Tools | Templates.
        return emplacement.compareTo(o.emplacement);
    }
    
}
