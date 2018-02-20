/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Contacts;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_etbl")
public class Etablissement extends BaseElement implements Serializable, Comparable<Etablissement> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "LOGO" )	
	@Predicate(label = "LOGO",target = "image", sequence=1 ,search=true , colsequence=1  )
	private String logo ;
	
	@Column(name = "NOM")
	@Predicate(label = "Nom",  search = true , sequence=2, colsequence=2)
	protected String nom;
	
	@Column(name = "DES")
	@Predicate(label="DESCRIPTION", target = "textarea", search = true, sequence=3)
	protected String description;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true )
    @JoinColumn(name ="CONTACTS_ID_ETB")
	@Predicate(label = "Contacts",group = true,groupName = "tab1",groupLabel = "Contacts",target = "one-to-many",type = Contacts.class,search = false)
	private List<Contacts> contact = new ArrayList<Contacts>();
	
	@Column(name = "ENTETE_ETAT" )	
	@Predicate(label = "ENTETE_ETAT",target = "image", group = true,groupName = "tab2",groupLabel = "Entete Rapport" )
	private String entete ;
	
	@Column(name = "FOOTER_ETAT" )	
	@Predicate(label = "FOOTER_ETAT",target = "image" ,group = true,groupName = "tab3",groupLabel = "Footer Rapport" )
	private String footer ;
	
	

	public Etablissement() {
	}

	public Etablissement(Etablissement etbl) {
		super(etbl.id, etbl.designation, etbl.moduleName);
		this.logo = etbl.logo;
		this.nom = etbl.nom;
		this.description = etbl.description;
		this.entete = etbl.entete;
		this.footer = etbl.footer;
		
		for(Contacts con:etbl.contact){
			contact.add(new Contacts(con));
	    }
		
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Etablissement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Etablissement Scolaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Etablissement Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom;
	}

	/**
	 * @return the logo
	 */
	public String getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the contact
	 */
	public List<Contacts> getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(List<Contacts> contact) {
		this.contact = contact;
	}

	/**
	 * @return the entete
	 */
	public String getEntete() {
		return entete;
	}

	/**
	 * @param entete the entete to set
	 */
	public void setEntete(String entete) {
		this.entete = entete;
	}

	/**
	 * @return the footer
	 */
	public String getFooter() {
		return footer;
	}

	/**
	 * @param footer the footer to set
	 */
	public void setFooter(String footer) {
		this.footer = footer;
	}
	
	

}
