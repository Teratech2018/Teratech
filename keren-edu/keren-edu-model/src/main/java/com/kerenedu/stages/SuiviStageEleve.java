/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_suvi_eleve")
public class SuiviStageEleve extends BaseElement implements Serializable, Comparable<SuiviStageEleve> {

	protected static final long serialVersionUID = 7741105795796486143L;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Ref. Etudiant Concerné", target = "many-to-one", type = Inscription.class, search = true, sequence = 1,updatable=false)
	private Eleve eleve;
	
	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label = "Ref. Encadreur ACC.", target = "many-to-one", type = Professeur.class, search = true, sequence = 2,updatable=true)
	private Professeur prof;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Début Réelle", type = Date.class, target = "date", optional = false, search = false, sequence = 3)
	protected Date debut;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Fin Réelle", type = Date.class, target = "date", optional = false, search = false, sequence =4)
	protected Date fin;
	
	@ManyToOne
	@JoinColumn(name = "SERVI_ID")
	@Predicate(label = "Ref. Service d'affectation", target = "many-to-one", type = DivisionStage.class, search = true, sequence = 5)
	private DivisionStage service;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name = "TACHE_ID")
	@Predicate(target = "one-to-many",type = TacheStage.class,search = true,sequence=1, group = true, groupName = "tab1", groupLabel = "Tâches")
	private List<TacheStage> taches = new ArrayList<TacheStage>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EVA_ID")
	@Predicate(target = "one-to-many",type = EvaluationStage.class,search = true,sequence=1, group = true, groupName = "tab2", groupLabel = "Evaluation du STage")
	private List<EvaluationStage> evaluation = new ArrayList<EvaluationStage>();
	
	@Column(name = "E_NOM")
	@Predicate(label = "Nom", type = String.class, updatable=true,search = false, sequence = 2,group = true, groupName = "tab3", groupLabel = "Encadreur Prof." )
	private String nom;
	
	@Column(name = "E_CONTACT")
	@Predicate(label = "Contact", type = String.class, updatable=true,search = false, sequence = 2,group = true, groupName = "tab3", groupLabel = "Encadreur Prof." )
	private String contact;
	
	@Column(name = "OBS")
	@Predicate( type = String.class, updatable=true,search = true, sequence =1,group = true, groupName = "tab4", groupLabel = "Notes" )
	private String obs;
	
	@Column(name = "VAL_FINAL")
	@Predicate(label="Appreciation Finale",optional=false,updatable=true,search=true, target="combobox", values="Mauvais;Médiocre;Moyen;Bien;Trein Bien; Excelent" , sequence=6)
	protected String app ;

	/**
	 * 
	 */
	public SuiviStageEleve() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public SuiviStageEleve(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}



	public SuiviStageEleve(Eleve eleve, Professeur prof, Date debut, Date fin, DivisionStage service,
			String obs, String nom, String contact, List<TacheStage> taches, List<EvaluationStage> evaluation,
			String app) {
		super();
		this.eleve = eleve;
		this.prof = prof;
		this.debut = debut;
		this.fin = fin;
		this.service = service;
		this.obs = obs;
		this.nom = nom;
		this.contact = contact;
		this.taches = taches;
		this.evaluation = evaluation;
		this.app = app;
	}
	
	public SuiviStageEleve(SuiviStageEleve sseleve) {
		super(sseleve.id, sseleve.designation, sseleve.moduleName);
		this.eleve = new Eleve(sseleve.eleve);
		this.prof = new Professeur(sseleve.prof);
		this.debut = sseleve.debut;
		this.fin = sseleve.fin;
		this.service = new DivisionStage(sseleve.service);
		this.obs = sseleve.obs;
		this.nom = sseleve.nom;
		this.contact = sseleve.contact;
		this.taches = new ArrayList<TacheStage>();
		this.evaluation = new ArrayList<EvaluationStage>();
		this.app = sseleve.app;
	}
	
	public SuiviStageEleve(Eleve sseleve,Stage suivi) {
		super();
		this.eleve = new Eleve(sseleve);
		this.prof = new Professeur(suivi.getProf());
		this.debut = new Date();
		this.fin = new Date();
		this.service = new DivisionStage(suivi.getService());
		this.obs = "";
		this.nom = "";
		this.contact ="";
		this.taches = new ArrayList<TacheStage>();
		this.evaluation = new ArrayList<EvaluationStage>();
		this.app = "";
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Suivi du Stage";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Suivi du Stage";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getDesignation();
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		serial = Long.toString(serialVersionUID);
		return serial;
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


	public DivisionStage getService() {
		return service;
	}

	public void setService(DivisionStage service) {
		this.service = service;
	}



	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Professeur getProf() {
		return prof;
	}

	public void setProf(Professeur prof) {
		this.prof = prof;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<TacheStage> getTaches() {
		return taches;
	}

	public void setTaches(List<TacheStage> taches) {
		this.taches = taches;
	}

	public List<EvaluationStage> getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(List<EvaluationStage> evaluation) {
		this.evaluation = evaluation;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public int compareTo(SuiviStageEleve o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
