/**
 * 
 */
package com.keren.kerenpaie.model.comptabilite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_PEPA") 
public class PeriodePaie extends BaseElement implements Serializable, Comparable<PeriodePaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -984562080325134277L;

	@Predicate(label="Reference période",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Actif",type=Boolean.class,editable=false,updatable=false)
	private Boolean actif = Boolean.TRUE;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Dossier de paie",type=Societe.class,target="many-to-one",optional=false,search=true)
	private Societe societe;
	
	@ManyToOne
	@JoinColumn(name="EXE_ID")
	@Predicate(label="Exercice concerné",type=ExerciceComptable.class,target="many-to-one",optional=false,search=true)
	private ExerciceComptable exercice ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de debut",type=Date.class,target="date",search=true)
	private Date ddebut;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",search=true)
	private Date dfin ;
	
	@OneToMany(mappedBy="periode",fetch=FetchType.LAZY)
        @JsonIgnore
//	@Predicate(label="Salaires",type=BulletinPaie.class,target="one-to-many",group=true,groupName="group2",groupLabel="SALAIRES")
	private List<BulletinPaie> salaires = new ArrayList<BulletinPaie>();
	
	@OneToMany(mappedBy="peiode",fetch=FetchType.LAZY)
        @JsonIgnore
//	@Predicate(label="Elements Variables",type=ElementVariable.class,target="one-to-many",group=true,groupName="group3",groupLabel="Elements Variables")
	private List<ElementVariable> variables = new ArrayList<ElementVariable>();
	
	private String state="etabli";
	/**
	 * 
	 */
	public PeriodePaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PeriodePaie(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param actif
	 * @param societe
	 * @param ddebut
	 * @param dfin
	 */

	public PeriodePaie(long id, String designation, String moduleName, String code, Boolean actif, Societe societe,
			Date ddebut, Date dfin) {
		super(id, designation, moduleName);
		this.code = code;
		this.actif = actif;
		this.societe = societe;
		this.ddebut = ddebut;
		this.dfin = dfin;
	}
	
	public PeriodePaie(PeriodePaie periode) {
		super(periode.id, periode.designation, periode.moduleName);
		this.code = periode.code;
		this.actif = periode.actif;
		if(periode.societe!=null){
			this.societe = new Societe(periode.societe);
		}
		if(periode.exercice!=null){
			this.exercice = new ExerciceComptable(periode.exercice);
		}
		this.ddebut = periode.ddebut;
		this.dfin = periode.dfin;
		this.state = periode.state;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
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
	
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ExerciceComptable getExercice() {
		return exercice;
	}

	public void setExercice(ExerciceComptable exercice) {
		this.exercice = exercice;
	}

	public List<BulletinPaie> getSalaires() {
		return salaires;
	}

	public void setSalaires(List<BulletinPaie> salaires) {
		this.salaires = salaires;
	}
	
	

	public List<ElementVariable> getVariables() {
		return variables;
	}

	public void setVariables(List<ElementVariable> variables) {
		this.variables = variables;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Période de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Périodes de paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
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
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Non ouvert");
		states.add(state);
		state = new State("ouvert", "Ouvert");
		states.add(state);
		state = new State("ferme", "Fermé");
		states.add(state);
		return states;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(PeriodePaie arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
