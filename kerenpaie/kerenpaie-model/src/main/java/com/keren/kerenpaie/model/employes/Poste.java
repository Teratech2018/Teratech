/**
 * 
 */
package com.keren.kerenpaie.model.employes;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.structures.Departement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_POS")
public class Poste extends BaseElement implements Serializable, Comparable<Poste> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4629448432824263569L;

	@Predicate(label="Code",optional=false,unique=true,search=true)
	private String code;

//	@ManyToOne
//	@JoinColumn(name="DEP_ID")
//	@Predicate(label="Département",type=Departement.class,target="many-to-one",search=true)
//	private Departement departement ;
	
	@Predicate(label="Nom du poste",optional=false,search=true)
	private String intitule ;
	
	@ManyToOne
	@JoinColumn(name="FON_ID")
	@Predicate(label="Fonction associée",type=Fonction.class,target="many-to-one",search=true)
	private Fonction fonction;
	

	@Predicate(label="Actif",type=Boolean.class,search=true)
	private Boolean responsable = Boolean.FALSE;
	
	@Predicate(label="Description",group=true,groupName="group1",groupLabel="Description du poste",target="textarea")
	private String description ;
	/**
	 * 
	 */
	public Poste() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Poste(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	public Poste(Poste poste) {
		super(poste.id, poste.designation, poste.moduleName);
		this.code = poste.code;
//		if(poste.departement!=null){
//			this.departement = new Departement(poste.departement);
//		}
		this.intitule = poste.intitule;
		if(poste.fonction!=null){
			this.fonction = new Fonction(poste.fonction);
		}
		this.responsable = poste.responsable;
		this.description = poste.description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public Departement getDepartement() {
//		return departement;
//	}
//
//	public void setDepartement(Departement departement) {
//		this.departement = departement;
//	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Boolean getResponsable() {
		return responsable;
	}

	public void setResponsable(Boolean responsable) {
		this.responsable = responsable;
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
		return "POSTE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "POSTES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
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
	public int compareTo(Poste o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
