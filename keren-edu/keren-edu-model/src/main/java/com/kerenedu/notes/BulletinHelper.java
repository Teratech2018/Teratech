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
import com.kerenedu.inscription.Inscription;

/**
 * @author ntchuente
 *
 */
//@Table
//@Entity(name = "e_zview_helper_bull")
public class BulletinHelper extends BaseElement implements Serializable, Comparable<BulletinHelper> {



	@ManyToOne
	@JoinColumn(name ="INS_ID")
	protected Inscription inscription;


	@ManyToOne
	@JoinColumn(name ="CLASSE_ID")
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name ="BULL_ID")
	protected Bulletin bulletin;

	@Column(name ="ANNEE_ID")
	private String anneeid;
	
//	@ManyToOne
//	@JoinColumn(name = "EXAMEN_ID")
//	protected Examen examen;

	
	@Column(name = "MOYT1")
	private Double moyt1 = new Double(0);

	@Column(name = "MOYT2")
	private Double moyt2 = new Double(0);

	@Column(name = "MOYT3")
	private Double moyt3 = new Double(0);
	
	@Column(name = "MOYAN")
	private Double moyan = new Double(0);

	
	public BulletinHelper() {
		super();
		// TODO Auto-generated constructor stub
	}



	public BulletinHelper(Inscription inscription, Classe classe, Bulletin bulletin, String anneeid, Double moyt1,
			Double moyt2, Double moyt3, Double moyan) {
		super();
		this.inscription = inscription;
		this.classe = classe;
		this.bulletin = bulletin;
		this.anneeid = anneeid;
		this.moyt1 = moyt1;
		this.moyt2 = moyt2;
		this.moyt3 = moyt3;
		this.moyan = moyan;
	}



	public BulletinHelper(BulletinHelper bull) {
		super(bull.id, bull.designation, bull.moduleName, 0L);
		this.inscription = new Inscription(bull.inscription);
		this.classe = new Classe(bull.classe);
		this.bulletin = new Bulletin(bull.bulletin);
		this.anneeid = bull.anneeid;
		this.moyt1 = bull.moyt1;
		this.moyt2 = bull.moyt2;
		this.moyt3 = bull.moyt3;
		this.moyan = bull.moyan;
	//	this.examen=new Examen(bull.examen);
		
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



	public Double getMoyt1() {
		return moyt1;
	}



	public void setMoyt1(Double moyt1) {
		this.moyt1 = moyt1;
	}



	@Override
	public String toString() {
		return "BulletinHelper [inscription=" + inscription + ", classe=" + classe + ", bulletin=" + bulletin
				+ ", anneeid=" + anneeid + ", moyt1=" + moyt1 + ", moyt2=" + moyt2 + ", moyt3=" + moyt3 + ", moyan="
				+ moyan + "]";
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



	public int compareTo(BulletinHelper o) {
		// TODO Auto-generated method stub
		return 0;
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

}
