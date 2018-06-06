/**
 * 
 */
package com.keren.model.recrutement;

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
@Table(name="T_LANGRH")
public class LangueCandidat extends BaseElement implements Serializable, Comparable<LangueCandidat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2651535106778713492L;
	
	@Predicate(label="Langue",target="combobox",values="Francais;Anglais;Allemend;Espagnol;Portugais",search=true)
	private String langue ;
	
	@Predicate(label="Niveau de Langue",target="combobox",values="Notions;Courant;Professionel",search=true)
	private String niveau ;

	/**
	 * 
	 */
	public LangueCandidat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LangueCandidat(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param langue
	 * @param niveau
	 */

	public LangueCandidat(long id, String designation, String moduleName, String langue, String niveau) {
		super(id, designation, moduleName,0L);
		this.langue = langue;
		this.niveau = niveau;
	}
	
	public LangueCandidat(LangueCandidat langue) {
		super(langue.id, langue.designation, langue.moduleName,langue.compareid);
		this.langue = langue.langue;
		this.niveau = langue.niveau;
	}
	
	

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LangueCandidat o) {
		// TODO Auto-generated method stub
		return langue.compareTo(o.langue);
	}

}
