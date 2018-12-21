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
@Table(name="CLASSE")
public class Classe extends Base{

    /**
     * 
     */
    public Classe() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public Classe(String code, String designation) {
        super(code, designation);
    }
    
    
}
