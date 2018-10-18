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
@Table(name="e_fonction")
public class Fonction extends BaseElement implements Serializable, Comparable<Fonction> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1607730185733659522L;
	
	@Predicate(label="Code/Abbréviation",optional=false,unique=true,search=true)
	private String code ;
	
	@Predicate(label="Actif",type=Boolean.class,search=true)
	private Boolean actif = Boolean.TRUE;
	
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String intitule ;
	
	@Predicate(label="Type",search=true,target="combobox",values="Employé;Agent de Maitrise;cadre")
	private String type = "0" ;
	
	@Predicate(label="Descrition ",group=true,groupName="group1",groupLabel="Description de la fonction",target="textarea")
	private String description ;

	/**
	 * 
	 */
	public Fonction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Fonction(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public Fonction(Fonction fonc) {
		super(fonc.id, fonc.designation, fonc.moduleName,fonc.compareid);
		this.code = fonc.code;
		this.intitule = fonc.intitule;
		this.type = fonc.type;
		this.actif = fonc.actif;
		this.description = fonc.description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "FONCTION";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "FONCTIONS";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+"-"+intitule;
	}

	@Override
	public int compareTo(Fonction o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

    @Override
    public String toString() {
        return "Fonction{" + "code=" + code + ", intitule=" + intitule + '}';
    }
        
        

}
