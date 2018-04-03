/**
 * 
 */
package com.keren.kerenpaie.model.structures;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_GRADEP")
public class Grade extends BaseElement implements Serializable, Comparable<Grade> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3930728155646263416L;
	
	@Predicate(label="Grade",optional=false)
	private String code ;

	/** 
	 * 
	 */
	public Grade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Grade(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
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
		return "Grade";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Grades";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Grade o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
