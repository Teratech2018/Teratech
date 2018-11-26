/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.core.base.State;
import com.core.referentiels.Societe;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "T_USER")
@XmlRootElement
public class UserEducation extends BaseElement implements Serializable,Comparable<UserEducation>{

    @Predicate(label = "image",target = "image",sequence = 1)
    private String image ="img\\photo.png";  
    
    @Predicate(label = "ACTIF",colsequence = 100,sequence = 2)
    private Boolean actif = Boolean.FALSE; 
    
    @Predicate(label = "LOGIN" ,nullable = false ,optional = false,min = 4,unique = true,updatable = false,search = true,sequence = 3)
    private String intitule ;     
    
    @Predicate(label = "ADRESSE ELECTRONIQUE",target = "email",unique = false,optional = false,search = true,sequence = 4)
    private String courriel ;
    
    //@Predicate(label = "MOT DE PASSE",target = "password" ,optional = false,search = false)
    private String password ; 
    
    private String name = "admin";
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastconfirme = null;
    
    @Predicate(label = "Etablissement Scolaire" , type = Societe.class,optional = false,sequence = 5,search = true,searchfields ="nom" )
    @ManyToOne
    @JoinColumn(name = "SC_ID")
    private Etablissement CurrentSchool ;
    
   
    
    @Predicate(label = "NIVEAU ADMINISTRATION" ,target = "combobox" ,values = "Aucun;Applications;Configuration;Applications & Configuration",search = false,sequence = 7)
    private String adminlevel = "0" ;   
    
   
    private String state ="etabli";

    /**
     * 
     */
    public UserEducation() {
    }

    /**
     * 
     * @param image
     * @param intitule
     * @param courriel
             * @param societeCourante
     * @param id
     * @param designation
     * @param moduleName 
     */
    public UserEducation(String image, String intitule, String courriel, Societe societeCourante, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.image = image;
        this.intitule = intitule;
        this.courriel = courriel;
        //this.societeCourante = societeCourante;
    }

    /**
     * 
     * @param user 
     */
   public UserEducation(UserEducation user) {
        super(user.id, user.designation, user.moduleName,user.compareid);
        this.image = user.image;
        this.intitule = user.intitule;
        this.courriel = user.courriel;
        this.password = user.password;
        this.state = user.state;
        this.name = user.name;
        this.actif = user.actif;
        this.adminlevel = user.adminlevel;
      //  this.CurrentSchool=user.getCurrentSchool();
 
    }
    
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String getDesignation() {
        return intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Boolean isActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(String adminlevel) {
        this.adminlevel = adminlevel;
    }   

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }
 

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }    

  
    @Override
    public String getListTitle() {
        return "UTILISATEURS"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "UTILISATEUR"; //To change body of generated methods, choose Tools | Templates.
    }

    public Date getLastconfirme() {
        return lastconfirme;
    }

    public void setLastconfirme(Date lastconfirme) {
        this.lastconfirme = lastconfirme;
    }

       
    
    @Override
    public String getModuleName() {
        return "kereneducation"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        //To change body of generated methods, choose Tools | Templates.
        List<State> etats = new ArrayList<State>();
        State etat = new State("etabli", "Non Confirmé");
        etats.add(etat);
        etat = new State("confirme", "Confirmé");
        etats.add(etat);
        return etats; 
    }

	public Etablissement getCurrentSchool() {
		return CurrentSchool;
	}

	public void setCurrentSchool(Etablissement currentSchool) {
		CurrentSchool = currentSchool;
	}

	public int compareTo(UserEducation o) {
		// TODO Auto-generated method stub
		return 0;
	}

    
    
  
    
}
