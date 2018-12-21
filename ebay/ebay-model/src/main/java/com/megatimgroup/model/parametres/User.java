/**
 * 
 */
package com.megatimgroup.model.parametres;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.megatim.security.model.Utilisateur;

/**
 * @author mgt
 *
 */
@Entity
@Table(name="UTILISATEUR")
public class User implements Serializable ,Comparable<User>{
    @Id
    @Column(name="LOGIN")
    private String login;
    
    @Column(name="NOM")
    private String nom;
    
    @Column(name="PRENOM")
    private String prenom;
    
    @Column(name="PASSWORD")
    private String password;
        
     
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int compareTo(User o) {
        return login.compareTo(o.login); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return login;
    }
}