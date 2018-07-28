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
@Table(name = "T_RUBGM")
public class Rubrique extends BaseElement implements Serializable,Comparable<Rubrique>{

    @Predicate(label = "Rubrique",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true) 
    private String intitule;
    
    @ManyToOne
    @JoinColumn(name = "FAM_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one")
    private FamilleArticle famille ;
    
    @Predicate(label = "Catégorie",target = "combobox",values = "Préventif;Correctif;Divers",optional = false)
    private String categorie ;

    /**
     * 
     * @param code
     * @param intitule
     * @param famille
     * @param categorie 
     */
    public Rubrique(String code, String intitule, FamilleArticle famille, String categorie) {
        this.code = code;
        this.intitule = intitule;
        this.famille = famille;
        this.categorie = categorie;
    }

    
    /**
     * 
     * @param code
     * @param intitule
     * @param famille
     * @param categorie
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Rubrique(String code, String intitule, FamilleArticle famille, String categorie, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.famille = famille;
        this.categorie = categorie;
    }
    
    public Rubrique(Rubrique entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.famille!=null){
            this.famille = new FamilleArticle(entity.famille);
        }
        this.categorie = entity.categorie;
    }

    public Rubrique() {
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

    public FamilleArticle getFamille() {
        return famille;
    }

    public void setFamille(FamilleArticle famille) {
        this.famille = famille;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
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
        return "Rubriques"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Rubriques"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Rubrique o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
