/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.LienEmplacement;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    
    private Double sorties = 0.0;
    
    private Double encours = 0.0;
    
    @Predicate(label = "Péremption",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date peremption ;
    
    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date fabrication ;
    
    @ManyToOne
    @JoinColumn(name = "LIEM_ID")
    private LienEmplacement lien ;
    
    @Column(unique = true)    
    private String reference ;
    
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
    
     public Lot(Lot lot) {
        super(lot.id, lot.designation, lot.moduleName);
        this.code = lot.code;
        this.quantite = lot.quantite;
        this.peremption = lot.peremption;
        this.fabrication = lot.fabrication;
        this.reference = lot.reference;
        if(lot.lien!=null){
            lien = new LienEmplacement(lot.lien);
        }
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

    public LienEmplacement getLien() {
        return lien;
    }

    public void setLien(LienEmplacement lien) {
        this.lien = lien;
    }

    public Double getSorties() {
        return sorties;
    }

    public void setSorties(Double sorties) {
        this.sorties = sorties;
    }

    public Double disponible() {
        return (quantite==null ? 0.0 : quantite)-(sorties==null? 0.0:sorties)-(encours==null ? 0.0:encours);
    }//end public Double disponible()  

    public Double getEncours() {
        return encours;
    }

    public void setEncours(Double encours) {
        this.encours = encours;
    }

    
    /**
     * 
     * @param quantite
     * @return 
     */
    public void addSortie(Double quantite){
        if(sorties==null){
            sorties = 0.0;
        }
        sorties = sorties+quantite;
    }
    
    /**
     * 
     * @param qte 
     */
    public void addEntree(Double qte){
        if(quantite==null){
            quantite = 0.0;
        }
        quantite = quantite+qte;
    }

    public String getReference() {
        StringBuilder builder = new StringBuilder(code);
        builder.append(lien.getEmplacement().getCode());
        reference = builder.toString();
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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
