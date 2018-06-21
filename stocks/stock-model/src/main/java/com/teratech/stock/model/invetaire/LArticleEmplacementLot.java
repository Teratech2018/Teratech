/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.core.base.BaseElement;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import com.teratech.stock.model.base.LienEmplacement;
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
@Table(name = "V_LAREMLO")
public class LArticleEmplacementLot extends BaseElement implements Serializable,Comparable<LArticleEmplacementLot>{

    private String code ;
    
    @ManyToOne
    @JoinColumn(name = "ART_ID")
    private Article article ;
    
    @ManyToOne
    @JoinColumn(name = "LIE_ID")
    private LienEmplacement lien ;
    
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    private Emplacement emplacement ;
    
    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    private Entrepot entrepot ;
    
    private Double stock ;

    
    /**
     * 
     * @param article
     * @param lien
     * @param emplacement
     * @param entrepot
     * @param stock 
     */
    public LArticleEmplacementLot(Article article, LienEmplacement lien, Emplacement emplacement, Entrepot entrepot, Double stock) {
        this.article = article;
        this.lien = lien;
        this.emplacement = emplacement;
        this.entrepot = entrepot;
        this.stock = stock;
    }

    
    /**
     * 
     * @param article
     * @param lien
     * @param emplacement
     * @param entrepot
     * @param stock
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LArticleEmplacementLot(Article article, LienEmplacement lien, Emplacement emplacement, Entrepot entrepot, Double stock, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
        this.lien = lien;
        this.emplacement = emplacement;
        this.entrepot = entrepot;
        this.stock = stock;
    }

    /**
     * 
     * @param lart 
     */
    public LArticleEmplacementLot(LArticleEmplacementLot lart) {
        super(lart.id, lart.designation, lart.moduleName,lart.compareid);
        if(lart.article!=null){
            this.article = new Article(lart.article);
        }
        if(lart.lien!=null){
            this.lien = new LienEmplacement(lart.lien);
        }
        if(lart.emplacement!=null){
            this.emplacement = new Emplacement(lart.emplacement);
        }
        if(lart.entrepot!=null){
            this.entrepot = new Entrepot(lart.entrepot);
        }
        this.stock = lart.stock;
    }
   

    public LArticleEmplacementLot() {
    }

    
    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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

    public LienEmplacement getLien() {
        return lien;
    }

    public void setLien(LienEmplacement lien) {
        this.lien = lien;
    }

    public Entrepot getEntrepot() {
        return entrepot;
    }

    public void setEntrepot(Entrepot entrepot) {
        this.entrepot = entrepot;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
    @Override
    public int compareTo(LArticleEmplacementLot o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
