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
@Table(name="N_JURIDIQUE")
public class NatureJuridique extends Base{

    /**
     * 
     */
    public NatureJuridique() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public NatureJuridique(String code, String designation) {
        super(code, designation);
    }
    
    
}
