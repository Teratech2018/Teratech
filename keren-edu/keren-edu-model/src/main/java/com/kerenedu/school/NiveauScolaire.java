/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 * niveau scolaire BACC+1 CP CE1
 */
@Table
@Entity(name = "e_niv")
public class NiveauScolaire extends BaseElement implements Serializable, Comparable<NiveauScolaire> {

	@Column(name = "CODE", unique = true)
	@Predicate(label="CODE",optional=false,updatable=false,search=true)
	protected String code;

	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=false,search=true)
	protected String description;
	
	public NiveauScolaire() {
		super();
	}

	public NiveauScolaire(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

	public NiveauScolaire(NiveauScolaire niveauScolaire) {
		super(niveauScolaire.id, niveauScolaire.designation, niveauScolaire.moduleName,0L);
		this.code = niveauScolaire.code;
		this.description = niveauScolaire.description;
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final NiveauScolaire other = (NiveauScolaire) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return code + " - " + description;
	}

	public int compareTo(NiveauScolaire o) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Niveau Scoalire";
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Niveau Scoalire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return toString();
	}
}
