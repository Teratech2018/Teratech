/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.operations.Lot;
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
@Table(name = "T_LIEM_ST")
public class LienEmplacement extends BaseElement implements Serializable,Comparable<LienEmplacement>{

     @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt",type = Entrepot.class,target = "many-to-one",optional = false,nullable = false,search = true)
    private Entrepot entrpot ;
    
    @ManyToOne
    @JoinColumn(name = "EMP_ID")
    @Predicate(label = "Emplacement",type = Emplacement.class,target = "many-to-one",optional = false,nullable = false,search = true)
    @Filter(value = "[{\"fieldName\":\"edepot\",\"value\":\"object.entrpot\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'entrepôt\"}]")
    private Emplacement emplacement ;
    
    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",search = false,editable = false)
    private Article article ;
    
    @Predicate(label = "Stock réel",type = Double.class,editable = false,search = true)
    private Double stock ;    
    
    @Predicate(label = "Stock sécurité",type = Double.class,optional = false)
    private Double stocksec =0.0;
     
    @Predicate(label = "Stock d'alerte",type = Double.class,optional = false)
    private Double stockalert =0.0;
    
    @Predicate(label = "Stock Min",type = Double.class)
    private Double stockmin ;
    
    @Predicate(label = "Stock Maxi",type = Double.class)
    private Double stockmax ;
    
    @Predicate(label = "Prévision de sortie",type = Double.class,search = true,editable = false,hide = true)
    private Double prevision ;
    
    @Predicate(label = "A terme",type = Double.class,search = true,editable = false,hide=true)
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
        this.entrpot = new Entrepot(empl.entrpot);
        this.article = new Article(empl.article);
        this.stock = empl.stock;
        this.prevision = empl.prevision;
        this.terme = empl.terme;
        this.stockalert = empl.stockalert;
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

    public Double getStockalert() {
        return stockalert;
    }

    public void setStockale(Double stockale) {
        this.stockalert = stockale;
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

    public Entrepot getEntrpot() {
        return entrpot;
    }

    public void setEntrpot(Entrepot entrpot) {
        this.entrpot = entrpot;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String getOwnermodule() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechstock";  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return true;//To change body of generated methods, choose Tools | Templates.
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
