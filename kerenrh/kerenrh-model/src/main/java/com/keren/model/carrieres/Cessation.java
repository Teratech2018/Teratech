/**
 * 
 */
package com.keren.model.carrieres;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
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
@Table(name="T_CESSARH")
public class Cessation extends BaseElement implements Serializable, Comparable<Cessation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4328459478743457997L;
	
	@Predicate(label="Référence",optional=false,search=true,unique=true)
	@Column(unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe salarie ;
	
	@Predicate(label="Type de cessation",target="combobox",values="Retraite anticipée;Retraite;Licenciement;Demission;Décès;Invalidité permanente;Maladie prolongée")
	private String type="0";
	
	@Predicate(label="Cause de cessation",target="combobox",values="Faute lourde;Faute grave;Absence prolongée;Autres")
	private String cause ="0";
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de cession",type=Date.class,target="date",optional=false)
	private Date decision ;
	
	@Predicate(label="motif",target="textarea",group=true,groupName="group1",groupLabel="Motif")
	private String motif ;
	
	private String state = "etabli";

	/**
	 * 
	 */
	public Cessation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Cessation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param salarie
	 * @param type
	 * @param cause
	 * @param decision
	 * @param motif
	 */

	public Cessation(long id, String designation, String moduleName, String code, Employe salarie, String type,
			String cause, Date decision, String motif) {
		super(id, designation, moduleName);
		this.code = code;
		this.salarie = salarie;
		this.type = type;
		this.cause = cause;
		this.decision = decision;
		this.motif = motif;
	}
	
	/**
	 * 
	 * @param cessation
	 */
	public Cessation(Cessation cessation) {
		super(cessation.id, cessation.designation, cessation.moduleName);
		this.code = cessation.code;
		if(cessation.salarie!=null){
			this.salarie = new Employe(cessation.salarie);
		}
		this.type = cessation.type;
		this.cause = cessation.cause;
		this.decision = cessation.decision;
		this.motif = cessation.motif;
		this.state = cessation.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Employe getSalarie() {
		return salarie;
	}

	public void setSalarie(Employe salarie) {
		this.salarie = salarie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Date getDecision() {
		return decision;
	}

	public void setDecision(Date decision) {
		this.decision = decision;
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

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Cessation de Travail";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Cessations de Travail";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return salarie.getDesignation();
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
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		states.add(new State("etabli", "Brouillon"));
		states.add(new State("valide", "Validé"));
//		states.add(new State("annule", "Annulé"));
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Cessation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
