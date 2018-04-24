/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.security.KeyStore.TrustedCertificateEntry;

import javax.persistence.CollectionTable;
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
@Table(name="T_CAMODRH")
public class CategorieModule extends BaseElement implements Serializable, Comparable<CategorieModule> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8370565777350975904L;
	
	@Predicate(label="Reference",optional=false,unique=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false)
	private String intitule ;
	
	@Predicate(label="Notes",target="textarea",group=true,groupName="group1",groupLabel="Notes")
	private String note ;
	
    
	/**
	 * 
	 */
	public CategorieModule() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CategorieModule(long id, String designation, String moduleName) {
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
	 * @param note
	 */

	public CategorieModule(long id, String designation, String moduleName, String code, String intitule, String note) {
		super(id, designation, moduleName);
		this.code = code;
		this.intitule = intitule;
		this.note = note;
	}
	
	/**
	 * 
	 * @param cate
	 */
	public CategorieModule(CategorieModule cate) {
		super(cate.id, cate.designation, cate.moduleName);
		this.code = cate.code;
		this.intitule = cate.intitule;
		this.note = cate.note;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Catégorie du Module";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Catégories des Modules";
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
	public int compareTo(CategorieModule o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
