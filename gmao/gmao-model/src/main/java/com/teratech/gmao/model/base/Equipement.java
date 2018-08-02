/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_EQUIGM")
public class Equipement extends BaseElement implements Serializable,Comparable<Equipement>{
    
    @Predicate(label = "image",target = "image")
    private String image ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @Predicate(label = "Equipement",optional = false,unique = true ,search = true)
    private String code ;
    
    @ManyToOne
    @JoinColumn(name = "CF_ID")
    @Predicate(label = "Centre de frais",type = CentreFrais.class,target = "many-to-one",optional = false)
    private CentreFrais centre;
    
    @ManyToOne
    @JoinColumn(name = "FA_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one",optional = false)
    private FamilleArticle famille ;
    
    @ManyToOne
    @JoinColumn(name = "CR_ID")
    @Predicate(label = "Criticité",type = Criticite.class,target = "many-to-one",optional = false)
    private Criticite criticite ;
    
    @ManyToOne
    @JoinColumn(name = "EM_ID")
    @Predicate(label = "Emplacement",type = Emplacement.class,target = "many-to-one",optional = false)
    private Emplacement emplacement ;
    
    
     @ManyToOne
    @JoinColumn(name = "MAR_ID")
    @Predicate(label = "Marque",type = Marque.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments",search = true)
    private Marque marque ;
    
     @ManyToOne
    @JoinColumn(name = "FOUR_ID")
    @Predicate(label = "Fournisseur",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
     @Filter(value = "")
     private Intervenant fornisseur ;
     
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    @Filter(value = "")
    private Intervenant responsable ;
    
    @ManyToOne
    @JoinColumn(name = "ART_ID")
    @Predicate(label = "Article Lié",type = Article.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Compléments")
    private Article article ;
    
    @Predicate(label = "Numero Série",group = true,groupName = "group1",groupLabel = "Compléments")
    private String numserie ;
    
    @Predicate(label = "Mise en service le",type = Date.class,target = "date",group = true,groupName = "group1",groupLabel = "Compléments")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date mservice ;
    
    @Predicate(label = "Date limite garantie",type = Date.class,target = "date",group = true,groupName = "group1",groupLabel = "Compléments")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date garantie ;
    
    @Predicate(label = "Taux horaire",type = Double.class,group = true,groupName = "group1",groupLabel = "Compléments")
    private Double thoraire=0.0;

    @Predicate(label = "Consigne de Sécurité",target = "textarea",group =true,groupName = "group2",groupLabel = "Consigne de sécurite " )
    private String consigne ;
    
    @Predicate(label = "Commentaire",target = "textarea",group =true,groupName = "group2",groupLabel = "Consigne de sécurite " )
    private String commentaire ;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_ORGEQUGM",joinColumns = @JoinColumn(name = "ORG_ID"),inverseJoinColumns = @JoinColumn(name = "ART_ID"))
    @Predicate(label = "Organes",type = Organe.class,target = "many-to-many-list",group = true,groupName = "group3",groupLabel = "Organes et Compteurs")
    private List<Organe> organes = new ArrayList<Organe>();
    
    @OneToMany(mappedBy = "equipement" ,fetch = FetchType.LAZY)
    @Predicate(label = "Compteurs",type = Compteur.class,target = "one-to-many",group = true,groupName = "group3",groupLabel = "Organes et Compteurs",editable = false,updatable = false)
    private List<Compteur> compteurs = new ArrayList<Compteur>();

    /**
     * 
     * @param image
     * @param code
     * @param intitule
     * @param centre
     * @param famille
     * @param criticite
     * @param emplacement
     * @param marque
     * @param fornisseur
     * @param responsable
     * @param article
     * @param numserie
     * @param mservice
     * @param garantie
     * @param consigne
     * @param commentaire 
     */
    public Equipement(String image, String code, String intitule, CentreFrais centre, FamilleArticle famille, Criticite criticite, Emplacement emplacement, Marque marque, Intervenant fornisseur, Intervenant responsable, Article article, String numserie, Date mservice, Date garantie, String consigne, String commentaire) {
        this.image = image;
        this.code = code;
        this.intitule = intitule;
        this.centre = centre;
        this.famille = famille;
        this.criticite = criticite;
        this.emplacement = emplacement;
        this.marque = marque;
        this.fornisseur = fornisseur;
        this.responsable = responsable;
        this.article = article;
        this.numserie = numserie;
        this.mservice = mservice;
        this.garantie = garantie;
        this.consigne = consigne;
        this.commentaire = commentaire;
    }

    /**
     * 
     * @param image
     * @param code
     * @param intitule
     * @param centre
     * @param famille
     * @param criticite
     * @param emplacement
     * @param marque
     * @param fornisseur
     * @param responsable
     * @param article
     * @param numserie
     * @param mservice
     * @param garantie
     * @param consigne
     * @param commentaire
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Equipement(String image, String code, String intitule, CentreFrais centre, FamilleArticle famille, Criticite criticite, Emplacement emplacement, Marque marque, Intervenant fornisseur, Intervenant responsable, Article article, String numserie, Date mservice, Date garantie, String consigne, String commentaire, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.image = image;
        this.code = code;
        this.intitule = intitule;
        this.centre = centre;
        this.famille = famille;
        this.criticite = criticite;
        this.emplacement = emplacement;
        this.marque = marque;
        this.fornisseur = fornisseur;
        this.responsable = responsable;
        this.article = article;
        this.numserie = numserie;
        this.mservice = mservice;
        this.garantie = garantie;
        this.consigne = consigne;
        this.commentaire = commentaire;
    }
    
    public Equipement(Equipement entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.image = entity.image;
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.centre!=null){
            this.centre = new CentreFrais(entity.centre);
        }
        if(entity.famille!=null){
            this.famille = new FamilleArticle(entity.famille);
        }
        if(entity.criticite!=null){
            this.criticite = new Criticite(entity.criticite);
        }
        if(entity.emplacement!=null){
            this.emplacement = new Emplacement(entity.emplacement);
        }
        if(entity.marque!=null){
            this.marque = new Marque(entity.marque);
        }
        if(entity.fornisseur!=null){
            this.fornisseur = new Intervenant(entity.fornisseur);
        }
        if(entity.responsable!=null){
            this.responsable = new Intervenant(entity.responsable);
        }
        if(entity.article!=null){
            this.article = new Article(entity.article);
        }
        this.numserie = entity.numserie;
        this.mservice = entity.mservice;
        this.garantie = entity.garantie;
        this.consigne = entity.consigne;
        this.commentaire = entity.commentaire;
    }

    public Equipement() {
    }
    
    

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public CentreFrais getCentre() {
        return centre;
    }

    public void setCentre(CentreFrais centre) {
        this.centre = centre;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }

    public Criticite getCriticite() {
        return criticite;
    }

    public void setCriticite(Criticite criticite) {
        this.criticite = criticite;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Intervenant getFornisseur() {
        return fornisseur;
    }

    public void setFornisseur(Intervenant fornisseur) {
        this.fornisseur = fornisseur;
    }

    public Intervenant getResponsable() {
        return responsable;
    }

    public void setResponsable(Intervenant responsable) {
        this.responsable = responsable;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public Date getMservice() {
        return mservice;
    }

    public void setMservice(Date mservice) {
        this.mservice = mservice;
    }

    public Date getGarantie() {
        return garantie;
    }

    public void setGarantie(Date garantie) {
        this.garantie = garantie;
    }

    public Double getThoraire() {
        return thoraire;
    }

    public void setThoraire(Double thoraire) {
        this.thoraire = thoraire;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<Organe> getOrganes() {
        return organes;
    }

    public void setOrganes(List<Organe> organes) {
        this.organes = organes;
    }

    public List<Compteur> getCompteurs() {
        return compteurs;
    }

    public void setCompteurs(List<Compteur> compteurs) {
        this.compteurs = compteurs;
    }
    
    

    @Override
    public String getDesignation() {
        return code+" - "+intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Equipements"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Equipement"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Equipement o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
