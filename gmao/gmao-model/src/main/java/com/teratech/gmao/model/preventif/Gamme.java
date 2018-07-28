/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.preventif;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.FamilleArticle;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.base.Qualification;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_GAMGM")
public class Gamme extends BaseElement implements Serializable,Comparable<Gamme>{

    @Predicate(label = "Gamme",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule;
    
    @ManyToOne
    @JoinColumn(name = "FAM_ID")
    @Predicate(label = "Famille",type = FamilleArticle.class,target = "many-to-one",optional = false,search = true)
    private FamilleArticle famille ;
    
    @ManyToOne
    @JoinColumn(name = "QUALI_ID")
    @Predicate(label = "Qualification",type = Qualification.class,target = "many-to-one",optional = false,search = true)
    private Qualification qualification;
    
    @Predicate(label = "",target = "richeditor",optional = false,group = true,groupName = "group1",groupLabel = "Mode opératoire")
    @Lob
    private String mode ;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "GAM_ID")
    @Predicate(label = "",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group2",groupLabel = "Documents joints")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();

    public Gamme() {
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param famille
     * @param qualification
     * @param mode
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Gamme(String code, String intitule, FamilleArticle famille, Qualification qualification, String mode, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.famille = famille;
        this.qualification = qualification;
        this.mode = mode;
    }
    
    public Gamme(Gamme entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.famille!=null){
            this.famille = new FamilleArticle(entity.famille);
        }
        this.qualification = entity.qualification;
        this.mode = entity.mode;
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

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<FichierLie> getPiecesjointes() {
        return piecesjointes;
    }

    public void setPiecesjointes(List<FichierLie> piecesjointes) {
        this.piecesjointes = piecesjointes;
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
        return "Gammes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Gamme"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Gamme o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
