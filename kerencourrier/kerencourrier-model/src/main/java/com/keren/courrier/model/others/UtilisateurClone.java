/**
 * 
 */
package com.keren.courrier.model.others;

import com.keren.courrier.model.referentiel.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_CONTKC")
public class UtilisateurClone extends BaseElement implements Serializable, Comparable<UtilisateurClone> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1305068370002429237L;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	@Predicate(label = "Compte lié", type = User.class, target = "many-to-one", optional = false, search = true)
	private User compte;

	 @ManyToOne
	 @JoinColumn(name = "SERV_ID")
	 @Predicate(label = "Service affectation",type =
	 StructureCompany.class,target = "many-to-one",optional = false,search =
	 true)
	 private StructureCompany service ;

	// @Predicate(label="Nature du
	// Contact",optional=false,updatable=false,search=true, target="combobox",
	// values="Particulier;Personne Morale")
	private String nature = "3";

	@ManyToOne
	@JoinColumn(name = "T_CORRES")
	// @Predicate(label="Type de
	// Contact",updatable=true,type=TypeCorrespondant.class ,
	// target="many-to-one",search=true)
	// @Filter(value="[{\"fieldName\":\"nature\",\"value\":\"object.nature\",\"optional\":true,\"message\":\"Veuillez
	// sélectionner la nature\"}]")
	protected TypeCorrespondant type;

	// Particulier
	@Column(name = "NOM")
	@Predicate(label = "Nom ", optional = true, updatable = true, search = true)
	private String nom;

	@Column(name = "PRENOM")
	@Predicate(label = "Prénom ", optional = true, updatable = true, search = false)
	private String prenom;

	@ManyToOne
	@JoinColumn(name = "J_CIV")
	@Predicate(label = "Civilité ", optional = true, updatable = true, search = false, type = Civilite.class, target = "many-to-one")
	protected Civilite civilite;

	@Column(name = "FONTION")
	@Predicate(label = "Fonction ", optional = true, updatable = true, search = false)
	private String fonction;

	@Column(name = "SIG")
	// @Predicate(label="Sigle Structure
	// ",optional=true,updatable=true,search=false)
	private String sigle;

	@Predicate(label = "Adresse", group = true, groupName = "group1", groupLabel = "Adresse")
	private String adress;

	@Predicate(label = "Boîte postale", group = true, groupName = "group1", groupLabel = "Adresse")
	private String bp;

	@Predicate(label = "Courriel ", group = true, groupName = "group1", groupLabel = "Adresse")
	private String courriel;

	@Predicate(label = "Pays", group = true, groupName = "group1", groupLabel = "Adresse")
	private String pays;

	@Predicate(label = "Ville", group = true, groupName = "group1", groupLabel = "Adresse")
	private String ville;

	@Predicate(label = "Téléphone", group = true, groupName = "group1", groupLabel = "Adresse")
	private String telephone;

	@Predicate(label = "Fax", group = true, groupName = "group1", groupLabel = "Adresse")
	private String fax;
	@Predicate(label = "Site internet", group = true, groupName = "group1", groupLabel = "Adresse")
	private String site;

	/*
	 * @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "CONT_ID")
	 * 
	 * @Predicate(label = "",type = Contact.class,target =
	 * "one-to-many",edittable = true,group = true,groupName =
	 * "group2",groupLabel = "Contacts") private List<Contact> contacts = new
	 * ArrayList<Contact>();
	 */

	/**
	 * 
	 */
	public UtilisateurClone() {
		// TODO Auto-generated constructor stub
	}

	public UtilisateurClone(TypeCorrespondant type, String structure, String sigle, Civilite civilite, String nom,
			String prenom, String fonction, String courriel, String obs, String adress, String bp, String pays,
			String ville, String telephone, String fax, String site, long id, String designation, String moduleName,
			long comparedid) {
		super(id, designation, moduleName, comparedid);
		this.type = type;
		this.sigle = sigle;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.courriel = courriel;
		// this.obs = obs;
		this.adress = adress;
		this.bp = bp;
		this.pays = pays;
		this.ville = ville;
		this.telephone = telephone;
		this.fax = fax;
		this.site = site;
	}

	public UtilisateurClone(UtilisateurClone entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.type = entity.type;
		this.sigle = entity.sigle;
		this.civilite = entity.civilite;
		this.nom = entity.nom;
		this.prenom = entity.prenom;
		this.fonction = entity.fonction;
		this.courriel = entity.courriel;
		// this.obs = entity.obs;
		this.adress = entity.adress;
		this.bp = entity.bp;
		this.pays = entity.pays;
		this.ville = entity.ville;
		this.telephone = entity.telephone;
		this.fax = entity.fax;
		this.site = entity.site;
		this.nature = entity.nature;
		if (entity.compte != null) {
			this.compte = new User(entity.compte);
		}
//		 if(entity.service!=null){
//		 this.service = new StructureCompany(entity.service);
//		 }
	}

	public UtilisateurClone(UtilisateurClone entity, String compte) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.type = entity.type;
		this.sigle = entity.sigle;
		this.civilite = entity.civilite;
		this.nom = entity.nom;
		this.prenom = entity.prenom;
		this.fonction = entity.fonction;
		this.courriel = entity.courriel;
		// this.obs = entity.obs;
		this.adress = entity.adress;
		this.bp = entity.bp;
		this.pays = entity.pays;
		this.ville = entity.ville;
		this.telephone = entity.telephone;
		this.fax = entity.fax;
		this.site = entity.site;
		this.nature = entity.nature;
		// if(entity.compte!=null){
		// this.compte = new User(entity.compte);
		// }
		// if(entity.service!=null){
		// this.service = new StructureCompany(entity.service);
		// }
	}

	public UtilisateurClone(UtilisateurCourrier entity) {
		super(entity.getId(), entity.getDesignation(), entity.getModuleName(), entity.getCompareid());
		this.type = entity.getType();
		this.sigle = entity.getSigle();
		this.civilite = entity.getCivilite();
		this.nom = entity.getNom();
		this.prenom = entity.getPrenom();
		this.fonction = entity.getFonction();
		this.courriel = entity.getCourriel();
		// this.obs = entity.obs;
		this.adress = entity.getAdress();
		this.bp = entity.getBp();
		this.pays = entity.getPays();
		this.ville = entity.getVille();
		this.telephone = entity.getTelephone();
		this.fax = entity.getFax();
		this.site = entity.getSite();
		this.nature = entity.getNature();
		// if(entity.compte!=null){
		// this.compte = new User(entity.compte);
		// }
		// if(entity.service!=null){
		// this.service = new StructureCompany(entity.service);
		// }
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Utilisateurs";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Utilisateur";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return nom + " " + prenom;
	}

	@Override
	public int compareTo(UtilisateurClone o) {
		// TODO Auto-generated method stub
		return nom.compareTo(o.nom);
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBp() {
		return bp;
	}

	public void setBp(String bp) {
		this.bp = bp;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public TypeCorrespondant getType() {
		return type;
	}

	public void setType(TypeCorrespondant type) {
		this.type = type;
	}

	public String getSigle() {
		return sigle;
	}

	public void setSigle(String sigle) {
		this.sigle = sigle;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public User getCompte() {
		return compte;
	}

	public void setCompte(User compte) {
		this.compte = compte;
	}

	 public StructureCompany getService() {
	 return service;
	 }
	
	 public void setService(StructureCompany service) {
	 this.service = service;
	 }

}
