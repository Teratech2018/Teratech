/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name="T_MISSIRH")
public class ResultatMission extends BaseElement implements Serializable, Comparable<ResultatMission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605223720860489103L;
	
	@Predicate(label="Reference",optional=false,updatable=false,search=true)
	private String code ;
	
	@Predicate(label="Libellé",updatable=false,search=true)
	private String intitule ;	

	
	@Predicate(label="Type de mission",target="combobox",values="Locale;Internationale",updatable=false)
	private String type ="0";
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de création",type=Date.class,target="date",editable=false,updatable=false)
	private Date dcreation ;	
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="MISS_ID")
	@Predicate(label=".",type=ActionMission.class,target="one-to-many",group=true,groupName="group4",groupLabel="Actions à mener",edittable=true)
	private List<ActionMission> actions = new ArrayList<ActionMission>();

//	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public ResultatMission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ResultatMission(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param dcreation
	 * @param intitule
	 * @param dvalidation
	 * @param type
	 * @param dapprob
	 * @param categorie
	 * @param dcloture
	 * @param ddebut
	 * @param dfin
	 * @param cout
	 */

	public ResultatMission(long id, String designation, String moduleName, String code, Date dcreation, String intitule,
			Date dvalidation, String type, Date dapprob, CategorieMission categorie, Date dcloture, Date ddebut,
			Date dfin, Double cout) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.dcreation = dcreation;
		this.intitule = intitule;
		
	}
	
	public ResultatMission(ResultatMission mission) {
		super(mission.id, mission.designation, mission.moduleName,mission.compareid);
		this.code = mission.code;
		this.dcreation = mission.dcreation;
		this.intitule = mission.intitule;
		this.state = mission.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDcreation() {
		return dcreation;
	}

	public void setDcreation(Date dcreation) {
		this.dcreation = dcreation;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ActionMission> getActions() {
		return actions;
	}

	public void setActions(List<ActionMission> actions) {
		this.actions = actions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "Mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Missions";
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
		states.add(new State("valide", "Validée"));
		states.add(new State("encours", "En Cours"));
		states.add(new State("termine", "Terminée"));
		states.add(new State("annule", "Annulée"));
		return states;
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ResultatMission o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
