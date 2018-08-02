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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.Statut;
import com.keren.courrier.model.referentiel.StructureCompany;
import com.keren.courrier.model.referentiel.TypeCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;
import java.util.ArrayList;

import javax.faces.view.facelets.FaceletContext;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 * @author NTW table type correspondants
 */
@Entity
@Table(name = "T_COURRGC")
public class CourrierDepart extends BaseElement implements Serializable, Comparable<CourrierDepart> {

	private static final long serialVersionUID = -12411984333486963L;

	@Predicate(label = "Numéro du Courrier", search = true, optional = true, unique = true, editable=false)
	private String code;
	

	@ManyToOne
	@JoinColumn(name = "T_NATURE")
	@Predicate(label = "Nature", type = NatureCourrier.class, target = "many-to-one", search = true)
	private NatureCourrier nature;
	
	@Predicate(label = "Type courrier départ", target = "combobox", values = "Initial;Réponse", search = false)
	private String type = "0";


	@Predicate(label = "Mention du courrier", target = "combobox", values = "Ordinaire;Confidentiel", search = true)
	private String porte = "0";
	

	
	@Column(name = "T_CAT")
	 @Predicate(label = "Catégorie Courrier", optional = true, search = false,
	 target = "combobox", values = "Courrier Arrivée;Courrier Départ;CourrierInterne;Document GED",editable = false)
	private String categorie;

	@ManyToOne
	@JoinColumn(name = "T_TYPE")
	// @Predicate(label = "Type Courrier", type = TypeCourrier.class, target =
	// "many-to-one", search = true, optional = false)
	private TypeCourrier typecourrier;
	
	@ManyToOne
	@JoinColumn(name = "T_PRIO")
//	@Predicate(label = "Priorité", type = Priorite.class, target = "many-to-one", search = true, optional = false, observable = true)
	private Priorite priorite;

	@Column(name = "D_COUR")
	@Predicate(label = "Date de l'expédition", optional = false, updatable = true, search = false, type = Date.class, target = "date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date dcourrier;

	@ManyToOne
	@JoinColumn(name = "T_CORRES")
	@Predicate(label = "Destinataire", type = Correspondant.class, target = "many-to-one", search = true, optional = false)
	private Correspondant correspondant;

	@ManyToOne
	@JoinColumn(name = "T_SERV")
	@Predicate(label = "Service initiateur", type = StructureCompany.class, target = "many-to-one", search = true, optional = false, observable = true, updatable=false)
	private StructureCompany service;

	@ManyToOne
	@JoinColumn(name = "DES_ID")
	@Predicate(label = "Expéditeur", type = UtilisateurCourrier.class, target = "many-to-one", search = true)
	@Observer(observable = "service", source = "field:responsable")
	private UtilisateurCourrier expediteur;
	
	@ManyToOne
	@JoinColumn(name = "C_COUR")
	@Predicate(label = "Courrier Arrivéé", type = Courrier.class, target = "many-to-one", optional = true,hidden="currentObject.type=='0'")
	private Courrier courrier;


	@Predicate(label = "Signataire", group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	private String signataire;

	@Lob
	@Predicate(label = "Objet", target = "textarea", group = true, groupName = "group1", groupLabel = "objet/Pièces jointes")
	private String objet;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	@Predicate(label = "Pièces jointes", type = FichierLie.class, target = "one-to-many", edittable = true, group = true, groupName = "group1", groupLabel = "objet/Pièces jointes")
	private List<FichierLie> piecesjointes = new ArrayList<FichierLie>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	// @Predicate(label = "",type = LigneDiffusion.class,target =
	// "one-to-many",edittable = true,group = true,groupName =
	// "group3",groupLabel = "Liste de diffusion")
	// @Observer(observable = "service" ,source =
	// "method:diffusionlist",parameters = "service")
	private List<LigneDiffusion> diffusions = new ArrayList<LigneDiffusion>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "COU_ID")
	private List<TraitementCourrier> traitements = new ArrayList<TraitementCourrier>();

	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label = "Date limite", type = Date.class, target = "date", search = false, group = true, groupLabel = "Informations Complémentaires", groupName = "group2")
	@Observer(observable = "priorite", source = "method:datelimite", parameters = "priorite")
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
    private BorderoCourrier bordero ;
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

	

