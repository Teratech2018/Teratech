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

import com.core.base.BaseElement;
import com.core.tools.EnmHeureCours;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Matiere;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_tranchehoriarecours")
public class TrancheHoraireCours extends BaseElement implements Serializable, Comparable<TrancheHoraireCours> {
	
		
	@Column(name = "HEURE_DEBUT")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE DEBUT (Ex:6:30)",optional=false,updatable=false,search=true, type=String.class , sequence=2 , pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heuredebut;
	
	@Column(name = "HEURE_FIN")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE FIN (Ex:7:30)",optional=false,updatable=false,search=true, type=String.class, sequence=4, pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heurefin;
	
	@Column(name = "ZNHT")
	@Predicate(label="HEURE TOTAL",optional=false,updatable=false,search=false, type=Long.class, target="time", sequence=5, hide=true)
	protected Long heuretotal;

	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	@Predicate(label="MATIERE",updatable=true,type=Matiere.class , target="many-to-one",search=true , sequence=1	)
	protected Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label="PROFESSEUR",updatable=true,type=Professeur.class , target="many-to-one",search=true , sequence=3	)
	protected Professeur professeur;

//	@ManyToOne
//	@JoinColumn(name = "ANNEE_ID")
//	protected AnneScolaire anneScolaire;
	


	public TrancheHoraireCours() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TrancheHoraireCours(Matiere matiere,String heuredebut, String heurefin, Long heuretotal,Professeur professeur) {
		super();
		this.heuredebut = heuredebut;
		this.heuretotal = heuretotal;
		this.heurefin = heurefin;
		//this.anneScolaire = anneScolaire;
		this.matiere=matiere;
		this.professeur=professeur;
	}


	public TrancheHoraireCours(TrancheHoraireCours ins) {
		super(ins.id, ins.designation, ins.moduleName);
		
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.matiere= new Matiere(ins.matiere);
		this.heurefin = ins.heurefin;
		this.heuredebut = ins.heuredebut;
		this.heuretotal = ins.heuretotal;
		this.professeur = new Professeur(ins.professeur);
	
	}

	public TrancheHoraireCours(EnmHeureCours ins) {		
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.matiere= new Matiere();
		this.heurefin = ins.getHfin();
		this.heuredebut = ins.getHdeb();
		this.professeur= new Professeur();
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(TrancheHoraireCours o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Tranche Horaire ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Tranche Horaire ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return heuredebut+"-"+heurefin;
	}


	


	public String getHeuredebut() {
		return heuredebut;
	}


	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}


	public String getHeurefin() {
		return heurefin;
	}


	public Long getHeuretotal() {
		return heuretotal;
	}


	public void setHeuretotal(Long heuretotal) {
		this.heuretotal = heuretotal;
	}


	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public Professeur getProfesseur() {
		return professeur;
	}


	public void setProfesseur(Professeur professeur) {
		this.professeur = professeur;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



	
	

}
