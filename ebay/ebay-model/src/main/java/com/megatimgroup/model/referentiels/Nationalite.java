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
@Table(name="NATIONALITE")
public class Nationalite extends Base{

    /**
     * 
     */
    public Nationalite() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public Nationalite(String code, String designation) {
        super(code, designation);
    }
    
    
}
