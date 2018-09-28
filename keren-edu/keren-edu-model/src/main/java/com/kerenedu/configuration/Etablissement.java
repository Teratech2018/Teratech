/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "T_SOCIETE")
@XmlRootElement
public class Etablissement extends BaseElement implements Serializable, Comparable<Etablissement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "LOGO")
	@Predicate(label = "LOGO", target = "image")
	private String logo;

	@Column(name = "NOM")
	@Predicate(label = "Nom", search = true, optional = false)
	protected String nom;

	@Column(name = "CONTACT")
	@Predicate(label = "Contacts", search = true, optional = false)
	protected String contacts;

	@Column(name = "ADR")
	@Predicate(label = "Adresse", search = true, optional = false)
	protected String adresse;

	@Column(name = "EMAIL")
	@Predicate(label = "Email", search = true)
	protected String email;

	@Column(name = "SITE")
	@Predicate(label = "Site Web", search = true)
	protected String sites;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CYCLE_ID")
	@Predicate(label = "Cycle", group = true, groupName = "tab1", groupLabel = "Cycle", target = "one-to-many", type = Cycle.class, search = false)
	private List<Cycle> cyles;

	@Column(name = "ANNIV_ELEVE")
	@Predicate(label = "Allerte Anniversaire Elève ?", group = true, groupName = "tab2", groupLabel = "Gestion des Allertes", type = Boolean.class, search = false)
	protected Boolean allerteanniveleve = Boolean.FALSE;;

	@Column(name = "ANNIV_TUTEUR")
	@Predicate(label = "Allerte Anniversaire Tuteur ?", group = true, groupName = "tab2", groupLabel = "Gestion des Allertes", type = Boolean.class, search = false)
	protected Boolean allerteannivTuteur = Boolean.FALSE;;

	@Column(name = "DELAI_PAIEMENT")
	@Predicate(label = "Allerte Delai de Paiement ?", group = true, groupName = "tab2", groupLabel = "Gestion des Allertes", type = Boolean.class, search = false)
	protected Boolean allertedelaiPaiement = Boolean.FALSE;

	@Column(name = "N_MORATOIRE")
	@Predicate(label = "Quota de Moratoire", type = Long.class)
	private long quota;

	public Etablissement() {
	}

	public Etablissement(Etablissement etbl) {
		super(etbl.id, etbl.designation, etbl.moduleName, 0L);
		this.logo = etbl.logo;
		this.nom = etbl.nom;
		this.contacts = etbl.contacts;
		this.adresse = etbl.adresse;
		this.email = etbl.email;
		this.allerteanniveleve = etbl.allerteanniveleve;
		this.allerteannivTuteur = etbl.allerteannivTuteur;
		this.allertedelaiPaiement = etbl.allertedelaiPaiement;
		this.quota=etbl.quota;
		this.cyles = new ArrayList<Cycle>();
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
	 * @param logo
	 *            the logo to set
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
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}

	

	public Boolean getAllerteanniveleve() {
		return allerteanniveleve;
	}

	public void setAllerteanniveleve(Boolean allerteanniveleve) {
		this.allerteanniveleve = allerteanniveleve;
	}

	public Boolean getAllerteannivTuteur() {
		return allerteannivTuteur;
	}

	public void setAllerteannivTuteur(Boolean allerteannivTuteur) {
		this.allerteannivTuteur = allerteannivTuteur;
	}

	public Boolean getAllertedelaiPaiement() {
		return allertedelaiPaiement;
	}

	public void setAllertedelaiPaiement(Boolean allertedelaiPaiement) {
		this.allertedelaiPaiement = allertedelaiPaiement;
	}

	public long getQuota() {
		return quota;
	}

	public void setQuota(long quota) {
		this.quota = quota;
	}

	public List<Cycle> getCyles() {
		return cyles;
	}

	public void setCyles(List<Cycle> cyles) {
		this.cyles = cyles;
	}

}
