/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="T_SEAFORMRH")
public class SeanceFormation extends BaseElement implements Serializable, Comparable<SeanceFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7710244902159305871L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de la séance",type=Date.class,target="date",optional=false,search=true)
	private Date date ;
	
	@Temporal(TemporalType.TIME)
	@Predicate(label="Heure de début",type=Date.class,target="time",optional=false,search=true)
	private Date hdebut ;
	
	@Temporal(TemporalType.TIME)
	@Predicate(label="Heure de fin",type=Date.class,target="time",optional=false,search=true)
	private Date hfin ;
	
	@ManyToMany
	@JoinTable(name="T_SEAN_FORM",joinColumns=@JoinColumn(name="SEAN_ID"),inverseJoinColumns=@JoinColumn(name="FORM_ID"))
	@Predicate(label="Formateurs",type=Formateur.class,target="many-to-many")
	private List<Formateur> formateurs = new ArrayList<Formateur>();
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Resumé du Cours")
	private String cours ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="PART_ID")
	@Predicate(label=".",type=ParticipantSeance.class,target="one-to-many",editable=false,edittable=true,group=true,groupName="group2",groupLabel="Presences ")
	private List<ParticipantSeance> participants = new ArrayList<ParticipantSeance>();
	
	

	/**
	 * 
	 */
	public SeanceFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public SeanceFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	public SeanceFormation(long id, String designation, String moduleName, String code, Date date, Date hdebut,
			Date hfin, List<Formateur> formateurs, String cours, List<ParticipantSeance> participants) {
		super(id, designation, moduleName);
		this.code = code;
		this.date = date;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.formateurs = formateurs;
		this.cours = cours;
		this.participants = participants;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getHdebut() {
		return hdebut;
	}

	public void setHdebut(Date hdebut) {
		this.hdebut = hdebut;
	}

	public Date getHfin() {
		return hfin;
	}

	public void setHfin(Date hfin) {
		this.hfin = hfin;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public String getCours() {
		return cours;
	}

	public void setCours(String cours) {
		this.cours = cours;
	}

	public List<ParticipantSeance> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantSeance> participants) {
		this.participants = participants;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Seance de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Seances de Formation";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}
	
	

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
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
		states.add(new State("valide", "Validée"));
		states.add(new State("rejete", "Rejetée"));
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
	public int compareTo(SeanceFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}
	
	

}
