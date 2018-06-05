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
import com.keren.kerenpaie.model.structures.Region;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DEP")
public class DepartementSoc extends BaseElement implements Comparable<DepartementSoc>, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -8631423073919012110L;
	
	@Predicate(label="Code",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Nom",optional=false,search=true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="REG_ID")
	@Predicate(label="Région",type=Region.class,target="many-to-one",search=true)
	private Region region ;
	
//	@Predicate(label="Statut" , type=Boolean.class,search=true)
	private Boolean statut = Boolean.TRUE;

	/**
	 * 
	 */
	public DepartementSoc() {
		// TODO Auto-generated constructor stub
	}
	
	

	public DepartementSoc(DepartementSoc dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.nom = dep.nom;
		this.region = dep.region;
		this.statut = dep.statut;
	}



	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DepartementSoc(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "DEPARTEMENT";
	}



	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "DEPARTEMENTS";
	}



	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}



	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+nom;
	}



	@Override
	public int compareTo(DepartementSoc o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

	

}
