/**
 * 
 */
package com.keren.kerenpaie.model.employes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Table(name="T_ECHE")
@Entity
public class Echelon extends BaseElement implements Comparable<Echelon>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1846597410284200688L;
	
	@Predicate(label="Libellé",optional=false,unique=true,search=true)
	private String  code ;
	
//	@Predicate(label="Actif" , type=Boolean.class,search=true)
	private Boolean actif = Boolean.TRUE;
	
	@Predicate(label="Description" , group=true,groupName="group1",groupLabel="DESCRIPTION",target="textarea")
	private String description;
	

	/**
	 * 
	 */
	public Echelon() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Echelon(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public Echelon(Echelon echel) {
		super(echel.id, echel.designation, echel.moduleName,echel.compareid);
		this.code = echel.code;
		this.actif = echel.actif;
		this.description = echel.description;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(Echelon o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "ECHELON";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "ECHELONS";
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

	@Override
	public String toString() {
		return "Echelon [code=" + code + ", actif=" + actif + ", description=" + description + "]";
	}
	
	

}
