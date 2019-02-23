/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.personnel.Professeur;

/**
 * @author ntchuente
 *
 */
//@Table
//@Entity(name = "e_bul_lgn_builder")
public class BuilderLigneNote extends BaseElement implements Serializable, Comparable<BuilderLigneNote> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "NOTET1")
	private Double notet1 = new Double(0);

	@Column(name = "NOTET2")
	private Double notet2 = new Double(0);

	@Column(name = "NOTET3")
	private Double notet3 = new Double(0);
	
	@Column(name = "NOTETAN")
	private Double notean = new Double(0);
	
	@Column(name = "MAT_ID")
	protected String matiereid;
	
	@Column(name = "INSCRIPTION_ID")
	protected String inscriptionid;


	public BuilderLigneNote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BuilderLigneNote(MatiereDlt matiere, Professeur prof, Double note, Double moyenne, Long coef,
			Long pourcentage, Long rang, Double moyeClasse, Double extremeMin, Double extremeMax, String obs, Double totaux) {
		super();
		
	}

	public BuilderLigneNote(BuilderLigneNote filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,filiere.compareid);
		this.notet1 = filiere.notet1;
		this.notet2 = filiere.notet2;
		this.notet3 = filiere.notet3;
		this.notean = filiere.notean;
		this.inscriptionid=filiere.inscriptionid;
		this.matiereid=filiere.matiereid;

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Details  Bulletin";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Details Bulletin";
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

	public void setNotean(Double notean) {
		this.notean = notean;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}
	
	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	public int compareTo(BuilderLigneNote o) {
		// TODO Auto-generated method stub
		return (int) o.getId();
	}

	

	public String getInscriptionid() {
		return inscriptionid;
	}

	public void setInscriptionid(String inscriptionid) {
		this.inscriptionid = inscriptionid;
	}

	public String getMatiereid() {
		return matiereid;
	}

	public void setMatiereid(String matiereid) {
		this.matiereid = matiereid;
	}

	@Override
	public String toString() {
		return "BuilderLigneNote [notet1=" + notet1 + ", notet2=" + notet2 + ", notet3=" + notet3 + ", notean=" + notean
				+ "]";
	}

}
