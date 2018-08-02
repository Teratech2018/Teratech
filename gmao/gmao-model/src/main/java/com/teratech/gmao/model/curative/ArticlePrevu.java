/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Article;
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
@Table(name = "T_ARTPREGM")
public class ArticlePrevu extends BaseElement implements Serializable,Comparable<ArticlePrevu>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
   @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,search = true )
    private Article article ;    
      
    @Predicate(label = "Prévus",type = Double.class,optional = false,nullable = false,search = true )
    private Double prevus ;
    
    @Predicate(label = "Utilisés",type = Double.class,editable = false,updatable = false,search = true )
    private Double utilise;

    public ArticlePrevu() {
    }

    /**
     * 
     * @param article
     * @param prevus
     * @param utilise
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ArticlePrevu(Article article, Double prevus, Double utilise, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.article = article;
        this.prevus = prevus;
        this.utilise = utilise;
    }
    
     public ArticlePrevu(ArticlePrevu entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.article!=null){
            this.article = new Article(entity.article);
        }
        this.prevus = entity.prevus;
        this.utilise = entity.utilise;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getPrevus() {
        return prevus;
    }

    public void setPrevus(Double prevus) {
        this.prevus = prevus;
    }

    public Double getUtilise() {
        return utilise;
    }

    public void setUtilise(Double utilise) {
        this.utilise = utilise;
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Articles prévus"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Article prévu"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ArticlePrevu o) {
         //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
