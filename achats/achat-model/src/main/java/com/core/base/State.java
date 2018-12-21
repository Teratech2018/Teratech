/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.base;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Commercial_2
 */
@XmlRootElement
public class State implements Serializable{
    
    private String code ;
    
    private String intitule ;
    
    private String icone ;
    
    private String couleur;

    /**
     * 
     * @param code
     * @param intitule 
     */
    public State(String code, String intitule) {
        this.code = code;
        this.intitule = intitule;
    }

    /**
     * 
     * @param code
     * @param intitule
     * @param icone
     * @param couleur 
     */
    public State(String code, String intitule, String icone, String couleur) {
        this.code = code;
        this.intitule = intitule;
        this.icone = icone;
        this.couleur = couleur;
    }
    
    

    public State() {
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

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    
    
    
    
}
