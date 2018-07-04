/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.kerenpaie.model.comptabilite;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Commercial_2
 */
@Entity
@Table(name = "T_EXERCMBLE")
public class ExerciceComptable extends BaseElement implements Serializable,Comparable<ExerciceComptable>{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1637931667564529909L;

	@Predicate(label = "CODE",optional = false,updatable = false,search = true,colsequence = 1)
    @Column(unique = true,nullable = false)
    private String code ;
    
	@ManyToOne
    @JoinColumn(name="SOC_ID")
    @Predicate(label="Dossier de paie",type=Societe.class,target="many-to-one",optional=false)
    private Societe societe ;
    
    @Predicate(label = "EXERCICE OUVERT",search = true,colsequence = 2,type = Boolean.class,hide=true)
    private Boolean  ouvert = false ;
    
    @Predicate(label = "DATE DE DEBUT",type = Date.class,target = "date",optional = false,updatable = false,search = true,colsequence = 4)
    @Temporal(TemporalType.DATE)
    private Date debut ;
    
    @Predicate(label = "DATE DE FIN",type = Date.class,target = "date",optional = false,updatable = false,search = true,colsequence = 3)
    @Temporal(TemporalType.DATE)
    private Date fin ;
    
    @OneToMany(fetch=FetchType.LAZY,mappedBy="exercice")
    @Predicate(label="Periode",type=PeriodePaie.class,target="one-to-many",group=true,groupName="group1",groupLabel="PERIODES DE PAIE")
    private List<PeriodePaie> periodes = new ArrayList<PeriodePaie>();
    
    private boolean active = false;

    /**
     * 
     * @param code
     * @param debut
     * @param fin 
     */
    public ExerciceComptable(String code, Date debut, Date fin) {
        this.code = code;
        this.debut = debut;
        this.fin = fin;
    }

    /**
     * 
     * @param code
     * @param debut
     * @param fin
     * @param id
     * @param designation
     * @param moduleName 
     */
    public ExerciceComptable(String code, Date debut, Date fin, long id, String designation, String moduleName) {
        super(id, designation, moduleName,0L);
        this.code = code;
        this.debut = debut;
        this.fin = fin;
    }
    
    public ExerciceComptable(ExerciceComptable exo) {
        super(exo.id, exo.designation, exo.moduleName,exo.compareid);
        this.code = exo.code;
        this.debut = exo.debut;
        this.fin = exo.fin;
        if(exo.societe!=null){
        	this.societe = new Societe(exo.societe);
        }
    }

    public ExerciceComptable() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
    
    

    public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public List<PeriodePaie> getPeriodes() {
		return periodes;
	}

	public void setPeriodes(List<PeriodePaie> periodes) {
		this.periodes = periodes;
	}

	@Override
    public String getDesignation() {
        //To change body of generated methods, choose Tools | Templates.
        return code;
    }

    @Override
    public String getListTitle() {
        //To change body of generated methods, choose Tools | Templates.
        return "EXERCICES COMPTABLE";
    }

    @Override
    public String getEditTitle() {
        //To change body of generated methods, choose Tools | Templates.
        return "EXERCICE COMPTABLE";
    }
    
     @Override
    public String getModuleName() {
        return "kerenpaie"; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int compareTo(ExerciceComptable o) {
         //To change body of generated methods, choose Tools | Templates.
        return code.compareTo(o.code);
    }

    @Override
    public String toString() {
        return "ExerciceComptable{" + "code=" + code + ", ouvert=" + ouvert + ", debut=" + debut + ", fin=" + fin + ", active=" + active + '}';
    }
    
}
