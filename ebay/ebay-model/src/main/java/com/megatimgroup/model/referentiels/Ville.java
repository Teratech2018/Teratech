/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.referentiels;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="VILLE")
public class Ville extends Base{

    /**
     * 
     */
    public Ville() {
    }

    
    /**
     * 
     * @param code
     * @param designation 
     */
    public Ville(String code, String designation) {
        super(code, designation);
    }
    
    
}
