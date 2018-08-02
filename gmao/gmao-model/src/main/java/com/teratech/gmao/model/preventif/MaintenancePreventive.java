/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.preventif;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Contrat;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Organe;
import com.teratech.gmao.model.base.Rubrique;
import com.teratech.gmao.model.curative.ArticlePrevu;
import com.teratech.gmao.model.curative.EtatEquipement;
import com.teratech.gmao.model.curative.IntervenantPrevu;
import com.teratech.gmao.model.curative.Priorite;
import com.teratech.gmao.model.projet.Projet;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "T_MAPREGM")
public class MaintenancePreventive extends BaseElement implements Serializable,Comparable<MaintenancePreventive>{

    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",optional = false,search = true)
    private Equipement equipement ;
    
    @ManyToOne
    @JoinColumn(name = "ETEQ_ID")
    @Predicate(label = "Etat equipement",type = EtatEquipement.class,target = "many-to-one",optional = false,search = true)
    private EtatEquipement etat ;
    
    @ManyToOne
    @JoinColumn(name = "GAM_ID")
    @Predicate(label = "Gamme",type = Gamme.class,target = "many-to-one",optional = false,search = true)
    private Gamme gamme; 
    
    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",optional = false,search = true)
    private Rubrique rubrique;
    
    @ManyToOne
    @JoinColumn(name = "INT_ID")
    @Predicate(label = "Destinataire",type = Intervenant.class,target = "many-to-one",optional = false,search = true)
    private Intervenant destinataire;
    
    @Predicate(label = "Description",optional = false)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "ORG_ID")
    @Predicate(label = "Organe",type = Organe.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Organe organe ;

    @ManyToOne
    @JoinColumn(name = "ETOR_ID")
    @Predicate(label = "etat organe",type = EtatEquipement.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private EtatEquipement etatorgane ;
    
    @ManyToOne
    @JoinColumn(name = "PRIO_ID")
    @Predicate(label = "Priorité",type = Priorite.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Priorite priorite ;
    
    @ManyToOne
    @JoinColumn(name = "PROJ_ID")
    @Predicate(label = "Projet",type = Projet.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Projet  projet ;
    
    @ManyToOne
    @JoinColumn(name = "CON_ID")
    @Predicate(label = "Contrat",type = Contrat.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Contrat contrat ;
    
    @ManyToOne
    @JoinColumn(name = "FOU_ID")
    @Predicate(label = "Fournisseur",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Intervenant fornisseur ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPV_ID")
    @Predicate(label = "Articles",type = ArticlePrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Ressources")
    private List<ArticlePrevu> articles = new ArrayList<ArticlePrevu>();
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "MAPV_ID")
    @Predicate(label = "Intervenants",type = IntervenantPrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Ressources")
    private List<IntervenantPrevu> intervenants = new ArrayList<IntervenantPrevu>();
    
    public MaintenancePreventive() {
    }

    public Equipement getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipement equipement) {
        this.equipement = equipement;
    }

    public EtatEquipement getEtat() {
        return etat;
    }

    public void setEtat(EtatEquipement etat) {
        this.etat = etat;
    }

    public Gamme getGamme() {
        return gamme;
    }

    public void setGamme(Gamme gamme) {
        this.gamme = gamme;
    }

    public Rubrique getRubrique() {
        return rubrique;
    }

    public void setRubrique(Rubrique rubrique) {
        this.rubrique = rubrique;
    }

    public Intervenant getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Intervenant destinataire) {
        this.destinataire = destinataire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Priorite getPriorite() {
        return priorite;
    }

    public void setPriorite(Priorite priorite) {
        this.priorite = priorite;
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

    public Intervenant getFornisseur() {
        return fornisseur;
    }

    public void setFornisseur(Intervenant fornisseur) {
        this.fornisseur = fornisseur;
    }

    public List<IntervenantPrevu> getIntervenants() {
        return intervenants;
    }

    public void setIntervenants(List<IntervenantPrevu> intervenants) {
        this.intervenants = intervenants;
    }
    
    

    @Override
    public String getDesignation() {
        return super.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Fiches de maintenance préventive"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Fiche de maintenance préventive"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    @Override
    public int compareTo(MaintenancePreventive o) {
        return equipement.compareTo(o.equipement); //To change body of generated methods, choose Tools | Templates.
    }
    
}
