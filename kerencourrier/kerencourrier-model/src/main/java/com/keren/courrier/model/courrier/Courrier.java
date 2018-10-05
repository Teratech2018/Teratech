/**
 * 
 */
package com.keren.courrier.model.courrier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.DossierCourrier;
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.Statut;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.workflow.WorkflowAction;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_COURRGC")
public class Courrier extends BaseElement implements Serializable, Comparable<Courrier> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3033098358734571005L;

	@Predicate(label = "Numéro du Courrier", search = true, optional = true, unique = true, updatable=false, sequence=2, editable=false)
	private String code;
	
	@Column(name="reference",unique=true)
	@Predicate(label = "Reférence d'envoi", search = true, optional = true, unique = true , sequence=1)
	private String reference;      

	@Predicate(label = "Mention du courrier", target = "combobox", values = "Ordinaire;Confidentiel", search = true, sequence=3, optional=true)
	private String porte = "0";

	@ManyToOne
	@JoinColumn(name = "T_NATURE")
	@Predicate(label = "Nature", type = NatureCourrier.class, target = "many-to-one", search = true, sequence=4, optional=false)
	private NatureCourrier nature;

	@Column(name = "T_CAT")
//	@Predicate(label = "Catégorie Courrier", optional = true, search = false, editable = false, target = "combobox", values = "Courrier Arrivée;Courrier Départ;Courrier Interne;Document GED")
	private String categorie;

	@ManyToOne
	@JoinColumn(name = "T_TYPE")
	// @Predicate(label = "Type Courrier", type = TypeCourrier.class, target =
	// "many-to-one", search = true, optional = false)
	private TypeCourrier typecourrier;

	@ManyToOne
	@JoinColumn(name = "T_PRIO")
	@Predicate(label = "Priorité", type = Priorite.class, target = "many-to-one", search = true, optional = true, observable = true, sequence=8)
	private Priorite priorite;

	@Column(name = "D_COUR")
	@Predicate(label = "Date de Création du Courrier", optional = true, updatable = false, search = false, type = Date.class, target = "date", sequence=5)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dcourrier;

	@Column(name = "D_ARR")
	@Predicate(label = "Date d'arrivée Courrier", optional = true, updatable = false, search = false, type = Date.class, target = "date", sequence=6)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date darrive;
	
	@Column(name = "D_EXP")
	@Predicate(label = "Date d'expédition du courrier", optional = true, updatable = false, search = false, type = Date.class, target = "date", sequence=7)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dexep;

	@ManyToOne
	@JoinColumn(name = "T_CORRES")
	@Predicate(label = "Expéditeur", type = Correspondant.class, target = "many-to-one", search = true, optional = false, sequence=9)
	private Correspondant correspondant;

	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Traitant", type = StructureCompany.class, target = "many-to-one", updatable = false, search = true, 
	optional = false, observable = true, sequence=10)
	private StructureCompany service;

	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinTable(name="T_CA_DEST",joinColumns=@JoinColumn(name="CA_ID"),inverseJoinColumns=@JoinColumn(name="USER_ID"))
	@Predicate(label = "Destinataire",target = "many-to-many-list",type = UtilisateurCourrier.class,search = false, sequence=11, optional=true)
	private List<UtilisateurCourrier> destinataire ;
	
//	@ManyToOne
//	@JoinColumn(name = "DES_ID")
//	@Predicate(label = "Destinataire", type = UtilisateurCourrier.class, updatable = false, target = "many-to-one", search = true, sequence=10, optional=true)
//	private List<UtilisateurCourrier> destinataire;
	
	@Lob
	@Predicate(label = "Objet", target = "textarea" ,optional=false , sequence=13)
	private String objet;
	
	@Predicate(label = "Signataire", optional=false, sequence=12)
	private String signataire;


	@ManyToOne
	@JoinColumn(name = "STAT_ID")
	// @Predicate(label = "Statut courrier",type = Statut.class,target =
	// "many-to-one" ,optional = false,search = true)
	private Statut statutcourrier;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "objet/Pièces jointes")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();
	
	//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "COU_ID")
