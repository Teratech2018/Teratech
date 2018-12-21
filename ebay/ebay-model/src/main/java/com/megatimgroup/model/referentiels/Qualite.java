/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.model.referentiels;

import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name="QUALITE")
public class Qualite extends Base {  
   
    
    /**
     * 
     */
    public Qualite() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public Qualite(String code, String designation) {
        super(code, designation);
    }

        
    
}
