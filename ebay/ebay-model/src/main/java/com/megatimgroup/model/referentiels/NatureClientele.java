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
@Table(name="N_CLIENTELE")
public class NatureClientele extends Base{

    /**
     * 
     */
    public NatureClientele() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public NatureClientele(String code, String designation) {
        super(code, designation);
    }
    
    
}
