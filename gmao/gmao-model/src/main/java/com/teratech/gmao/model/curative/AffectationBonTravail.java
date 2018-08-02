/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Rubrique;
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
@Table(name = "T_BOTRGM")
public class AffectationBonTravail extends BaseElement implements Serializable,Comparable<AffectationBonTravail>{

    @Predicate(label = "Bon de travail",optional = false,unique = true,editable = true,search = true)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @Predicate(label = "Rubrique",type = Rubrique.class,target = "many-to-one",editable = true,optional = false,search = true)
    private Rubrique rubrique;
    
    @ManyToOne
    @JoinColumn(name = "EQU_ID")
    @Predicate(label = "Equipement",type = Equipement.class,target = "many-to-one",editable = true,optional = false,search = true)
    private Equipement equipement;
    
    @ManyToOne
    @JoinColumn(name = "ETEQ_ID")
    @Predicate(label = "Etat equipement",type = EtatEquipement.class,target = "many-to-one",editable = true,optional = false,search = true)
    private EtatEquipement etatEquipement;
    
    @ManyToOne
    @JoinColumn(name = "EME_ID")
    @Predicate(label = "Emetteur",type = Intervenant.class,target = "many-to-one",editable = true,optional = false,search = true)
    private Intervenant emetteur ;
    
    @ManyToOne
    @JoinColumn(name = "DES_ID")
    @Predicate(label = "Destinataire",type = Intervenant.class,target = "many-to-one",editable = true,optional = false,search = true)
    private Intervenant destinataire ;    
     
     
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BT_ID")
    @Predicate(label = "Articles prévus",type = ArticlePrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Planning ressources")
    private List<ArticlePrevu> articles = new ArrayList<ArticlePrevu>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "BTID")
    @Predicate(label = "Intervenants prévus",type = IntervenantPrevu.class,target = "one-to-many",edittable = true,group = true,groupName = "group5",groupLabel = "Planning ressources")
    private List<IntervenantPrevu> intervenants = new ArrayList<IntervenantPrevu>();
    
    
    
    public AffectationBonTravail() {
    }

    /**
     * 
     * @param code
     * @param rubrique
     * @param equipement
     * @param etatEquipement
     * @param emetteur
     * @param destinataire
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public AffectationBonTravail(String code, Rubrique rubrique, Equipement equipement, EtatEquipement etatEquipement, Intervenant emetteur, Intervenant destinataire, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.rubrique = rubrique;
        this.equipement = equipement;
        this.etatEquipement = etatEquipement;
        this.emetteur = emetteur;
        this.destinataire = destinataire;
    }
    
     public AffectationBonTravail(AffectationBonTravail entity) {
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
        return "Affectation des bons de travail"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Affectation bon de travail";//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(AffectationBonTravail o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
