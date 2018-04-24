/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.w3c.dom.stylesheets.LinkStyle;

import com.core.base.BaseElement;
import com.keren.model.structures.Pays;
import com.keren.model.structures.Ville;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_CANSPORH")
public class CandidatureSpontane extends BaseElement implements Serializable, Comparable<CandidatureSpontane> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9051161593766292464L;
	
	@Predicate(label="Objet",search=true)
	private String objet ;
	
	@ManyToOne
	@JoinColumn(name="PAY_ID")
	@Predicate(label="Nationalité",type=Pays.class,target="many-to-one",search=true)
	private Pays nationalite ;
	
	@Predicate(label="Nom et Prenom",optional=false,search=true)
	private String nom ;
	
	@ManyToOne
	@JoinColumn(name="VIL_ID")
	@Predicate(label="Lieu de résidence",type=Ville.class,target="many-to-one")
	private Ville residence ;
	
	@Predicate(label="Etat civil",target="combobox",values="Célébataire;Marié;Veuf(ve);Divorcé(e)")
	private String statut ="0";
	
	@Predicate(label="Quatier")
	private String quatier;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de naissance",type=Date.class,target="date")
	private Date naissa;
	
	@Predicate(label="Téléphone",target="tel")
	private String tel ;
	
	@Predicate(label="Courriel",target="email")
	private String mail ;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="CANSPO_ID")
	@Predicate(label=".",type=FormationCandidat.class,target="one-to-many",group=true,groupName="group1",groupLabel="Formations",edittable=true)
	private List<FormationCandidat> formations = new ArrayList<FormationCandidat>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="CANSPO_ID")
	@Predicate(label=".",type=ExperienceCandidat.class,target="one-to-many",group=true,groupName="group2",groupLabel="Experiences",edittable=true)
	private List<ExperienceCandidat> experiences = new ArrayList<ExperienceCandidat>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="CANSPO_ID")
	@Predicate(label=".",type=LangueCandidat.class,target="one-to-many",group=true,groupName="group3",groupLabel="Langues",edittable=true)
	private List<LangueCandidat> langues = new ArrayList<LangueCandidat>();

	@Lob
	@Predicate(label=".",target="richeditor",group=true,groupName="group4",groupLabel="Resumé Candidature",search=true)
	private String resume ;
	
	/**
	 * 
	 */
	public CandidatureSpontane() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CandidatureSpontane(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param objet
	 * @param nationalite
	 * @param nom
	 * @param residence
	 * @param statut
	 * @param quatier
	 * @param naissa
	 * @param tel
	 * @param mail
	 * @param formations
	 * @param experiences
	 * @param langues
	 * @param resume
	 */

	public CandidatureSpontane(long id, String designation, String moduleName, String objet, Pays nationalite,
			String nom, Ville residence, String statut, String quatier, Date naissa, String tel, String mail,
			List<FormationCandidat> formations, List<ExperienceCandidat> experiences, List<LangueCandidat> langues,
			String resume) {
		super(id, designation, moduleName);
		this.objet = objet;
		this.nationalite = nationalite;
		this.nom = nom;
		this.residence = residence;
		this.statut = statut;
		this.quatier = quatier;
		this.naissa = naissa;
		this.tel = tel;
		this.mail = mail;
		this.formations = formations;
		this.experiences = experiences;
		this.langues = langues;
		this.resume = resume;
	}

	public CandidatureSpontane(CandidatureSpontane candidat) {
		super(candidat.id, candidat.designation, candidat.moduleName);
		this.objet = candidat.objet;
		if(candidat.nationalite!=null){
			this.nationalite = new Pays(candidat.nationalite);
		}
		this.nom = candidat.nom;
		this.residence = candidat.residence;
		this.statut = candidat.statut;
		this.quatier = candidat.quatier;
		this.naissa = candidat.naissa;
		this.tel = candidat.tel;
		this.mail = candidat.mail;
		this.resume = candidat.resume;
	}
	
	

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public Pays getNationalite() {
		return nationalite;
	}

	public void setNationalite(Pays nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Ville getResidence() {
		return residence;
	}

	public void setResidence(Ville residence) {
		this.residence = residence;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getQuatier() {
		return quatier;
	}

	public void setQuatier(String quatier) {
		this.quatier = quatier;
	}

	public Date getNaissa() {
		return naissa;
	}

	public void setNaissa(Date naissa) {
		this.naissa = naissa;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<FormationCandidat> getFormations() {
		return formations;
	}

	public void setFormations(List<FormationCandidat> formations) {
		this.formations = formations;
	}

	public List<ExperienceCandidat> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<ExperienceCandidat> experiences) {
		this.experiences = experiences;
	}

	public List<LangueCandidat> getLangues() {
		return langues;
	}

	public void setLangues(List<LangueCandidat> langues) {
		this.langues = langues;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Candidature";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Candidatures";
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

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CandidatureSpontane o) {
		// TODO Auto-generated method stub
		return nom.compareTo(o.nom);
	}

}
