/**
 * 
 */
package com.keren.model.presences;

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
@Table(name="T_LIFIPO")
public class LigneFichePointage extends BaseElement implements Serializable, Comparable<LigneFichePointage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1500456322811875903L;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,nullable=false,search=true)
	private Employe employe ;
	
	@Temporal(TemporalType.TIME)
	@Predicate(label="Date du pointage",type=Date.class,target="date",search=true)
	private Date datepointage ;
	
	@Temporal(TemporalType.TIME)
	@Predicate(label="Heure arrivé",type=Date.class,target="time",search=true)
	private Date heurearrive ;
	
	@Temporal(TemporalType.TIME)
	@Predicate(label="Heure de depart",type=Date.class,target="time",search=true)
	private Date heuredepart ;
	
	@Predicate(label="Absent",type=Boolean.class,search=true)
	private Boolean absent = Boolean.FALSE;
	
	@Predicate(label="Absent payée",type=Boolean.class,search=true)
	private Boolean absencepaye = Boolean.FALSE;
	
	

	/**
	 * 
	 */
	public LigneFichePointage() {
		// TODO Auto-generated constructor stub
//		state ="etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneFichePointage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
//		state ="etabli";
	}
	
	
/**
 * 
 * @param id
 * @param designation
 * @param moduleName
 * @param employe
 * @param heurearrive
 * @param heuredepart
 * @param absent
 * @param absencepaye
 */
	public LigneFichePointage(long id, String designation, String moduleName, Employe employe, Date heurearrive,
			Date heuredepart, Boolean absent, Boolean absencepaye) {
		super(id, designation, moduleName);
		this.employe = employe;
		this.heurearrive = heurearrive;
		this.heuredepart = heuredepart;
		this.absent = absent;
		this.absencepaye = absencepaye;
//		state ="etabli";
		
	}
	
	public LigneFichePointage(LigneFichePointage lign) {
		super(lign.id, lign.designation, lign.moduleName);
		this.employe = lign.employe;
		this.heurearrive = lign.heurearrive;
		this.heuredepart = lign.heuredepart;
		this.absent = lign.absent;
		this.absencepaye = lign.absencepaye;
		this.datepointage = lign.datepointage;
//		state =lign.state;
	}
	
	
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getHeurearrive() {
		return heurearrive;
	}

	public void setHeurearrive(Date heurearrive) {
		this.heurearrive = heurearrive;
	}

	public Date getHeuredepart() {
		return heuredepart;
	}

	public void setHeuredepart(Date heuredepart) {
		this.heuredepart = heuredepart;
	}

	public Boolean getAbsent() {
		return absent;
	}

	public void setAbsent(Boolean absent) {
		this.absent = absent;
	}

	public Boolean getAbsencepaye() {
		return absencepaye;
	}

	public void setAbsencepaye(Boolean absencepaye) {
		this.absencepaye = absencepaye;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "POINTANGE "+(employe==null ? "":" / "+employe.getNom());
	}
	
	

	public Date getDatepointage() {
		return datepointage;
	}

	public void setDatepointage(Date datepointage) {
		this.datepointage = datepointage;
	}

//	public String getState() {
//		return state;
//	}
//
//	public void setState(String state) {
//		this.state = state;
//	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "ABSENCES NON JUSTIFIEES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
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
		State etat = new State("etabli", "Brouillon");
		states.add(etat);
		etat = new State("justifier", "Justifiée");
		states.add(etat);
		etat = new State("nonjustifier", "non justifiée");
		states.add(etat);
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
	public int compareTo(LigneFichePointage o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}

}
