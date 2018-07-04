/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_tabscence")
public class TypeAbscence extends BaseElement implements Serializable, Comparable<TypeAbscence> {


	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=false , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3, colsequence=2)
	protected String libelle;

	public TypeAbscence() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TypeAbscence(TypeAbscence ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.code=ins.code;
		this.libelle=ins.libelle;

	}

	


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(TypeAbscence o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des type d'abscence";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des type d'abscence";
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


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return this.code+"-"+this.libelle;
	}


	
	

}
