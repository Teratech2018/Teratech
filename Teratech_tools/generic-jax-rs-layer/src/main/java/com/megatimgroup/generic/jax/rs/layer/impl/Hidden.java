/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.megatimgroup.generic.jax.rs.layer.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *Hidden Object use to hidde GUI object
 * @author BEKO
 */
@XmlRootElement
public class Hidden implements Serializable{
    
    private String leftOper ;
    
    private String rigthOper ;
    
    private String oper ;

    /**
     * 
     */
    public Hidden() {
    }

    /**
     * 
     * @param leftOper
     * @param rigthOper
     * @param oper 
     */
    public Hidden(String leftOper, String rigthOper, String oper) {
        this.leftOper = leftOper;
        this.rigthOper = rigthOper;
        this.oper = oper;
    }

    public String getLeftOper() {
        return leftOper;
    }

    public void setLeftOper(String leftOper) {
        this.leftOper = leftOper;
    }

    public String getRigthOper() {
        return rigthOper;
    }

    public void setRigthOper(String rigthOper) {
        this.rigthOper = rigthOper;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
    
    
}
