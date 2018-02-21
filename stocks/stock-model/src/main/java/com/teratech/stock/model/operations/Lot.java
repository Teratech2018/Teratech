/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LOT")
public class Lot extends BaseElement implements Serializable,Comparable<Lot>{

    @Predicate(label = "Numéro",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Quantite",type = Double.class,optional = false,search = true)
    private Double quantite ;
    
    @Predicate(label = "Péremption",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date peremption ;
    
    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date fabrication ;

    /**
     * 
     * @param code
     * @param quantite
     * @param peremption
     * @param fabrication 
     */
    public Lot(String code, Double quantite, Date peremption, Date fabrication) {
        this.code = code;
        this.quantite = quantite;
        this.peremption = peremption;
        this.fabrication = fabrication;
    }

    /**
     * 
     * @param code
     * @param quantite
     * @param peremption
     * @param fabrication
     * @param id
     * @param designation
     * @param moduleName 
     */
    public Lot(String code, Double quantite, Date peremption, Date fabrication, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.code = code;
        this.quantite = quantite;
        this.peremption = peremption;
        this.fabrication = fabrication;
    }

    /**
     * 
     */
    public Lot() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Date getPeremption() {
        return peremption;
    }

    public void setPeremption(Date peremption) {
        this.peremption = peremption;
    }

    public Date getFabrication() {
        return fabrication;
    }

    public void setFabrication(Date fabrication) {
        this.fabrication = fabrication;
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "LOTS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "LOT"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Lot o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
