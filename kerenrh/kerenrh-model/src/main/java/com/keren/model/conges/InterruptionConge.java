/**
 * 
 */
package com.keren.model.conges;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_INRCON")
public class InterruptionConge extends BaseElement implements Serializable, Comparable<InterruptionConge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -659833474161943385L;
	
	
	@ManyToOne
	@JoinColumn(name="DC_ID")
	@Predicate(label="Congé concerné",type=DemandeCongeV.class,target="many-to-one",optional=false,nullable=false,search=true)
	private DemandeCongeV conge ;
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employe",type=Employe.class,target="many-to-one",optional=true,nullable=false,search=true, editable=false)
	private Employe employe;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de prise effet",type=Date.class,target="date",search=true , optional=false)
	private Date date ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Début du congé",type=Date.class,target="date",editable=false,search=true)
	private Date dateconge;
	
	@Predicate(label="Durer du Congé",type=Short.class,editable=false,search=true)
	private Short dureeconge ;
	
	@Predicate(label="Nombre de jours restant",type=Short.class,editable=false,search=true)
	private Short joursr =0;
	
	@Predicate(target="textarea",group=true,groupName="group1",groupLabel="Motif Interruption")
	private String motif ;
	
	private String state = "etabli";
	

	/**
	 * 
	 */
	public InterruptionConge() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public InterruptionConge(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
		state = "etabli";
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param date
	 * @param conge
	 * @param dateconge
	 * @param dureeconge
	 * @param joursr
	 */
	public InterruptionConge(long id, String designation, String moduleName, Employe employe, Date date,
			DemandeCongeV conge, Date dateconge, Short dureeconge, Short joursr) {
		super(id, designation, moduleName);
		this.employe = employe;
		this.date = date;
		this.conge = conge;
		this.dateconge = dateconge;
		this.dureeconge = dureeconge;
		this.joursr = joursr;
		state = "etabli";
	}
	 
	public InterruptionConge(InterruptionConge cg) {
		super(cg.id, cg.designation, cg.moduleName);
		if(cg.employe!=null){
			this.employe = new Employe(cg.employe);
		}
		this.date = cg.date;
		if(cg.conge!=null){
			this.conge = new DemandeCongeV(cg.conge);
		}
		this.dateconge = cg.dateconge;
		this.dureeconge = cg.dureeconge;
		this.joursr = cg.joursr;
		this.motif = cg.motif;
		this.state = cg.state;
	}
	
	

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DemandeCongeV getConge() {
		return conge;
	}

	public void setConge(DemandeCongeV conge) {
		this.conge = conge;
	}

	public Date getDateconge() {
		return dateconge;
	}

	public void setDateconge(Date dateconge) {
		this.dateconge = dateconge;
	}

	public Short getDureeconge() {
		return dureeconge;
	}

	public void setDureeconge(Short dureeconge) {
		this.dureeconge = dureeconge;
	}

	public Short getJoursr() {
		return joursr;
	}

	public void setJoursr(Short joursr) {
		this.joursr = joursr;
	}

	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "INTERRUPTION DE CONGE";
	}
	
	

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "INTERRUPTIONS DE CONGES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return conge.getDesignation();
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State etat = new State("etabli", "Brouillon");
		states.add(etat);
		etat = new State("confirmer", "Validé");
		states.add(etat);		
		return states;
	}
	

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(InterruptionConge o) {
		// TODO Auto-generated method stub
		return conge.compareTo(o.conge);
	}

}