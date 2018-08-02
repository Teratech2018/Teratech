/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Organe;
import com.teratech.gmao.model.base.Rubrique;
import com.teratech.gmao.model.preventif.Gamme;
import com.teratech.gmao.model.projet.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_BOTRGM")
public class BonTravail extends BaseElement implements Serializable,Comparable<BonTravail>{

    @Predicate(label = "Bon de travail",optional = false,unique = true,search = true)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",optional = false,search = true)
    private Rubrique rubrique;
    
    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",optional = false,search = true)
    private Equipement equipement;
    
    @ManyToOne
    @JoinColumn(name = "ETEQ_ID")
    @Predicate(label = "Etat equipement",type = EtatEquipement.class,target = "many-to-one",optional = false,search = true)
    private EtatEquipement etatEquipement;
    
    @ManyToOne
    @JoinColumn(name = "EME_ID")
    @Predicate(label = "Emetteur",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant emetteur ;
    
    @ManyToOne
    @JoinColumn(name = "DES_ID")
    @Predicate(label = "Destinataire",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant destinataire ;
    
     
    @ManyToOne
    @JoinColumn(name = "ETOR_ID")
    @Predicate(label = "Etat organe",type = EtatEquipement.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private EtatEquipement etatorgane ;
    
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private Organe organe ;
    
    
    @ManyToOne
    @JoinColumn(name = "SYM_ID")
    @Predicate(label = "Symptôme",type = Symptome.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private Symptome symptome ;
    
    @ManyToOne
    @JoinColumn(name = "PRIO_ID")
    @Predicate(label = "Priorité",type = Priorite.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private Priorite priorite;
    
    @ManyToOne
    @JoinColumn(name = "GAM_ID")
    @Predicate(label = "Gamme",type = Gamme.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private Gamme gamme ;
    
    @ManyToOne
    @JoinColumn(name = "PROJ_ID")
    @Predicate(label = "Projet",type = Projet.class,target = "many-to-one",optional = true,group = true,groupName = "group1",groupLabel = "Général")
    private Projet projet ;
   
     @OneToMany(cascade = CascadeType.ALL,mappedBy = "bontravail")
    @Predicate(label = "Demandes liées",type = DemandeIntervention.class,target = "many-to-many-list",group = true,groupName = "group1",groupLabel = "Général")
    private List<DemandeIntervention> demandes = new ArrayList<DemandeIntervention>();     
    
    
    @Lob
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group3",groupLabel = "Commentaires/Docs")
    private String commentaire;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BT_ID")
    @Predicate(label = "Pièces jointes",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group3",groupLabel = "Commentaires/Docs")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
    @Lob
    @Predicate(label = "",target = "richeditor",group = true,groupName = "group4",groupLabel = "Mode opératoire")
    private String mode;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BT_ID")
    @Predicate(label = "Articles prévus",type = ArticlePrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Planning ressources")
    private List<ArticlePrevu> articles = new ArrayList<ArticlePrevu>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BTID")
    @Predicate(label = "Intervenants prévus",type = IntervenantPrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Planning ressources")
    private List<IntervenantPrevu> intervenants = new ArrayList<IntervenantPrevu>();
    
    @OneToMany(mappedBy = "bontravail" , fetch =FetchType.LAZY)
    @Predicate(label = "Activites",type = ActiviteBT.class,target = "one-to-many",editable = false,updatable = false,group = true,groupName = "group6",groupLabel = "Récapitulatifs")
    private List<ActiviteBT> activites = new ArrayList<ActiviteBT>();
    
    /**
     * 
     */
    public BonTravail() {
    }

    /**
     * 
     * @param code
     * @param rubrique
     * @param equipement
     * @param etatEquipement
     * @param emetteur
     * @param destinataire
     * @param etatorgane
     * @param organe
     * @param symptome
     * @param priorite
     * @param gamme
     * @param projet
     * @param commentaire
     * @param mode
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public BonTravail(String code, Rubrique rubrique, Equipement equipement, EtatEquipement etatEquipement, Intervenant emetteur, Intervenant destinataire, EtatEquipement etatorgane, Organe organe, Symptome symptome, Priorite priorite, Gamme gamme, Projet projet, String commentaire, String mode, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.rubrique = rubrique;
        this.equipement = equipement;
        this.etatEquipement = etatEquipement;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
        this.etatorgane = etatorgane;
        this.organe = organe;
        this.symptome = symptome;
        this.priorite = priorite;
        this.gamme = gamme;
        this.projet = projet;
        this.commentaire = commentaire;
        this.mode = mode;
    }
    
     public BonTravail(BonTravail entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.rubrique!=null){
            this.rubrique = new Rubrique(entity.rubrique);
        }
        if(entity.equipement!=null){
            this.equipement = new Equipement(entity.equipement);
        }
        if(entity.etatEquipement!=null){
            this.etatEquipement = new EtatEquipement(entity.etatEquipement);
        }
        if(entity.emetteur!=null){
            this.emetteur = new Intervenant(entity.emetteur);
        }
        if(entity.destinataire!=null){
            this.destinataire = new Intervenant(entity.destinataire);
        }
        if(entity.etatorgane!=null){
            this.etatorgane = new EtatEquipement(entity.etatorgane);
        }
        if(entity.organe!=null){
            this.organe = new Organe(entity.organe);
        }
        if(entity.symptome!=null){
            this.symptome = new Symptome(entity.symptome);
        }
        if(entity.priorite!=null){
            this.priorite = new Priorite(entity.priorite);
        }
        if(entity.gamme!=null){
            this.gamme = new Gamme(entity.gamme);
        }
        if(entity.projet!=null){
            this.projet = new Projet(entity.projet);
        }
        this.commentaire = entity.commentaire;
        this.mode = entity.mode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public EtatEquipement getEtatEquipement() {
        return etatEquipement;
    }

    public void setEtatEquipement(EtatEquipement etatEquipement) {
        this.etatEquipement = etatEquipement;
    }

    public Intervenant getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Intervenant emetteur) {
        this.emetteur = emetteur;
    }

    public Intervenant getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Intervenant destinataire) {
        this.destinataire = destinataire;
    }

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

    public EtatEquipement getEtatorgane() {
        return etatorgane;
    }

    public void setEtatorgane(EtatEquipement etatorgane) {
        this.etatorgane = etatorgane;
    }

    public Symptome getSymptome() {
        return symptome;
    }

    public void setSymptome(Symptome symptome) {
        this.symptome = symptome;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public Gamme getGamme() {
        return gamme;
    }

    public void setGamme(Gamme gamme) {
        this.gamme = gamme;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<FichierLie> getPiecesjointes() {
        return piecesjointes;
    }

    public void setPiecesjointes(List<FichierLie> piecesjointes) {
        this.piecesjointes = piecesjointes;
    }   

    public List<ArticlePrevu> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticlePrevu> articles) {
        this.articles = articles;
    }

    public List<IntervenantPrevu> getIntervenants() {
        return intervenants;
    }

    public void setIntervenants(List<IntervenantPrevu> intervenants) {
        this.intervenants = intervenants;
    }

    public List<DemandeIntervention> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<DemandeIntervention> demandes) {
        this.demandes = demandes;
    }

    public List<ActiviteBT> getActivites() {
        return activites;
    }

    public void setActivites(List<ActiviteBT> activites) {
        this.activites = activites;
    }
    

    
    
    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Bons de travail"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Bon de travail"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(BonTravail o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
