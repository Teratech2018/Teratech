/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Objects;

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
@Entity(name = "e_tremise")
public class TypeRemise extends BaseElement implements Serializable, Comparable<TypeRemise> {

	
	@Column(name = "CODE")
	@Predicate(label="Code",optional=false,updatable=true,search=true, sequence=1)
	protected String code;
	
	@Column(name = "LIBELLE")
	@Predicate(label="Libellé",optional=false,updatable=true,  sequence=2)
	protected String libelle;
	
	
	public TypeRemise() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	



	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(TypeRemise o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Type de Remises ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion  des Type de Remises  ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
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

	




		

}
