/**
 * 
 */
package com.keren.model.formations;

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
@Table(name="T_FORMRH")
public class Formateur extends BaseElement implements Serializable, Comparable<Formateur> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6614371836289897854L;
	
	@Predicate(label="Nom",optional=false,search=true)
	private String nom;
	
	@Predicate(label="Qualification",search=true)
	private String qualif ;
	
	@Predicate(label="Adresse",search=true)
	private String adress ;
	
	@Predicate(label="Courriel",search=true)
	private String mail ;
	

	/**
	 * 
	 */
	public Formateur() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Formateur(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param nom
	 * @param qualif
	 * @param adress
	 * @param mail
	 */

	public Formateur(long id, String designation, String moduleName, String nom, String qualif, String adress,
			String mail) {
		super(id, designation, moduleName);
		this.nom = nom;
		this.qualif = qualif;
		this.adress = adress;
		this.mail = mail;
	}
	
	/**
	 * 
	 * @param formateur
	 */
	public Formateur(Formateur formateur) {
		super(formateur.id, formateur.designation, formateur.moduleName);
		this.nom = formateur.nom;
		this.qualif = formateur.qualif;
		this.adress = formateur.adress;
		this.mail = formateur.mail;
	}
	
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getQualif() {
		return qualif;
	}

	public void setQualif(String qualif) {
		this.qualif = qualif;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Formateur";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Formateurs";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Formateur o) {
		// TODO Auto-generated method stub
		return nom.compareTo(o.nom);
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", qualif=" + qualif + ", adress=" + adress + ", mail=" + mail + ", id=" + id
				+ "]";
	}
	
	

}
