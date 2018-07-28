/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.CentreFrais;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Organe;
import com.teratech.gmao.model.base.Rubrique;
import com.teratech.gmao.model.base.UniteGestion;
import com.teratech.gmao.model.projet.Projet;
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
@Table(name = "T_ACTHBTGM")
public class ActiviteHBT extends BaseElement implements Serializable,Comparable<ActiviteHBT>{

    @Predicate(label = "Activité",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Type",target = "combobox",values = "Demande intervention;Autres",optional = false)
    private String type ="0";    
    
    @ManyToOne
    @JoinColumn(name = "DI_ID")
    @Predicate(label = "Demande intervention",type = DemandeIntervention.class,target = "many-to-one",optional = true,search = true,hidden = "currentObject.type!='0'||currentObject.type==null")
    private DemandeIntervention demande;
    
   @ManyToOne
    @JoinColumn(name = "INT_ID")
    @Predicate(label = "Intervenant",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant intervenant ;
    
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Predicate(label = "Date début",type = Date.class,target = "datetime",optional = false,search = true)
    private Date ddebut;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Predicate(label = "Date de fin",type = Date.class,target = "datetime",optional = false,search = true)
    private Date dfin ;    
    
    @ManyToOne
    @JoinColumn(name = "DIAG_ID")
    @Predicate(label = "Diagnostic",type = Diagnostic.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Diagnostic diagnostic ;
    
    @ManyToOne
    @JoinColumn(name = "REM_ID")
    @Predicate(label = "Remède",type = Remede.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Remede remede ;
    
    @ManyToOne
    @JoinColumn(name = "EQ_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",editable = false,search = true,group = true,groupName = "group1",groupLabel = "Général")
    private Equipement equipement ;
    
    @ManyToOne
    @JoinColumn(name = "CFEQ_ID")
    @Predicate(label = "Centre de frais equipement",type = CentreFrais.class,target = "many-to-one",editable = false,group = true,groupName = "group1",groupLabel = "Général")
    private CentreFrais cfequipement ;
    
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",optional = true,search = true,group = true,groupName = "group1",groupLabel = "Général")
    private Organe organe ;    
    
    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Rubrique rubrique ;
    
    @Predicate(label = "Temps passé(heures)",type = Double.class,group = true,groupName = "group1",groupLabel = "Général")
    private Double tppasse ;
    
    @Predicate(label = "Temps indisponibilité(heures)",type = Double.class,group = true,groupName = "group1",groupLabel = "Général")
    private Double tpindispo;
    
    @ManyToOne
    @JoinColumn(name = "UG_ID")
    @Predicate(label = "Unité compteur",type = UniteGestion.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private UniteGestion unite ;
    
    @Predicate(label = "Valeur compteur",type = Double.class,group = true,groupName = "group1",groupLabel = "Général")
    private Double valeur;
    
    @Lob
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group2",groupLabel = "Commentaire/Docs")
    private String commentaire;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "AHBT_ID")
    @Predicate(label = "Pièces jointes",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group2",groupLabel = "Commentaire/Docs")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
     @ManyToOne
    @JoinColumn(name = "PROJ_ID")
//    @Predicate(label = "Projet",type = Projet.class,target = "many-to-one",optional = false,group = true,groupName = "group1",groupLabel = "Général")
    private Projet projet ; 
     
    public ActiviteHBT() {
    }

    /**
     * 
     * @param code
     * @param demande
     * @param intervenant
     * @param dfin
     * @param ddebut
     * @param diagnostic
     * @param remede
     * @param equipement
     * @param cfequipement
     * @param organe
     * @param rubrique
     * @param tppasse
     * @param tpindispo
     * @param unite
     * @param valeur
     * @param commentaire
     * @param projet
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ActiviteHBT(String code, DemandeIntervention demande, Intervenant intervenant, Date dfin, Date ddebut, Diagnostic diagnostic, Remede remede, Equipement equipement, CentreFrais cfequipement, Organe organe, Rubrique rubrique, Double tppasse, Double tpindispo, UniteGestion unite, Double valeur, String commentaire, Projet projet, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.demande = demande;
        this.intervenant = intervenant;
        this.dfin = dfin;
        this.ddebut = ddebut;
        this.diagnostic = diagnostic;
        this.remede = remede;
        this.equipement = equipement;
        this.cfequipement = cfequipement;
        this.organe = organe;
        this.rubrique = rubrique;
        this.tppasse = tppasse;
        this.tpindispo = tpindispo;
        this.unite = unite;
        this.valeur = valeur;
        this.commentaire = commentaire;
        this.projet = projet;
    }
    
     public ActiviteHBT(ActiviteHBT entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.demande!=null){
            this.demande = new DemandeIntervention(entity.demande);
        }
        if(entity.intervenant!=null){
            this.intervenant = new Intervenant(entity.intervenant);
        }
        this.dfin = entity.dfin;
        this.ddebut = entity.ddebut;
        if(entity.diagnostic!=null){
            this.diagnostic = new Diagnostic(entity.diagnostic);
        }
        if(entity.remede!=null){
            this.remede = new Remede(entity.remede);
        }
        if(entity.equipement!=null){
            this.equipement = new Equipement(entity.equipement);//equipement;
        }
        if(entity.cfequipement!=null){
            this.cfequipement = new CentreFrais(entity.cfequipement);//cfequipement;
        }
        if(entity.organe!=null){
            this.organe = new Organe(entity.organe);//organe;
        }
        if(entity.rubrique!=null){
            this.rubrique = new Rubrique(entity.rubrique);//rubrique;
        }
        this.tppasse = entity.tppasse;
        this.tpindispo = entity.tpindispo;
        this.unite = entity.unite;
        this.valeur = entity.valeur;
        this.commentaire = entity.commentaire;
        if(entity.projet!=null){
            this.projet = new Projet(entity.projet);
        }
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DemandeIntervention getDemande() {
        return demande;
    }

    public void setDemande(DemandeIntervention demande) {
        this.demande = demande;
    }

   

    public Date getDdebut() {
        return ddebut;
    }

    public void setDdebut(Date ddebut) {
        this.ddebut = ddebut;
    }

    public Date getDfin() {
        return dfin;
    }

    public void setDfin(Date dfin) {
        this.dfin = dfin;
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public CentreFrais getCfequipement() {
        return cfequipement;
    }

    public void setCfequipement(CentreFrais cfequipement) {
        this.cfequipement = cfequipement;
    }

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public Double getTppasse() {
        return tppasse;
    }

    public void setTppasse(Double tppasse) {
        this.tppasse = tppasse;
    }

    public Double getTpindispo() {
        return tpindispo;
    }

    public void setTpindispo(Double tpindispo) {
        this.tpindispo = tpindispo;
    }

    public UniteGestion getUnite() {
        return unite;
    }

    public void setUnite(UniteGestion unite) {
        this.unite = unite;
    }

    public Double getValeur() {
        return valeur;
    }

    public void setValeur(Double valeur) {
        this.valeur = valeur;
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

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Remede getRemede() {
        return remede;
    }

    public void setRemede(Remede remede) {
        this.remede = remede;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
    

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
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
        return "Activités hors bon de travail"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Activité hors bon de travail"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public int compareTo(ActiviteHBT o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
