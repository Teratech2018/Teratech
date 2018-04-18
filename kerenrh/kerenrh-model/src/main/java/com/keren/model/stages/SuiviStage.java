/**
 * 
 */
package com.keren.model.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.model.employes.Employe;
import com.keren.model.structures.Departement;
import com.keren.model.structures.Etablissement;
import com.keren.model.structures.NiveauEtude;
import com.keren.model.structures.Specialite;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_STAGERH")
public class SuiviStage extends BaseElement implements Serializable, Comparable<SuiviStage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2850156837807405991L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true,editable=false)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Nom & Prenom",optional=false,unique=true,search=true,editable=false)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="DEPAR_ID")
	@Predicate(label="Structure d'affectation",type=Departement.class,target="many-to-one",search=true,editable=false)
	private Departement departement ;	
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de debut effectif",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations du stage",search=true)
	private Date ddebutr ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin effectif",type=Date.class,target="date",group=true,groupName="group1",groupLabel="Informations du stage")
	private Date dfinr ;	
	
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	@Predicate(label="Encadreur professionnel",type=Employe.class,target="many-to-one",group=true,groupName="group1",groupLabel="Informations du stage",editable=false)
	private Employe encadreur ;  
	
	@Lob
	@Predicate(label="Portable du Stagiaire",target="richeditor",group=true,groupName="group5",groupLabel="Notes")
	private String note ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="SUISTA_ID")
	@Predicate(label=".",type=TacheStage.class,target="one-to-many",edittable=true,group=true,groupName="group2",groupLabel="Tâches")
	private List<TacheStage> taches = new ArrayList<TacheStage>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="SUISTA_ID")
	@Predicate(label=".",type=EvaluationStage.class,target="one-to-many",edittable=true,group=true,groupName="group3",groupLabel="Evaluation du Stage")
	private List<EvaluationStage> evaluations = new ArrayList<EvaluationStage>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="SUISTA_ID")
	@Predicate(label=".",type=LivrableStage.class,target="one-to-many",edittable=true,group=true,groupName="group4",groupLabel="Outils Livrés")
	private List<LivrableStage> livrables = new ArrayList<LivrableStage>();
	

//	@Predicate(label="Etat",hide=true,search=true)
	private String state = "etabli";
	
	
	/**
	 * 
	 */
	public SuiviStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public SuiviStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param nom
	 * @param type
	 * @param ecole
	 * @param departement
	 * @param specialite
	 * @param besion
	 * @param niveau
	 * @param note
	 * @param taches
	 * @param evaluations
	 * @param livrables
	 */

	public SuiviStage(long id, String designation, String moduleName, String code, String nom, String type,
			Etablissement ecole, Departement departement, Specialite specialite, BesionStage besion, NiveauEtude niveau,
			String note, List<TacheStage> taches, List<EvaluationStage> evaluations, List<LivrableStage> livrables) {
		super(id, designation, moduleName);
		this.code = code;
		this.nom = nom;
		this.departement = departement;
		this.note = note;
		this.taches = taches;
		this.evaluations = evaluations;
		this.livrables = livrables;
	}
	
	public SuiviStage(SuiviStage suivi) {
		super(suivi.id, suivi.designation, suivi.moduleName);
		this.code = suivi.code;
		this.nom = suivi.nom;
		this.ddebutr = suivi.ddebutr;
		this.dfinr = suivi.dfinr;
		if(suivi.encadreur!=null){
			this.encadreur = new Employe(suivi.encadreur);
		}//end if(suivi.encadreur!=null)
		if(suivi.departement!=null){
			this.departement = new Departement(suivi.departement);
		}
		this.note = suivi.note;
		this.state = suivi.state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
		
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	

	public Date getDdebutr() {
		return ddebutr;
	}

	public void setDdebutr(Date ddebutr) {
		this.ddebutr = ddebutr;
	}

	public Date getDfinr() {
		return dfinr;
	}

	public void setDfinr(Date dfinr) {
		this.dfinr = dfinr;
	}

	public Employe getEncadreur() {
		return encadreur;
	}

	public void setEncadreur(Employe encadreur) {
		this.encadreur = encadreur;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<TacheStage> getTaches() {
		return taches;
	}

	public void setTaches(List<TacheStage> taches) {
		this.taches = taches;
	}

	public List<EvaluationStage> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<EvaluationStage> evaluations) {
		this.evaluations = evaluations;
	}

	public List<LivrableStage> getLivrables() {
		return livrables;
	}

	public void setLivrables(List<LivrableStage> livrables) {
		this.livrables = livrables;
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
		return "Suivi des Stages";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Suivi des Stages";
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
		return super.getStates();
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
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
	public int compareTo(SuiviStage o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
