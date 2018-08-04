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
@Entity(name = "e_section")
public class SectionE extends BaseElement implements Serializable, Comparable<SectionE> {
	
	
	@Column(name = "LIBELLE")	
	@Predicate(label="Libellé",optional=false,updatable=false,search=true)
	protected String libelle;
	
	


	public SectionE() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SectionE(SectionE filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle=filiere.libelle;

		
		//this.elevelist= new ArrayList<Eleve>();
	}

	public String getLibelle() {
		return libelle;
	}



	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Scetions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Sections";
	}



	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		return libelle;
	}


	
	public int compareTo(SectionE o) {
		return 0;
	}
	

}
