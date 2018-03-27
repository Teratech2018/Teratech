/**
 * 
 */
package com.keren.kerenpaie.model.employes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_CAT")
public class Categorie extends BaseElement implements Serializable, Comparable<Categorie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7591118344084563684L;
	
	@Predicate(label="Code catégorie" , type=Short.class,optional=false,search=true)
	private Short code ;
	
	@Predicate(label="Type" , type=Short.class,optional=false,search=true,target="combobox",values="CADRE;AGENT DE MAITRISE;EMPLOYE;EMPLOYE DE SERVICE;TEMPORAIRE")
	private String type = "0" ;
	
	@ManyToMany
	@JoinTable(name="T_CAT_ECH",joinColumns=@JoinColumn(name="CAT_ID"),inverseJoinColumns=@JoinColumn(name="ECH_ID"))
	@Predicate(label="ECHELON",type=Echelon.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="ECHELONS")
	private List<Echelon> echelons = new ArrayList<Echelon>();

	/**
	 * 
	 */
	public Categorie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Categorie(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	public Categorie(Categorie cat) {
		super(cat.id, cat.designation, cat.moduleName);
		this.code = cat.code;
		this.type = cat.type;
	}

	public Short getCode() {
		return code;
	}

	public void setCode(Short code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Echelon> getEchelons() {
		return echelons;
	}

	public void setEchelons(List<Echelon> echelons) {
		this.echelons = echelons;
	}

	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Catégorie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Catégories";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return Short.toString(code);
	}

	@Override
	public int compareTo(Categorie arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
