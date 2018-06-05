/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_CONS")
public class Constante extends BaseElement implements Serializable, Comparable<Constante> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2730799554016413609L;
	
	
	private String code ;
	
	/**
	 * 
	 */
	public Constante() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Constante(long id, String designation, String moduleName) {
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
	public int compareTo(Constante arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
