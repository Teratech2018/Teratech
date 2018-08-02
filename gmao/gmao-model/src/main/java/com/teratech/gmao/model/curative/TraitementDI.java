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
    
    @Predicate(label = "Demande intervantion",optional = false,unique = true,search = true)
    private String code ;
   
    @ManyToOne
    @JoinColumn(name = "EM_ID")
    @Predicate(label = "Emetteur",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant emetteur ;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Début incident",type = Date.class,target = "date",optional = false,search = true)
    private Date dincident ;
    
    @Predicate(label = "Heure incident",target = "time",optional = false,search = true)
    private String hincident ;
    
     @ManyToOne
    @JoinColumn(name = "DE_ID")
    @Predicate(label = "Destinataire",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Intervenant destinataire ;
     
    @ManyToOne
    @JoinColumn(name = "RU_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
     private Rubrique rubrique ;
     
    @ManyToOne
    @JoinColumn(name = "EQUI_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
     private Equipement equipement ;
     
     @ManyToOne
    @JoinColumn(name = "ETEQ_ID")
    @Predicate(label = "Etat équipement",type = EtatEquipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private EtatEquipement etatEquipement ;
     
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Organe organe ;
     
    @ManyToOne
    @JoinColumn(name = "ETOR_ID")
    @Predicate(label = "Etat organe",type = EtatEquipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private EtatEquipement etatOrgane ;

    @ManyToOne
    @JoinColumn(name = "PRIO_ID")
    @Predicate(label = "Priorité",type = Priorite.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Priorite priorite ;
    
    @ManyToOne
    @JoinColumn(name = "SYM_ID")
    @Predicate(label = "Symptôme",type = Symptome.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Symptome symptome ;
    
    @Predicate(label = "Localisation",group = true,groupName = "group1",groupLabel = "Général")
    private String localisation;
    
    @Predicate(label = "Observation",group = true,groupName = "group1",groupLabel = "Général")
    private String observation;
    
    @ManyToOne
    @JoinColumn(name = "BT_ID")
    @Predicate(label = "Bon de travail lié",type = BonTravail.class,editable = false,updatable = false,group = true,groupName = "group2",groupLabel = "Compléments")
    private BonTravail bontravail;
    
    @ManyToOne
    @JoinColumn(name = "PRO_ID")
    @Predicate(label = "Projet",type = Projet.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments")
    private Projet projet;
    
    @ManyToOne
    @JoinColumn(name = "CON_ID")
    @Predicate(label = "Contrat",type = Contrat.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments")
    private Contrat contrat;
    
    @ManyToOne
    @JoinColumn(name = "UNGE_ID")
    @Predicate(label = "Unité compteur",type = UniteGestion.class,target = "many-to-one",group = true,groupName = "group2",groupLabel = "Compléments")
    private UniteGestion unite ;
    
    @Predicate(label = "Valeur compteur",type = Double.class,group = true,groupName = "group2",groupLabel = "Compléments")
    private Double valcompter ;
    
    @Predicate(label = "Commentaire",target = "textarea",group = true,groupName = "group3",groupLabel = "Commentaire/Docs")
    @Lob
    private String commentaire ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "DI_ID")
    @Predicate(label = "Pièces jointes",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group3",groupLabel = "Commentaire/Docs")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
    
    @Predicate(label = "",target = "richeditor",group = true,groupName = "group4",groupLabel = "Reponse")
    @Lob
    private String reponse ;
    
    @OneToMany(mappedBy = "demande" , fetch = FetchType.LAZY)
    @Predicate(label = "Activites",type = ActiviteHBT.class,editable = false,updatable = false,target = "one-to-many",group = true,groupName = "group6",groupLabel = "Récapitulatifs")
    private List<ActiviteHBT> activites = new ArrayList<ActiviteHBT>();
    
    private String state = "etabli";
    
    public TraitementDI() {
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
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
    
     
     
    @Override
    public int compareTo(TraitementDI o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
