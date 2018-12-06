/**
 * 
 */
package com.kerenedu.school;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_nat")
public class Nationalite extends BaseElement implements Serializable, Comparable<Nationalite> {

	@Column(name = "CODE", unique = true)
	@Predicate(label="CODE",optional=false,updatable=false,search=true)
	protected String code;

	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=true,search=true)
	protected String description;
	
	@Column(name = "DESCRIPTION_EN")
	@Predicate(label="DESCRIPTION/english",optional=false,updatable=true,search=true)
	protected String descriptionen;
	
	public Nationalite() {
		super();

	}

	public Nationalite(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}
	

	public Nationalite(Nationalite nationalite) {
		super(nationalite.id, nationalite.designation, nationalite.moduleName,0L);
		this.code = nationalite.code;
		this.description = nationalite.description;
		this.descriptionen = nationalite.descriptionen;
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
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Nationalité";
	}

	public String getDescriptionen() {
		return descriptionen;
	}

	public void setDescriptionen(String descriptionen) {
		this.descriptionen = descriptionen;
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des Nationalités";
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
		final Nationalite other = (Nationalite) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return code + " - " + description;
	}

	public int compareTo(Nationalite o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
