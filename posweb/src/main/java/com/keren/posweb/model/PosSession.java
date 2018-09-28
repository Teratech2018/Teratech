/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.posweb.model;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
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
@Table(name = "T_SESSIONPOS")
public class PosSession extends BaseElement implements Serializable,Comparable<PosSession>{

    @Predicate(label = "Session",optional = false,search = true,nullable = false)
    private String code;
    
    @ManyToOne
    @JoinColumn(name = "RES_ID")
    @Predicate(label = "Responsable",type = User.class,target = "many-to-one",search = true,optional = false)
    private User responsable ;
   
    @ManyToOne
    @JoinColumn(name = "POS_ID")
    @Predicate(label = "Point de Vente",type = PointVente.class,target = "many-to-one",search = true,optional = false)
    private PointVente pointvente ;
   
    @Temporal(TemporalType.DATE)
    @Predicate(label = "Date d'ouverture",type = Date.class,target = "date",search = true)
    private Date douverture ;

    public PosSession() {
    }

    /**
     * 
     * @param code
     * @param responsable
     * @param pointvente
     * @param douverture
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public PosSession(String code, User responsable, PointVente pointvente, Date douverture, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.code = code;
        this.responsable = responsable;
        this.pointvente = pointvente;
        this.douverture = douverture;
    }
   
    public PosSession(PosSession entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.code = entity.code;
        if(entity.responsable!=null){
            this.responsable = new User(entity.responsable);
        }
        if(entity.pointvente!=null){
            this.pointvente = new PointVente(entity.pointvente);
        }
        this.douverture = entity.douverture;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }

    public PointVente getPointvente() {
        return pointvente;
    }

    public void setPointvente(PointVente pointvente) {
        this.pointvente = pointvente;
    }

    public Date getDouverture() {
        return douverture;
    }

    public void setDouverture(Date douverture) {
        this.douverture = douverture;
    }

    @Override
    public boolean isDesablecreate() {
        return false; //To change body of generated methods, choose Tools | Templates.
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
        return "posweb"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getListTitle() {
        return "Sessions"; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditTitle() {
        return "Session"; //To change body of generated methods, choose Tools | Templates.
    }
   
    
   
    @Override
    public int compareTo(PosSession o) {
        //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }
    
}
