/**
 * 
 */
package com.keren.kerenpaie.model.structures;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "T_REGION")
@XmlRootElement
public class Region extends BaseElement implements Serializable,Comparable<Region>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4507609418715013335L;
	
	@Predicate(label = "Code de la Region" ,optional = false,unique = true,search = true)
    private String code ;
   
   @Predicate(label = "Nom de la Region" ,optional = false,unique = true,search = true)
    private String intitule ;

	/**
	 * 
	 */
	public Region() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param intitule
	 */

	public Region(long id, String designation, String moduleName, String code, String intitule) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.intitule = intitule;
	}


	public Region(Region reg) {
		super(reg.id, reg.designation, reg.moduleName,reg.compareid);
		this.code = reg.code;
		this.intitule = reg.intitule;
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
	
	


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "REGION";
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "REGIONS";
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}


	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return intitule;
	}


	@Override
	public int compareTo(Region arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
