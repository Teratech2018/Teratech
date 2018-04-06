/**
 * 
 */
package com.keren.kerenpaie.model.employes;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_MEDAILLE")
public class Medaille extends BaseElement implements Serializable, Comparable<Medaille> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1200731372643620270L;
	
	@Predicate(label="Nom de la médaille",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Type de médaille",optional=false,target="combobox",values="Agent;Vermeil;Or",search=true)
	private String type ="0";
	
	@Predicate(label="Description",target="textarea",search=true)
	private String description ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date d'obtention",type=Date.class,target="date",search=true)
	private Date recu ;

	/**
	 * 
	 */
	public Medaille() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Medaille(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param type
	 * @param description
	 * @param recu
	 */

	public Medaille(long id, String designation, String moduleName, String code, String type, String description,
			Date recu) {
		super(id, designation, moduleName);
		this.code = code;
		this.type = type;
		this.description = description;
		this.recu = recu;
	}
	
	/**
	 * 
	 * @param code
	 * @param type
	 * @param description
	 * @param recu
	 */
	public Medaille(String code, String type, String description,
			Date recu) {
		super(-1, null, null);
		this.code = code;
		this.type = type;
		this.description = description;
		this.recu = recu;
	}

	public Medaille(Medaille medaille) {
		super(medaille.id, medaille.designation, medaille.moduleName);
		this.code = medaille.code;
		this.type = medaille.type;
		this.description = medaille.description;
		this.recu = medaille.recu;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getRecu() {
		return recu;
	}

	public void setRecu(Date recu) {
		this.recu = recu;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Médaille";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Médailles";
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

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Medaille arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
