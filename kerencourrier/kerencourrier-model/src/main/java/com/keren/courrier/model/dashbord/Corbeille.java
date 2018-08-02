/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.dashbord;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.User;
import com.megatim.common.annotations.Predicate;
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
@Table(name = "T_CORBGC")
public class Corbeille extends BaseElement implements Serializable,Comparable<Corbeille>{

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user ;
    
    @Predicate(label = "Corbeille",optional = false,editable = false,hide=true)
    private String code;
    
    @Predicate(label = "Désignation",optional = false,search = true)
    private String intitule ;
    
    private int quantite =0;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "COR_ID")
    @Predicate(label = "",type = RegleCorbeille.class,target = "one-to-many",edittable = true,group = true,groupName = "group1",groupLabel = "Règles de filtrages")
    private List<RegleCorbeille> rules = new ArrayList<RegleCorbeille>();
    
    @Lob
    @Predicate(label = "Description",target = "textarea",search = false,group = true,groupName = "group2",groupLabel = "Description")
    private String commentaire;

    public Corbeille() {
    }

    public Corbeille(String code, String intitule, String commentaire, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.intitule = intitule;
        this.commentaire = commentaire;
    }

    public Corbeille(Corbeille entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        this.intitule = entity.intitule;
        this.commentaire = entity.commentaire;
        if(entity.user!=null){
            this.user = new User(entity.user);
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

    public List<RegleCorbeille> getRules() {
        return rules;
    }

    public void setRules(List<RegleCorbeille> rules) {
        this.rules = rules;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    

    @Override
    public String getDesignation() {
        return user.getDesignation(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Corbeilles"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Corbeille de "; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(Corbeille o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Corbeille{" + "user=" + user + ", code=" + code + ", intitule=" + intitule + ", quantite=" + quantite + ", rules=" + rules + ", commentaire=" + commentaire + '}';
    }
    
    
}
