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
@Table(name = "T_PAYS")
@XmlRootElement
public class Pays extends BaseElement implements Serializable, Comparable<Pays> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7038647813878811888L;
	
	 @Predicate(label = "image",target = "image",search = false)
     private String image ;
     
    @Predicate(label = "Nom du pays" ,optional = false,unique = true,search = true)
    private String intitule ;
    
    @Predicate(label = "Code du pays" ,optional = false,updatable = false,unique = true,search = true)
    private String code;

	/**
	 * 
	 */
	public Pays() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Pays(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	
 /**
  * 
  * @param id
  * @param designation
  * @param moduleName
  * @param image
  * @param intitule
  * @param code
  */
	public Pays(long id, String designation, String moduleName, String image, String intitule, String code) {
		super(id, designation, moduleName);
		this.image = image;
		this.intitule = intitule;
		this.code = code;
	}
	
	public Pays(Pays pays) {
		super(pays.id, pays.designation, pays.moduleName);
		this.image = pays.image;
		this.intitule = pays.intitule;
		this.code = pays.code;
	}
	
	  

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
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
		return "PAYS";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "PAYS";
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
	public int compareTo(Pays arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
