/**
 * 
 */
package com.keren.courrier.model.referentiel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW
 * table type correspondants
 */
@Entity
@Table(name="T_TYCOKC")
public class TypeCorrespondant extends BaseElement implements Serializable, Comparable<TypeCorrespondant> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5954077291868061600L;

	
	@Predicate(label="Type de contact",optional=false,unique = true,search=true)
	private String code ;
	
	@Predicate(label="Nature du contact",optional=false,search=true, target="combobox", values="Personne Morale et oarticulier;Personne Morale;Particulier" , sequence=2 )
	private String nature ;
	

	/**
	 * 
	 */
	public TypeCorrespondant() {
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	public TypeCorrespondant(TypeCorrespondant dep) {
		super(dep.id, dep.designation, dep.moduleName,dep.compareid);
		this.code = dep.code;
		this.nature=dep.nature;
	
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
		return "Type de contact";
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Types de contact";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int compareTo(TypeCorrespondant o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