//	private List<TraitementCourrier> traitements = new ArrayList<TraitementCourrier>();

	
	@Temporal(javax.persistence.TemporalType.DATE)
	//@Predicate(label = "Date limite", type = Date.class, target = "date", search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	//@Observer(observable = "priorite", source = "method:datelimite", parameters = "priorite")
	private Date limite;

	
	@ManyToOne
	@JoinColumn(name = "T_DOS")
	@Predicate(label = "Dossier", type = DossierCourrier.class, target = "many-to-one", search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	//@Filter(value = "[{\"fieldName\":\"classement\",\"value\":\"1\"}]")
	protected DossierCourrier dossier;

	@Column(name = "MOTS_CLES")
	@Predicate(label = "Mots Clés", updatable = true, search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	protected String motscles;

	@ManyToOne
	@JoinColumn(name = "ETA_ID")
	private WorkflowAction etape;

	@Predicate(label = "Etat", search = true, hide = true)
	private String state = "etabli";

	// @OneToMany(mappedBy = "courrier",fetch = FetchType.LAZY)
	// private List<TraitementCourrier> traitements = new
	// ArrayList<TraitementCourrier>();

	@ManyToOne
	@JoinColumn(name = "SOUR_ID")
	private UtilisateurCourrier source;

	@ManyToOne
	@JoinColumn(name = "OWSERV_ID")
	// @Predicate(label = "Service Traitant", type = StructureCompany.class,
	// target = "many-to-one",updatable = false, search = true, optional =
	// true,observable = true)
	private StructureCompany sowner;

	@ManyToOne
	@JoinColumn(name = "ORI_ID")
	private Courrier origanal;

	@ManyToOne
	@JoinColumn(name = "BORD_ID")
	private BorderoCourrier bordero;
	/*
	 * @Column(name = "D_LIM_TRT")
	 * 
	 * @Predicate(label = "Date Limite Traitement", optional = true, updatable =
	 * false, search = false, type = Date.class, target = "date", group = true,
	 * groupLabel = "Informations Complémentaires", groupName = "tab6", hidden =
	 * "currentObject.limite ==true") private Date dlimtrt;
	 * 
	 * @Lob
	 * 
	 * @Column(name = "OBS")
	 * 
	 * @Predicate(label = "Observation", optional = false, search = false, group
	 * = true, groupLabel = "Informations Complémentaires", groupName = "tab6")
	 * private String obs;
	 */

	public Courrier(String categorie, String niveauDeTraitement, TypeCourrier typecourrier, Priorite priorite,
			boolean confidentiel, Date dcourrier, Date darrive, Correspondant correspondant, Boolean limite,
			Date dlimtrt, Statut statut, StructureCompany service, String obs, DossierCourrier dossier, String motscles,
			List<DossierCourrier> dossiercourrier) {
		super();
		this.categorie = categorie;
		this.typecourrier = typecourrier;
		// this.priorite = priorite;
		// this.confidentiel = confidentiel;
		this.dcourrier = dcourrier;
		this.darrive = darrive;
		this.correspondant = correspondant;
		this.dossier = dossier;
		this.motscles = motscles;

		// this.nature = nature;
		// this.limite = limite;
		// this.dlimtrt = dlimtrt;
		this.service = service;
		// this.obs = obs;
		// this.motscles = motscles;
		// this.dossier = dossier;

	}

	/**
	 * 
	 */
	public Courrier() {
		// TODO Auto-generated constructor stub
	}

	public Courrier(Courrier dep) {
		super(dep.id, dep.designation, dep.moduleName, dep.compareid);
		this.categorie = dep.categorie;
		this.code = dep.code;

		if (dep.typecourrier != null) {
			this.typecourrier = new TypeCourrier(dep.typecourrier);
		}

		if (dep.priorite != null) {
			this.priorite = new Priorite(dep.priorite);
		}

		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.dcourrier;
		this.darrive = dep.darrive;

		if (dep.correspondant != null) {
			this.correspondant = new Correspondant(dep.correspondant);
		}

		if (dep.nature != null) {
			this.nature = new NatureCourrier(dep.nature);
		}
		this.objet = dep.objet;
		this.limite = dep.limite;
		// this.dlimtrt = dep.dlimtrt;

		if (dep.dossier != null) {
			this.dossier = new DossierCourrier(dep.getDossier());
		}
		this.motscles = dep.getMotscles();

		if (dep.service != null) {
			this.service = new StructureCompany(dep.service);
		}
		if (dep.etape != null) {
			this.etape = new WorkflowAction(dep.etape);
		}
		this.state = dep.state;

		if (dep.source != null) {
			this.source = new UtilisateurCourrier(dep.source);
		}
		this.destinataire = new ArrayList<UtilisateurCourrier>();
//		if (dep.destinataire != null) {
//			//this.destinataire = new UtilisateurCourrier(dep.destinataire);
//			this.destinataire = new ArrayList<UtilisateurCourrier>();
//		}
		if (dep.statutcourrier != null) {
			this.statutcourrier = new Statut(dep.statutcourrier);
		}
		this.state = dep.state;
//		if (dep.origanal != null) {
//			this.origanal = new Courrier(dep.origanal);
//		}
		this.porte = dep.porte;
//		if (dep.bordero != null) {
//			this.bordero = new BorderoCourrier(dep.bordero);
//		}
		if (dep.sowner != null) {
			this.sowner = new StructureCompany(dep.sowner);
		}
		this.reference=dep.reference;
		this.dexep= dep.dexep;
		this.signataire= dep.signataire;
	}

	public Courrier(CourrierDepart dep) {
		super(dep.getId(), dep.getDesignation(), dep.getModuleName(), dep.getCompareid());
		this.categorie = dep.getCategorie();
		this.code = dep.getCode();

		if (dep.getTypecourrier() != null) {
			this.typecourrier = new TypeCourrier(dep.getTypecourrier());
		}

		if (dep.getPriorite() != null) {
			this.priorite = new Priorite(dep.getPriorite());
		}

		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.getDcourrier();
		this.darrive = null;

	
		if (dep.getNature() != null) {
			this.nature = new NatureCourrier(dep.getNature());
		}
		this.objet = dep.getObjet();
		this.limite = dep.getLimite();
		// this.dlimtrt = dep.dlimtrt;

		if (dep.dossier != null) {
			this.dossier = new DossierCourrier(dep.getDossier());
		}
		this.motscles = dep.getMotscles();

		if (dep.getService() != null) {
			this.service = new StructureCompany(dep.getService());
		}
		// if(dep.getE()!=null){
		// this.etape = new WorkflowAction(dep.etape);
		// }
		this.state = dep.getState();

		if (dep.getSource() != null) {
			this.source = new UtilisateurCourrier(dep.getSource());
		}
		this.piecesjointes = new ArrayList<FichierLie>();
//		this.traitements=new ArrayList<TraitementCourrier>();
		
	

	}

	public Courrier(CourrierInterne dep) {
		super(dep.getId(), dep.getDesignation(), dep.getModuleName(), dep.getCompareid());
		this.categorie = dep.getCategorie();
		this.code = dep.getCode();

		if (dep.getTypecourrier() != null) {
			this.typecourrier = new TypeCourrier(dep.getTypecourrier());
		}

		if (dep.getPriorite() != null) {
			this.priorite = new Priorite(dep.getPriorite());
		}

		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.getDcourrier();
		this.darrive = null;

		// if(dep.getCorrespondant() != null){
		// this.correspondant = new Uti(dep.getCorrespondant());
		// }

		if (dep.getNature() != null) {
			this.nature = new NatureCourrier(dep.getNature());
		}
		this.objet = dep.getObjet();
		this.limite = dep.getLimite();
		// this.dlimtrt = dep.dlimtrt;

		if (dep.dossier != null) {
			this.dossier = new DossierCourrier(dep.getDossier());
		}
		this.motscles = dep.getMotscles();

		if (dep.getService() != null) {
			this.service = new StructureCompany(dep.getService());
		}
		// if(dep.getE()!=null){
		// this.etape = new WorkflowAction(dep.etape);
		// }
		this.state = dep.getState();

		if (dep.getSource() != null) {
			this.source = new UtilisateurCourrier(dep.getSource());
		}
		this.piecesjointes = new ArrayList<FichierLie>();
//		this.traitements=new ArrayList<TraitementCourrier>();
		this.reference=dep.getReference();
	}

	public StructureCompany getSowner() {
		return sowner;
	}

	public void setSowner(StructureCompany sowner) {
		this.sowner = sowner;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Courrier arrivé";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Courriers arrivés";
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerencourrier";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public TypeCourrier getTypecourrier() {
		return typecourrier;
	}

	public void setTypecourrier(TypeCourrier typecourrier) {
		this.typecourrier = typecourrier;
	}

	
	public Date getDexep() {
		return dexep;
	}

	public void setDexep(Date dexep) {
		this.dexep = dexep;
	}

	public DossierCourrier getDossier() {
		return dossier;
	}

	public void setDossier(DossierCourrier dossier) {
		this.dossier = dossier;
	}

	public String getMotscles() {
		return motscles;
	}

	public void setMotscles(String motscles) {
		this.motscles = motscles;
	}

	public List<UtilisateurCourrier> getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(List<UtilisateurCourrier> destinataire) {
		this.destinataire = destinataire;
	}

	public BorderoCourrier getBordero() {
		return bordero;
	}

	public void setBordero(BorderoCourrier bordero) {
		this.bordero = bordero;
	}

	public NatureCourrier getNature() {
		return nature;
	}

	public void setNature(NatureCourrier nature) {
		this.nature = nature;
	}

	public String getObjet() {
		return objet;
	}

	public void setObjet(String objet) {
		this.objet = objet;
	}

	public List<FichierLie> getPiecesjointes() {
		return piecesjointes;
	}

	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}

	public Date getLimite() {
		return limite;
	}

	public void setLimite(Date limite) {
		this.limite = limite;
	}

	public WorkflowAction getEtape() {
		return etape;
	}

	public void setEtape(WorkflowAction etape) {
		this.etape = etape;
	}

	public Statut getStatutcourrier() {
		return statutcourrier;
	}

	public void setStatutcourrier(Statut statutcourrier) {
		this.statutcourrier = statutcourrier;
	}

	public Date getDcourrier() {
		return dcourrier;
	}

	public void setDcourrier(Date dcourrier) {
		this.dcourrier = dcourrier;
	}

	public Date getDarrive() {
		return darrive;
	}

	public void setDarrive(Date darrive) {
		this.darrive = darrive;
	}

	public Correspondant getCorrespondant() {
		return correspondant;
	}

	public void setCorrespondant(Correspondant correspondant) {
		this.correspondant = correspondant;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Priorite getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite priorite) {
		this.priorite = priorite;
	}

	public StructureCompany getService() {
		return service;
	}

	public void setService(StructureCompany service) {
		this.service = service;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// public List<TraitementCourrier> getTraitements() {
	// return traitements;
	// }
	//
	// public void setTraitements(List<TraitementCourrier> traitements) {
	// this.traitements = traitements;
	// }

	public UtilisateurCourrier getSource() {
		return source;
	}

	public void setSource(UtilisateurCourrier source) {
		this.source = source;
	}

	public String getSignataire() {
		return signataire;
	}

	public void setSignataire(String signataire) {
		this.signataire = signataire;
	}

	public Courrier getOriganal() {
		return origanal;
	}

	public void setOriganal(Courrier origanal) {
		this.origanal = origanal;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	@Override
	public boolean isActivatefollower() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

//	public List<TraitementCourrier> getTraitements() {
//		return traitements;
//	}
//
//	public void setTraitements(List<TraitementCourrier> traitements) {
//		this.traitements = traitements;
//	}

	@Override
	public List<State> getStates() {
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		// state = new State("valide", "Saisi validée");
		// states.add(state);
		return states; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public String getSerial() {
		return Long.toString(serialVersionUID); // To change body of generated
												// methods, choose Tools |
												// Templates.
	}

	@Override
	public boolean isCreateonfield() {
		return false; // To change body of generated methods, choose Tools |
						// Templates.
	}	

	

	@Override
	public int compareTo(Courrier o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
