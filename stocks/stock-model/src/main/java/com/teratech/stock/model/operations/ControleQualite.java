/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.operations;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Controle;
import com.teratech.stock.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CONQUA_ACH")
public class ControleQualite extends BaseElement implements Serializable,Comparable<ControleQualite>{

    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article",type = Article.class,target = "many-to-one",search = true,optional = false,editable = false)
    private Article article;
    
    @Predicate(label = "N° Lot/Série" ,search = true,editable = false)
    private String numlot ;
    
    @ManyToOne
    @JoinColumn(name = "TIER_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",search = true,editable = false)
    private Tier fournisseur ;
    
    @ManyToOne
    @JoinColumn(name = "EN_ID")
    @Predicate(label = "Document source",type = Entree.class,target = "many-to-one",search = true,editable = false)
    private Entree entree;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date contrôle",type = Date.class,target = "date",search = true)
    private Date dcontrole ;
    
    @Predicate(label = "Quantité recue",type = Double.class,search = true,editable = false)
    private Double recu ;
    
    @Predicate(label = "Rebus",type = Double.class,search = true)
    private Double rebus ;
    
    @Predicate(label = " ",target = "color",search = true,hide = true)
    private String color ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "COQU_ID")
    @Predicate(label = " ",type = LigneControleQualite.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "Resultats")
    private List<LigneControleQualite> lignes = new ArrayList<LigneControleQualite>();
    
    @Predicate(label = " ",target = "richeditor",group = true,groupName = "group2",groupLabel = "Votre Rapport")
    @Lob
    private String avis ;
    
    private String state ="etabli";

    public ControleQualite() {
    }

    /**
     * 
     * @param article
     * @param bonlivraison
     * @param dcontrole
     * @param avis
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ControleQualite(Article article, Entree bonlivraison, Date dcontrole, String avis, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.article = article;
        this.entree = bonlivraison;
        this.dcontrole = dcontrole;
        this.avis = avis;
    }
    
    /**
     * 
     * @param article
     * @param bonlivraison
     * @param ligne 
     */
     public ControleQualite(Article article, Entree bonlivraison,LigneEntree ligne) {
        super(-1L, article.getDesignation(), article.getModuleName(), -1);
        this.article = new Article(article);
        this.entree = new Entree(bonlivraison);
        this.dcontrole = new Date();
        this.avis = null;
        this.fournisseur = new Tier(bonlivraison.getFournisseur());
        this.recu = ligne.getQuantite();
        this.rebus = 0.0;
        this.state = "etabli";
        for(Controle lig:article.getControles()){
            this.lignes.add(new LigneControleQualite(lig));
        }//end for(Controle lig:article.getControles()){
    }
     

    public ControleQualite(ControleQualite entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.article!=null){
            this.article = new Article(entity.article);
        }
        if(entity.entree!=null){
            this.entree = new Entree(entity.entree);
        }
        if(entity.fournisseur!=null){
            this.fournisseur = new Tier(entity.fournisseur);
        }
        this.dcontrole = entity.dcontrole;
        this.avis = entity.avis;
        this.rebus = entity.rebus;
        this.recu = entity.recu;
        this.state = entity.state;
        this.color = entity.color;
    }
    
    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Entree getEntree() {
        return entree;
    }

    public void setEntree(Entree entree) {
        this.entree = entree;
    }

    

    public Date getDcontrole() {
        return dcontrole;
    }

    public void setDcontrole(Date dcontrole) {
        this.dcontrole = dcontrole;
    }

    public List<LigneControleQualite> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneControleQualite> lignes) {
        this.lignes = lignes;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public String getNumlot() {
        return numlot;
    }

    public void setNumlot(String numlot) {
        this.numlot = numlot;
    }

    public Double getRecu() {
        return recu;
    }

    public void setRecu(Double recu) {
        this.recu = recu;
    }

    public Double getRebus() {
        return rebus;
    }

    public void setRebus(Double rebus) {
        this.rebus = rebus;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    

    @Override
    public String getOwnermodule() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "coqu240220181452"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return article.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Contrôle Qualité"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Contrôle Qualité"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] searchFields() {
        return super.searchFields(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesableupdate() {
        return !state.equalsIgnoreCase("etabli"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        if(state.equalsIgnoreCase("etabli")){
            states.add(new State("etabli", "A traiter"));
        }else if(state.equalsIgnoreCase("traite")){
            states.add(new State("traite", "Traité"));
        }
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(ControleQualite o) {
        //To change body of generated methods, choose Tools | Templates.
        return article.compareTo(o.article);
    }
    
}
