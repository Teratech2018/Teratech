/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.inscription.Inscription;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_zview_helper_ligne")
public class LigneHelper extends BaseElement implements Serializable, Comparable<LigneHelper> {

	@ManyToOne
	@JoinColumn(name = "INS_ID")
	protected Inscription inscription;


	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "BULL_ID")
	protected Bulletin bulletin;
	
	@ManyToOne
	@JoinColumn(name = "LGN_ID")
	protected LigneBulletinClasse ligne;
	
	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	protected MatiereDlt matiere;
	
//	@ManyToOne
//	@JoinColumn(name = "EXAMEN_ID")
//	protected Examen examen;

	@Column(name = "ANNEE_ID")
	private String anneeid;

	
	@Column(name = "NOTET1")
	private Double notet1 = new Double(0);

	@Column(name = "NOTET2")
	private Double notet2 = new Double(0);

	@Column(name = "NOTET3")
	private Double notet3 = new Double(0);
	
	@Column(name = "NOTEAN")
	private Double notean = new Double(0);

	
	public LigneHelper() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LigneHelper(Inscription inscription, Classe classe, Bulletin bulletin, String anneeid, Double moyt1,
			Double moyt2, Double moyt3, Double moyan) {
		super();
		this.inscription = inscription;
		this.classe = classe;
		this.bulletin = bulletin;
		this.anneeid = anneeid;
		
	}



	public LigneHelper(LigneHelper bull) {
		super(bull.id, bull.designation, bull.moduleName, 0L);
		this.inscription = new Inscription(bull.inscription);
		this.classe = new Classe(bull.classe);
		this.bulletin = new Bulletin(bull.bulletin);
		this.anneeid = bull.anneeid;
		this.notet1 = bull.notet1;
		this.notet2 = bull.notet2;
		this.notet3 = bull.notet3;
		this.notean = bull.notean;
		this.ligne= new LigneBulletinClasse(bull.ligne);
		this.matiere= new MatiereDlt(bull.matiere);
		//this.examen= new Examen(bull.examen);
		
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de classe";
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
		return id + "";
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}




	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}



	public Bulletin getBulletin() {
		return bulletin;
	}



	public void setBulletin(Bulletin bulletin) {
		this.bulletin = bulletin;
	}



	public String getAnneeid() {
		return anneeid;
	}



	public void setAnneeid(String anneeid) {
		this.anneeid = anneeid;
	}



	

	public LigneBulletinClasse getLigne() {
		return ligne;
	}



	public void setLigne(LigneBulletinClasse ligne) {
		this.ligne = ligne;
	}



	public Double getNotet1() {
		return notet1;
	}



	public void setNotet1(Double notet1) {
		this.notet1 = notet1;
	}



	public Double getNotet2() {
		return notet2;
	}



	public void setNotet2(Double notet2) {
		this.notet2 = notet2;
	}



	public Double getNotet3() {
		return notet3;
	}



	public void setNotet3(Double notet3) {
		this.notet3 = notet3;
	}



	public Double getNotean() {
		return notean;
	}



	public MatiereDlt getMatiere() {
		return matiere;
	}



	public void setMatiere(MatiereDlt matiere) {
		this.matiere = matiere;
	}

//
//
//	public Examen getExamen() {
//		return examen;
//	}
//
//
//
//	public void setExamen(Examen examen) {
//		this.examen = examen;
//	}



	public void setNotean(Double notean) {
		this.notean = notean;
	}



	public int compareTo(LigneHelper o) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public String toString() {
		return "LigneHelper [inscription=" + inscription + ", classe=" + classe + ", bulletin=" + bulletin + ", ligne="
				+ ligne + ", anneeid=" + anneeid + ", notet1=" + notet1 + ", notet2=" + notet2 + ", notet3=" + notet3
				+ ", notean=" + notean + "]";
	}

}
