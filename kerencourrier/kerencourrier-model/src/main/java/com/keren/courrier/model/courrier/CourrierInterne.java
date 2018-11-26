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
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.Statut;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.traitement.RelanceAction;
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
public class CourrierInterne extends BaseElement implements Serializable, Comparable<CourrierInterne> {

	private static final long serialVersionUID = -12411984333486963L;

	@Predicate(label = "Numéro du Courrier", search = true, optional = true, unique = true, editable = false, updatable=false, sequence=2)
	private String code;

	//@Predicate(label = "Reférence d'envoi", search = true, optional = true, unique = true, sequence=2)
	private String reference;

	@Predicate(label = "Type courrier ", target = "combobox", values = "Initial;Réponse", search = false, sequence=1)
	private String type = "0";

	@ManyToOne
	@JoinColumn(name = "T_NATURE")
	@Predicate(label = "Nature", type = NatureCourrier.class, target = "many-to-one", search = true, sequence=3)
	private NatureCourrier nature;

	@Column(name = "T_CAT")
	// @Predicate(label = "Catégorie Courrier", optional = true, search =
	// false,target = "combobox", values = "Courrier Arrivée;Courrier
	// Départ;Courrier Interne;Document GED",editable = false)
	private String categorie;

	@Predicate(label = "Mention du courrier", target = "combobox", values = "Ordinaire;Confidentiel", search = true, sequence=4)
	private String porte = "0";

	@ManyToOne
	@JoinColumn(name = "T_TYPE")
	// @Predicate(label = "Type Courrier", type = TypeCourrier.class, target =
	// "many-to-one", search = true, optional = false)
	private TypeCourrier typecourrier;

	@ManyToOne
	@JoinColumn(name = "T_PRIO")
	@Predicate(label = "Priorité", type = Priorite.class, target = "many-to-one", search = true, optional = true, observable = true, sequence=5)
	private Priorite priorite;

	@Column(name = "D_COUR")
	@Predicate(label = "Date de création", optional = true, updatable = false, search = false, type = Date.class, target = "date", sequence=6)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dcourrier;

		
	@ManyToOne
	@JoinColumn(name = "T_EXPE")
	@Predicate(label = "Expediteur du courrier", type = UtilisateurCourrier.class, target = "many-to-one", search = true, optional = true, 
	observable = true, sequence=7)
	@Observer(observable = "sexp", source = "field:responsable")
	private UtilisateurCourrier expediteur;
	
	@ManyToOne
	@JoinColumn(name = "T_SEXP")
	//@Predicate(label = "Service Expéditeur", type = StructureCompany.class, target = "many-to-one", search = true, optional = false, sequence=8, observable=true)
//	@Observer(observable = "expediteur", source = "field:service")
	private StructureCompany sexp;

	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service Traitant", type = StructureCompany.class, target = "many-to-one", search = true, optional = false, sequence=8)
	@Observer(observable = "correspondant", source = "field:service")
	private StructureCompany service;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL )
	@JoinTable(name="T_CA_DEST",joinColumns=@JoinColumn(name="CA_ID"),inverseJoinColumns=@JoinColumn(name="USER_ID"))
	@Predicate(label = "Destinataire",target = "many-to-many-list",type = UtilisateurCourrier.class,search = false, optional=true, sequence=9)
	private List<UtilisateurCourrier> correspondant ;

//	@ManyToOne
//	@JoinColumn(name = "DES_ID")
//	@Predicate(label = "Destinataire", type = UtilisateurCourrier.class, target = "many-to-one", search = true, optional = false, observable = true, sequence=9)
//	private UtilisateurCourrier correspondant;

	@ManyToOne
	@JoinColumn(name = "C_COUR")
	@Predicate(label = "Courrier Joint", type = CourrierInterneJoint.class, target = "many-to-one", optional = true,
	hidden = "currentObject.type=='0'||currentObject.type==null", sequence=10)
