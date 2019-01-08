/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.LienEmplacement;
import com.teratech.achat.model.base.UniteGestion;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_LIDS_ST")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("DC")
public class LigneDocumentStock extends BaseElement implements Serializable,Comparable<LigneDocumentStock>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article concerné",type = Article.class,target = "many-to-one",optional = false,nullable = true,search = true)
    protected Article article ;
    
    @ManyToOne
    @JoinColumn(name = "UNG_ID")
//    @Predicate(label = "Unité de gestion",type = UniteGestion.class,target = "many-to-one",editable = false,search = true)
    protected UniteGestion unite ;    
    
    @Predicate(label = "Quantité",type = Double.class,optional = false,search = true)
    protected Double quantite ;    
    
    @Predicate(label = "PU HT",type = Double.class,optional = false,search = true)
    protected Double puht ;
    
    @ManyToOne
    @JoinColumn(name = "LIEMP_ID")
    @Predicate(label = "Emplacement cible",type = LienEmplacement.class,target = "many-to-one",search = true,optional = false)
    @Filter(value = "[{\"fieldName\":\"article\",\"value\":\"object.article\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'article\"},{\"fieldName\":\"entrpot\",\"value\":\"this.entrepot\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner le magasin\"}]")
    protected LienEmplacement emplacement ;
    
//    @Predicate(label = "PU Net",type = Double.class,optional = false,editable = false)
    protected Double punet ;
//    
//    @Predicate(label = "N° lot/série",optional = false,unique = true,search = true)
//    private String code ;
//    
//    @Predicate(label = "Péremption",type = Date.class,target = "date",search = true)
//    @Temporal(TemporalType.DATE)
//    private Date peremption ;
//    
//    @Predicate(label = "Fabrication",type = Date.class,target = "date",search = true)
//    @Temporal(TemporalType.DATE)
//    private Date fabrication ;
//    
////    @Predicate(label = "Total HT",type = Double.class,optional = false,search = true,hide = true,compute = true,values ="this.puht,*,this.quantite" )
//    private Double totalht ;    
//    
//    @OneToOne
//    private Lot lot ;

    public LigneDocumentStock(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht) {
        this.article = article;
        this.unite = unite;
        this.puht = puht;
        this.quantite = quantite;
        this.punet = punet;
//        this.code = code;
//        this.peremption = peremption;
//        this.fabrication = fabrication;
//        this.totalht = totalht;
    }

    /**
     * 
     * @param article
     * @param unite
     * @param puht
     * @param quantite
     * @param punet
     * @param code
     * @param peremption
     * @param fabrication
     * @param totalht
     * @param id
     * @param designation
     * @param moduleName 
     */
    public LigneDocumentStock(Article article, UniteGestion unite, Double puht, Double quantite, Double punet, String code, Date peremption, Date fabrication, Double totalht, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.article = article;
        this.unite = unite;
        this.puht = puht;
        this.quantite = quantite;
        this.punet = punet;
//        this.code = code;
//        this.peremption = peremption;
//        this.fabrication = fabrication;
//        this.totalht = totalht;
    }
    
   
public LigneDocumentStock(LigneDocumentStock ligne) {
        super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
        this.article = new Article(ligne.article);
        this.unite = ligne.unite;
        this.puht = ligne.puht;
        this.quantite = ligne.quantite;
        this.punet = ligne.punet;
//        this.code = ligne.code;
//        this.peremption = ligne.peremption;
//        this.fabrication = ligne.fabrication;
//        this.totalht = ligne.totalht;
        if(ligne.emplacement!=null){
            this.emplacement = new LienEmplacement(ligne.emplacement);
        }
    }
   
   public LigneDocumentStock(LigneDocumentAchat ligne) {
        super(-1, ligne.getDesignation(), ligne.getModuleName(),ligne.getCompareid());
        this.article = new Article(ligne.getArticle());
        this.unite = ligne.getArticle().getUnitevente();
        this.puht = ligne.getPuht();
        this.quantite = ligne.getQuantite();
        this.punet = ligne.getPuht();
//        this.code = ligne.getCode();
//        this.peremption = ligne.getPeremption();
//        this.fabrication = ligne.getFabrication();
//        this.totalht = ligne.getTotalht();
    }

    public LigneDocumentStock() {
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Double getPuht() {
        return puht;
    }

    public void setPuht(Double puht) {
        this.puht = puht;
    }

    public Double getPunet() {
        return punet;
    }

    public void setPunet(Double punet) {
        this.punet = punet;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    public UniteGestion getUnite() {
        return unite;
    }

    public void setUnite(UniteGestion unite) {
        this.unite = unite;
    }

//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
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
//
//   
//
//    public Double getTotalht() {
//        return totalht;
//    }
//
//    public void setTotalht(Double totalht) {
//        this.totalht = totalht;
//    }

    public LienEmplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(LienEmplacement emplacement) {
        this.emplacement = emplacement;
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
    public String getEditTitle() {
        return "Ligne Stock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "lidocst220220180919"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(LigneDocumentStock o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
