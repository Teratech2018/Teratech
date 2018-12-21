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
@Table(name="TYPE_OPERATION")
public class TypeOperation extends Base{

    /**
     * 
     */
    public TypeOperation() {
    }

    /**
     * 
     * @param code
     * @param designation 
     */
    public TypeOperation(String code, String designation) {
        super(code, designation);
    }
    
    
}
