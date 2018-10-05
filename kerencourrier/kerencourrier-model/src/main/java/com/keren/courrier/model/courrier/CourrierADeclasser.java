/**
 * 
 */
package com.keren.courrier.model.courrier;

import com.keren.courrier.model.referentiel.DossierCourrier;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.Statut;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.workflow.WorkflowAction;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_COURRGC")
public class CourrierADeclasser extends BaseElement implements Serializable, Comparable<CourrierADeclasser> {

	private static final long serialVersionUID = -12411984333486963L;

	@Predicate(label = "Numéro du Courrier", search = true, optional = true, editable = false, unique = true)
	private String code;

	@Predicate(label = "Mention du courrier", target = "combobox", editable = false, values = "Ordinaire;Confidentiel", search = true)
	private String porte = "0";

	@ManyToOne
	@JoinColumn(name = "T_NATURE")
	@Predicate(label = "Nature", type = NatureCourrier.class, target = "many-to-one", editable = false, search = true)
	private NatureCourrier nature;

	@Column(name = "T_CAT")
	@Predicate(label = "Catégorie Courrier", optional = false, search = false, target = "combobox", editable = false, values = "Courrier Arrivée;Courrier Départ;Courrier Interne;Document GED")
	private String categorie;

	// @ManyToOne
	// @JoinColumn(name = "T_TYPE")
	// @Predicate(label = "Type Courrier", type = TypeCourrier.class, target =
	// "many-to-one", search = true, optional = false)
	// private TypeCourrier typecourrier;

	@ManyToOne
	@JoinColumn(name = "T_PRIO")
	@Predicate(label = "Priorité", type = Priorite.class, target = "many-to-one", editable = false, search = true, optional = false, observable = true)
	private Priorite priorite;

