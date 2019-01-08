/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.comptabilite.Taxe;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_REDP_ACH")
public class LigneReponseDP extends BaseElement implements Serializable,Comparable<LigneReponseDP>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,search = true,observable = true)
    private Article article ;   
    
    @Predicate(label = "Quantité",type = Double.class,optional = false,search = true)
    private Double quantite ;
    
    @Predicate(label = "Prix HT",type = Double.class,search = true)
    @Observer(observable = "article",source = "field:puachat")
    private Double puht ;
    
    @ManyToMany
    @JoinTable(name = "T_REDPTA_ACH",joinColumns = @JoinColumn(name = "REDP_ID")
            ,inverseJoinColumns = @JoinColumn(name = "TAXE_ID"))    
    @Predicate(label = "Taxes",type = Taxe.class,target = "many-to-many",optional = false,search = true)
    private List<Taxe> taxes = new ArrayList<Taxe>();
    
    @Predicate(label = "Remise(%)",type = Double.class,search = true)
    private Double remise = 0.0;
     
    @Predicate(label = "Sous-total",type = Double.class,compute = true,values = "this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100",hide =true ,search = true)
    private Double totalht ;
    
      

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht 
     */
    public LigneReponseDP(Article article, Date prevue, Double quantite, Double puht, Double totalht) {
        this.article = article;
        this.quantite = quantite;
        this.puht = puht;
        this.totalht = totalht;
    }

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneReponseDP(Article article, Date prevue, Double quantite, Double puht, Double totalht, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
        this.quantite = quantite;
        this.puht = puht;
        this.totalht = totalht;
    }

    /**
     * 
     * @param ligne 
     */
    public LigneReponseDP(LigneReponseDP ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
        if(ligne.article!=null){
            this.article = new Article(ligne.article);
        }
        this.quantite = ligne.quantite;
        this.puht = ligne.puht;
        this.remise = ligne.remise;
        this.totalht = ligne.totalht;
    }
    
    public LigneReponseDP(LigneDemandePrix ligne) {
        super(-1, ligne.getDesignation(), ligne.getModuleName(),ligne.getCompareid());
        if(ligne.getArticle()!=null){
            this.article = new Article(ligne.getArticle());
        }
        this.quantite = ligne.getQuantite();
        this.puht = null;
        
    }
    
    public LigneReponseDP() {
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

    public Double getPuht() {
        return puht;
    }

    public void setPuht(Double puht) {
        this.puht = puht;
    }

    public Double getTotalht() {
        return totalht;
    }

    public void setTotalht(Double totalht) {
        this.totalht = totalht;
    }

    public List<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxe> taxes) {
        this.taxes = taxes;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
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
        return "LIGNES ACHATS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "ACHAT"; //To change body of generated methods, choose Tools | Templates.
    }

        
    @Override
    public int compareTo(LigneReponseDP o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
