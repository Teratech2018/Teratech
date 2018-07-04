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
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LIEXBE")
public class LigneExprBesion extends BaseElement implements Serializable,Comparable<LigneExprBesion>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,search = true)
    private Article article ;
    
    @Predicate(label = "Quantité",type = Double.class,optional = false,search = true)
    private Double quantite ;

    /**
     * 
     * @param article
     * @param quantite 
     */
    public LigneExprBesion(Article article, Double quantite) {
        this.article = article;
        this.quantite = quantite;
    }
    
    /**
     * 
     * @param ligne 
     */
     public LigneExprBesion(LigneExprBesion ligne) {
         if(ligne.article!=null){
             this.article = new Article(ligne.article);
         }
        this.quantite = ligne.quantite;
    }

    /**
     * 
     * @param article
     * @param quantite
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneExprBesion(Article article, Double quantite, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
        this.quantite = quantite;
    }

    public LigneExprBesion() {
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
    public int compareTo(LigneExprBesion o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