	/**
	 * 
	 */
	public CourrierDepart() {
		// TODO Auto-generated constructor stub
		this.categorie = "1";
	}

	public CourrierDepart(String code, NatureCourrier nature, String porte, String type, String categorie,
			TypeCourrier typecourrier, Courrier courrier, Priorite priorite, Date dcourrier,
			Correspondant correspondant, StructureCompany service, UtilisateurCourrier expediteur, String signataire,
			String objet, List<FichierLie> piecesjointes, List<LigneDiffusion> diffusions, Date limite,
			DossierCourrier dossier, String motscles, String state, UtilisateurCourrier source,
			BorderoCourrier bordero) {
		super();
		this.code = code;
		this.nature = nature;
		this.porte = porte;
		this.type = type;
		this.categorie = categorie;
		this.typecourrier = typecourrier;
		this.courrier = courrier;
		this.priorite = priorite;
		this.dcourrier = dcourrier;
		this.correspondant = correspondant;
		this.service = service;
		this.expediteur = expediteur;
		this.signataire = signataire;
		this.objet = objet;
		this.piecesjointes = piecesjointes;
		this.diffusions = diffusions;
		this.limite = limite;
		this.dossier = dossier;
		this.motscles = motscles;
		this.state = state;
		this.source = source;
		this.bordero = bordero;
	}

	public CourrierDepart(CourrierDepart dep) {
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
		if (dep.correspondant != null) {
			this.correspondant = new Correspondant(dep.correspondant);
		}
		this.nature = dep.nature;
		this.objet = dep.objet;
		this.limite = dep.limite;
		// this.dlimtrt = dep.dlimtrt;
		if (dep.service != null) {
			this.service = new StructureCompany(dep.service);
		}
		this.state = dep.state;
		// this.motscles = dep.motscles;
		// this.dossier = dep.dossier;
		if (dep.source != null) {
			this.source = new UtilisateurCourrier(dep.source);
		}
		if (dep.expediteur != null) {
			this.expediteur = new UtilisateurCourrier(dep.expediteur);
		}
		this.signataire = dep.signataire;
		this.porte = dep.porte;
		
		if(dep.courrier!=null){
			this.courrier=new Courrier(dep.courrier) ;
		}
		if(dep.sowner!=null){
			this.sowner=new StructureCompany(dep.sowner);
		}
		if(dep.getBordero()!=null){
			this.bordero= new BorderoCourrier(dep.getBordero());
		}
		this.type=dep.type;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Courrier Départ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Courriers Départ";
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

	public List<LigneDiffusion> getDiffusions() {
		return diffusions;
	}

	public void setDiffusions(List<LigneDiffusion> diffusions) {
		this.diffusions = diffusions;
	}

	public DossierCourrier getDossier() {
		return dossier;
	}

	public void setDossier(DossierCourrier dossier) {
		this.dossier = dossier;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Courrier getCourrier() {
		return courrier;
	}

	public void setCourrier(Courrier courrier) {
		this.courrier = courrier;
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

	public List<TraitementCourrier> getTraitements() {
		return traitements;
	}

	public void setTraitements(List<TraitementCourrier> traitements) {
		this.traitements = traitements;
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

	public void setPiecesjointes(List<FichierLie> piecesjointes) {
		this.piecesjointes = piecesjointes;
	}

	public Date getLimite() {
		return limite;
	}

	public void setLimite(Date limite) {
		this.limite = limite;
	}

	public UtilisateurCourrier getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(UtilisateurCourrier expediteur) {
		this.expediteur = expediteur;
	}

	public Date getDcourrier() {
		return dcourrier;
	}

	public void setDcourrier(Date dcourrier) {
		this.dcourrier = dcourrier;
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

	public BorderoCourrier getBordero() {
		return bordero;
	}

	public void setBordero(BorderoCourrier bordero) {
		this.bordero = bordero;
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

	public String getSignataire() {
		return signataire;
	}

	public void setSignataire(String signataire) {
		this.signataire = signataire;
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

	@Override
	public List<State> getStates() {
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		 state = new State("valide", "Distribué");
		 states.add(state);
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
	public int compareTo(CourrierDepart o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
