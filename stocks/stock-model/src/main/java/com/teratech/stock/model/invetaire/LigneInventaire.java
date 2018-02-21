/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
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
@Table(name = "T_LIIN")
public class LigneInventaire extends BaseElement implements Serializable,Comparable<LigneInventaire>{

    @ManyToOne
    @JoinColumn(name = "ARTI_ID")
    @Predicate(label = "Article concerné",type = Article.class,target = "many-to-one",optional = true,nullable = false,search = true)
    private Article article ;
    
    @Predicate(label = "Stock Dispo",type = Double.class,editable = false,search = true)
    private Double stockdispo ;
    
    @Predicate(label = "Stock Ajusté",type = Double.class,optional = true,nullable = false,search = true)
    private Double stockconstate;
    
    @Predicate(label = "Ecart",type = Double.class,editable = false,search = true)
    private Double stockecart;
    
    @Predicate(label = "PU HT",type = Double.class,editable = false,search = true)
    private Double puht;
    
    @Predicate(label = "PU HT Ajusté",type = Double.class,search = true)
    private Double puajuste ;
    
    @ManyToOne
    @JoinColumn(name = "EMPL_ID")
    @Predicate(label = "Emplacement concerné",type = Emplacement.class,target = "many-to-one",search = true)
    private Emplacement localisation ;

    /**
     * 
     * @param article
     * @param stockdispo
     * @param stockconstate
     * @param stockecart
     * @param puht
     * @param puajuste
     * @param localisation 
     */
    public LigneInventaire(Article article, Double stockdispo, Double stockconstate, Double stockecart, Double puht, Double puajuste, Emplacement localisation) {
        this.article = article;
        this.stockdispo = stockdispo;
        this.stockconstate = stockconstate;
        this.stockecart = stockecart;
        this.puht = puht;
        this.puajuste = puajuste;
        this.localisation = localisation;
    }

    
    /**
     * 
     * @param article
     * @param stockdispo
     * @param stockconstate
     * @param stockecart
     * @param puht
     * @param puajuste
     * @param localisation
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneInventaire(Article article, Double stockdispo, Double stockconstate, Double stockecart, Double puht, Double puajuste, Emplacement localisation, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.article = article;
        this.stockdispo = stockdispo;
        this.stockconstate = stockconstate;
        this.stockecart = stockecart;
        this.puht = puht;
        this.puajuste = puajuste;
        this.localisation = localisation;
    }
    
    /**
     * 
     * @param ligne 
     */
     public LigneInventaire(LigneInventaire ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName);
        this.article = ligne.article;
        this.stockdispo = ligne.stockdispo;
        this.stockconstate = ligne.stockconstate;
        this.stockecart = ligne.stockecart;
        this.puht = ligne.puht;
        this.puajuste = ligne.puajuste;
        if(ligne.localisation!=null){
            this.localisation = new Emplacement(ligne.localisation);
        }
    }

    public LigneInventaire() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getStockdispo() {
        return stockdispo;
    }

    public void setStockdispo(Double stockdispo) {
        this.stockdispo = stockdispo;
    }

    public Double getStockconstate() {
        return stockconstate;
    }

    public void setStockconstate(Double stockconstate) {
        this.stockconstate = stockconstate;
    }

    public Double getStockecart() {
        return stockecart;
    }

    public void setStockecart(Double stockecart) {
        this.stockecart = stockecart;
    }

    public Double getPuht() {
        return puht;
    }

    public void setPuht(Double puht) {
        this.puht = puht;
    }

    public Double getPuajuste() {
        return puajuste;
    }

    public void setPuajuste(Double puajuste) {
        this.puajuste = puajuste;
    }

    public Emplacement getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Emplacement localisation) {
        this.localisation = localisation;
    }

    @Override
    public String getEditTitle() {
        return "Ligne d'inventaire"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(LigneInventaire o) {
        return article.compareTo(o.article);
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
