/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_sstgeel")
public class SuiviStageEleve extends BaseElement implements Serializable, Comparable<SuiviStageEleve> {

	protected static final long serialVersionUID = 7741105795796486143L;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Ref. Etudiant Concerné", target = "many-to-one", type = Inscription.class, search = true, sequence = 1,updatable=false)
	private Inscription inscription;
	
	@ManyToOne
	@JoinColumn(name = "BS_ID")
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

	@Column(name = "OBS")
	@Predicate( type = String.class, updatable=true,search = true, sequence =1,group = true, groupName = "tab1", groupLabel = "Notes" )
	private String obs;
	
	@Column(name = "E_NOM")
	@Predicate(label = "Nom", type = String.class, updatable=true,search = true, sequence = 2,group = true, groupName = "tab2", groupLabel = "Encadreur Prof." )
	private String nom;
	
	@Column(name = "E_CONTACT")
	@Predicate(label = "Contact", type = String.class, updatable=true,search = true, sequence = 2,group = true, groupName = "tab2", groupLabel = "Encadreur Prof." )
	private String contact;
	
	@OneToMany(fetch = FetchType.LAZY )
    @JoinColumn(name = "TACHE_ID")
	@Predicate(target = "one-to-many",type = TacheStage.class,search = true,sequence=1, group = true, groupName = "tab3", groupLabel = "Tâches")
	private List<TacheStage> taches = new ArrayList<TacheStage>();
	
	@OneToMany(fetch = FetchType.LAZY )
    @JoinColumn(name = "EVA_ID")
	@Predicate(target = "one-to-many",type = EvaluationStage.class,search = true,sequence=1, group = true, groupName = "tab4", groupLabel = "Evaluation du STage")
	private List<EvaluationStage> evaluation = new ArrayList<EvaluationStage>();
	
	@Column(name = "VAL_FINAL")
	@Predicate(label="Appreciation Finale",optional=false,updatable=true,search=false, target="combobox", values="Mauvais;Médiocre;Moyen;Bien;Trein Bien; Excelent" , sequence=6)
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



	public SuiviStageEleve(Inscription inscription, Professeur prof, Date debut, Date fin, DivisionStage service,
			String obs, String nom, String contact, List<TacheStage> taches, List<EvaluationStage> evaluation,
			String app) {
		super();
		this.inscription = inscription;
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
		super();
		this.inscription = new Inscription(sseleve.inscription);
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
		return inscription.getDesignation();
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



	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
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
