/**
 * 
 */
package com.keren.model.structures;

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
@Table(name="T_SPECI")
public class Specialite extends BaseElement implements Serializable, Comparable<Specialite> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3015478686378509393L;

	/**
	 * 
	 */
	
	
	@Predicate(label="Intitulé spécialité",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Description",group=true,groupName="group1",groupLabel="Description",target="textarea")
	private String description ;

	/**
	 * 
	 */
	public Specialite() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Specialite(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
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
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "SPECIALITE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "SPECIALITES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return"kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int compareTo(Specialite o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
