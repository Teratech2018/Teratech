/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Contrat;
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
@Table(name = "T_DEINGM")
public class TraitementDI extends BaseElement implements Serializable,Comparable<TraitementDI>{

    private static final long serialVersionUID = -170720181413L;
    
    @Predicate(label = "Demande intervantion",optional = false,unique = true,search = true,editable = false)
    private String code ;
   
    @ManyToOne
    @JoinColumn(name = "EM_ID")
    @Predicate(label = "Emetteur",type = Intervenant.class,target = "many-to-one",optional = false,search = true,editable = false)
    private Intervenant emetteur ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Début incident",type = Date.class,target = "date",optional = false,search = true,editable = false)
    private Date dincident ;
    
    @Predicate(label = "Heure incident",target = "time",optional = false,search = true,editable = false)
    private String hincident ;
    
     @ManyToOne
    @JoinColumn(name = "DE_ID")
    @Predicate(label = "Destinataire",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private Intervenant destinataire ;
     
    @ManyToOne
    @JoinColumn(name = "RU_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
     private Rubrique rubrique ;
     
    @ManyToOne
    @JoinColumn(name = "EQUI_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
     private Equipement equipement ;
     
     @ManyToOne
    @JoinColumn(name = "ETEQ_ID")
    @Predicate(label = "Etat équipement",type = EtatEquipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private EtatEquipement etatEquipement ;
     
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private Organe organe ;
     
    @ManyToOne
    @JoinColumn(name = "ETOR_ID")
    @Predicate(label = "Etat organe",type = EtatEquipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private EtatEquipement etatOrgane ;

    @ManyToOne
    @JoinColumn(name = "PRIO_ID")
    @Predicate(label = "Priorité",type = Priorite.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private Priorite priorite ;
    
    @ManyToOne
    @JoinColumn(name = "SYM_ID")
    @Predicate(label = "Symptôme",type = Symptome.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private Symptome symptome ;
    
    @Predicate(label = "Localisation",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private String localisation;
    
    @Predicate(label = "Observation",group = true,groupName = "group1",groupLabel = "Général",editable = false)
    private String observation;
    
    @ManyToOne
    @JoinColumn(name = "BT_ID")
    @Predicate(label = "Bon de travail lié",type = BonTravail.class,editable = false,updatable = false,group = true,groupName = "group2",groupLabel = "Compléments")
    private BonTravail bontravail;
    
    @ManyToOne
    @JoinColumn(name = "PRO_ID")
    @Predicate(label = "Projet",type = Projet.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments",editable = false)
    private Projet projet;
    
    @ManyToOne
    @JoinColumn(name = "CON_ID")
    @Predicate(label = "Contrat",type = Contrat.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments",editable = false)
    private Contrat contrat;
    
    @ManyToOne
    @JoinColumn(name = "UNGE_ID")
    @Predicate(label = "Unité compteur",type = UniteGestion.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments",editable = false)
    private UniteGestion unite ;
    
    @Predicate(label = "Valeur compteur",type = Double.class,group = true,groupName = "group2",groupLabel = "Compléments",editable = false)
    private Double valcompter ;
    
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group3",groupLabel = "Commentaire/Docs",editable = false)
    @Lob
    private String commentaire ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DI_ID")
    @Predicate(label = "Pièces jointes",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group3",groupLabel = "Commentaire/Docs",updatable = false)
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
    @Predicate(label = "",target = "richeditor",group = true,groupName = "group4",groupLabel = "Reponse")
    @Lob
    private String reponse ;
    
    @OneToMany(mappedBy = "demande" , fetch = FetchType.LAZY)
    @Predicate(label = "Activites",type = ActiviteHBT.class,editable = false,updatable = false,target = "one-to-many",group = true,groupName = "group6",groupLabel = "Récapitulatifs")
    private List<ActiviteHBT> activites = new ArrayList<ActiviteHBT>();
    
    private String state = "etabli";
    
    /**
     * 
     */
    public TraitementDI() {
    }

    /**
     * 
     * @param code
     * @param emetteur
     * @param dincident
     * @param hincident
     * @param destinataire
     * @param rubrique
     * @param equipement
     * @param etatEquipement
     * @param organe
     * @param etatOrgane
     * @param priorite
     * @param symptome
     * @param localisation
     * @param observation
     * @param bontravail
     * @param projet
     * @param contrat
     * @param unite
     * @param valcompter
     * @param commentaire
     * @param reponse
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public TraitementDI(String code, Intervenant emetteur, Date dincident, String hincident, Intervenant destinataire, Rubrique rubrique, Equipement equipement, EtatEquipement etatEquipement, Organe organe, EtatEquipement etatOrgane, Priorite priorite, Symptome symptome, String localisation, String observation, BonTravail bontravail, Projet projet, Contrat contrat, UniteGestion unite, Double valcompter, String commentaire, String reponse, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.emetteur = emetteur;
        this.dincident = dincident;
        this.hincident = hincident;
        this.destinataire = destinataire;
        this.rubrique = rubrique;
        this.equipement = equipement;
        this.etatEquipement = etatEquipement;
        this.organe = organe;
        this.etatOrgane = etatOrgane;
        this.priorite = priorite;
        this.symptome = symptome;
        this.localisation = localisation;
        this.observation = observation;
        this.bontravail = bontravail;
        this.projet = projet;
        this.contrat = contrat;
        this.unite = unite;
        this.valcompter = valcompter;
        this.commentaire = commentaire;
        this.reponse = reponse;
    }

    public TraitementDI(TraitementDI entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.emetteur!=null){
            this.emetteur = new Intervenant(entity.emetteur);
        }
        this.dincident = entity.dincident;
        this.hincident = entity.hincident;
        if(entity.destinataire!=null){
            this.destinataire = new Intervenant(entity.destinataire);
        }
        if(entity.rubrique!=null){
            this.rubrique = new Rubrique(entity.rubrique);
        }
        if(entity.equipement!=null){
            this.equipement = new Equipement(entity.equipement);
        }
        if(entity.etatEquipement!=null){
            this.etatEquipement = new EtatEquipement(entity.etatEquipement);
        }
        if(entity.organe!=null){
            this.organe = new Organe(entity.organe);
        }
        if(entity.etatOrgane!=null){
            this.etatOrgane = new EtatEquipement(entity.etatOrgane);
        }
        if(entity.priorite!=null){
            this.priorite = new Priorite(entity.priorite);
        }
        if(entity.symptome!=null){
            this.symptome = new Symptome(entity.symptome);
        }
        this.localisation = entity.localisation;
        this.observation = entity.observation;
        if(entity.bontravail!=null){
            this.bontravail = new BonTravail(entity.bontravail);
        }
        if(entity.projet!=null){
            this.projet = new Projet(entity.projet);
        }
        if(entity.contrat!=null){
            this.contrat = new Contrat(entity.contrat);
        }
        if(entity.unite!=null){
            this.unite = entity.unite;
        }
        this.valcompter = entity.valcompter;
        this.commentaire = entity.commentaire;
        this.reponse = entity.reponse;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Intervenant getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(Intervenant emetteur) {
        this.emetteur = emetteur;
    }

    public Date getDincident() {
        return dincident;
    }

    public void setDincident(Date dincident) {
        this.dincident = dincident;
    }

    public String getHincident() {
        return hincident;
    }

    public void setHincident(String hincident) {
        this.hincident = hincident;
    }

    public Intervenant getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Intervenant destinataire) {
        this.destinataire = destinataire;
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

    public Organe getOrgane() {
        return organe;
    }

    public void setOrgane(Organe organe) {
        this.organe = organe;
    }

    public EtatEquipement getEtatOrgane() {
        return etatOrgane;
    }

    public void setEtatOrgane(EtatEquipement etatOrgane) {
        this.etatOrgane = etatOrgane;
    }

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
    }

    public Symptome getSymptome() {
        return symptome;
    }

    public void setSymptome(Symptome symptome) {
        this.symptome = symptome;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public UniteGestion getUnite() {
        return unite;
    }

    public void setUnite(UniteGestion unite) {
        this.unite = unite;
    }

    public Double getValcompter() {
        return valcompter;
    }

    public void setValcompter(Double valcompter) {
        this.valcompter = valcompter;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public BonTravail getBontravail() {
        return bontravail;
    }

    public void setBontravail(BonTravail bontravail) {
        this.bontravail = bontravail;
    }    

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public List<FichierLie> getPiecesjointes() {
        return piecesjointes;
    }

    public void setPiecesjointes(List<FichierLie> piecesjointes) {
        this.piecesjointes = piecesjointes;
    }

    public List<ActiviteHBT> getActivites() {
        return activites;
    }

    public void setActivites(List<ActiviteHBT> activites) {
        this.activites = activites;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        List<State> states = new ArrayList<State>();
        if(state.equalsIgnoreCase("etabli")){
            State state = new State("accepte", "Accepter");
            states.add(state);
            state = new State("refuse","Rejeter");
            states.add(state);
        }else if(state.equalsIgnoreCase("refuse")){
            State state = new State("refuse","Rejeter");
            states.add(state);
        }
        return states; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return super.getSerial(); //To change body of generated methods, choose Tools | Templates.
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
        return "Demandes interventions"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Demande intervention"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
//
    @Override
    public boolean isDesablecreate() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
     
     
    @Override
    public int compareTo(TraitementDI o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
