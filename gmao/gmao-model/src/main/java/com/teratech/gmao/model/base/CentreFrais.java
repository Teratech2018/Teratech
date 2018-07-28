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
@Table(name = "T_CFRGM")
public class CentreFrais extends BaseElement implements Serializable,Comparable<CentreFrais>{

    @Predicate(label = "Centre de frais",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",search = true)
    private String intitule ; 
    
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = Intervenant.class,target = "many-to-one",search = true)
    private Intervenant responsable ;
    
    @ManyToOne
    @JoinColumn(name = "DIV_ID")
    @Predicate(label = "Division",type = Division.class,target = "many-to-one" ,optional = false,search = true)
    private Division division ;
    
    @ManyToOne
    @JoinColumn(name = "CA_ID")
    @Predicate(label = "Centre analytique",type = CentreAnalytique.class,target = "many-to-one",search = true)
    private CentreAnalytique centre ;
    
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
    public CentreFrais() {
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
    public CentreFrais(String code, String intitule, String adresse1, String bp, String ville, String telecopie, String telephone) {
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
    public CentreFrais(String code, String intitule, String adresse1, String bp, String ville, String telecopie, String telephone, long id, String designation, String moduleName, long comparedid) {
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
     * @param entity 
     */
     public CentreFrais(CentreFrais entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.adresse1 = entity.adresse1;
        this.bp = entity.bp;
        this.ville = entity.ville;
        this.telecopie = entity.telecopie;
        this.telephone = entity.telephone;
        if(entity.responsable!=null){
            this.responsable = new Intervenant(entity.responsable);
        }//end if(entity.responsable!=null){
        if(entity.division!=null){
            this.division = new Division(entity.division);
        }
        if(entity.centre!=null){
            this.centre = new CentreAnalytique(entity.centre);
        }
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

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public CentreAnalytique getCentre() {
        return centre;
    }

    public void setCentre(CentreAnalytique centre) {
        this.centre = centre;
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
        return "Centres de frais"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Centre de frais"; //To change body of generated methods, choose Tools | Templates.
    }
    
     
     
    @Override
    public int compareTo(CentreFrais o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
