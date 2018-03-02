/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teratech.stock.model.invetaire;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.Entrepot;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_FIIN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NIV",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("TMP")
public class BaseInventaire extends BaseElement implements Serializable,Comparable<BaseInventaire>{

    @Predicate(label = "Reference",optional = false,unique = true,search = true)
    protected String code ;
    
    @Predicate(label = "Date Inventaire",optional = false,type = Date.class,target = "date",search = true)
    @Temporal(TemporalType.DATE)
    protected Date dateinventaire ;
    
    @ManyToOne
    @JoinColumn(name = "ENTR_ID")
    @Predicate(label = "Entrepôt",type = Entrepot.class,target = "many-to-one",search = true)
    protected Entrepot fentrepot ;
    
    @ManyToOne
    @JoinColumn(name = "EMPL_ID")
    @Predicate(label = "Emplacement",type = Emplacement.class,target = "many-to-one",search = true)
    @Filter(value = "[{\"fieldName\":\"edepot\",\"value\":\"object.fentrepot\",\"searchfield\":\"code\",\"optional\":false,\"message\":\"Veuillez selectionner l'entrepôt\"}]")
    protected Emplacement femplacement;
    
    protected String state = "etabli";

    /**
     * 
     * @param code
     * @param date
     * @param fentrepot
     * @param femplacement 
     */
    public BaseInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement) {
        this.code = code;
        this.dateinventaire = date;
        this.fentrepot = fentrepot;
        this.femplacement = femplacement;
    }

    /**
     * 
     * @param code
     * @param date
     * @param fentrepot
     * @param femplacement
     * @param id
     * @param designation
     * @param moduleName 
     */
    public BaseInventaire(String code, Date date, Entrepot fentrepot, Emplacement femplacement, long id, String designation, String moduleName) {
        super(id, designation, moduleName);
        this.code = code;
        this.dateinventaire = date;
        this.fentrepot = fentrepot;
        this.femplacement = femplacement;
    }
    
    /**
     * 
     * @param base 
     */
    public BaseInventaire(BaseInventaire base) {
        super(base.id, base.designation, base.moduleName);
        this.code = base.code;
        this.dateinventaire =base.dateinventaire;
        if(base.fentrepot!=null){
            this.fentrepot = new Entrepot(base.fentrepot);
        }
        if(base.femplacement!=null){
            this.femplacement = new Emplacement(base.femplacement);
        }
        this.state = base.state;
    }

    public BaseInventaire() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateinventaire() {
        return dateinventaire;
    }

    public void setDateinventaire(Date dateinventaire) {
        this.dateinventaire = dateinventaire;
    }

   
    public Entrepot getFentrepot() {
        return fentrepot;
    }

    public void setFentrepot(Entrepot fentrepot) {
        this.fentrepot = fentrepot;
    }

    public Emplacement getFemplacement() {
        return femplacement;
    }

    public void setFemplacement(Emplacement femplacement) {
        this.femplacement = femplacement;
    }

    @Override
    public boolean isActivatefollower() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<State> getStates() {
        return super.getStates(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isActivefilelien() {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSerial() {
        return "bain200220182041"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCreateonfield() {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDesignation() {
        return code; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getModuleName() {
        return "teratechstock"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
       return "Fiches d'inventaire"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Fiche d'inventaire"; //To change body of generated methods, choose Tools | Templates.
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
            
            
    

    
    @Override
    public int compareTo(BaseInventaire o) {
         //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
