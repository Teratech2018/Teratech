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
@Table(name="T_NIVETU")
public class NiveauEtude extends BaseElement implements Serializable, Comparable<NiveauEtude> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -421626522451384532L;
	
	@Predicate(label="Niveau d'etude",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Description",group=true,groupName="group1",groupLabel="Description",target="textarea")
	private String description ;

	/**
	 * 
	 */
	public NiveauEtude() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public NiveauEtude(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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
		return "NIVEAU ETUDE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "NIVEAU ETUDE";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int compareTo(NiveauEtude o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
