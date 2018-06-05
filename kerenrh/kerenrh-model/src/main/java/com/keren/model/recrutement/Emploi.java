/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_EMPLRH")
public class Emploi extends BaseElement implements Serializable, Comparable<Emploi> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8237347095612373733L;
	
	@Predicate(label="Code" ,optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé" ,optional=false,search=true)
	private String intitule ;
	
	@Lob
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Description de l'emploi",search=true)
	private String description ;

	/**
	 * 
	 */
	public Emploi() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Emploi(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param intitule
	 * @param description
	 */

	public Emploi(long id, String designation, String moduleName, String code, String intitule, String description) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.intitule = intitule;
		this.description = description;
	}
	
	public Emploi(Emploi emploi) {
		super(emploi.id, emploi.designation, emploi.moduleName,emploi.compareid);
		this.code = emploi.code;
		this.intitule = emploi.intitule;
		this.description = emploi.description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Emploi";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Emplois";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
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
	public int compareTo(Emploi arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
