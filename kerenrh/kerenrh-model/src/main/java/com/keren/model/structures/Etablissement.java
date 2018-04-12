/**
 * 
 */
package com.keren.model.structures;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ETABLRH")
public class Etablissement extends BaseElement implements Serializable, Comparable<Etablissement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 318775858666926613L;
	
	@Predicate(label="Nom Ecole/Institut",optional=false,unique=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Téléphone",target="tel")
	private String tel ;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Adresse")
	private String adresse;

	/**
	 * 
	 */
	public Etablissement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Etablissement(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param tel
	 * @param adresse
	 */

	public Etablissement(long id, String designation, String moduleName, String code, String tel, String adresse) {
		super(id, designation, moduleName);
		this.code = code;
		this.tel = tel;
		this.adresse = adresse;
	}
	
	public Etablissement(Etablissement school) {
		super(school.id, school.designation, school.moduleName);
		this.code = school.code;
		this.tel = school.tel;
		this.adresse = school.adresse;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Etablissement";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Etablissements";
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
	public int compareTo(Etablissement o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
