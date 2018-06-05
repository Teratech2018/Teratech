/**
 * 
 */
package com.keren.model.presences;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
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
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_POJORH")
public class PointageJouranlier extends BaseElement implements Serializable, Comparable<PointageJouranlier> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 7027189051167266574L;
	
	@Predicate(label="Intitulé" ,optional=false,search=true,unique=true)
	@Column(unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="FIPO_ID")
	@Predicate(label="Fiche de pointage",type=FichePointage.class,target="many-to-one",updatable=true,search=true,observable=true)
	private FichePointage fiche ;

	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de la feuille de presence",type=Date.class,target="date",updatable=true,optional=false,search=true)
	private Date datepointage ;
	
	@OneToMany(mappedBy="pointage",fetch=FetchType.LAZY)
	@Predicate(label="Fiche pointage",type=LignePointage.class,target="one-to-many",group=true,groupName="group1",groupLabel="POINTAGES",edittable=true)
	@Observer(observable="fiche",source="method:presence",parameters="datepointage")
	private List<LignePointage> lignes =new ArrayList<LignePointage>();
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";

	/**
	 * 
	 */
	public PointageJouranlier() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PointageJouranlier(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
		state = "etabli";
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param date
	 * @param fiche
	 * @param lignes
	 */
	public PointageJouranlier(long id, String designation, String moduleName, String code, Date date,
			FichePointage fiche, List<LignePointage> lignes) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.datepointage = date;
		this.fiche = fiche;
		this.lignes = lignes;
		state = "etabli";
	}
	
	/**
	 * 
	 * @param p
	 */
	public PointageJouranlier(PointageJouranlier p) {
		super(p.id, p.designation, p.moduleName,p.compareid);
		this.code = p.code;
		this.datepointage = p.datepointage;
		state = p.state;
		if(p.fiche!=null){
			this.fiche = new FichePointage(p.fiche);
		}       
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setDatepointage(Date datepointage) {
		this.datepointage = datepointage;
	}

	
	public FichePointage getFiche() {
		return fiche;
	}

	public void setFiche(FichePointage fiche) {
		this.fiche = fiche;
	}

	public List<LignePointage> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePointage> lignes) {
		this.lignes = lignes;
	}
	
	

	public Date getDatepointage() {
		return datepointage;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "POINTAGE JOURNEE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "POINTAGES JOURNALIER";
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
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State etat = new State("etabli", "Brouillon");
		states.add(etat);
		etat = new State("confirmer", "Validé");
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
	public int compareTo(PointageJouranlier o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
