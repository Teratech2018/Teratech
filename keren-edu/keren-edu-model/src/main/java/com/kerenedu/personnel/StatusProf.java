/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_status")
public class StatusProf extends BaseElement implements Serializable, Comparable<StatusProf> {
	
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3, colsequence=3)
	protected String libelle;
	


	public StatusProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StatusProf(StatusProf filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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


	

	public int compareTo(StatusProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
