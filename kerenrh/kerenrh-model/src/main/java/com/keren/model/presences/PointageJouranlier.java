/**
 * 
 */
package com.keren.model.presences;

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
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_POJO")
public class PointageJouranlier extends BaseElement implements Serializable, Comparable<PointageJouranlier> {

	/**
	 *  
	 */
	private static final long serialVersionUID = 7027189051167266574L;
	
	@Predicate(label="Intitulé" ,optional=false,search=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de la feuille de presence",type=Date.class,target="date",optional=false,search=true)
	private Date date ;
	
	@ManyToOne
	@JoinColumn(name="FIPO_ID")
	@Predicate(label="Fiche de pointage",type=FichePointage.class,target="many-to-one",updatable=false,search=true)
	private FichePointage fiche ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="FIPO_ID")
	@Predicate(label="Fiche pointage",type=LigneFichePointage.class,target="one-to-many",group=true,groupName="group1",groupLabel="POINTAGES")
	private List<LignePointage> lignes =new ArrayList<LignePointage>();
	
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
		super(id, designation, moduleName);
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
		super(id, designation, moduleName);
		this.code = code;
		this.date = date;
		this.fiche = fiche;
		this.lignes = lignes;
		state = "etabli";
	}
	
	/**
	 * 
	 * @param p
	 */
	public PointageJouranlier(PointageJouranlier p) {
		super(p.id, p.designation, p.moduleName);
		this.code = p.code;
		this.date = p.date;
		state = p.state;
		if(p.fiche!=null){
			this.fiche = new FichePointage(p.fiche);
		}

        for(LignePointage lig:p.lignes){
        	this.lignes.add(new LignePointage(lig));
        }
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