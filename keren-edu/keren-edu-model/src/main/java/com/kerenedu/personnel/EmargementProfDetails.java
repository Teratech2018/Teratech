/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Matiere;

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
	@Predicate(label="MATIERE",updatable=true,type=Matiere.class , target="many-to-one",search=true , sequence=1	)
	protected Matiere matiere;
	
	@Column(name = "HEURE_DEBUT")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE DEBUT (Ex:6:30)",optional=false,updatable=false,search=true, type=String.class , sequence=2 , pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heuredebut;
	
	@Column(name = "HEURE_FIN")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE FIN (Ex:7:30)",optional=false,updatable=true,search=true, type=String.class, sequence=4, pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heurefin;
	
	@Column(name = "STATUT")
	@Predicate(label="STATUT ELEVE",optional=false,updatable=true,search=true, target="combobox", values="Validé;Non Validé" , sequence=3)
	protected String statut="0";


	public EmargementProfDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmargementProfDetails(Matiere matiere, String heurefin, String heuredebut,String statut) {
		super();
		this.matiere = matiere;
		this.heurefin = heurefin;
		this.heuredebut = heuredebut;
		this.statut = statut;
	}


	public EmargementProfDetails(EmargementProfDetails ins) {
		super(ins.id, ins.designation, ins.moduleName);
		
		this.matiere= new Matiere(ins.matiere);
		this.heurefin = ins.heurefin;
		this.heuredebut = ins.heuredebut;
		this.statut = ins.statut;

	
	
	}
	
	public EmargementProfDetails(TrancheHoraireCours ins) {
		this.matiere= new Matiere(ins.getMatiere().getMatiere());
		this.heurefin = ins.getHeurefin();
		this.heuredebut = ins.getHeuredebut();
		this.statut= "0";

	
	
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




	public Matiere getMatiere() {
		return matiere;
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


	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}



}
