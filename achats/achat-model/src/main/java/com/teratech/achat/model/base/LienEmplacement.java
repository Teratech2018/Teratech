/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.operations.Lot;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Predicate(label = "Stock sécurité",type = Double.class,optional = false)
    private Double stocksec =0.0;
     
    @Predicate(label = "Stock d'alerte",type = Double.class,optional = false)
    private Double stockale =0.0;
    
    @Predicate(label = "Stock Min",type = Double.class,optional = false,editable = false)
    private Double stockmin ;
    
    @Predicate(label = "Stock Maxi",type = Double.class,optional = false)
    private Double stockmax ;
    
    @Predicate(label = "Prévision",type = Double.class,optional = false,search = true,editable = false)
    private Double prevision ;
    
    @Predicate(label = "A terme",type = Double.class,optional = false,search = true,editable = false)
    private Double terme ;
    
    @OneToMany(mappedBy = "lien",fetch = FetchType.LAZY)
    private List<Lot> lots = new ArrayList<Lot>();

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
        super(id, designation, moduleName,0L);
        this.emplacement = emplacement;
        this.stock = stock;
        this.prevision = prevision;
        this.terme = terme;
    }
    
    /**
     * 
     * @param empl 
     */
    public LienEmplacement(LienEmplacement empl) {
        super(empl.id, empl.designation, empl.moduleName,empl.compareid);
        this.emplacement = new Emplacement(empl.emplacement);
        this.stock = empl.stock;
        this.prevision = empl.prevision;
        this.terme = empl.terme;
        this.stockale = empl.stockale;
        this.stockmax = empl.stockmax;
        this.stockmin = empl.stockmin;
        this.stocksec = empl.stocksec;
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

    public Double getStocksec() {
        return stocksec;
    }

    public void setStocksec(Double stocksec) {
        this.stocksec = stocksec;
    }

    public Double getStockale() {
        return stockale;
    }

    public void setStockale(Double stockale) {
        this.stockale = stockale;
    }

    public Double getStockmin() {
        return stockmin;
    }

    public void setStockmin(Double stockmin) {
        this.stockmin = stockmin;
    }

    public Double getStockmax() {
        return stockmax;
    }

    public void setStockmax(Double stockmax) {
        this.stockmax = stockmax;
    }

    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }  
    

    /**
     * 
     * @param quantite 
     */
    public void addStock(Double quantite){
        if(stock==null){
            stock = 0.0;
        }//end if(stock==null){
        if(quantite!=null){
            stock = stock + quantite;
        }//end if(quantite!=null){
    }

    @Override
    public String getEditTitle() {
        return "Espace de stockage"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return emplacement.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LienEmplacement o) {
        //To change body of generated methods, choose Tools | Templates.
        return emplacement.compareTo(o.emplacement);
    }
    
}
