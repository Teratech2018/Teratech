/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_bul_mod")
public class ModelBulletin extends BaseElement implements Serializable, Comparable<ModelBulletin> {
	

	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String libelle;
	
	@ManyToMany(fetch = FetchType.LAZY )
    @JoinColumn(name ="EXA_ID")
	@Predicate(label = "SEQUENCE CONCERNES",group = true,groupName = "tab1",groupLabel = "SEQUENCE CONCERNES",target = "many-to-many-list",
	type = Examen.class,search = false, sequence=6)
	private List<Examen> sequence = new ArrayList<Examen>();

	public ModelBulletin() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ModelBulletin(ModelBulletin filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName);
		this.libelle = filiere.libelle;
		this.code=filiere.code;
		this.sequence=new ArrayList<Examen>();
		

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


	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Model de Bulletin";
	}

	/**
	 * @return the sequence
	 */
	public List<Examen> getSequence() {
		return sequence;
	}


	/**
	 * @param sequence the sequence to set
	 */
	public void setSequence(List<Examen> sequence) {
		this.sequence = sequence;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Model de Bulletin";
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

	

	public int compareTo(ModelBulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
