/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Contacts;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_filiere")
public class Filiere extends BaseElement implements Serializable, Comparable<Filiere> {
	
	
	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=true,search=true , sequence=1)
	protected String code;
	
	@Column(name = "LIBELLE",unique=true )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2)
	protected String libelle;
	
	@Column(name = "NIV_FORMT")
	@Predicate(label="NIVEAU FORMATION",optional=false,updatable=true,search=false, target="combobox", values="Marternelle;Primaire;Secondaire;université" , sequence=3)
	protected String nivFormation="0";
	
	@Column(name = "CAPACITE" )	
	@Predicate(label="CAPACITE",optional=false,updatable=true,search=true , sequence=4, type=Long.class)
	protected Long capacite;
	
	@Column(name = "DUREE" )	
	@Predicate(label="DUREE",optional=false,updatable=true,search=true , sequence=5, type=Long.class)
	protected Long duree;


	public Filiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Filiere(Filiere filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.capacite=filiere.capacite;
		this.duree=filiere.duree;
		this.nivFormation=filiere.nivFormation;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}


	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	public String getNivFormation() {
		return nivFormation;
	}


	public void setNivFormation(String nivFormation) {
		this.nivFormation = nivFormation;
	}


	public Long getCapacite() {
		return capacite;
	}


	public void setCapacite(Long capacite) {
		this.capacite = capacite;
	}


	public Long getDuree() {
		return duree;
	}


	public void setDuree(Long duree) {
		this.duree = duree;
	}


	@Override
	public int compareTo(Filiere o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Edition des Filières";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Filières";
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

}
