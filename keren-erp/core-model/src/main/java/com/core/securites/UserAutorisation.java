/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.securites;

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
@Table(name = "T_USAU")
public class UserAutorisation extends BaseElement implements Serializable,Comparable<UserAutorisation>{

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    @Predicate(label = "Niveau d'autorisation",type = Groupe.class,target = "many-to-one",search = true,editable = false)
    private Groupe groupe ;
    
    @Predicate(label = "Roles utilisateur(separateur ;)",search = true,optional = false)
    private String role;

    public UserAutorisation(Groupe groupe, String role) {
        this.groupe = groupe;
        this.role = role;
    }

    /**
     * 
     * @param groupe
     * @param role
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public UserAutorisation(Groupe groupe, String role, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.groupe = groupe;
        this.role = role;
    }
    
     public UserAutorisation(UserAutorisation entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        if(entity.groupe!=null){
            this.groupe = new Groupe(entity.groupe);
        }
        this.role = entity.role;
    }

    public UserAutorisation() {
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getOwnermodule() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencore"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Autorisations"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Autorisation"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(UserAutorisation o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
    
}
