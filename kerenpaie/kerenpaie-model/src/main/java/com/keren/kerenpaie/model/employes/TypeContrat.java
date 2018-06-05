/**
 * 
 */
package com.keren.kerenpaie.model.employes;

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
@Table(name="T_TYCON")
public class TypeContrat extends BaseElement implements Serializable, Comparable<TypeContrat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5261526208669017067L;
	
	@Predicate(label="Type de contrat",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Catégorie de contrat",optional=false,search=true,target="combobox",values="CDD;CDI;Fonctionnaire détaché;Contratuel;Temporaire;Stagiaire;Autres")
	private String categorie ="0";

	/**
	 * 
	 */
	public TypeContrat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TypeContrat(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param categorie
	 */

	public TypeContrat(long id, String designation, String moduleName, String code, String categorie) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.categorie = categorie;
	}
	
	/**
	 * 
	 * @param typecontrat
	 */
	public TypeContrat(TypeContrat typecontrat) {
		super(typecontrat.id, typecontrat.designation, typecontrat.moduleName,typecontrat.compareid);
		this.code = typecontrat.code;		
		this.categorie = typecontrat.categorie;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "TYPE CONTRAT";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "TYPE CONTRAT";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	@Override
	public int compareTo(TypeContrat o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
