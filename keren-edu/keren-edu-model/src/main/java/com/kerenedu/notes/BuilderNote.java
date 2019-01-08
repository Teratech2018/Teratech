/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_bul_builder")
public class BuilderNote extends BaseElement implements Serializable, Comparable<BuilderNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210923131046279039L;

	@Column(name = "MOYT1")
	private Double moyt1 = new Double(0);

	@Column(name = "MOYT2")
	private Double moyt2 = new Double(0);

	@Column(name = "MOYT3")
	private Double moyt3 = new Double(0);
	
	@Column(name = "MOYANN")
	private Double moyan = new Double(0);
	
	
	@Column(name = "INSCRIPTION_ID")
	protected String inscriptionid;
	
	@Column(name = "ANNEE_ID")
	private String anneeScolaire ;
		public BuilderNote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BuilderNote(Double moyt1, Double moyt2, Double moyt3, Double moyan, String anneeScolaire) {
			super();
			this.moyt1 = moyt1;
			this.moyt2 = moyt2;
			this.moyt3 = moyt3;
			this.moyan = moyan;
			this.anneeScolaire = anneeScolaire;
		}


	public BuilderNote(BuilderNote bulletin) {
		super(bulletin.id, bulletin.designation, bulletin.moduleName, 0L);
		this.moyt1 = bulletin.moyt1;
		this.moyt2 = bulletin.moyt2;
		this.moyt3 = bulletin.moyt3;
		this.moyan = bulletin.moyan;
		this.anneeScolaire = bulletin.anneeScolaire;
		this.inscriptionid= bulletin.inscriptionid;
		
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de classe" ;
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return " Bulletin de classe";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}

	public int compareTo(BuilderNote o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Etabli");
		states.add(state);
		state = new State("valide", "Validé");
		states.add(state);
		return states;
	}


	public String getAnneeScolaire() {
		return anneeScolaire;
	}

	public void setAnneeScolaire(String anneeScolaire) {
		this.anneeScolaire = anneeScolaire;
	}

	

	public Double getMoyt1() {
		return moyt1;
	}

	public void setMoyt1(Double moyt1) {
		this.moyt1 = moyt1;
	}

	public Double getMoyt2() {
		return moyt2;
	}

	public void setMoyt2(Double moyt2) {
		this.moyt2 = moyt2;
	}

	public Double getMoyt3() {
		return moyt3;
	}

	public void setMoyt3(Double moyt3) {
		this.moyt3 = moyt3;
	}

	public Double getMoyan() {
		return moyan;
	}

	public void setMoyan(Double moyan) {
		this.moyan = moyan;
	}

	
	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}



	@Override
	public String toString() {
		return "BuilderNote [moyt1=" + moyt1 + ", moyt2=" + moyt2 + ", moyt3=" + moyt3 + ", moyan=" + moyan
				+ ", anneeScolaire=" + anneeScolaire + "]";
	}


	public String getInscriptionid() {
		return inscriptionid;
	}


	public void setInscriptionid(String inscriptionid) {
		this.inscriptionid = inscriptionid;
	}


	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

}
