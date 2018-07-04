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
@Table(name="T_LITHEFORRH")
public class LigneThemeFormation extends BaseElement implements Serializable, Comparable<LigneThemeFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8512599202467344945L;
	
	@Predicate(label="Reference",unique=true,optional=false,search=true)
	@Column(unique=true)
	private String code ;
	
	@Predicate(label="Intitulé",search=true)
	private String intitule ;
	
	@ManyToOne
	@JoinColumn(name="CATMOD_ID")
	@Predicate(label="Catégorie du Module",type=CategorieModule.class,target="many-to-one",optional=false,search=true)
	private CategorieModule categorie ;
	
	@Predicate(label="Nbre d'Heures",type=Short.class,optional=false,min=1,search=true)
	private Short heures =0;
	
	@Predicate(label="Coût Estimatif unitaire",type=Double.class,search=true)
	private Double cout =0.0;
	
	

	/**
	 * 
	 */
	public LigneThemeFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneThemeFormation(long id, String designation, String moduleName) {
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
	 * @param categorie
	 * @param heures
	 * @param cout
	 */

	public LigneThemeFormation(long id, String designation, String moduleName, String code, String intitule,
			CategorieModule categorie, Short heures, Double cout) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.intitule = intitule;
		this.categorie = categorie;
		this.heures = heures;
		this.cout = cout;
	}
	
        /**
         * 
         * @param theme 
         */
	public LigneThemeFormation(LigneThemeFormation theme) {
		super(theme.id, theme.designation, theme.moduleName,theme.compareid);
		this.code = theme.code;
		this.intitule = theme.intitule;
		this.categorie = theme.categorie;
		this.heures = theme.heures;
		this.cout = theme.cout;
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

	public CategorieModule getCategorie() {
		return categorie;
	}

	public void setCategorie(CategorieModule categorie) {
		this.categorie = categorie;
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
		return "Thème";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Thèmes";
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
		return Long.toString(serialVersionUID);
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LigneThemeFormation o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
