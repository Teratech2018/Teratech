/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_cat")
public class Categorie extends BaseElement implements Serializable, Comparable<Categorie> {


	@Predicate(label="Code catégorie" , type=Short.class,optional=false,search=true, sequence=1)
	private Short code ;
	
	@Predicate(label="Type" , type=Short.class,optional=false,search=true,target="combobox",
			values="CADRE;AGENT DE MAITRISE;EMPLOYE;EMPLOYE DE SERVICE;TEMPORAIRE", sequence=2)
	private String type = "0" ;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "e_CAT_ECH")
	@Predicate(group = true,groupName = "tab1",groupLabel = "MATIERE",target = "many-to-many-list",type = Echellon.class,search = false)
//	@Filter(value="[{\"fieldName\":\"filiere\",\"value\":\"object.filiere\",\"searchfield\":\"code\"}]")
	private List<Echellon> echelons = new ArrayList<Echellon>();
	
	
//	@ManyToMany
//	@JoinTable(name="e_CAT_ECH",joinColumns=@JoinColumn(name="CAT_ID"),inverseJoinColumns=@JoinColumn(name="ECH_ID"))
//	@Predicate(label="ECHELON",type=Echellon.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="ECHELONS")
//	private List<Echellon> echelons = new ArrayList<Echellon>();

	





	public Categorie(Short code, String type, List<Echellon> echelons) {
		super();
		this.code = code;
		this.type = type;
		this.echelons = echelons;
	}
	

	public Categorie(Categorie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code =entity.code;
		this.type = entity.type;
		this.echelons = new ArrayList<Echellon>();
	}








	public Categorie() {
		// TODO Auto-generated constructor stub
	}


	public int compareTo(Categorie o) {
		// TODO Auto-generated method stub
		return 0;
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







	public List<Echellon> getEchelons() {
		return echelons;
	}







	public void setEchelons(List<Echellon> echelons) {
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
		return "Catégorie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"";
	}




}
