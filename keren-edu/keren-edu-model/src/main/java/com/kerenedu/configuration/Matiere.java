/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_matiere")
public class Matiere extends BaseElement implements Serializable, Comparable<Matiere> {
	

	@ManyToOne 
    @JoinColumn(name = "FILIERE_ID")
	@Predicate(label = "FILIERE",target = "many-to-one",type = Filiere.class,search = true  , sequence=1, colsequence=2)
	private Filiere filiere = new Filiere();
	
	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=2, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3, colsequence=3)
	protected String libelle;
	


	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Matiere(Matiere filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.filiere=new Filiere(filiere.filiere);
		

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


	


	public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
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


	

	public int compareTo(Matiere o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
