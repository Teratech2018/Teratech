/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_CANGM")
public class CentreAnalytique extends BaseElement implements Serializable,Comparable<CentreAnalytique>{

    @Predicate(label = "Centre analytique",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",search = true)
    private String intitule ; 
    
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = Intervenant.class,target = "many-to-one",search = true)
    private Intervenant responsable ;
    
    
    @Predicate(label = "Adresse",target = "textarea",group = true,groupLabel = "Adresse",groupName = "group1")
    private String adresse1 ;
    
    @Predicate(label = "Boite Postale",group = true,groupLabel = "Adresse",groupName = "group1")
    private String bp ;
    
    @Predicate(label = "Ville",group = true,groupLabel = "Adresse",groupName = "group1")
    private String ville ;
    
    @Predicate(label = "Télécopie",group = true,groupLabel = "Adresse",groupName = "group1")
    private String telecopie ;
    
    @Predicate(label = "Téléphone",group = true,groupLabel = "Adresse",groupName = "group1")
    private String telephone ;
    
   
    /**
     * 
     */
    public CentreAnalytique() {
    }

    
    /**
     * 
     * @param code
     * @param intitule
     * @param adresse1
     * @param bp
     * @param ville
     * @param telecopie
     * @param telephone 
     */
    public CentreAnalytique(String code, String intitule, String adresse1, String bp, String ville, String telecopie, String telephone) {
        this.code = code;
        this.intitule = intitule;
        this.adresse1 = adresse1;
        this.bp = bp;
        this.ville = ville;
        this.telecopie = telecopie;
        this.telephone = telephone;
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param adresse1
     * @param bp
     * @param ville
     * @param telecopie
     * @param telephone
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public CentreAnalytique(String code, String intitule, String adresse1, String bp, String ville, String telecopie, String telephone, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.adresse1 = adresse1;
        this.bp = bp;
        this.ville = ville;
        this.telecopie = telecopie;
        this.telephone = telephone;
    }
    
    /**
     * 
     * @param secteur 
     */
     public CentreAnalytique(CentreAnalytique secteur) {
        super(secteur.id, secteur.designation, secteur.moduleName, secteur.compareid);
        this.code = secteur.code;
        this.intitule = secteur.intitule;
        this.adresse1 = secteur.adresse1;
        this.bp = secteur.bp;
        this.ville = secteur.ville;
        this.telecopie = secteur.telecopie;
        this.telephone = secteur.telephone;
        if(secteur.responsable!=null){
            this.responsable = new Intervenant(secteur.responsable);
        }//end if(secteur.responsable!=null){
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

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelecopie() {
        return telecopie;
    }

    public void setTelecopie(String telecopie) {
        this.telecopie = telecopie;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Intervenant getResponsable() {
        return responsable;
    }

    public void setResponsable(Intervenant responsable) {
        this.responsable = responsable;
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
        return "Centres analytiques"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Centre analytique"; //To change body of generated methods, choose Tools | Templates.
    }
    
     
     
    @Override
    public int compareTo(CentreAnalytique o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
