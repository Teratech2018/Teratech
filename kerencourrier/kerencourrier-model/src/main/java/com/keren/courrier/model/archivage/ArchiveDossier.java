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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.referentiels.PieceJointe;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.DossierCourrier;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeDossier;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 *
 * @author BEKO
 */
@Entity
@Table(name = "T_ARCDOCGC")
public class ArchiveDossier extends BaseElement implements Serializable, Comparable<ArchiveDossier> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Predicate(label = "Reference du dossier ", optional = false, search = true)
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
	@Predicate(label = "Type Dossier", type = DossierCourrier.class, target = "many-to-one", updatable = false, search = false, optional = true, observable = true)
	private DossierCourrier dossier;
	
	private String nature = " ";

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "ARCDOS_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", group = true, groupName = "group1", groupLabel = "Dossier à Archiver")
	//@Observer(observable="dossier",source="method:findpiecejointe")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
	
	@Predicate(label = "Mots clés", optional = false, group = true, groupName = "group2", groupLabel = "Autres Informations", search = true)
	private String motscles;

	@Predicate(label = "Decription sommaire du dossier", optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = false)
	private String description;

	@Predicate(label = "Nombre de Piece", type = Short.class, optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = true)
	private Short nbrepieces = 0;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Création", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = false)
	private Date dcreation;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Piéce Recente", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = false)
	private Date dprecente;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date Piéce Ancienne", type = Date.class, target = "date", optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = false)
	private Date dpancienne;

	@Predicate(label = "Observation ", optional = true, group = true, groupName = "group2", groupLabel = "Autres Informations", search = false, target = "textarea")
	private String observation;

	@Override
	public int compareTo(ArchiveDossier o) {
		// To change body of generated methods, choose Tools | Templates.
		return code.compareTo(o.code);
	}

	public ArchiveDossier(String code, String intitule, CadreClassement cadre, BoiteArchivage boite, String motscles,
			String description, Short nbrepieces, Correspondant correspondant, StructureCompany service,
			DossierCourrier dossier, Date dcreation, Date dprecente, Date dpancienne, String observation,
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
		this.dossier = dossier;
		this.dcreation = dcreation;
		this.dprecente = dprecente;
		this.dpancienne = dpancienne;
		this.observation = observation;
	}

	public ArchiveDossier(ArchiveDossier entity) {
		super(entity.id, entity.designation, entity.moduleName, entity.compareid);
		this.code = entity.code;
		this.intitule = entity.intitule;
		this.cadre = entity.cadre;
		this.boite = entity.boite;
		this.motscles = entity.motscles;
		this.description = entity.description;
		this.nbrepieces = entity.nbrepieces;
		this.correspondant = new Correspondant(entity.correspondant);
		this.service = new StructureCompany(entity.service);
		this.dossier = new DossierCourrier(entity.dossier);
		this.dcreation = entity.dcreation;
		this.dprecente = entity.dprecente;
		this.dpancienne = entity.dpancienne;
		this.observation = entity.observation;
		this.piecesjointes = new ArrayList<FichierLie>();
	}

	public DossierCourrier getDossier() {
		return dossier;
	}

	public void setDossier(DossierCourrier dossier) {
		this.dossier = dossier;
	}

	public ArchiveDossier() {
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

	public StructureCompany getService() {
		return service;
	}

	public void setService(StructureCompany service) {
		this.service = service;
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

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Date getDpancienne() {
		return dpancienne;
	}

	public void setDpancienne(Date dpancienne) {
		this.dpancienne = dpancienne;
	}

	public List<FichierLie> getPiecesjointes() {
		return piecesjointes;
	}

	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}

	@Override
	public String getListTitle() {
		return "Archives des Dossiers "; // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public String getEditTitle() {
		return "Archiver un Dossier"; // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

}
