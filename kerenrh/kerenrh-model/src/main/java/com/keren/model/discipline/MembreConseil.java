/**
 * 
 */
package com.keren.model.discipline;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */ 
@Entity
@Table(name="T_MECORH")
public class MembreConseil extends BaseElement implements Serializable, Comparable<MembreConseil> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4340932266817438153L;
	
	@ManyToOne
	@JoinColumn(name="EMP_ID")  
	@Predicate(label="Membre",type=Employe.class,target="many-to-one",optional=false,nullable=false,search=true)
	private Employe employe ;
	
	@Predicate(label="Qualité du membre",target="combobox",values="Président;Délégué membre;Sécrétaire;Rapporteur;Témoin",search=true)
	private String qualite ;
	

	/**
	 * 
	 */
	public MembreConseil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public MembreConseil(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param employe
	 * @param qualite
	 */

	public MembreConseil(long id, String designation, String moduleName, Employe employe, String qualite) {
		super(id, designation, moduleName);
		this.employe = employe;
		this.qualite = qualite;
	}
	
	public MembreConseil(MembreConseil mem) {
		super(mem.id, mem.designation, mem.moduleName);
		if(mem.employe!=null){
			this.employe = new Employe(mem.employe);
		}
		this.qualite = mem.qualite;
	}
	
	

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public String getQualite() {
		return qualite;
	}

	public void setQualite(String qualite) {
		this.qualite = qualite;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "MEMBRE DU CONSEIL";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "MEMBRES DU CONSEIL";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(MembreConseil o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}

}
