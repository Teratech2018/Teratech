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
import com.kerenedu.configuration.PeriodeScolaire;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_examen")
public class Examen extends BaseElement implements Serializable, Comparable<Examen> {
	

	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=false , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String libelle;
	
	@Column(name = "SUR")	
	@Predicate(label="Noter Sur",optional=false,updatable=true,search=true , type=Long.class, sequence=3, colsequence=3)
	protected long sur;
	
	@Column(name = "STATUT")
	@Predicate(label="STATUT",optional=false,updatable=true,search=true, target="combobox", values="Optionel;Obligatoire;Bonus" , sequence=4)
	protected String statut="0";
	
	@ManyToOne
	@JoinColumn(name = "PERIODE_ID")
	@Predicate(label="PERIODE SCOLAIRE",updatable=true,type=PeriodeScolaire.class , target="many-to-one",search=true , sequence=5	)
	protected PeriodeScolaire periode;

	public Examen() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Examen(Examen filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.sur=filiere.sur;
		this.statut=filiere.statut;
		this.periode= new PeriodeScolaire(filiere.periode);
		

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	
	
	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public long getSur() {
		return sur;
	}


	public void setSur(long sur) {
		this.sur = sur;
	}


	public PeriodeScolaire getPeriode() {
		return periode;
	}


	public void setPeriode(PeriodeScolaire periode) {
		this.periode = periode;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Examens";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Examens";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
	}


	

	public int compareTo(Examen o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
