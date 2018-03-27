/**
 * 
 */
package com.keren.model.conges;

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
@Table(name="T_TYPCON")
public class TypeConge extends BaseElement implements Serializable, Comparable<TypeConge> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8687883004267850993L;
	
	@Predicate(label="Code type",unique=true,optional=false,search=true)
	private String code ;
	
	@Predicate(label="Nombre de jours" , optional=false,type=Short.class,search=true)
	private Short nbrejours =0;
	
	@Predicate(label="Type de congé",target="combobox",values="Congé annuel;Congé de maternité;Autres",search=true)
	private String nature = "0";
	

	/**
	 * 
	 */
	public TypeConge() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TypeConge(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	public TypeConge(TypeConge type) {
		super(type.id, type.designation, type.moduleName);
		this.code = type.code;
		this.nbrejours = type.nbrejours;
		this.nature = type.nature;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Short getNbrejours() {
		return nbrejours;
	}

	public void setNbrejours(Short nbrejours) {
		this.nbrejours = nbrejours;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "TYPE DE CONGE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "TYPES DE CONGES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TypeConge o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
