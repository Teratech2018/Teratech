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
@Table(name="e_banque")
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

    
    @Predicate(label = "Actif",group = true,groupName = "group1",groupLabel = "Informations")
    private Boolean active = true;
	    
	/**
	 * 
	 */
	public Banque() {
		// TODO Auto-generated constructor stub
	}
	

	public Banque(String code, String label, String adresse, Boolean active) {
		super();
		this.code = code;
		this.label = label;
		this.adresse = adresse;
		this.active = active;
	}
	
	public Banque(Banque entity) {
		super(entity.id, entity.designation, entity.moduleName, 0L);
		this.code = entity.code;
		this.label = entity.label;
		this.adresse = entity.adresse;
		this.active = entity.active;
	}


	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Banque(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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

	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
	}

    @Override
    public String toString() {
        return code;
    }

	public int compareTo(Banque o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
