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
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LIDOAC_ACH")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("TMP")
public class LigneDocumentAchat extends BaseElement implements Serializable,Comparable<LigneDocumentAchat>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",optional = false,search = true,observable = true)
    protected Article article ;    
    
//    @Temporal(TemporalType.DATE)
//    @Predicate(label = "Date prévue",type = Date.class,target = "date",optional = false,search = true)
//    private Date prevue ;
//    
    @Predicate(label = "N° Lot/Serie",optional = true,search = true)
    private String code ;
//    
//    @Predicate(label = "Péremption",type = Date.class,target = "date",search = false)
//    @Temporal(TemporalType.DATE)
//    private Date peremption ;
//    
//    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = false)
//    @Temporal(TemporalType.DATE)
//    private Date fabrication ;
    
    @Predicate(label = "Quantité",type = Double.class,optional = false,search = true)
    protected Double quantite ;
    
    @Predicate(label = "Prix HT",type = Double.class,search = true)
    @Observer(observable = "article",source = "field:puachat")
    protected Double puht ;
    
    @ManyToMany
    @JoinTable(name = "T_LIDOAC_TA",joinColumns = @JoinColumn(name = "LIDOAC_ID")
            ,inverseJoinColumns = @JoinColumn(name = "TAXE_ID"))    
    @Predicate(label = "Taxes",type = Taxe.class,target = "many-to-many",optional = false,search = true)
    protected List<Taxe> taxes =new ArrayList<Taxe>();
    
    @Predicate(label = "Remise(%)",type = Double.class,search = true)
    protected Double remise = 0.0;
    
    @Predicate(label = "Sous-total",type = Double.class,compute = true,values = "this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100",hide =true ,search = true)
    protected Double totalht ;
    
    protected Double qtefacturee = 0.0;
    
    
    protected Double stokdispo = 0.0;
    
    @Transient
    protected LigneDocumentAchat ligneachat ;

    /**
     * 
     * @param article
     * @param prevue
     * @param quantite
     * @param puht
     * @param totalht 
     */
    public LigneDocumentAchat(Article article, Date prevue, Double quantite, Double puht, Double totalht) {
        this.article = article;
//        this.prevue = prevue;
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
    public LigneDocumentAchat(Article article, Date prevue, Double quantite, Double puht, Double totalht, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
//        this.prevue = prevue;
        this.quantite = quantite;
        this.puht = puht;
        this.totalht = totalht;
    }

    /**
     * 
     * @param ligne 
     */
    public LigneDocumentAchat(LigneDocumentAchat ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
        if(ligne.article!=null){
            this.article = new Article(ligne.article);
        }
//        this.prevue = ligne.prevue;
        this.quantite = ligne.quantite;
        this.puht = ligne.puht;
        this.totalht = ligne.totalht;
        if(ligne.taxes!=null){
            
            for(Taxe taxe:ligne.taxes){
                this.taxes.add(new Taxe(taxe));
            }
        }
        this.remise = ligne.remise;
        this.code = ligne.code;
//        this.peremption = ligne.getPeremption();
//        this.fabrication = ligne.getFabrication();
        this.qtefacturee = ligne.getQtefacturee();
        this.stokdispo = ligne.getStokdispo();
        
    }
    
    
    public LigneDocumentAchat() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

//    public Date getPrevue() {
//        return prevue;
//    }
//
//    public void setPrevue(Date prevue) {
//        this.prevue = prevue;
//    }

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

    public void setTaxes(List<Taxe> taxe) {
        this.taxes = taxe;
    }

    public Double getRemise() {
        return remise;
    }

    public void setRemise(Double remise) {
        this.remise = remise;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String lot) {
//        this.code = lot;
//    }
//
//    public Date getPeremption() {
//        return peremption;
//    }
//
//    public void setPeremption(Date peremption) {
//        this.peremption = peremption;
//    }
//
//    public Date getFabrication() {
//        return fabrication;
//    }
//
//    public void setFabrication(Date fabrication) {
//        this.fabrication = fabrication;
//    }

    public Double getQtefacturee() {
        return qtefacturee;
    }

    public void setQtefacturee(Double qtefacturee) {
        this.qtefacturee = qtefacturee;
    }
    
    /**
     * 
     * @return 
     */
    public Double qtenonfacturee(){
        if(qtefacturee==null){
            qtefacturee = 0.0;
        }
        Double solde = quantite-qtefacturee;
        return solde>=0 ? solde:0.0;
    }

    public LigneDocumentAchat getLigneachat() {
        return ligneachat;
    }

    public void setLigneachat(LigneDocumentAchat ligneachat) {
        this.ligneachat = ligneachat;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
    
    /**
     * 
     * @param qte 
     */
    public void addQuantitefacturee(Double qte){
        if(qte!=null){
            this.qtefacturee+=qte;
        }//end if(qte!=null)
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

    public Double getStokdispo() {
        return stokdispo;
    }

    public void setStokdispo(Double stokdispo) {
        this.stokdispo = stokdispo;
    }
    
    
    
    @Override
    public int compareTo(LigneDocumentAchat o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
