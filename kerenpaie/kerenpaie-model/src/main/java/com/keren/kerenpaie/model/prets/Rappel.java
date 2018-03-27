/**
 * 
 */
package com.keren.kerenpaie.model.prets;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_RAPPP")
public class Rappel extends BaseElement implements Serializable, Comparable<Rappel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -418456960336586821L;
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Salarié",type=Employe.class,target="many-to-one",optional=false,search=true)
	private Employe employe ;
	
	@Predicate(label="Type de rappel",target="combobox",values="Prise en charge salarial;Avancement;Reclassement;Nommination;Autres Rappels")
	private String type = "0";

	@Predicate(label="Date de début",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date debut ;
	
	@Predicate(label="Date de fin",type=Date.class,target="date",search=true)
	@Temporal(TemporalType.DATE)
	private Date fin ;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=true)
	@JoinColumn(name="RAP_ID")
	@Predicate(label="Ligne",type=LigneRappel.class,target="one-to-many",group=true,groupName="group1",groupLabel="Rappels")
	private List<LigneRappel> lignes = new ArrayList<LigneRappel>();
	
	private String state ="etabli";
	
	@ManyToOne
	@JoinColumn(name="RAPP_ID")
	private ElementVariable eltVariable ;
	
	/**
	 * 
	 */
	public Rappel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Rappel(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param type
	 * @param debut
	 * @param fin
	 * @param lignes
	 */

	public Rappel(long id, String designation, String moduleName, Employe employe, String type, Date debut, Date fin,
			List<LigneRappel> lignes) {
		super(id, designation, moduleName);
		this.employe = employe;
		this.type = type;
		this.debut = debut;
		this.fin = fin;
		this.lignes = lignes;
	}
	
	/**
	 * 
	 * @param rappel
	 */
	public Rappel(Rappel rappel) {
		super(rappel.id, rappel.designation, rappel.moduleName);
		if(rappel.employe!=null){
			this.employe = new Employe(rappel.employe);
		}
		this.type = rappel.type;
		this.debut = rappel.debut;
		this.fin = rappel.fin;
		this.state = rappel.state;
		if(rappel.eltVariable!=null){
			this.eltVariable = new ElementVariable(rappel.eltVariable);
		}
//		this.lignes = lignes;
	}
	
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public List<LigneRappel> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneRappel> lignes) {
		this.lignes = lignes;
	}
	
	

	public ElementVariable getEltVariable() {
		return eltVariable;
	}

	public void setEltVariable(ElementVariable eltVariable) {
		this.eltVariable = eltVariable;
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
		return "Rappel sur Salaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Rappels sur Salaire";
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
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("engage", "Engagé");
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
	public int compareTo(Rappel o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
