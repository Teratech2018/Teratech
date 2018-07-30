/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.workflow;

import com.core.base.BaseElement;
import com.keren.courrier.model.referentiel.Statut;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ACCOUGC")
public class ActionCourrier extends BaseElement implements Serializable,Comparable<ActionCourrier>{

    @Predicate(label = "Action",optional = false,unique = true,search = true)
    private String code ;    
   
    @ManyToOne
    @JoinColumn(name = "STAT_ID")
    @Predicate(label = "Statut associé",type = Statut.class,target = "many-to-one",optional = false,search = true)
    private Statut statut ;

    @Predicate(label = "Resultat action",target = "combobox",values = "Confirmation;Transferer le courrier;Viser le courrier;Refus de visa;Clôturer le courrier;Marquer comme lu")
    private String nature ;
    
    public ActionCourrier() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
    
    

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "kerencourrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Actions Courrier"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Action Courrier"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public int compareTo(ActionCourrier o) {
        return code.compareTo(o.code); //To change body of generated methods, choose Tools | Templates.
    }
    
}
