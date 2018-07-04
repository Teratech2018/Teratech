/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_dlieu")
public class DivisionStage extends BaseElement implements Serializable, Comparable<DivisionStage> {

	
	@Column(name = "LIBELLE" ,unique=true)	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=3, colsequence=2)
	protected String libelle;
	


	public DivisionStage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DivisionStage(DivisionStage filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.libelle = filiere.libelle;
		

	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}




	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Service/Département";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Service/Département";
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


	

	public int compareTo(DivisionStage o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
