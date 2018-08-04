/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.tools.DateHelper;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.notes.CoefMatiereDetail;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_emarge_dlt")
public class EmargementProfDetails extends BaseElement implements Serializable, Comparable<EmargementProfDetails> {
	
	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	@Predicate(label="Matière",updatable=false,type=MatiereDlt.class , target="many-to-one",search=true , sequence=1 ,colsequence=1	)
	protected CoefMatiereDetail matiere;
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "P_ID")
	@Predicate(label="Professeur",updatable=false,type=Professeur.class , target="many-to-one",search=true , sequence=2	,colsequence=2)
	protected Professeur prof;
	
	@Column(name = "HEURE_DEBUT")
	@Predicate(label="Heure Début(Ex:6:30)",optional=false,updatable=true, type=String.class , search=true,sequence=3 , target="time",colsequence=3)
	protected String heuredebut;
	
	@Column(name = "HEURE_FIN")
	@Predicate(label="Heure Fin(Ex:7:30)",optional=false,updatable=true, type=String.class, sequence=4,search=true, target="time",colsequence=4)
	protected String heurefin;
	
	@Column(name = "HTEMARG")
	@Predicate(label="Total Heure",updatable=false,search=true,  sequence=5, type=Double.class, editable=false,colsequence=5)
	protected Double heuretotal;
	
	@Column(name = "STATUT")
	@Predicate(label="Statut",type=Boolean.class,search=true,colsequence=6)
	private Boolean statut = Boolean.FALSE;

	public EmargementProfDetails() {
		super();
		// TODO Auto-generated constructor stub
	}




	public EmargementProfDetails(EmargementProfDetails ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		if(ins.getMatiere() !=null){
		this.matiere= new CoefMatiereDetail(ins.matiere);
		this.prof = new Professeur(ins.matiere.getProffesseur());
		}
		this.heurefin = ins.heurefin;
		this.heuredebut = ins.heuredebut;
		this.heuretotal = ins.heuretotal;
		this.statut = ins.statut;

	
	
	}
	
	public EmargementProfDetails(CoefMatiereDetail matiere, Professeur prof, String heuredebut, String heurefin,
			Boolean statut) {
		super();
		this.matiere = matiere;
		this.prof = prof;
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.heuretotal= DateHelper.hours(heuredebut, heurefin, new Date());
		this.statut = statut;
	}




	public EmargementProfDetails(TrancheHoraireCours ins) {
		
		if(ins.matiere!=null){
			this.matiere= new CoefMatiereDetail(ins.getMatiere());
			this.prof= new Professeur(ins.getMatiere().getProffesseur());
		}
		this.heurefin = ins.getHeurefin();
		this.heuredebut = ins.getHeuredebut();
		this.heuretotal= DateHelper.hours(heuredebut, heurefin, new Date());
		this.statut=Boolean.FALSE;

	
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EmargementProfDetails o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des cours";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des cours";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return id+"";
	}




	public CoefMatiereDetail getMatiere() {
		return matiere;
	}


	public String getHeuredebut() {
		return heuredebut;
	}


	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}


	public Professeur getProf() {
		return prof;
	}




	public void setProf(Professeur prof) {
		this.prof = prof;
	}




	public String getHeurefin() {
		return heurefin;
	}


	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}


	public Boolean getStatut() {
		return statut;
	}


	public void setStatut(Boolean statut) {
		this.statut = statut;
	}


	public Double getHeuretotal() {
		return heuretotal;
	}




	public void setHeuretotal(Double heuretotal) {
		this.heuretotal = heuretotal;
	}




	public void setMatiere(CoefMatiereDetail matiere) {
		this.matiere = matiere;
	}



}
