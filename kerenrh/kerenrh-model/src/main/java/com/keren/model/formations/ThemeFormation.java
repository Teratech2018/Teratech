/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_THEFORRH")
public class ThemeFormation extends BaseElement implements Serializable, Comparable<ThemeFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8641430172815547244L;

	@Column(unique=true)
	@Predicate(label="Reference",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String intitule ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="THEME_ID")
	@Predicate(label=".",type=LigneThemeFormation.class,target="one-to-many",edittable=true,group=true,groupName="group1",groupLabel="Modules")
	private List<LigneThemeFormation> lignes = new ArrayList<LigneThemeFormation>();
	
	/**
	 * 
	 */
	public ThemeFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ThemeFormation(long id, String designation, String moduleName) {
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
	 * @param lignes
	 */

	public ThemeFormation(long id, String designation, String moduleName, String code, String intitule,
			List<LigneThemeFormation> lignes) {
		super(id, designation, moduleName);
		this.code = code;
		this.intitule = intitule;
		this.lignes = lignes;
	}
	
	public ThemeFormation(ThemeFormation theme) {
		super(theme.id, theme.designation, theme.moduleName);
		this.code = theme.code;
		this.intitule = theme.intitule;
//		this.lignes = lignes;
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

	public List<LigneThemeFormation> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneThemeFormation> lignes) {
		this.lignes = lignes;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Thème Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Thèmes Formation";
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
	public int compareTo(ThemeFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
