/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keren.courrier.model.archivage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeDossier;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ARCDOCGC")
public class ArchiveLiasse extends BaseElement implements Serializable, Comparable<ArchiveLiasse> {

	/**
	 */
	private static final long serialVersionUID = 1L;

	@Predicate(label = "Reference du dossier", optional = false, search = true)
	private String code;

	@Predicate(label = "Objet", optional = false, search = true)
	private String intitule;

	@ManyToOne
	@JoinColumn(name = "CAD_ID")
	@Predicate(label = "Numéro de série", type = CadreClassement.class, target = "many-to-one", search = true)
	private CadreClassement cadre;

	@ManyToOne
	@JoinColumn(name = "T_CORRES")
	@Predicate(label = "Expéditeur", type = Correspondant.class, target = "many-to-one", search = true, optional = false)
	private Correspondant correspondant;

	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Ayant traité", type = StructureCompany.class, target = "many-to-one", updatable = false, search = true, optional = true, observable = true)
	private StructureCompany service;

	@ManyToOne
	@JoinColumn(name = "BOI_ID")
	@Predicate(label = "Boîte d'archivage", type = BoiteArchivage.class, target = "many-to-one", search = true)
	private BoiteArchivage boite;

	@ManyToOne
	@JoinColumn(name = "T_TYPDOS")
//	@Predicate(label = "Type Dossier", type = TypeDossier.class, target = "many-to-one", updatable = false, search = false, optional = true, observable = true)
	private TypeDossier typeDossier;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "LIASS_ID")
	@Predicate(label = "Liasse concerné", type = LiasseDocumentTri.class, target = "many-to-many-list", group = true, groupName = "group1", groupLabel = "Liasse Archivés")
	private List<LiasseDocumentTri> liassedocuments = new ArrayList<LiasseDocumentTri>();
	
	@Predicate(label = "Mots clés", optional = false, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = true)
	private String motscles;

	@Predicate(label = "Decription sommaire du dossier", optional = true, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = false)
	private String description;

	@Predicate(label = "Nombre de Piece", type = Short.class, optional = true, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = true)
	private Short nbrepieces = 0;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Création", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = false)
	private Date dcreation;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Piéce Recente", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = false)
	private Date dprecente;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Piéce Ancienne", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Infrmations", search = false)
	private Date dpancienne;

	@Predicate(label = "Observation ", optional = true, group = true, groupName = "group2", groupLabel = "Général", search = false, target = "textarea")
	private String observation;
	
	 //@Predicate(label = "Mention du courrier", target = "combobox", values = "Documents;Dossiers;Liasses", search = true)
	private String nature = " ";


	@Override
	public int compareTo(ArchiveLiasse o) {
		// To change body of generated methods, choose Tools | Templates.
		return code.compareTo(o.code);
	}

	public ArchiveLiasse(String code, String intitule, CadreClassement cadre, BoiteArchivage boite, String motscles,
			String description, Short nbrepieces, Correspondant correspondant, StructureCompany service,
			TypeDossier typeDossier, Date dcreation, Date dprecente, Date dpancienne, String observation,
			List<FichierLie> piecesjointes) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.cadre = cadre;
		this.boite = boite;
		this.motscles = motscles;
		this.description = description;
		this.nbrepieces = nbrepieces;
		this.correspondant = correspondant;
		this.service = service;
		this.typeDossier = typeDossier;
		this.dcreation = dcreation;
		this.dprecente = dprecente;
		this.dpancienne = dpancienne;
		this.observation = observation;
//		this.piecesjointes = piecesjointes;
	}

	public ArchiveLiasse(ArchiveLiasse entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		
		this.code = entity.code;
		this.intitule = entity.intitule;
		
		if(entity.cadre!=null){
			this.cadre = new CadreClassement(entity.cadre);
		}
		if(entity.boite!=null){
			this.boite = new BoiteArchivage(entity.boite);	
		}
		
		this.motscles = entity.motscles;
		this.description = entity.description;
		this.nbrepieces = entity.nbrepieces;
		if(entity.correspondant!=null){
			this.correspondant = new Correspondant(entity.correspondant);
		}
		if(entity.service!=null){
			this.service = new StructureCompany(entity.service);
		}
		if(entity.typeDossier!=null){
			this.typeDossier = new TypeDossier(entity.typeDossier);
		}
		
		this.dcreation = entity.dcreation;
		this.dprecente = entity.dprecente;
		this.dpancienne = entity.dpancienne;
		this.observation = entity.observation;
		this.liassedocuments = new ArrayList<LiasseDocumentTri>();
//		this.piecesjointes = new ArrayList<FichierLie>();
	}

	public ArchiveLiasse() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public CadreClassement getCadre() {
		return cadre;
	}

	public void setCadre(CadreClassement cadre) {
		this.cadre = cadre;
	}

	public BoiteArchivage getBoite() {
		return boite;
	}

	public void setBoite(BoiteArchivage boite) {
		this.boite = boite;
	}

	public String getMotscles() {
		return motscles;
	}

	public void setMotscles(String motscles) {
		this.motscles = motscles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Short getNbrepieces() {
		return nbrepieces;
	}

	public void setNbrepieces(Short nbrepieces) {
		this.nbrepieces = nbrepieces;
	}

	public Correspondant getCorrespondant() {
		return correspondant;
	}

	public void setCorrespondant(Correspondant correspondant) {
		this.correspondant = correspondant;
	}

	public List<LiasseDocumentTri> getLiassedocuments() {
		return liassedocuments;
	}

	public void setLiassedocuments(List<LiasseDocumentTri> liassedocuments) {
		this.liassedocuments = liassedocuments;
	}

	public StructureCompany getService() {
		return service;
	}

	public void setService(StructureCompany service) {
		this.service = service;
	}

	public TypeDossier getTypeDossier() {
		return typeDossier;
	}

	public void setTypeDossier(TypeDossier typeDossier) {
		this.typeDossier = typeDossier;
	}

	public Date getDcreation() {
		return dcreation;
	}

	public void setDcreation(Date dcreation) {
		this.dcreation = dcreation;
	}

	public Date getDprecente() {
		return dprecente;
	}

	public void setDprecente(Date dprecente) {
		this.dprecente = dprecente;
	}

	public Date getDpancienne() {
		return dpancienne;
	}

	public void setDpancienne(Date dpancienne) {
		this.dpancienne = dpancienne;
	}



	@Override
	public String getListTitle() {
		return "Archiver une  Liasse "; // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	@Override
	public String getEditTitle() {
		return "Archiver une  Liasse "; // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

}
