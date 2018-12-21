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
@Table(name="PAYS")
public class Pays extends Base{

    /**
     * 
     */
    public Pays() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public Pays(String code, String designation) {
        super(code, designation);
    }
    
    
    
}
