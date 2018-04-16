/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_FORMARH")
public class Formation extends BaseElement implements Serializable, Comparable<Formation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7091681592633928968L;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="MOFO_ID")
	@Predicate(label="Module de formation",type=ModuleFormation.class,target="many-to-one",editable=false,updatable=false,search=true)
	private ModuleFormation module ;
	
	@ManyToOne
	@JoinColumn(name="THEM_ID")
	@Predicate(label="Thème de la formation",type=ThemeFormation.class,target="many-to-one",editable=false,updatable=false,search=true)
	private ThemeFormation theme ;
	
	@ManyToOne
	@JoinColumn(name="LIPLFO_ID")
	@Predicate(label="Plan de Formation",type=LignePlanningFormation.class,target="many-to-one",editable=false,search=true)
	private LignePlanningFormation plan ;
	
	@OneToMany(mappedBy="formation",fetch=FetchType.LAZY)
	@Predicate(label=".",type=SeanceFormation.class,target="one-to-many",group=true,groupName="group1",groupLabel="Seances de Formation")
	private List<SeanceFormation> seances = new ArrayList<SeanceFormation>();
	
	@Predicate(label=".",target="textarea",group=true,groupName="group2",groupLabel="Description")
	private String note ;
	

	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";

	/**
	 * 
	 */
	public Formation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Formation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param module
	 * @param theme
	 * @param plan
	 * @param seances
	 * @param note
	 */

	public Formation(long id, String designation, String moduleName, String code, ModuleFormation module,
			ThemeFormation theme, LignePlanningFormation plan, List<SeanceFormation> seances, String note) {
		super(id, designation, moduleName);
		this.code = code;
		this.module = module;
		this.theme = theme;
		this.plan = plan;
		this.seances = seances;
		this.note = note;
	}
	
	public Formation(Formation formation) {
		super(formation.id, formation.designation, formation.moduleName);
		this.code = formation.code;
		if(formation.module!=null){
			this.module = new ModuleFormation(formation.module);
		}
		if(formation.theme!=null){
			this.theme = new ThemeFormation(formation.theme);
		}
		if(formation.plan!=null){
			this.plan = new LignePlanningFormation(formation.plan);
		}
//		this.seances = seances;
		this.note = formation.note;
		this.state = formation.state;
	}
	
	/**
	 * 
	 * @param plan
	 */
	public Formation(LignePlanningFormation plan){
		super(-1, null, null);
		this.code = plan.getModule().getDesignation();
		if(plan.getModule()!=null){
			this.module = new ModuleFormation(plan.getModule());
		}
		if(plan.getModule()!=null&&plan.getModule().getTheme()!=null){
			this.theme = new ThemeFormation(plan.getModule().getTheme());
		}
		this.plan = new LignePlanningFormation(plan);
		
//		this.seances = seances;
//		this.note = formation.note;
		this.state = "etabli";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public ModuleFormation getModule() {
		return module;
	}

	public void setModule(ModuleFormation module) {
		this.module = module;
	}

	public ThemeFormation getTheme() {
		return theme;
	}

	public void setTheme(ThemeFormation theme) {
		this.theme = theme;
	}

	public LignePlanningFormation getPlan() {
		return plan;
	}

	public void setPlan(LignePlanningFormation plan) {
		this.plan = plan;
	}

	public List<SeanceFormation> getSeances() {
		return seances;
	}

	public void setSeances(List<SeanceFormation> seances) {
		this.seances = seances;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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
		return "Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Formations";
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
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
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
	public int compareTo(Formation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
