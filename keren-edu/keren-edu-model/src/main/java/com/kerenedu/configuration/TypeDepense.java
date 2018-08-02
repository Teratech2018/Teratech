/**
 * 
 */
package com.kerenedu.configuration;

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
@Entity(name = "e_t_dps")
public class TypeDepense extends BaseElement implements Serializable, Comparable<TypeDepense> {
	
	
	@Column(name = "CODE",unique=true )	
	@Predicate(label="Code",optional=false,updatable=true,search=true , sequence=1)
	protected String code;
	
	@Column(name = "LIBELLE",unique=true )	
	@Predicate(label="Libelle",optional=false,updatable=true,search=true , sequence=1)
	protected String libelle;


	public TypeDepense() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TypeDepense(String code, String libelle) {
		super();
		this.libelle = libelle;
		this.code = code;
	}
	
	public TypeDepense(TypeDepense app) {
		super();
		this.libelle = app.libelle;
		this.code = app.code;
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



	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Type de dépense";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Types de Dépenses";
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


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	public int compareTo(TypeDepense o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
