/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.posweb.model;

import com.core.base.BaseElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BEKO
 */
public class PosWebDashboard extends BaseElement implements Serializable,Comparable<PosWebDashboard>{

    private List<PointVente> postes = null;
    
    public PosWebDashboard() {
        postes = new ArrayList<PointVente>();
    }

    public List<PointVente> getPostes() {
        return postes;
    }

    public void setPostes(List<PointVente> postes) {
        this.postes = postes;
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
    public int compareTo(PosWebDashboard o) {
        //To change body of generated methods, choose Tools | Templates.
        return 0;
    }
    
}
