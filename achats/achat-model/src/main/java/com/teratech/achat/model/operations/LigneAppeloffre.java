/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Article;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "T_LIAPOF")
public class LigneAppeloffre extends BaseElement implements Serializable,Comparable<LigneAppeloffre>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Article article ;
    
    @Predicate(label = "Quantité",type = Double.class,optional = false,search = true)
    private Double quantite ;
    
    @Predicate(label = "Date prévu",type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    private Date prevu;

    /**
     * 
     * @param article
     * @param quantite 
     */
    public LigneAppeloffre(Article article, Double quantite) {
        this.article = article;
        this.quantite = quantite;
    }
    
    /**
     * 
     * @param ligne 
     */
     public LigneAppeloffre(LigneAppeloffre ligne) {
         if(ligne.article!=null){
             this.article = new Article(ligne.article);
         }
        this.quantite = ligne.quantite;
        this.prevu = ligne.prevu;
    }

    /**
     * 
     * @param article
     * @param quantite
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneAppeloffre(Article article, Double quantite, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
        this.quantite = quantite;
    }

    public LigneAppeloffre() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public Date getPrevu() {
        return prevu;
    }

    public void setPrevu(Date prevu) {
        this.prevu = prevu;
    }
    
    

    @Override
    public String getDesignation() {
        return article.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "BESIONS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "BESION"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LigneAppeloffre o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
