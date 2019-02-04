/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="e_para_cout_mat")
public class ParaCoutMatiere extends BaseElement implements Serializable, Comparable<ParaCoutMatiere> {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Predicate(label="Code",type=String.class,optional=false,search=true,updatable=false)
	private String code ;
	
	@Predicate(label="libelle",type=String.class,optional=false,search=true,updatable=true)
	private String libelle ;

	
	@Predicate(label="Cout",type=Double.class,optional=false,search=true,updatable=true)
	private Double cout = 0.0;
	
	

	public ParaCoutMatiere(String code, String libelle, Double cout) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.cout = cout;
	}

	/**
	 * 
	 */
	public ParaCoutMatiere() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param acompte
	 */
	public ParaCoutMatiere(ParaCoutMatiere acompte) {
		super(acompte.id, acompte.designation, acompte.moduleName,acompte.compareid);
		this.code = acompte.code;
		this.libelle = acompte.libelle;
		this.cout = acompte.cout;
	}
	
	


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Coût Horaire / Matiere ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Coût Horaire / Matiere";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}
	

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}


	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return libelle;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}



	public int compareTo(ParaCoutMatiere o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */


}
