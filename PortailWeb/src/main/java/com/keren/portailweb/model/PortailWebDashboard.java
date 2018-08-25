/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.portailweb.model;

import com.core.base.BaseElement;
import java.io.Serializable;

/**
 *
 * @author BEKO
 */
public class PortailWebDashboard extends BaseElement implements Serializable,Comparable<PortailWebDashboard>{

    public PortailWebDashboard() {
    }

    @Override
    public String getDesignation() {
        return "TABLEAU DE BORD"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "portailweb"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Tableau de bord"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Tableau de bord"; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    @Override
    public int compareTo(PortailWebDashboard o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
