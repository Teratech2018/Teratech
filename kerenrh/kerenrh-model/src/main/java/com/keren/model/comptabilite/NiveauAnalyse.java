/**
 * 
 */
package com.keren.model.comptabilite;

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
@Table(name = "T_NAnalyse")
public class NiveauAnalyse extends BaseElement implements Serializable, Comparable<NiveauAnalyse> {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3720239905653461401L;
	
	 @Predicate(label = "Intitulé" ,unique = true,optional = false)
	 private String code ;

	/**
	 * 
	 */
	public NiveauAnalyse() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public NiveauAnalyse(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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
		return "NIVEAU ANALYSE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "NIVEAUX ANALYSES";
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
	public int compareTo(NiveauAnalyse o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
