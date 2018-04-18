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
public class Mission extends BaseElement implements Serializable, Comparable<Mission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2605223720860489103L;
	
	@Predicate(label="Reference",optional=false,search=true)
	private String code ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de création",type=Date.class,target="date",editable=false,search=true)
	private Date dcreation ;
	
	@Predicate(label="Libellé",search=true,optional=false)
	private String intitule ;        
        
	@Predicate(label="Type de mission",target="combobox",values="Locale;Internationale",optional=false)
	private String type ="0";
	
//	@ManyToOne
//	@JoinColumn(name="CATMIS_ID")
//	@Predicate(label="Catégorie de Mission",type=CategorieFrais.class,target="many-to-one")
//	private CategorieMission categorie ;
        
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de validation",type=Date.class,target="date")
	private Date dvalidation ;
	
        @Temporal(TemporalType.DATE)
	@Predicate(label="Date d'approbation",type=Date.class,target="date")
	private Date dapprob ;
	
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de début",type=Date.class,target="date",search=true)
	private Date ddebut ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",search=true)
	private Date dfin ;	

	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de cloture",type=Date.class,target="date")
	private Date dcloture ;
	
	@Predicate(label="Coût total",type=Double.class,editable=false,updatable=false)
	private Double cout ;
	
	@OneToMany(mappedBy="mission",fetch=FetchType.LAZY) 
	@Predicate(label=".",type=OrdreMission.class,target="one-to-many",group=true,groupName="group2",groupLabel="Ordres de missions")
	private List<OrdreMission> missions = new ArrayList<OrdreMission>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="MISS_ID")
	@Predicate(label=".",type=Deploiement.class,target="one-to-many",group=true,groupName="group3",groupLabel="Plan de déploiement",edittable=true)
	private List<Deploiement> depoiements = new ArrayList<Deploiement>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="MISS_ID")
	@Predicate(label=".",type=ActionMission.class,target="one-to-many",group=true,groupName="group4",groupLabel="Actions à mener",edittable=true)
	private List<ActionMission> actions = new ArrayList<ActionMission>();
	
	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";

	/**
	 * 
	 */
	public Mission() {
		// TODO Auto-generated constructor stub
            state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Mission(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
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

	public Mission(long id, String designation, String moduleName, String code, Date dcreation, String intitule,
			Date dvalidation, String type, Date dapprob, CategorieMission categorie, Date dcloture, Date ddebut,
			Date dfin, Double cout) {
		super(id, designation, moduleName);
		this.code = code;
		this.dcreation = dcreation;
		this.intitule = intitule;
		this.dvalidation = dvalidation;
		this.type = type;
		this.dapprob = dapprob;
//		this.categorie = categorie;
		this.dcloture = dcloture;
		this.ddebut = ddebut;
		this.dfin = dfin;
		this.cout = cout;
	}
	
	public Mission(Mission mission) {
		super(mission.id, mission.designation, mission.moduleName);
		this.code = mission.code;
		this.dcreation = mission.dcreation;
		this.intitule = mission.intitule;
		this.dvalidation = mission.dvalidation;
		this.type = mission.type;
		this.dapprob = mission.dapprob;
//		if(mission.categorie!=null){
//			this.categorie = new CategorieMission(mission.categorie);
//		}
		this.dcloture = mission.dcloture;
		this.ddebut = mission.ddebut;
		this.dfin = mission.dfin;
		this.cout = mission.cout;
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

	public Date getDvalidation() {
		return dvalidation;
	}

	public void setDvalidation(Date dvalidation) {
		this.dvalidation = dvalidation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDapprob() {
		return dapprob;
	}

	public void setDapprob(Date dapprob) {
		this.dapprob = dapprob;
	}

//	public CategorieMission getCategorie() {
//		return categorie;
//	}
//
//	public void setCategorie(CategorieMission categorie) {
//		this.categorie = categorie;
//	}

	public Date getDcloture() {
		return dcloture;
	}

	public void setDcloture(Date dcloture) {
		this.dcloture = dcloture;
	}

	public Date getDdebut() {
		return ddebut;
	}

	public void setDdebut(Date ddebut) {
		this.ddebut = ddebut;
	}

	public Date getDfin() {
		return dfin;
	}

	public void setDfin(Date dfin) {
		this.dfin = dfin;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<OrdreMission> getMissions() {
		return missions;
	}

	public void setMissions(List<OrdreMission> missions) {
		this.missions = missions;
	}

	public List<Deploiement> getDepoiements() {
		return depoiements;
	}

	public void setDepoiements(List<Deploiement> depoiements) {
		this.depoiements = depoiements;
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
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Mission o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
