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
@Table(name="T_LIPORH")
public class Absence extends BaseElement implements Serializable, Comparable<Absence> {

	/**
	 * 
	 */
	/**
	 * 
	 */
	private static final long serialVersionUID = -1500456322811875903L;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")
	@Predicate(label="Employé",type=Employe.class,target="many-to-one",optional=false,updatable=false,nullable=false,search=true)
	private Employe employe ;
	
	@Temporal(TemporalType.DATE)
//	@Predicate(label="Date du pointage",type=Date.class,target="date",editable=false,search=true,hi)
	private Date datepointage ;
	

	@ManyToOne
	@JoinColumn(name="POJO_ID")
	@Predicate(label="Journée concernée",type=PointageJouranlier.class,target="many-to-one",editable=false)
	private PointageJouranlier pointage ;	
	
	@Predicate(label="Heure arrivé",editable=false,target="time",search=true)
	private String heurearrive ;

	@Predicate(label="Heure de depart",editable=false,target="time",search=true)
	private String heuredepart ;
	
	@Predicate(label="Absent",type=Boolean.class,editable=false,search=true)
	private Boolean absent = Boolean.FALSE;
	
	@Predicate(label="Absent payée",type=Boolean.class,editable=false,search=true)
	private Boolean absencepaye = Boolean.FALSE;
	
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state ="etabli";

	/**
	 * 
	 */
	public Absence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Absence(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param datepointage
	 * @param heurearrive
	 * @param heuredepart
	 * @param absent
	 * @param absencepaye
	 * @param pointage
	 * @param state
	 */

	public Absence(long id, String designation, String moduleName, Employe employe, Date datepointage,
			String heurearrive, String heuredepart, Boolean absent, Boolean absencepaye, PointageJouranlier pointage,
			String state) {
		super(id, designation, moduleName,0L);
		this.employe = employe;
		this.datepointage = datepointage;
		this.heurearrive = heurearrive;
		this.heuredepart = heuredepart;
		this.absent = absent;
		this.absencepaye = absencepaye;
		this.pointage = pointage;
		this.state = state;
	}
	
	public Absence(Absence absence) {
		super(absence.id, absence.designation, absence.moduleName,absence.compareid);
		if(absence.employe!=null){
			this.employe = new Employe(absence.employe);
		}
		this.datepointage = absence.datepointage;
		this.heurearrive = absence.heurearrive;
		this.heuredepart = absence.heuredepart;
		this.absent = absence.absent;
		this.absencepaye = absence.absencepaye;
		if(absence.getPointage()!=null){
			this.pointage = new PointageJouranlier(absence.pointage);
		}//end if(absence.getPointage()!=null){
		this.state = absence.state;
	}

	
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Date getDatepointage() {
		return datepointage;
	}

	public void setDatepointage(Date datepointage) {
		this.datepointage = datepointage;
	}

	public String getHeurearrive() {
		return heurearrive;
	}

	public void setHeurearrive(String heurearrive) {
		this.heurearrive = heurearrive;
	}

	public String getHeuredepart() {
		return heuredepart;
	}

	public void setHeuredepart(String heuredepart) {
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

	public PointageJouranlier getPointage() {
		return pointage;
	}

	public void setPointage(PointageJouranlier pointage) {
		this.pointage = pointage;
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
		return "ABSENCE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "ABSENCES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
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
	public int compareTo(Absence arg0) {
		// TODO Auto-generated method stub
		return employe.compareTo(arg0.employe);
	}

}
