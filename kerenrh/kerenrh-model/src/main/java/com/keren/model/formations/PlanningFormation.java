/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_PLAFORRH")
public class PlanningFormation extends BaseElement implements Serializable, Comparable<PlanningFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3225436215346112372L;
	
	@Predicate(label="Reference",unique=true,optional=false,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String intitule ;
	
	@ManyToOne
	@JoinColumn(name="BEFOR_ID")
	@Predicate(label="Besion de Formation",type=BesionFormation.class,target="many-to-one",search=true,optional=false,updatable=false)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"valide\"}]")
	private BesionFormation besion ;
	
	@Predicate(label="Période",target="combobox",values="1er Trimestre;2ème Trimestre;3ème Trimestre;4ème Trimestre;1er Semestre;2ème Semestre")
	private String periode ="0";
	
	@Predicate(label="Nombre total de participants",type=Short.class,editable=false,updatable=false,search=true)
	private Short places = 0;

	@OneToMany(mappedBy="planning",fetch=FetchType.LAZY)
//	@JoinColumn(name="PLAFOR_ID")
	@Predicate(label=".",type=LignePlanningFormation.class,target="one-to-many",group=true,groupName="group1",groupLabel="Calendrier de Formation")
	private List<LignePlanningFormation> lignes = new ArrayList<LignePlanningFormation>();
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public PlanningFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PlanningFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param intitule
	 * @param besion
	 * @param periode
	 * @param places
	 */

	public PlanningFormation(long id, String designation, String moduleName, String code, String intitule,
			BesionFormation besion, String periode, Short places) {
		super(id, designation, moduleName);
		this.code = code;
		this.intitule = intitule;
		this.besion = besion;
		this.periode = periode;
		this.places = places;
	}
	
	/**
	 * 
	 * @param planning
	 */
	public PlanningFormation(PlanningFormation planning) {
		super(planning.id, planning.designation, planning.moduleName);
		this.code = planning.code;
		this.intitule = planning.intitule;
		if(planning.besion!=null){
			this.besion = new BesionFormation(planning.besion);
		}
		this.periode = planning.periode;
		this.places = planning.places;
		this.state = planning.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public BesionFormation getBesion() {
		return besion;
	}

	public void setBesion(BesionFormation besion) {
		this.besion = besion;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public Short getPlaces() {
		return places;
	}

	public void setPlaces(Short places) {
		this.places = places;
	}

	public List<LignePlanningFormation> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePlanningFormation> lignes) {
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
		return "Planning de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Planning des Formations";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule;
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
		states.add(new State("valide", "Validé"));
		states.add(new State("encours", "En Exécution"));
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
	public int compareTo(PlanningFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