	@Column(name = "D_COUR")
	@Predicate(label = "Date de Création du Courrier", optional = false, updatable = false, editable = false, search = false, type = Date.class, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dcourrier;

	@Column(name = "D_ARR")
	@Predicate(label = "Date d'arrivée Courrier", optional = true, updatable = false, editable = false, search = false, type = Date.class, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date darrive;

	@ManyToOne
	@JoinColumn(name = "T_CORRES")
	@Predicate(label = "Expéditeur", type = Correspondant.class, target = "many-to-one", editable = false, search = true, optional = false)
	private Correspondant correspondant;

	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Traitant", type = StructureCompany.class, target = "many-to-one", editable = false, search = true, optional = false, observable = true)
	private StructureCompany service;

//	@ManyToOne
//	@JoinColumn(name = "DES_ID")
//	@Predicate(label = "Destinatire", type = UtilisateurCourrier.class, target = "many-to-one", editable = false, search = true)
//	@Observer(observable = "service", source = "field:responsable")
//	private UtilisateurCourrier destinataire;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinTable(name="T_CA_DEST",joinColumns=@JoinColumn(name="CA_ID"),inverseJoinColumns=@JoinColumn(name="USER_ID"))
	@Predicate(label = "Destinataire",target = "many-to-many-list",type = UtilisateurCourrier.class,search = false, optional=true)
	private List<UtilisateurCourrier> destinataire ;

	@ManyToOne
	@JoinColumn(name = "STAT_ID")
	// @Predicate(label = "Statut courrier",type = Statut.class,target =
	// "many-to-one" ,optional = false,search = true)
	private Statut statutcourrier;

	@Lob
	@Predicate(label = "Objet", target = "textarea", group = true, groupName = "group1", groupLabel = "objet/Pièces jointes", editable = false)
	private String objet;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", editable = false, group = true, groupName = "group1", groupLabel = "objet/Pièces jointes")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date limite", type = Date.class, target = "date", search = false, editable = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	@Observer(observable = "priorite", source = "method:datelimite", parameters = "priorite")
	private Date limite;

	@Predicate(label = "Signataire", editable = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	private String signataire;

	@ManyToOne
	@JoinColumn(name = "T_DOS")
	@Predicate(label = "Dossier", type = DossierCourrier.class, target = "many-to-one", editable = false, search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	@Filter(value = "[{\"fieldName\":\"classement\",\"value\":\"1\"}]")
	protected DossierCourrier dossier;

	@Column(name = "MOTS_CLES")
	@Predicate(label = "Mots Clés", updatable = true, search = false, editable = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
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
	@JoinColumn(name = "ORI_ID")
	private CourrierADeclasser origanal;

	@ManyToOne
	@JoinColumn(name = "BORD_ID")
	private BorderoCourrier bordero;

	@ManyToOne
	@JoinColumn(name = "OWSERV_ID")
	private StructureCompany sowner;

        
        @Column(name = "type_class")
        private String typeclassement = "0";
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

	public CourrierADeclasser(String categorie, String niveauDeTraitement, TypeCourrier typecourrier, Priorite priorite,
			boolean confidentiel, Date dcourrier, Date darrive, Correspondant correspondant, Boolean limite,
			Date dlimtrt, Statut statut, StructureCompany service, String obs, DossierCourrier dossier, String motscles,
			List<DossierCourrier> dossiercourrier) {
		super();
		this.categorie = categorie;
		// this.typecourrier = typecourrier;
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
	public CourrierADeclasser() {
		// TODO Auto-generated constructor stub
	}

	public CourrierADeclasser(CourrierADeclasser dep) {
		super(dep.id, dep.designation, dep.moduleName, dep.compareid);
		this.categorie = dep.categorie;
		this.code = dep.code;

		// if(dep.typecourrier!=null){
		// this.typecourrier = new TypeCourrier(dep.typecourrier);
		// }

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
//		if (dep.destinataire != null) {
//			this.destinataire = new UtilisateurCourrier(dep.destinataire);
//		}
		this.destinataire= new ArrayList<UtilisateurCourrier>();
		if (dep.statutcourrier != null) {
			this.statutcourrier = new Statut(dep.statutcourrier);
		}
		this.state = dep.state;
//		if (dep.origanal != null) {
//			this.origanal = new CourrierAClasser(dep.origanal);
//		}
//		if (dep.bordero != null) {
//			this.bordero = new BorderoCourrier(dep.bordero);
//		}
		this.porte = dep.porte;
		if (dep.sowner != null) {
			this.sowner = new StructureCompany(dep.sowner);
		}
                this.typeclassement = dep.typeclassement;
	}

	public CourrierADeclasser(CourrierDepart dep) {
		super(dep.getId(), dep.getDesignation(), dep.getModuleName(), dep.getCompareid());
		this.categorie = dep.getCategorie();
		this.code = dep.getCode();

		// if(dep.getTypecourrier()!=null){
		// this.typecourrier = new TypeCourrier(dep.getTypecourrier());
		// }

		if (dep.getPriorite() != null) {
			this.priorite = new Priorite(dep.getPriorite());
		}

		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.getDcourrier();
		this.darrive = null;

//		if (dep.getCorrespondant() != null) {
//			this.correspondant = new Correspondant(dep.getCorrespondant());
//		}

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
		this.piecesjointes = dep.getPiecesjointes();

	}

	public CourrierADeclasser(Courrier dep) {
		super(dep.getId(), dep.getDesignation(), dep.getModuleName(), dep.getCompareid());
		this.categorie = dep.getCategorie();
		this.code = dep.getCode();

		// if(dep.getTypecourrier()!=null){
		// this.typecourrier = new TypeCourrier(dep.getTypecourrier());
		// }

		if (dep.getPriorite() != null) {
			this.priorite = new Priorite(dep.getPriorite());
		}

		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.getDcourrier();
		this.darrive = null;

		if (dep.getCorrespondant() != null) {
			this.correspondant = new Correspondant(dep.getCorrespondant());
		}

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
		this.piecesjointes = dep.getPiecesjointes();

	}

	public CourrierADeclasser(CourrierInterne dep) {
		super(dep.getId(), dep.getDesignation(), dep.getModuleName(), dep.getCompareid());
		this.categorie = dep.getCategorie();
		this.code = dep.getCode();

		// if(dep.getTypecourrier()!=null){
		// this.typecourrier = new TypeCourrier(dep.getTypecourrier());
		// }

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
		this.piecesjointes = dep.getPiecesjointes();

	}

	public BorderoCourrier getBordero() {
		return bordero;
	}

	public void setBordero(BorderoCourrier bordero) {
		this.bordero = bordero;
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
		return "Courrier";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Courriers classés";
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

	// public TypeCourrier getTypecourrier() {
	// return typecourrier;
	// }
	//
	// public void setTypecourrier(TypeCourrier typecourrier) {
	// this.typecourrier = typecourrier;
	// }

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

	public CourrierADeclasser getOriganal() {
		return origanal;
	}

	public void setOriganal(CourrierADeclasser origanal) {
		this.origanal = origanal;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

        public String getTypeclassement() {
            return typeclassement;
        }

        public void setTypeclassement(String typeclassement) {
            this.typeclassement = typeclassement;
        }
        
        

	@Override
	public boolean isActivatefollower() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

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
	public boolean isDesableupdate() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public boolean isDesabledelete() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public boolean isDesablecreate() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

	@Override
	public int compareTo(CourrierADeclasser o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

	public CourrierADeclasser newInstace() {
		CourrierADeclasser entity = new CourrierADeclasser();
		entity.categorie = this.categorie;
		entity.code = this.code;

		// if(this.typecourrier!=null){
		// entity.typecourrier = new TypeCourrier(this.typecourrier);
		// }

		if (this.priorite != null) {
			entity.priorite = new Priorite(this.priorite);
		}

		// this.confidentiel = this.confidentiel;
		entity.dcourrier = this.dcourrier;
		entity.darrive = this.darrive;

		if (this.correspondant != null) {
			entity.correspondant = new Correspondant(this.correspondant);
		}

		if (this.nature != null) {
			entity.nature = new NatureCourrier(this.nature);
		}
		entity.objet = this.objet;
		entity.limite = this.limite;
		// this.dlimtrt = this.dlimtrt;

		if (this.dossier != null) {
			entity.dossier = new DossierCourrier(this.getDossier());
		}
		entity.motscles = this.getMotscles();

		if (this.service != null) {
			entity.service = new StructureCompany(this.service);
		}
		if (this.etape != null) {
			entity.etape = new WorkflowAction(this.etape);
		}
		entity.state = this.state;

		if (this.source != null) {
			entity.source = new UtilisateurCourrier(this.source);
		}
		this.destinataire= new ArrayList<UtilisateurCourrier>();
		
		if (this.statutcourrier != null) {
			entity.statutcourrier = new Statut(this.statutcourrier);
		}
		entity.state = this.state;
		if (this.origanal != null) {
			entity.origanal = new CourrierADeclasser(this.origanal);
		}
		if (this.bordero != null) {
			entity.bordero = new BorderoCourrier(this.bordero);
		}
		entity.porte = this.porte;
		if (this.sowner != null) {
			entity.sowner = new StructureCompany(this.sowner);
		}
		return entity; // To change body of generated methods, choose Tools |
						// Templates.
	}

}
