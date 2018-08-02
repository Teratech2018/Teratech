/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.projet;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.CentreFrais;
import com.teratech.gmao.model.base.Division;
import com.teratech.gmao.model.base.FamilleArticle;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Rubrique;
import com.teratech.gmao.model.base.Secteur;
import com.teratech.gmao.model.curative.ActiviteBT;
import com.teratech.gmao.model.curative.ActiviteHBT;
import com.teratech.gmao.model.curative.BonTravail;
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
import javax.persistence.Transient;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_PROJGM")
public class Projet extends BaseElement implements Serializable,Comparable<Projet>{

    @Predicate(label = "Projet",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date début",type = Date.class,target = "date",optional = false,search = true)
    private Date debut ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date de fin",type = Date.class,target = "date",optional = false,search = true)
    private Date fin ;

    @ManyToOne
    @JoinColumn(name = "FAM_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private FamilleArticle famille ;
    
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Intervenant responsable ;
    
    @ManyToOne
    @JoinColumn(name = "SEC_ID")
    @Predicate(label = "Secteur",type = Secteur.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Secteur secteur ;
    
    @ManyToOne
    @JoinColumn(name = "DIV_ID")
    @Predicate(label = "Division",type = Division.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Division division ;
    
    @ManyToOne
    @JoinColumn(name = "CF_ID")
    @Predicate(label = "Centre de frais",type = CentreFrais.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private CentreFrais centre ;
    
    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Rubrique rubrique ;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "PROJ_ID")
    @Predicate(label = "",type = BudgetProjet.class,target = "one-to-many",edittable = true,group = true,groupName = "group2",groupLabel = "Budget")
    private List<BudgetProjet> budgets = new ArrayList<BudgetProjet>();
    
    @Lob
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group3",groupLabel = "Commentaire/Docs")
    private String commentaire;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJ_ID")
    @Predicate(label = "Pièces jointes",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group3",groupLabel = "Commentaire/Docs")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
    @Predicate(label = "Que voulez vous voir ?",target = "combobox",values = "Bon de travail;Activités B.T;Activités hors B.T",group = true,groupName = "group4",groupLabel = "Recapitulatifs")
    @Transient
    private String show ="0";
    
    @OneToMany(mappedBy = "projet",fetch = FetchType.LAZY)
    @Predicate(label = "",type = BonTravail.class,target = "one-to-many",group = true,groupName = "group4",groupLabel = "Recapitulatifs",hidden = "currentObject.show==''||currentObject.show=='1'||currentObject.show=='2'")
    private List<BonTravail> bonstravail = new ArrayList<BonTravail>();
    
    @OneToMany(mappedBy = "projet",fetch = FetchType.LAZY)
    @Predicate(label = "",type = ActiviteBT.class,target = "one-to-many",group = true,groupName = "group4",groupLabel = "Recapitulatifs",hidden = "currentObject.show==''||(currentObject.show=='0'||currentObject.show=='2')")
    private List<ActiviteBT> activitesbt = new ArrayList<ActiviteBT>();
    
    
    @OneToMany(mappedBy = "projet",fetch = FetchType.LAZY)
    @Predicate(label = "",type = ActiviteHBT.class,target = "one-to-many",group = true,groupName = "group4",groupLabel = "Recapitulatifs",hidden = "currentObject.show==''||(currentObject.show=='0'||currentObject.show=='1')")
    private List<ActiviteHBT> activiteshbt = new ArrayList<ActiviteHBT>();
    
    
    public Projet() {
    }

    public Projet(String code, String intitule, Date debut, Date fin) {
        this.code = code;
        this.intitule = intitule;
        this.debut = debut;
        this.fin = fin;
    }

    public Projet(String code, String intitule, Date debut, Date fin, FamilleArticle famille, Intervenant responsable, Secteur secteur, Division division, CentreFrais centre, Rubrique rubrique, String commentaire, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.debut = debut;
        this.fin = fin;
        this.famille = famille;
        this.responsable = responsable;
        this.secteur = secteur;
        this.division = division;
        this.centre = centre;
        this.rubrique = rubrique;
        this.commentaire = commentaire;
    }

    public Projet(Projet entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.debut = entity.debut;
        this.fin = entity.fin;
        if(entity.famille!=null){
            this.famille = new FamilleArticle(entity.famille);
        }
        if(entity.responsable!=null){
            this.responsable = new Intervenant(entity.responsable);
        }
        if(entity.secteur!=null){
            this.secteur = new Secteur(entity.secteur);
        }
        if(entity.division!=null){
            this.division = new Division(entity.division);//division;
        }
        if(entity.centre!=null){
            this.centre = new CentreFrais(entity.centre);
        }
        if(entity.rubrique!=null){
            this.rubrique = new Rubrique(entity.rubrique);
        }
        this.commentaire = entity.commentaire;
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

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }

    public Intervenant getResponsable() {
        return responsable;
    }

    public void setResponsable(Intervenant responsable) {
        this.responsable = responsable;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public CentreFrais getCentre() {
        return centre;
    }

    public void setCentre(CentreFrais centre) {
        this.centre = centre;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public List<BudgetProjet> getBudgets() {
        return budgets;
    }

    public void setBudgets(List<BudgetProjet> budgets) {
        this.budgets = budgets;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public List<FichierLie> getPiecesjointes() {
        return piecesjointes;
    }

    public void setPiecesjointes(List<FichierLie> piecesjointes) {
        this.piecesjointes = piecesjointes;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public List<BonTravail> getBonstravail() {
        return bonstravail;
    }

    public void setBonstravail(List<BonTravail> bonstravail) {
        this.bonstravail = bonstravail;
    }

    public List<ActiviteBT> getActivitesbt() {
        return activitesbt;
    }

    public void setActivitesbt(List<ActiviteBT> activitesbt) {
        this.activitesbt = activitesbt;
    }

    public List<ActiviteHBT> getActiviteshbt() {
        return activiteshbt;
    }

    public void setActiviteshbt(List<ActiviteHBT> activiteshbt) {
        this.activiteshbt = activiteshbt;
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
        return "Projets"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Projet"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(Projet o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
