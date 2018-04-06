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
@Table(name="T_TYPCAISP")
public class TypeCaisse extends BaseElement implements Serializable, Comparable<TypeCaisse> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1905660755862812380L;
	
	@Predicate(label="Type de caisse",optional=false,unique=true,search=true)
	private String code ;

	@Predicate(label="Intitulé de la caisse",search=true)
	private String intitule ;
	
	/**
	 * 
	 */
	public TypeCaisse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TypeCaisse(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param intitule
	 */

	public TypeCaisse(long id, String designation, String moduleName, String code, String intitule) {
		super(id, designation, moduleName);
		this.code = code;
		this.intitule = intitule;
	}
	
	/**
	 * 
	 * @param type
	 */
	public TypeCaisse(TypeCaisse type) {
		super(type.id, type.designation, type.moduleName);
		this.code = type.code;
		this.intitule = type.intitule;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Type de Caisse";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Types de Caisse";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+intitule;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TypeCaisse o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
