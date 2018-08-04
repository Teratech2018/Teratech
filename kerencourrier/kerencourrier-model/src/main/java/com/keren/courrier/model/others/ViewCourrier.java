/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.others;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.CourrierTous;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "V_COURRGC")
public class ViewCourrier extends BaseElement implements Serializable,Comparable<ViewCourrier>{

    @Lob
    private String motscles ;
    
    @ManyToOne
    @JoinColumn(name = "COU_ID")
    private CourrierTous courrier ;

    public ViewCourrier() {
    }

    /**
     * 
     * @param motscles
     * @param courrier
     * @param id
     * @param designation
     * @param moduleName
     * @param comparedid 
     */
    public ViewCourrier(String motscles, CourrierTous courrier, long id, String designation, String moduleName, long comparedid) {
        super(id, designation, moduleName, comparedid);
        this.motscles = motscles;
        this.courrier = courrier;
    }
    
    public ViewCourrier(ViewCourrier entity) {
        super(entity.id, entity.designation, entity.moduleName, entity.compareid);
        this.motscles = entity.motscles;
        if(entity.courrier!=null){
            this.courrier = new CourrierTous(entity.courrier);
        }
    }

    public String getMotscles() {
        return motscles;
    }

    public void setMotscles(String motscles) {
        this.motscles = motscles;
    }

    public CourrierTous getCourrier() {
        return courrier;
    }

    public void setCourrier(CourrierTous courrier) {
        this.courrier = courrier;
    }
    
    
    @Override
    public int compareTo(ViewCourrier o) {
        //To change body of generated methods, choose Tools | Templates.
        return courrier.compareTo(o.courrier);
    }
    
}
