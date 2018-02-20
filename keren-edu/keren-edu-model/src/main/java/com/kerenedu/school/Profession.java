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
@Entity(name = "e_prof")
public class Profession extends BaseElement implements Serializable, Comparable<Profession> {

	@Column(name = "CODE", unique = true)
	@Predicate(label="CODE",optional=false,updatable=false,search=true)
	protected String code;

	@Column(name = "DESCRIPTION")
	@Predicate(label="DESCRIPTION",optional=false,updatable=false,search=true)
	protected String description;
	

	public Profession() {
		super();
	}

	public Profession(Profession profession) {
		super(profession.id, profession.designation, profession.moduleName);
		this.code = profession.code;
		this.description = profession.description;
	}

	public Profession(String code, String description) {
		super();
		this.code = code;
		this.description = description;
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
		final Profession other = (Profession) obj;
		if (!Objects.equals(this.code, other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return code + " - " + description;
	}

	public int compareTo(Profession o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Profession";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Profession";
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
