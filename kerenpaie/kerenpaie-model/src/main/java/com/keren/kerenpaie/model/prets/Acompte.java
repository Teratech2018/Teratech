/**
 * 
 */
package com.keren.kerenpaie.model.prets;

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
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.Variable;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ACOMP")
public class Acompte extends BaseElement implements Serializable, Comparable<Acompte> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8106416349038340585L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe employe ;
	
	@ManyToOne
	@JoinColumn(name="VAR_ID")
	@Predicate(label="Variable Liée",type=Variable.class,target="many-to-one",optional=false,search=true)
	@Filter(value="[{\"fieldName\":\"code\",\"value\":\"MTACOMPTE\",\"optional\":false,\"message:\":\"Impossible de trouver la Variable MTACOMPTE\"}]")
	private Variable variable ;
	
	@Predicate(label="Date",type=Date.class,target="date",optional=false,search=true)
	@Temporal(TemporalType.DATE)
	private Date effet ;
	
	@Predicate(label="Montant",type=Double.class,optional=false,search=true)
	private Double montant = 0.0;
	
	@Predicate(label=" ",target="textarea",group=true,groupName="grou1",groupLabel="Commentaire")
	private String description ;
	
	private String state="etabli";
	
	@ManyToOne
	@JoinColumn(name="ELVAP_ID")
	private ElementVariable eltVariable ;

	/**
	 * 
	 */
	public Acompte() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Acompte(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param effet
	 * @param montant
	 * @param description
	 */

	public Acompte(long id, String designation, String moduleName, Employe employe, Date effet, Double montant,
			String description) {
		super(id, designation, moduleName,0L);
		this.employe = employe;
		this.effet = effet;
		this.montant = montant;
		this.description = description;
	}
	
	/**
	 * 
	 * @param acompte
	 */
	public Acompte(Acompte acompte) {
		super(acompte.id, acompte.designation, acompte.moduleName,acompte.compareid);
		if(acompte.employe!=null){
			this.employe = new Employe(acompte.employe);
		}
		if(acompte.eltVariable!=null){
			this.eltVariable = new ElementVariable(acompte.eltVariable);
		}
		
		if(acompte.variable!=null){
			this.variable = new Variable(acompte.variable);
		}
//		if(acompte.rubrique!=null){
//			this.rubrique = new Rubrique(acompte.rubrique);
//		}
		this.effet = acompte.effet;
		this.montant = acompte.montant;
		this.description = acompte.description;
		this.state = acompte.state;
	}
	
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getEffet() {
		return effet;
	}

	public void setEffet(Date effet) {
		this.effet = effet;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public ElementVariable getEltVariable() {
		return eltVariable;
	}

	public void setEltVariable(ElementVariable eltVariable) {
		this.eltVariable = eltVariable;
	}	

//	public Rubrique getRubrique() {
//		return rubrique;
//	}
//
//	public void setRubrique(Rubrique rubrique) {
//		this.rubrique = rubrique;
//	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Acompte de ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Acomptes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
	}
	
	

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("confirme", "Validée");
		states.add(state);
		state = new State("paye", "Payée");
		states.add(state);
		state = new State("annule", "Annulée");
		states.add(state);
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
	public int compareTo(Acompte arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
