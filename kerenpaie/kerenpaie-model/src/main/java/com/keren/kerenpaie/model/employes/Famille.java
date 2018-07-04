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
@Table(name="T_FAM")
public class Famille extends BaseElement implements Serializable, Comparable<Famille> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2867467381045634965L;

	@Predicate(label="Noms et prenoms" ,optional=false,search=true)
	private String intitule ;
	

	@Predicate(label="Eligible?",type=Boolean.class,search=true)
	private Boolean eligible = Boolean.FALSE;
	
	@Predicate(label="Qualité" ,target="combobox",values="Enfant;Conjoint",search=true)
	private String qualite = "0" ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de naissance",type=Date.class,target="date",search=true)
	private Date naissance ;
	
	/**
	 * 
	 */
	public Famille() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Famille(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
	

	public Famille(Famille famille) {
		super(famille.id, famille.designation, famille.moduleName,famille.compareid);
		this.intitule = famille.intitule;
		this.qualite = famille.qualite;
		this.naissance = famille.naissance;
		this.eligible = famille.eligible;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public Boolean getEligible() {
		return eligible;
	}

	public void setEligible(Boolean eligible) {
		this.eligible = eligible;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Famille o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
