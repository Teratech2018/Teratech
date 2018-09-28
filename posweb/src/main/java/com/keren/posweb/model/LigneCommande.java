/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.posweb.model;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "T_LICMPOS")
public class LigneCommande extends BaseElement implements Serializable,Comparable<LigneCommande>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,search = true)
    private Article article ;
    
    @Predicate(label = "Quantité",type = Double.class,search = true,optional = false)
    private Double quantite ;
    
    @Predicate(label = "P.U",type = Double.class,search = true,optional = false)
    private Double pu ;
    
    @Predicate(label = "Remise(%)",type = Double.class,search = true,optional = false)
    private Double remise ;
   
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_LIGCMDE_TAXE",joinColumns = @JoinColumn(name = "LIG_ID"),inverseJoinColumns = @JoinColumn(name = "TAX_ID"))
    private List<Taxe> taxes = new ArrayList<Taxe>();

    public LigneCommande() {
    }

    public LigneCommande(LigneCommande entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.article!=null){
            this.article = new Article(entity.article);
        }
        this.quantite = entity.quantite;
        this.pu = entity.pu;
        this.remise = entity.remise;
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

    public Double getPu() {
        return pu;
    }

    public void setPu(Double pu) {
        this.pu = pu;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

    public List<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<Taxe> taxes) {
        this.taxes = taxes;
    }

    @Override
    public String getDesignation() {
        return article.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "posweb"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Lignes Commandes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Ligne Commande"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(LigneCommande o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
