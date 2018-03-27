/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_REDE")
public class ReponseDE extends BaseElement implements Serializable, Comparable<ReponseDE> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 584029503483059312L;
	
	@ManyToOne
	@JoinColumn(name="DE_ID")
	@Predicate(label="Demande",type=DemandeExplication.class,target="many-to-one",optional=false,nullable=false,search=true)
	private DemandeExplication demande ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de la reponse",type=Date.class,target="date" ,optional=false,search=true)
	private Date dater ;
	
	@Predicate(label="Resumé",target="textarea" ,group=true,groupName="group1",groupLabel="RESUME")
	private String resume;
	

	/**
	 * 
	 */
	public ReponseDE() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ReponseDE(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	
    /**
     * 
     * @param id
     * @param designation
     * @param moduleName
     * @param demande
     * @param dater
     * @param resume
     */
	public ReponseDE(long id, String designation, String moduleName, DemandeExplication demande, Date dater,
			String resume) {
		super(id, designation, moduleName);
		this.demande = demande;
		this.dater = dater;
		this.resume = resume;
	}
	
	public ReponseDE(ReponseDE rep) {
		super(rep.id, rep.designation, rep.moduleName);
		if(rep.demande!=null){
			this.demande = new DemandeExplication(rep.demande);
		}
		this.dater = rep.dater;
		this.resume = rep.resume;
	}
	
	

	public DemandeExplication getDemande() {
		return demande;
	}

	public void setDemande(DemandeExplication demande) {
		this.demande = demande;
	}

	public Date getDater() {
		return dater;
	}

	public void setDater(Date dater) {
		this.dater = dater;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "DEPONSE DEMANDE D'EXPLICATION";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "DEPONSES AUX DEMANDES D'EXPLICATION";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return demande.getDesignation();
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}
	
	

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compareTo(ReponseDE o) {
		// TODO Auto-generated method stub
		return demande.compareTo(o.demande);
	}

}
