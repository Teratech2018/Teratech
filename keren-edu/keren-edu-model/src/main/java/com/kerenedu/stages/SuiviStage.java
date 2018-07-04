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
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_sstage")
public class SuiviStage extends BaseElement implements Serializable, Comparable<SuiviStage> {

	protected static final long serialVersionUID = 7741105795796486143L;

	@Column(name = "REF")
	@Predicate(label = "Reférence", optional = false, updatable = false, search = true, sequence = 1)
	protected String reference;
	
	@ManyToOne
	@JoinColumn(name = "BS_ID")
	@Predicate(label = "Ref. Besoin Stage", target = "many-to-one", type = BesionStage.class, search = true, sequence = 2)
	private BesionStage bstage;
	
	@ManyToOne
	@JoinColumn(name = "SERVI_ID")
	@Predicate(label = "Ref. Service d'affectation", target = "many-to-one", type = DivisionStage.class, search = true, sequence = 3)
	private DivisionStage service;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Début", type = Date.class, target = "date", optional = false, search = false, editable = false, sequence = 5)
	protected Date debut;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Fin", type = Date.class, target = "date", optional = false, search = false, editable = false, sequence =6)
	protected Date fin;

	@ManyToOne
	@JoinColumn(name = "CLS_ID")
	@Predicate(label = "Ref.Classe", target = "many-to-one", type = Classe.class, search = true, sequence = 4)
	private Classe classe;

	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "ETU_ID")
	@Predicate(target = "one-to-many",type = SuiviStageEleve.class,search = true,sequence=1
	, group = true, groupName = "tab1", groupLabel = "Stagiaires")
	private List<SuiviStageEleve> stagiaires ;
	

	
	protected String state ;

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
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}



	
	public SuiviStage(SuiviStage stage) {
		super(stage.id, stage.designation, stage.moduleName,0L);
		this.reference = stage.reference;
		this.bstage = new BesionStage(stage.bstage);
		this.service = new DivisionStage(stage.service);
		this.classe = new Classe(stage.classe);
		this.debut = stage.debut;
		this.fin = stage.fin;
		this.stagiaires = new ArrayList<SuiviStageEleve>();
		this.state = stage.state;
	}
	
	public SuiviStage(Stage stage) {;
		this.reference = stage.reference;
		this.bstage = new BesionStage(stage.getBstage());
		this.service = new DivisionStage(stage.getService());
		this.classe = new Classe(stage.getClasse());
		this.debut = stage.getDebut();
		this.fin = stage.getFin();
		this.stagiaires = new ArrayList<SuiviStageEleve>();
		for(Eleve ins:stage.getElevelist()){
			this.stagiaires.add(new SuiviStageEleve(ins,stage));
		}
		this.state = "etabli";
	}
	
	public SuiviStage(String reference, BesionStage bstage, Date debut, Date fin, Professeur prof, List<SuiviStageEleve> stagiaires,
			String motif, String state) {
		super();
		this.reference = reference;
		this.bstage = bstage;
		this.debut = debut;
		this.fin = fin;
		this.stagiaires = stagiaires;
		this.state = state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Suivi des Stagaiaires";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Suivi des Stagaiaires";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return reference;
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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


	
	public String getState() {
		return state;
	}

	public BesionStage getBstage() {
		return bstage;
	}

	public void setBstage(BesionStage bstage) {
		this.bstage = bstage;
	}


	public void setState(String state) {
		this.state = state;
	}

	public DivisionStage getService() {
		return service;
	}

	public void setService(DivisionStage service) {
		this.service = service;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<SuiviStageEleve> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<SuiviStageEleve> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public int compareTo(SuiviStage o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "Brouillon");
			states.add(etat);
			etat = new State("encours", "EnCours");
			states.add(etat);
			etat = new State("terminer", "Terminé");
			states.add(etat);
			
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
	
	
}
