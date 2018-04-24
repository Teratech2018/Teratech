/**
 * 
 */
package com.keren.kerenpaie.model.paie;

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
@Table(name="T_CONV")
public class Convension extends BaseElement implements Comparable<Convension>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 270403082233442524L;
	
	@Predicate(label="Reference",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String label ;
	
	@Predicate(label="Version",optional=true,search=true)
	private String version;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubrique",type=Rubrique.class,target="many-to-one",optional=false,search=true)
	private Rubrique rubrique;
	
	@Temporal(TemporalType.DATE)

	@Predicate(label="Date de début",target="date",type=Date.class,search=true)
	private Date debut;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",target="date",type=Date.class,search=true)
	private Date fin ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="LICOON_ID")
	@Predicate(label="Lignes",type=LigneConvension.class,target="one-to-many",group=true,groupName="group1",groupLabel="Lignes de la grille salariale",edittable=true)
	private List<LigneConvension> lignes = new ArrayList<LigneConvension>();
        
	private String state ="etabli";
	
	/**
	 * 
	 */
	public Convension() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Convension(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param label
	 * @param version
	 * @param rubrique
	 * @param debut
	 * @param fin
	 * @param lignes
	 */

	public Convension(long id, String designation, String moduleName, String code, String label, String version,
			Rubrique rubrique, Date debut, Date fin, List<LigneConvension> lignes) {
		super(id, designation, moduleName);
		this.code = code;
		this.label = label;
		this.version = version;
		this.rubrique = rubrique;
		this.debut = debut;
		this.fin = fin;
		this.lignes = lignes;
	}

	/**
	 * 
	 * @param convension
	 */
	public Convension(Convension convension) {
		super(convension.id, convension.designation, convension.moduleName);
		this.code = convension.code;
		this.label = convension.label;
		this.version = convension.version;
		if(convension.rubrique!=null){
			this.rubrique = new Rubrique(convension.rubrique);
		}
		this.debut = convension.debut;
		this.fin = convension.fin;

		this.state = convension.state;
//		this.lignes = lignes;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
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

	public List<LigneConvension> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneConvension> lignes) {
		this.lignes = lignes;
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
		return "Convention collective";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Conventions collectives";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
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
		state = new State("actif", "Actif");
		states.add(state);
		state = new State("inactif", "Inactif");
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
	public int compareTo(Convension arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
