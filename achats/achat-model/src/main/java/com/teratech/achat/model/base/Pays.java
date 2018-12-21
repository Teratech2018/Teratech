/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.achat.model.base;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
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
@Table(name = "T_PAYS")
public class Pays extends BaseElement implements Serializable,Comparable<Pays>{
    
     @Predicate(label = "image",target = "image",search = false)
     private String image ="avatar.png";
     
    @Predicate(label = "Nom du pays" ,optional = false,unique = true,search = true)
    private String intitule ;
    
    @Predicate(label = "Code du pays" ,optional = false,updatable = false,unique = true,search = true)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "DEVISE_ID")
    @Predicate(label = "Dévise",type = Devise.class,target="many-to-one",search = true)
    private Devise devise ;
    
    @Predicate(label = "Regions / Etats" , type = Region.class,target = "one-to-many" ,group = true,groupName = "regions",groupLabel = "Régions", edittable = true)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "PAYS_ID")
    private List<Region> etats = new ArrayList<Region>();

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getDesignation() {
        return intitule; //To change body of generated methods, choose Tools | Templates.
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public List<Region> getEtats() {
        return etats;
    }

    public void setEtats(List<Region> etats) {
        this.etats = etats;
    }
    
    

    @Override
    public String getModuleName() {
        return "teratechachat"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "PAYS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "PAYS"; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public int compareTo(Pays o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
}
