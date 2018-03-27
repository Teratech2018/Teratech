/**
 * 
 */
package com.keren.kerenpaie.model.comptabilite;

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
@Table(name="T_BANQUE")
public class Banque extends BaseElement implements Serializable, Comparable<Banque> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -12411984333486963L;

	@Predicate(label = "Code banque",updatable = false,optional = false,unique = true,search = true)
    private String code ;
    
    @Predicate(label = "Nom",search = true)
    private String label ;
    
    @Predicate(label = "Adresse",group = true,groupName = "group1",groupLabel = "Informations",search = true)
    private String adresse ;
    
    @Predicate(label = "Téléphone",group = true,groupName = "group1",groupLabel = "Informations",search = true)
    private String tel ;
    
    @Predicate(label = "Fax",group = true,groupName = "group1",groupLabel = "Informations",search = true)
    private String fax ;
    
    @Predicate(label = "Courriel",group = true,groupName = "group1",groupLabel = "Informations",search = true)
    private String courriel ;
    
    @Predicate(label = "Actif",group = true,groupName = "group1",groupLabel = "Informations")
    private Boolean active = true;
	    
	/**
	 * 
	 */
	public Banque() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Banque(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public int compareTo(Banque o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "BANQUE";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "BANQUES";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
	}
	
	

}
