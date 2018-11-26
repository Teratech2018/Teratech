/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_ech")
public class Echellon extends BaseElement implements Serializable, Comparable<Echellon> {


	@Predicate(label="Libellé",optional=false,unique=true,search=true, sequence=1)
	private String  code ;
	
//	@Predicate(label="Actif" , type=Boolean.class,search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Description" , group=true,groupName="group1",groupLabel="DESCRIPTION",target="textarea", sequence=2)
	private String description;
	


	public Echellon(String code, Boolean actif, String description ) {
		super();
		this.code = code;
		this.actif = actif;
		this.description = description;
	}

	

	public Echellon(Echellon entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.actif = entity.actif;
		this.description = entity.description;
	}



	public Echellon() {
		// TODO Auto-generated constructor stub
	}



	public int compareTo(Echellon o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public Boolean getActif() {
		return actif;
	}



	public void setActif(Boolean actif) {
		this.actif = actif;
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
		return "Echelon";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Echelon";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"";
	}



}
