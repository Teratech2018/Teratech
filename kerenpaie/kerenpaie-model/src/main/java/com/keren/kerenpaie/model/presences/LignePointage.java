/**
 * 
 */
package com.keren.kerenpaie.model.presences;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIPORH")
public class LignePointage extends BaseElement implements Serializable, Comparable<LignePointage> {

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
	
	@Predicate(label="Heure arrivé",target="time",search=true)
	private String heurearrive ;
	
	@Predicate(label="Heure de depart",target="time",search=true)
	private String heuredepart ;
	
	@Predicate(label="Retard",type=Boolean.class,search=true)
	private Boolean retard = Boolean.FALSE;
	
	@Predicate(label="Absent",type=Boolean.class,search=true)
	private Boolean absent = Boolean.FALSE;
	
	@Predicate(label="Absent payée",type=Boolean.class,search=true)
	private Boolean absencepaye = Boolean.FALSE;
	
//	@ManyToOne
//	@JoinColumn(name="POJO_ID")
//	@JsonIgnore	
//	private PointageJouranlier pointage ;
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state ="etabli";

	/**
	 * 
	 */
	public LignePointage() {
		// TODO Auto-generated constructor stub
		state ="etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LignePointage(long id, String designation, String moduleName) {
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
	public LignePointage(long id, String designation, String moduleName, Employe employe, String heurearrive,
			String heuredepart, Boolean absent, Boolean absencepaye) {
		super(id, designation, moduleName,0L);
		this.employe = employe;
		this.heurearrive = heurearrive;
		this.heuredepart = heuredepart;
		this.absent = absent;
		this.absencepaye = absencepaye;
		state ="etabli";
		
	}
	
	/**
	 * 
	 * @param lign
	 */
	public LignePointage(LignePointage lign) {
		super(lign.id, lign.designation, lign.moduleName,lign.compareid);
		if(lign.employe!=null){
			this.employe = new Employe(lign.employe);
		}
		this.heurearrive = lign.heurearrive;
		this.heuredepart = lign.heuredepart;
		this.absent = lign.absent;
		this.retard = lign.retard;
		this.absencepaye = lign.absencepaye;
		this.datepointage = lign.datepointage;
		state =lign.state;
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

	public Boolean getAbsencepaye() {
		return absencepaye;
	}

	public void setAbsencepaye(Boolean absencepaye) {
		this.absencepaye = absencepaye;
	}	

	public Boolean getRetard() {
		return retard;
	}

	public void setRetard(Boolean retard) {
		this.retard = retard;
	}

//	public PointageJouranlier getPointage() {
//		return pointage;
//	}
//
//	public void setPointage(PointageJouranlier pointage) {
//		this.pointage = pointage;
//	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

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
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LignePointage o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}

}
