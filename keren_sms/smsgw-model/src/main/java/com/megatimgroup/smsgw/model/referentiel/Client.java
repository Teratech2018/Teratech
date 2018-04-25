/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.smsgw.model.referentiel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "TB_CLIENT")
public class Client implements Serializable , Comparable<Client>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = -1L;
    
    private String nom ;
    
    /**
     * 
     */
    public Client() {
    }

    
    
    @Override
    public int compareTo(Client o) {
        //To change body of generated methods, choose Tools | Templates.
        return Long.valueOf(id).compareTo(o.id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}
