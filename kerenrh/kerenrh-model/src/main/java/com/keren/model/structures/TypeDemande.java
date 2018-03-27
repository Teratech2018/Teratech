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
@Table(name="T_TYDME")
public class TypeDemande extends BaseElement implements Serializable, Comparable<TypeDemande> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7034493951091316468L;
	
	@Predicate(label="Type de demande",optional=false,unique=false,search=true)
	private String code ;

	/**
	 * 
	 */
	public TypeDemande() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TypeDemande(long id, String designation, String moduleName) {
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
		return "TYPE DEMANDE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "TYPE DEMANDES";
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TypeDemande o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