//	@Observer(observable = "modePaiement", source = "method:versement", parameters = "modePaiement,eleve")
	private CourrierInterneJoint courrier;

	@Lob
	@Predicate(label = "Objet", target = "textarea", optional=false, sequence=11)
	private String objet;
	
	
	@ManyToOne
	@JoinColumn(name = "SIGN_ID")
	@Predicate(label = "Signataire", optional=false, sequence=12,type = UtilisateurCourrier.class, target = "many-to-one")
	private UtilisateurCourrier signataire;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "Pièces jointes")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();

	@Temporal(javax.persistence.TemporalType.DATE)
	//@Predicate(label = "Date limite", type = Date.class, target = "date", search = true, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	private Date limite;


	@ManyToOne
	@JoinColumn(name = "T_DOS")
	@Predicate(label = "Dossier", type = DossierCourrier.class, target = "many-to-one", search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	@Filter(value = "[{\"fieldName\":\"classement\",\"value\":\"1\"}]")
	protected DossierCourrier dossier;

	@Column(name = "MOTS_CLES")
	@Predicate(label = "Mots Clés", updatable = true, search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	protected String motscles;

	@Predicate(label = "Etat", search = true, hide = true)
	private String state = "etabli";

	@ManyToOne
	@JoinColumn(name = "SOUR_ID")
	private UtilisateurCourrier source;

	@ManyToOne
	@JoinColumn(name = "OWSERV_ID")
	private StructureCompany sowner;
	
	@ManyToOne
	@JoinColumn(name = "BORD_ID")
	private BorderoCourrier bordero;

	public CourrierInterne(String categorie, String niveauDeTraitement, TypeCourrier typecourrier, Priorite priorite,
			boolean confidentiel, Date dcourrier, Date darrive, UtilisateurCourrier correspondant, Boolean limite,
			Date dlimtrt, Statut statut, StructureCompany service, String obs, String motscles,
			List<DossierCourrier> dossiercourrier) {
		super();
		this.categorie = categorie;
		this.typecourrier = typecourrier;
		// this.priorite = priorite;
		// this.confidentiel = confidentiel;
		this.dcourrier = dcourrier;
		//this.correspondant = correspondant;
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
	public CourrierInterne() {
		// TODO Auto-generated constructor stub
		this.categorie = "1";
	}

	public CourrierInterne(CourrierInterne dep) {
		super(dep.id, dep.designation, dep.moduleName, dep.compareid);
		this.code = dep.code;
		this.categorie = dep.categorie;
		if (dep.typecourrier != null) {
			this.typecourrier = new TypeCourrier(dep.typecourrier);
		}
		if (dep.priorite != null) {
			this.priorite = new Priorite(dep.priorite);
		}
		// this.confidentiel = dep.confidentiel;
		this.dcourrier = dep.dcourrier;
		this.correspondant= new ArrayList<UtilisateurCourrier>();
//		if (dep.correspondant != null) {
//			this.correspondant = new UtilisateurCourrier(dep.correspondant);
//		}
		this.nature = dep.nature;
		this.objet = dep.objet;
		this.limite = dep.limite;
		// this.dlimtrt = dep.dlimte;
		if (dep.service != null) {
			this.service = new StructureCompany(dep.service);
		}
		this.state = dep.state;
		this.motscles = dep.motscles;
		if(dep.dossier!=null){
			this.dossier = new DossierCourrier(dep.dossier) ;
		}
		
		if (dep.source != null) {
			this.source = new UtilisateurCourrier(dep.source);
		}
		this.porte = dep.porte;
		this.signataire = dep.signataire;
		this.type = dep.type;
		// this.courrier=dep.courrier;
		// if(dep.bordero!=null){
		// this.bordero= new BorderoCourrier(dep.bordero);
		// }
		if (dep.signataire != null) {

			this.signataire = new UtilisateurCourrier(dep.signataire);
		}
		if (dep.sowner != null) {
			this.sowner = new StructureCompany(dep.sowner);
		}
		if (dep.sexp!= null) {
			this.sexp = new StructureCompany(dep.sexp);
		}
		if (dep.expediteur != null) {
			this.expediteur = new UtilisateurCourrier(dep.expediteur);
		}

		this.reference = dep.getReference();
		
		if(dep.courrier!=null){
			dep.courrier=new CourrierInterneJoint(dep.courrier);
		}

	}

	public CourrierInterne(RelanceAction dep) {
		super(-1, null, null, 0L);
		this.categorie = "2";
		if (dep.getCourrier().getPriorite() != null) {
			this.priorite = new Priorite(dep.getCourrier().getPriorite());
		}
		// this.confidentiel = dep.confidentiel;
		this.dcourrier = new Date();
		if (dep.getQuote() != null) {
			this.correspondant= new ArrayList<>();
			correspondant.add(dep.getQuote());
			//this.correspondant = new UtilisateurCourrier(dep.getQuote());
		}
		this.nature = dep.getCourrier().getNature();
		this.objet = dep.getNote();
		this.limite = dep.getLimite();
		if (dep.getService() != null) {
			this.service = new StructureCompany(dep.getService());
		}
		this.state = "transmis";
		if (dep.getQuoteur() != null) {
			this.source = new UtilisateurCourrier(dep.getQuoteur());
		}
		this.porte = dep.getCourrier().getPorte();
		this.signataire = dep.getCourrier().getSignataire();
		this.type = "0";
		if (dep.getService() != null) {
			this.sowner = new StructureCompany(dep.getService());
		}
		if (dep.getQuoteur() != null) {
			this.expediteur = dep.getQuoteur();
		}
		this.piecesjointes.addAll(dep.getPiecesjointes());

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Courrier Interne";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Courriers Interne";
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

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public UtilisateurCourrier getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(UtilisateurCourrier expediteur) {
		this.expediteur = expediteur;
	}

	public UtilisateurCourrier getSignataire() {
		return signataire;
	}

	public void setSignataire(UtilisateurCourrier signataire) {
		this.signataire = signataire;
	}

	public String getCategorie() {
		return categorie;
	}

	public StructureCompany getSexp() {
		return sexp;
	}

	public void setSexp(StructureCompany sexp) {
		this.sexp = sexp;
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

	public StructureCompany getSowner() {
		return sowner;
	}

	public void setSowner(StructureCompany sowner) {
		this.sowner = sowner;
	}

	public BorderoCourrier getBordero() {
		return bordero;
	}

	public void setBordero(BorderoCourrier bordero) {
		this.bordero = bordero;
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

	public Date getDcourrier() {
		return dcourrier;
	}

	public void setDcourrier(Date dcourrier) {
		this.dcourrier = dcourrier;
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

	public UtilisateurCourrier getSource() {
		return source;
	}

	public void setSource(UtilisateurCourrier source) {
		this.source = source;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public CourrierInterneJoint getCourrier() {
		return courrier;
	}

	public List<UtilisateurCourrier> getCorrespondant() {
		return correspondant;
	}

	public void setCorrespondant(List<UtilisateurCourrier> correspondant) {
		this.correspondant = correspondant;
	}

	public void setCourrier(CourrierInterneJoint courrier) {
		this.courrier = courrier;
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
	public int compareTo(CourrierInterne o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}