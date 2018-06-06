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
@Table(name="T_DIPLO")
public class Diplome extends BaseElement implements Serializable, Comparable<Diplome> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7034493951091316468L;
	
	@Predicate(label="Intitulé du diplôme",optional=false,unique=false,search=true)
	private String code ;

	/**
	 * 
	 */
	public Diplome() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Diplome(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Diplome o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
