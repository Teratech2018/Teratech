/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.operations;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.megatim.common.annotations.TableFooter;
import com.teratech.achat.model.base.Tier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_REFO_ACH")
public class ReponseFournisseur extends BaseElement implements Serializable,Comparable<ReponseFournisseur>{

    @Predicate(label = "Reference",optional = false,unique = true,search = true)
    private String code;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Predicate(label = "Date",type = Date.class,target = "date",search = true)
    private Date dreponse ;
    
    @ManyToOne
    @JoinColumn(name = "TIER_ID")
    @Predicate(label = "Fournisseur",type = Tier.class,target = "many-to-one",search = true,optional = false)
    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    private Tier fournisseur ;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "LIREP_ID")
    @Predicate(label = " ",type = LigneReponseDP.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "LIGNES",customfooter = true)
    @TableFooter(value = "<tr style='border:none;'><td></td><td></td><td></td><td></td><td style='font-weight: bold;'>Total HT</td> <td class='text-center'>this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100</td> </tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Taxes</td> <td  class='text-center'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};/;100</td> </tr> <tr style='border:none;'><td></td><td></td><td></td><td></td><td  style='font-weight: bold;'>Total TTC</td><td  class='text-center'  style='font-weight: bold;'>(;this.quantite;*;this.puht;*;(;100;-;this.remise;);/;100;);*;(;100;+;{\"op\":\"sum\",\"source\":\"this\",\"data\":\"taxes\",\"field\":\"montant\"};);/;100</td> </tr>")
    private List<LigneReponseDP> lignes = new ArrayList<LigneReponseDP>();

    @ManyToOne
    @JoinColumn(name = "DP_ID")
//    @Predicate(label = "Demande",type = DemandePrix.class,target = "many-to-one",search = true,optional = false)
    private DemandePrix demande ;
    
    @Predicate(label = "ETAT",target = "state",hide = true,search = true)
    private String state = "etabli";
    
    private double taxes = 0.0;
    
    private double totalht=0.0;
    
    private double totalttc = 0.0;
    
    /**
     * 
     */
    public ReponseFournisseur() {
    }

    /**
     * 
     * @param code
     * @param dreponse
     * @param fournisseur
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ReponseFournisseur(String code, Date dreponse, Tier fournisseur, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.dreponse = dreponse;
        this.fournisseur = fournisseur;
    }
    
    /**
     * 
     * @param entity 
     */
    public ReponseFournisseur(ReponseFournisseur entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.dreponse = entity.dreponse;
        if(entity.fournisseur!=null){
            this.fournisseur = new Tier(entity.fournisseur);
        }
        if(entity.getDemande()!=null){
            this.demande = new DemandePrix(entity.demande);
        }
        this.state = entity.state;
        this.totalht = entity.totalht;
        this.totalttc = entity.totalttc;
        this.taxes = entity.taxes;
    }

    /**
     * 
     * @param entity
     * @param fournisseur 
     */
    public ReponseFournisseur(DemandePrix entity ,Tier fournisseur) {
        super(-1, entity.getDesignation(), entity.getModuleName(), entity.getCompareid());
        this.code = entity.getCode();
        this.dreponse = new Date();
        if(entity.getFournisseurs()!=null){
            this.fournisseur = new Tier(fournisseur);
        }//end if(entity.getFournisseurs()!=null){
        for(LigneDemandePrix ligne:entity.getArticles()){
            lignes.add(new LigneReponseDP(ligne));
        }//end for(LigneDemandePrix ligne:entity.getArticles()){
        this.demande = entity;
        this.state = "etabli";
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDreponse() {
        return dreponse;
    }

    public void setDreponse(Date dreponse) {
        this.dreponse = dreponse;
    }

    public Tier getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Tier fournisseur) {
        this.fournisseur = fournisseur;
    }

    public List<LigneReponseDP> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneReponseDP> lignes) {
        this.lignes = lignes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getTotalht() {
        return totalht;
    }

    public void setTotalht(double totalht) {
        this.totalht = totalht;
    }

    public double getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(double totalttc) {
        this.totalttc = totalttc;
    }
    
    

    @Override
    public String getOwnermodule() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "REPONSEFOURL"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "REPONSEFOURD"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchkeys() {
        return super.getSearchkeys(); //To change body of generated methods, choose Tools | Templates.
    }

    public DemandePrix getDemande() {
        return demande;
    }

    public void setDemande(DemandePrix demande) {
        this.demande = demande;
    }

    @Override
    public boolean isDesableupdate() {
       return !state.equalsIgnoreCase("etabli");  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "rf220220182222"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesabledelete() {
        return !state.equalsIgnoreCase("etabli"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDesablecreate() {
       return state.equalsIgnoreCase("cloture");//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    @Override
    public int compareTo(ReponseFournisseur o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
