/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Pays;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIPLFORH")
public class LignePlanningFormation extends BaseElement implements Serializable, Comparable<LignePlanningFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8070044086967830345L;
	
	
	@ManyToOne
	@JoinColumn(name="MOFOR_ID")
	@Predicate(label="Module de Formation",type=ModuleFormation.class,target="many-to-one",optional=false,search=true)
	private ModuleFormation module ;	

	@ManyToOne
	@JoinColumn(name="PAYS_ID")
	@Predicate(label="Pays",type=Pays.class,target="many-to-one",search=true)
	private Pays pays ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de début",type=Date.class,target="date",search=true)
	private Date ddebut ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",search=true)
	private Date dfin ;		
	
	@Predicate(label="Durée(Jours)",type=Short.class,editable=false)
	private Short duree =0 ;
	
	@Predicate(label="Effectif à former",type=Short.class,search=true,editable=false)
	private Short places=0;

	@Predicate(label="Numéro",type=Short.class,hide=true)
	private Short num ;
	
	
	@ManyToMany
	@JoinTable(name="LIPLAFOR_EMPL",joinColumns=@JoinColumn(name="LIPLFO_ID"),inverseJoinColumns=@JoinColumn(name="EMPL_ID"))
	@Predicate(label=".",type=Employe.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Public cible")
	private List<Employe> cibles = new ArrayList<Employe>();


	@ManyToOne
	@JoinColumn(name="PLAFOR_ID")
	@JsonIgnore
	private PlanningFormation planning ;
	
	@Predicate(label="Formateur",type=Formateur.class,group=true,groupName="group2",groupLabel="Formations")
	@ManyToOne
	@JoinColumn(name="FORMA_ID")
	private Formateur formateur ;
	
	@ManyToMany
	@JoinTable(name="LIPLAFOR_FORM",joinColumns=@JoinColumn(name="LIPLFO_ID"),inverseJoinColumns=@JoinColumn(name="EMPL_ID"))
	@Predicate(label=".",type=Employe.class,target="many-to-many-list",group=true,groupName="group3",groupLabel="Formateurs Interne")
	private List<Employe> internes = new ArrayList<Employe>();
	

	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	/**
	 * 
	 */
	public LignePlanningFormation() {
		// TODO Auto-generated constructor stub
		this.state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LignePlanningFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
		state = "etabli";
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param num
	 * @param module
	 * @param planning
	 * @param ddebut
	 * @param dfin
	 * @param places
	 * @param pays
	 * @param cibles
	 */

	public LignePlanningFormation(long id, String designation, String moduleName, Short num, ModuleFormation module,
			PlanningFormation planning, Date ddebut, Date dfin, Short places, Pays pays, List<Employe> cibles) {
		super(id, designation, moduleName);
		this.num = num;
		this.module = module;
//		this.planning = planning;
		this.ddebut = ddebut;
		this.dfin = dfin;
		this.places = places;
		this.pays = pays;
		this.cibles = cibles;
	}
	
	public LignePlanningFormation(LignePlanningFormation ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName);
		this.num = ligne.num;
		if(ligne.module!=null){
			this.module = new ModuleFormation(ligne.module);
		}

		this.ddebut = ligne.ddebut;
		this.dfin = ligne.dfin;
		this.places = ligne.places;
		if(ligne.pays!=null){
			this.pays = new Pays(ligne.pays);
		}
		if(ligne.formateur!=null){
			this.formateur = new Formateur(ligne.formateur);
		}
		this.state = ligne.state;
//		this.cibles = cibles;
	}
	
	

	public Short getNum() {
		return num;
	}

	public void setNum(Short num) {
		this.num = num;
	}

	public ModuleFormation getModule() {
		return module;
	}

	public void setModule(ModuleFormation module) {
		this.module = module;
	}

	public PlanningFormation getPlanning() {
		return planning;
	}

	public void setPlanning(PlanningFormation planning) {
		this.planning = planning;
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

	public Short getPlaces() {
		return places;
	}

	public void setPlaces(Short places) {
		this.places = places;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public List<Employe> getCibles() {
		return cibles;
	}

	public void setCibles(List<Employe> cibles) {
		this.cibles = cibles;
	}
	
	

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public List<Employe> getInternes() {
		return internes;
	}

	public void setInternes(List<Employe> internes) {
		this.internes = internes;
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
		return "Calendrier Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Calendriers Formations";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return module.getDesignation();
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
		states.add(new State("etabli","Brouillon"));
		states.add(new State("valide","Validée"));
		states.add(new State("demarre","Démarrée"));
		states.add(new State("termine","Terminée"));
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
	public int compareTo(LignePlanningFormation o) {
		// TODO Auto-generated method stub
		return num.compareTo(o.num);
	}

}
