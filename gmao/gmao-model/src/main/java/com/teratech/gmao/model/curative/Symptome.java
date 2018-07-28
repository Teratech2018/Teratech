/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.gmao.model.curative;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.base.Intervenant;
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
@Table(name = "T_SYMPGM")
public class Symptome extends BaseElement implements Serializable,Comparable<Symptome>{

    @Predicate(label = "Symptôme",optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    @ManyToOne
    @JoinColumn(name = "INT_ID")
    @Predicate(label = "Destinataire D.I/B.T",type = Intervenant.class,target = "many-to-one",group = true,groupName = "group1",groupLabel = "Général")
    private Intervenant destinataire ;
    
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "SYM_ID")
    @Predicate(label = "",type = FichierLie.class,target = "one-to-many",edittable = true,group = true,groupName = "group2",groupLabel = "Documents joints")
    private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();

    public Symptome() {
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param destinataire 
     */
    public Symptome(String code, String intitule, Intervenant destinataire) {
        this.code = code;
        this.intitule = intitule;
        this.destinataire = destinataire;
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param destinataire
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public Symptome(String code, String intitule, Intervenant destinataire, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.destinataire = destinataire;
    }
    
    public Symptome(Symptome entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        if(entity.destinataire!=null){
            this.destinataire = entity.destinataire;
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

    public Intervenant getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Intervenant destinataire) {
        this.destinataire = destinataire;
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
        return "Symptômes"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
         return "Symptôme"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Symptome o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
