/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
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
@Table(name = "T_FAAR")
public class FamilleArticle extends BaseElement implements Serializable,Comparable<FamilleArticle>{

    @Predicate(label = "Famille",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @Predicate(label = "Type de Famille",target = "combobox",values = "Détail;Total;Centralisateur",search = true)
    private String type ="0";
     
     @ManyToOne
    @JoinColumn(name = "FAAR_ID")
    @Predicate(label = "Centralisation",type = FamilleArticle.class,target = "many-to-one",search = true)
    @Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
    private FamilleArticle centralisateur ;    
   
    
   

    /**
     * 
     * @param code
     * @param intitule
     * @param centralisateur
     * @param pays
     * @param codefiscal 
     */
    public FamilleArticle(String code, String intitule, FamilleArticle centralisateur, Pays pays, String codefiscal) {
        this.code = code;
        this.intitule = intitule;
       this.centralisateur = centralisateur;
       
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param centralisateur
     * @param pays
     * @param codefiscal
     * @param id
     * @param designation
     * @param moduleName 
     */
    public FamilleArticle(String code, String intitule, FamilleArticle centralisateur, Pays pays, String codefiscal, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.intitule = intitule;
        this.centralisateur = centralisateur;        
    }
    
     public FamilleArticle(FamilleArticle entity) {
        super(entity.id, entity.designation, entity.moduleName,entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.type = entity.type;
        if(entity.centralisateur!=null){
            this.centralisateur = new FamilleArticle(entity.centralisateur);
        }        
    }

    public FamilleArticle() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 

    public FamilleArticle getCentralisateur() {
        return centralisateur;
    }

    public void setCentralisateur(FamilleArticle centralisateur) {
        this.centralisateur = centralisateur;
    }

   

    @Override
    public String getDesignation() {
        return intitule; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechgmao"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Familles"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
       return "Famille"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(FamilleArticle o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
