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
public class Retard extends BaseElement implements Serializable, Comparable<Retard> {

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
	
	@Predicate(label="Heure de depart",target="time",search=true)
	private String heuredepart ;

	@Predicate(label="Heure arrivé",target="time",search=true)
	private String heurearrive ;
	
	@Predicate(label="Retard",type=Boolean.class,search=true,editable=false)
	private Boolean retard = Boolean.FALSE;
	
	@Predicate(label="Absent",type=Boolean.class,search=true)
	private Boolean absent = Boolean.FALSE;
	
	@ManyToOne
	@JoinColumn(name="POJO_ID")
	private PointageJouranlier pointage ;
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state ="etabli";

	/**
	 * 
	 */
	public Retard() {
		// TODO Auto-generated constructor stub
		state ="etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Retard(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
		state ="etabli";
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
	public Retard(long id, String designation, String moduleName, Employe employe, String heurearrive,
			String heuredepart, Boolean absent, Boolean absencepaye) {
		super(id, designation, moduleName,0L);
		this.employe = employe;
		this.heurearrive = heurearrive;
		this.heuredepart = heuredepart;
		this.absent = absent;
		state ="etabli";
		
	}
	
	/**
	 * 
	 * @param lign
	 */
	public Retard(Retard lign) {
		super(lign.id, lign.designation, lign.moduleName,lign.compareid);
		if(lign.employe!=null){
			this.employe = new Employe(lign.employe);
		}
		this.heurearrive = lign.heurearrive;
		this.heuredepart = lign.heuredepart;
		this.absent = lign.absent;
		this.retard = lign.retard;
		this.datepointage = lign.datepointage;
		state =lign.state;
	}
	
	/**
	 * 
	 * @param lign
	 */
	public Retard(LigneFichePointage lign) {
		super(-1, null, null,0L);
		if(lign.getEmploye()!=null){
			this.employe = new Employe(lign.getEmploye());
		}//end if(lign.getEmploye()!=null){
		this.heurearrive = lign.getHeurearrive();
		this.heuredepart = lign.getHeuredepart();
		this.absent = lign.getAbsent();
		this.datepointage = lign.getDatepointage();
		state ="etabli";
	}
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
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

	
	public Boolean getRetard() {
		return retard;
	}

	public void setRetard(Boolean retard) {
		this.retard = retard;
	}

	public PointageJouranlier getPointage() {
		return pointage;
	}

	public void setPointage(PointageJouranlier pointage) {
		this.pointage = pointage;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Retard ";
	}
	
	

	public Date getDatepointage() {
		return datepointage;
	}

	public void setDatepointage(Date datepointage) {
		this.datepointage = datepointage;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Retard";
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
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isDesabledelete() {
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
	public int compareTo(Retard o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}

}
