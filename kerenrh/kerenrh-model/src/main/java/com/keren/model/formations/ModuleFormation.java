/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_MOFORRH")
public class ModuleFormation extends BaseElement implements Serializable, Comparable<ModuleFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180546669292957751L;
	
	@Predicate(label="Reference",unique=true,optional=false,search=true)
	@Column(unique=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="CATMO_ID")
	@Predicate(label="Catégorie du Module",type=CategorieModule.class,target="many-to-one",optional=false,search=true)
	private CategorieModule categorie ;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String intitule ;
	
	@ManyToOne
	@JoinColumn(name="THEME_ID")
	@Predicate(label="Thème",type=ThemeFormation.class,target="many-to-one",optional=false,search=true)
	private ThemeFormation theme ;
	
	@Predicate(label="Nombre d'heures",type=Short.class,search=true)
	private Short heures =0;
	
	@Predicate(label="Coût Estimatif Unitaire",type=Double.class,min=1,search=true)
	private Double cout =0.0;

	/**
	 * 
	 */
	public ModuleFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ModuleFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param categorie
	 * @param intitule
	 * @param theme
	 * @param heures
	 * @param cout
	 */

	public ModuleFormation(long id, String designation, String moduleName, String code, CategorieModule categorie,
			String intitule, ThemeFormation theme, Short heures, Double cout) {
		super(id, designation, moduleName);
		this.code = code;
		this.categorie = categorie;
		this.intitule = intitule;
		this.theme = theme;
		this.heures = heures;
		this.cout = cout;
	}
	
	public ModuleFormation(ModuleFormation module) {
		super(module.id, module.designation, module.moduleName);
		this.code = module.code;
		this.categorie = module.categorie;
		this.intitule = module.intitule;
		if(module.theme!=null){
			this.theme = new ThemeFormation(module.theme);
		}
		this.heures = module.heures;
		this.cout = module.cout;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CategorieModule getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieModule categorie) {
		this.categorie = categorie;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public ThemeFormation getTheme() {
		return theme;
	}

	public void setTheme(ThemeFormation theme) {
		this.theme = theme;
	}

	public Short getHeures() {
		return heures;
	}

	public void setHeures(Short heures) {
		this.heures = heures;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Module de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Modules de Formation";
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

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return super.getSerial();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ModuleFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
