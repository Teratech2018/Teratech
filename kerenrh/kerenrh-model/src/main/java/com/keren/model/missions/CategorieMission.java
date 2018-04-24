/**
 * 
 */
package com.keren.model.missions;

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
@Table(name="T_CATMISRH")
public class CategorieMission extends BaseElement implements Serializable, Comparable<CategorieMission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6078536405573476387L;
	
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String intitule ;

	/**
	 * 
	 */
	public CategorieMission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CategorieMission(long id, String designation, String moduleName) {
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

	public CategorieMission(long id, String designation, String moduleName, String code, String intitule) {
		super(id, designation, moduleName);
		this.code = code;
		this.intitule = intitule;
	}
	
	/**
	 * 
	 * @param cate
	 */
	public CategorieMission(CategorieMission cate) {
		super(cate.id, cate.designation, cate.moduleName);
		this.code = cate.code;
		this.intitule = cate.intitule;
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
		return "Catégorie de Mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Catégories de Mission";
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
	public int compareTo(CategorieMission o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
