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
@Table(name="T_VILL")
public class Ville extends BaseElement implements Serializable, Comparable<Ville> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8873514357567227882L;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Type",optional=false,target="combobox",values="Ville;Site",search=true)
	private String type ="0";

	/**
	 * 
	 */
	public Ville() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Ville(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param type
	 */

	public Ville(long id, String designation, String moduleName, String code, String type) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.type = type;
	}
	
	public Ville(Ville ville) {
		super(ville.id, ville.designation, ville.moduleName,ville.compareid);
		this.code = ville.code;
		this.type = ville.type;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Ville";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Villed";
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
	public int compareTo(Ville o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
