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
@Table(name="N_SRESID")
public class StatusResidence extends Base{

    /**
     * 
     */
    public StatusResidence() {
    }

    
    /**
     * 
     * @param code
     * @param designation 
     */
    public StatusResidence(String code, String designation) {
        super(code, designation);
    }
    
    
}
