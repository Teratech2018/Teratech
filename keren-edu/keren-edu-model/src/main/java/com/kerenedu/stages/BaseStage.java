/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_stage")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ES", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("S")
public class BaseStage extends BaseElement implements Serializable, Comparable<BaseStage> {

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
	@Predicate(label = "Date Début", type = Date.class, target = "date", optional = false, search = false, editable = true, sequence = 5)
	protected Date debut;

	@Temporal(TemporalType.DATE)
	@Predicate(label = "Date Fin", type = Date.class, target = "date", optional = false, search = false, editable = true, sequence =6)
	protected Date fin;

	@ManyToOne
	@JoinColumn(name = "CLS_ID")
	@Predicate(label = "Ref.Classe", target = "many-to-one", type = Classe.class, search = true, sequence = 4)
	private Classe classe;

	
	@ManyToMany(fetch = FetchType.LAZY )
    @JoinColumn(name = "ETU_ID")
	@Predicate(target = "many-to-many-list",type = Inscription.class,search = true,sequence=1
	, group = true, groupName = "tab1", groupLabel = "Etudiants concernés")
	private List<Inscription> elevelist = new ArrayList<Inscription>();
	
	@Predicate( target = "textarea", group = true, groupName = "tab2", groupLabel = "notes",sequence=2)
	@Column(name = "MOTIF")
	protected String motif;

	
	protected String state ;

	/**
	 * 
	 */
	public BaseStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BaseStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}



	
	public BaseStage(BaseStage stage) {
		super(stage.id, stage.designation, stage.moduleName);
		this.reference = stage.reference;
		this.bstage = new BesionStage(stage.bstage);
		this.service = new DivisionStage(stage.service);
		this.classe = new Classe(stage.classe);
		this.debut = stage.debut;
		this.fin = stage.fin;
		this.elevelist = new ArrayList<Inscription>();
		this.motif = stage.motif;
		this.state = stage.state;
	}
	
	public BaseStage(String reference, BesionStage bstage, Date debut, Date fin, Professeur prof, List<Inscription> elevelist,
			String motif, String state) {
		super();
		this.reference = reference;
		this.bstage = bstage;
		this.debut = debut;
		this.fin = fin;
		this.elevelist = elevelist;
		this.motif = motif;
		this.state = state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Stage";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Stage";
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



	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
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


	public List<Inscription> getElevelist() {
		return elevelist;
	}

	public void setElevelist(List<Inscription> elevelist) {
		this.elevelist = elevelist;
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

	public int compareTo(BaseStage o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
