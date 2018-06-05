/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;

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
@Table(name="T_EXPCANRH")
public class ExperienceCandidat extends BaseElement implements Serializable, Comparable<ExperienceCandidat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1382783685573021236L;
	
	@Predicate(label="Type de Formation",target="combobox",values="Pas d'experience;Professionnel;Sociale;Autres",search=true)
	private String type ="0";
	
	@Predicate(label="Fonction",optional=false,search=true)
	private String fonction ;
	
	@Predicate(label="Durée ",type=Short.class,search=true)
	private Short duree =0;
	
	@Predicate(label="Entreprise/Association",search=true)
	private String entrep;
	
	@Predicate(label="Résumé Activité",target="textarea")
	@Lob
	private String description;

	/**
	 * 
	 */
	public ExperienceCandidat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ExperienceCandidat(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param type
	 * @param fonction
	 * @param duree
	 * @param entrep
	 * @param description
	 */

	public ExperienceCandidat(long id, String designation, String moduleName, String type, String fonction, Short duree,
			String entrep, String description) {
		super(id, designation, moduleName,0L);
		this.type = type;
		this.fonction = fonction;
		this.duree = duree;
		this.entrep = entrep;
		this.description = description;
	}
	
	/**
	 * 
	 * @param exp
	 */
	public ExperienceCandidat(ExperienceCandidat exp) {
		super(exp.id, exp.designation, exp.moduleName,exp.compareid);
		this.type = exp.type;
		this.fonction = exp.fonction;
		this.duree = exp.duree;
		this.entrep = exp.entrep;
		this.description = exp.description;
	}

	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	public String getEntrep() {
		return entrep;
	}

	public void setEntrep(String entrep) {
		this.entrep = entrep;
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
		return "Experience";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Experiences";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ExperienceCandidat o) {
		// TODO Auto-generated method stub
		return fonction.compareTo(o.fonction);
	}

}
