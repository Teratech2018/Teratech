/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_mat_dlt")
public class MatiereDlt extends BaseElement implements Serializable, Comparable<MatiereDlt> {
	

	
	@Column(name = "CODE")	
	@Predicate(label="CODE",optional=false,updatable=true,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String libelle;
	
	@Column(name = "COEF" )	
	@Predicate(label="Coef.",optional=false,updatable=true,search=true , sequence=3, colsequence=3, type=Integer.class)
	protected int coeficient;
	
	@Column(name = "STATE" )	
	@Predicate(label="Statut",optional=false,updatable=true, sequence=4, target = "checkbox", search=true)
	private Boolean state=Boolean.TRUE;
	
	

	public MatiereDlt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatiereDlt(MatiereDlt mat) {
		super(mat.id, mat.designation, mat.moduleName,0L);
		this.code=mat.code;
		this.libelle=mat.libelle;
		this.coeficient=mat.coeficient;
		this.state=mat.state;

	}



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Matieres";
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


	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public int getCoeficient() {
		return coeficient;
	}


	public boolean isState() {
		return state;
	}


	public void setState(boolean state) {
		this.state = state;
	}


	public void setCoeficient(int coeficient) {
		this.coeficient = coeficient;
	}


	public int compareTo(MatiereDlt o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}
	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return code+" , "+libelle;
	}
	


	

	

}
