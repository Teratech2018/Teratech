/**
 * 
 */
package com.kerenedu.stages;

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
import com.kerenedu.school.DossierMedical;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_lstage")
public class LieuStage extends BaseElement implements Serializable, Comparable<LieuStage> {
	

	
	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3, colsequence=2)
	protected String libelle;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "DIV_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Service",target = "one-to-many",type = DivisionStage.class,search = false)
	private List<DivisionStage> service = new ArrayList<DivisionStage>();
	


	public LieuStage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LieuStage(LieuStage filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.service = new ArrayList<DivisionStage>();
		

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	
	
	public String getCode() {
		return code;
	}


	public List<DivisionStage> getService() {
		return service;
	}


	public void setService(List<DivisionStage> service) {
		this.service = service;
	}


	public void setCode(String code) {
		this.code = code;
	}




	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Lieux de Stage";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Lieux de Stage";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
	}


	

	public int compareTo(LieuStage o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
