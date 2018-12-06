/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_bul")
public class Bulletin extends BaseElement implements Serializable, Comparable<Bulletin> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3210923131046279039L;

	@Column(name = "CODE")
	// @Predicate(label="LIBELLE",optional=false,updatable=false,search=true ,
	// sequence=1, colsequence=1)
	protected String code;
	
	
	@Column(name = "MATRICULE")
	@Predicate(label = "MATRICULE", optional = true, updatable = false, search = true, type = String.class, sequence=1)
	protected String matricule;
	
	
	@Column(name = "NOM")
	@Predicate(label = "NOM", optional = true, updatable = false, search = true, type = String.class,  sequence=2)
	protected String nom;
	

	@ManyToOne
	@JoinColumn(name = "INS_ID")
	//@Predicate(label = "ELEVE", updatable = false, search = true, type = Eleve.class, target = "many-to-one", sequence = 1, editable = false)
	protected Eleve eleve;

	@ManyToOne
	@JoinColumn(name = "CLS_ID")
	@Predicate(label = "CLASSE", updatable = false, search = true, type = Classe.class, target = "many-to-one", sequence = 3, editable = false)
	protected Classe classe;

	@ManyToOne
	@JoinColumn(name = "EXAMEN_ID")
	@Predicate(label = "Type Bulletin", updatable = true, type = Examen.class, target = "many-to-one", sequence = 4)
	protected Examen model;
	
//	@ManyToOne
//	@JoinColumn(name = "EXAMEN_S_ID")
//	@Predicate(label = "Type Bulletin", updatable = true, type = ExamenS.class, target = "many-to-one", sequence = 3)
//	protected Examen modelS;

	@ManyToOne
	@JoinColumn(name = "INSCRIPTION_ID")
	protected Inscription inscription;

	@Column(name = "MOYENNE")
	@Predicate(label = "MOY.", type = Double.class, search = true, sequence = 4, updatable = false)
	private Double moyenne = new Double(0);

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "LGN_BUL_ID")
	@Predicate(label = "Lignes", type = LigneBulletinClasse.class, target = "one-to-many", updatable = false, editable = false, group = true, 
	groupName = "group1", groupLabel = "Notes/Matieres", edittable = true)
	private List<LigneBulletinClasse> lignes = new ArrayList<LigneBulletinClasse>();
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
//	@JoinColumn(name = "LGN_BUL_ID")
//	@Predicate(label = "Lignes", type = LigneBulletinClassePrimaire.class, target = "one-to-many", updatable = false, editable = false,
//	group = true, groupName = "group1", groupLabel = "Notes/Matieres", edittable = true ,hidden = "currentObject.classe.filiere.cycle.typecycle!=1")
//	private List<LigneBulletinClassePrimaire> lignesprimaire = new ArrayList<LigneBulletinClassePrimaire>();

	@Column(name = "T_POINT")
	private Double tpoint = new Double(0);

	@Column(name = "RANG")
	@Predicate(label = "RANG", type = Long.class, search = true, sequence = 6, updatable = false)
	private Long rang = new Long(0);

	@Column(name = "MOY_PREMIER")
	@Predicate(label = "Moy. Premier", type = Double.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Double moypremier = new Double(0);

	@Column(name = "MOY_DER")
	@Predicate(label = "Moy. Dernier", type = Double.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Double moydernier = new Double(0);

	@Column(name = "NB_MOY")
	@Predicate(label = "Nbre. Moyenne", type = Long.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Long nbreMoy = new Long(0);

	@Column(name = "MOY_CLA")
	@Predicate(label = "Moy. Classe", type = Double.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Double moyenneClas = new Double(0);

	@Column(name = "TX_REU")
	@Predicate(label = "Taux. Reussite", type = Double.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Double txreusitte = new Double(0);

	@Column(name = "ECRAT_TYPE")
	@Predicate(label = "Ecart Type", type = Double.class, updatable = false, editable = false, group = true, groupName = "group2", groupLabel = "Profil de la classe", edittable = true)
	private Double eType = new Double(0);

	@Column(name = "NB_ABS_N")
	@Predicate(label = "Abscences Non Just.", type = Long.class, updatable = true, group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Long nbreAbsNonJus = new Long(0);

	@Column(name = "NB_ABS")
	@Predicate(label = "Abscences Just.", type = Long.class, updatable = true, group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Long nbreAbsJus = new Long(0);

	@Column(name = "CONSIGNE")
	@Predicate(label = "Consignes", type = Long.class, updatable = true, group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Long consigne = new Long(0);

	@Column(name = "Exclusions")
	@Predicate(label = "Exclusions", type = Long.class, updatable = true,group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Long exclusions = new Long(0);

	@Column(name = "RETARD")
	@Predicate(label = "Retards", type = Long.class, updatable = true, group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Long retards = new Long(0);

	@Column(name = "AVERT")
	@Predicate(label = "Avert. Conduite.", type = Boolean.class, target = "checkbox", updatable = true,  group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Boolean avert = false;

	@Column(name = "BLAME")
	@Predicate(label = "Blâme. Conduite.", type = Boolean.class, target = "checkbox", updatable = true,  group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Boolean blame = false;

	@Column(name = "CON_DIS")
	@Predicate(label = "Conseil. Discipline.", type = Boolean.class, target = "checkbox", updatable = true, group = true, groupName = "group3", groupLabel = "Conduite", edittable = true)
	private Boolean conseil = false;

	@Column(name = "APPRE")
	@Predicate(label = "Appreciation", type = String.class, updatable = false, editable = false, group = true, groupName = "group4", groupLabel = "Apprecistion du Travail", edittable = true)
	private String appre;

	@Column(name = "Sanction")
	@Predicate(label = "Sanction du Travail", type = String.class, updatable = false, editable = false, group = true, groupName = "group4", groupLabel = "Apprecistion du Travail", edittable = true)
	private String sanction;

	@Column(name = "T_COEF")
	private Long tcoef = new Long(0);

	@Column(name = "EXTR_MAX")
	private Double extrememax = new Double(0);

	@Column(name = "EXTR_MIN")
	private Double extremmemin = new Double(0);

	private String state = "etabli";
	
	@Transient
	private byte[] photo ;

	public Bulletin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bulletin(String code, Eleve eleve, Classe classe, Examen model, Double moyenne,
			List<LigneBulletinClasse> lignes, Double tpoint, Long rang, Double moypremier, Double moydernier,
			Long nbreMoy, Double moyenneClas, Double txreusitte, Double eType, Long nbreAbsNonJus, Long nbreAbsJus,
			Boolean avert, Boolean blame, Boolean conseil, Long consigne, Long exclusions, Long retards, String appre,
			String sanction, Long tcoef, Double extrememax, Double extremmemin, String state) {
		super();
		this.code = code;
		this.eleve = eleve;
		this.classe = classe;
		this.model = model;
		this.moyenne = moyenne;
		this.lignes = lignes;
		this.tpoint = tpoint;
		this.rang = rang;
		this.moypremier = moypremier;
		this.moydernier = moydernier;
		this.nbreMoy = nbreMoy;
		this.moyenneClas = moyenneClas;
		this.txreusitte = txreusitte;
		this.eType = eType;
		this.nbreAbsNonJus = nbreAbsNonJus;
		this.nbreAbsJus = nbreAbsJus;
		this.avert = avert;
		this.blame = blame;
		this.conseil = conseil;
		this.consigne = consigne;
		this.exclusions = exclusions;
		this.retards = retards;
		this.appre = appre;
		this.sanction = sanction;
		this.tcoef = tcoef;
		this.extrememax = extrememax;
		this.extremmemin = extremmemin;
		this.state = state;
	}

	public Bulletin(Bulletin bulletin) {
		super(bulletin.id, bulletin.designation, bulletin.moduleName, 0L);
		this.code = bulletin.code;
		this.eleve = new Eleve(bulletin.eleve);
		if (bulletin.model != null) {
			this.model = new Examen(bulletin.model);
		}
		this.lignes = new ArrayList<LigneBulletinClasse>();
		//this.lignesprimaire = new ArrayList<LigneBulletinClassePrimaire>();
		this.classe = new Classe(bulletin.classe);
		this.tpoint = bulletin.tpoint;
		this.rang = bulletin.rang;
		this.tcoef = bulletin.tcoef;
		this.state = bulletin.state;
		this.moypremier = bulletin.moypremier;
		this.moydernier = bulletin.moydernier;
		this.nbreMoy = bulletin.nbreMoy;
		this.moyenneClas = bulletin.moyenneClas;
		this.txreusitte = bulletin.txreusitte;
		this.eType = bulletin.eType;
		this.extrememax = bulletin.extrememax;
		this.extremmemin = bulletin.extremmemin;
		this.moyenne = bulletin.moyenne;
		this.nbreAbsNonJus = bulletin.nbreAbsNonJus;
		this.nbreAbsJus = bulletin.nbreAbsJus;
		this.avert = bulletin.avert;
		this.blame = bulletin.blame;
		this.conseil = bulletin.conseil;
		this.consigne = bulletin.consigne;
		this.exclusions = bulletin.exclusions;
		this.retards = bulletin.retards;
		this.appre = bulletin.appre;
		this.sanction = bulletin.sanction;
		this.matricule=bulletin.matricule;
		this.nom=bulletin.nom;
		if (bulletin.inscription != null) {
			this.inscription = new Inscription(bulletin.inscription);
		}
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Bulletin(ViewNoteHelper helper, Examen model) {
		this.code = model.getId() + "";
		this.eleve = new Eleve(helper.getEleve().getEleve());
		this.matricule=helper.getEleve().getMatricule();
		this.nom=helper.getEleve().getEleve().getNom()+" "+helper.getEleve().getEleve().getPrenon();
		this.model = new Examen(model);
		this.lignes = new ArrayList<LigneBulletinClasse>();
		this.classe = new Classe(helper.getClasse());
		this.tcoef = (long) helper.getMatiere().getMatiere().getCoeficient();
		this.tpoint = new Double(0);
		this.rang = new Long(0);
		this.tcoef = new Long(0);
		this.moypremier = helper.getMoyPremier();
		this.moydernier = helper.getMoyDernnier();
		this.nbreMoy = helper.getNbreMoy();
		this.moyenneClas = helper.getMoygencls();
		this.txreusitte = helper.getTxReu();
		this.eType = helper.getEcartType();
		this.extrememax = new Double(0);
		this.extremmemin = new Double(0);
		this.nbreAbsNonJus = new Long(0);
		this.nbreAbsJus = new Long(0);
		this.avert = false;
		this.blame = false;
		this.conseil = false;
		this.consigne = new Long(0);
		this.exclusions = new Long(0);
		this.retards = new Long(0);
		this.inscription = helper.getEleve();
		this.moyenne = helper.getMoyEtudiant();
		this.rang = helper.getRang();

	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

//	public List<LigneBulletinClassePrimaire> getLignesprimaire() {
//		return lignesprimaire;
//	}
//
//	public void setLignesprimaire(List<LigneBulletinClassePrimaire> lignesprimaire) {
//		this.lignesprimaire = lignesprimaire;
//	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de classe";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return " Bulletin de classe";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getNom();
	}

	public int compareTo(Bulletin o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Examen getModel() {
		return model;
	}

	public void setModel(Examen model) {
		this.model = model;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public List<LigneBulletinClasse> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneBulletinClasse> lignes) {
		this.lignes = lignes;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Etabli");
		states.add(state);
		state = new State("valide", "Validé");
		states.add(state);
		return states;
	}

	public String getState() {
		return state;
	}

	public Double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(Double moyenne) {
		this.moyenne = moyenne;
	}

	public Double getTpoint() {
		return tpoint;
	}

	public void setTpoint(Double tpoint) {
		this.tpoint = tpoint;
	}

	public Long getNbreAbsNonJus() {
		return nbreAbsNonJus;
	}

	public void setNbreAbsNonJus(Long nbreAbsNonJus) {
		this.nbreAbsNonJus = nbreAbsNonJus;
	}

	public Long getNbreAbsJus() {
		return nbreAbsJus;
	}

	public void setNbreAbsJus(Long nbreAbsJus) {
		this.nbreAbsJus = nbreAbsJus;
	}

	public Boolean getAvert() {
		return avert;
	}

	public void setAvert(Boolean avert) {
		this.avert = avert;
	}

	public Boolean getBlame() {
		return blame;
	}

	public void setBlame(Boolean blame) {
		this.blame = blame;
	}

	public Boolean getConseil() {
		return conseil;
	}

	public void setConseil(Boolean conseil) {
		this.conseil = conseil;
	}

	public Long getConsigne() {
		return consigne;
	}

	public void setConsigne(Long consigne) {
		this.consigne = consigne;
	}

	public String getAppre() {
		return appre;
	}

	public void setAppre(String appre) {
		this.appre = appre;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Long getExclusions() {
		return exclusions;
	}

	public void setExclusions(Long exclusions) {
		this.exclusions = exclusions;
	}

	public Long getRetards() {
		return retards;
	}

	public void setRetards(Long retards) {
		this.retards = retards;
	}

	public Long getRang() {
		return rang;
	}

	public Double getMoypremier() {
		return moypremier;
	}

	public void setMoypremier(Double moypremier) {
		this.moypremier = moypremier;
	}

	public Double getMoydernier() {
		return moydernier;
	}

	public void setMoydernier(Double moydernier) {
		this.moydernier = moydernier;
	}

	public Long getNbreMoy() {
		return nbreMoy;
	}

	public void setNbreMoy(Long nbreMoy) {
		this.nbreMoy = nbreMoy;
	}

	public Double getMoyenneClas() {
		return moyenneClas;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}

	public void setMoyenneClas(Double moyenneClas) {
		this.moyenneClas = moyenneClas;
	}

	public Double getTxreusitte() {
		return txreusitte;
	}

	public void setTxreusitte(Double txreusitte) {
		this.txreusitte = txreusitte;
	}

	public Double geteType() {
		return eType;
	}

	public void seteType(Double eType) {
		this.eType = eType;
	}

	public void setRang(Long rang) {
		this.rang = rang;
	}

	public Long getTcoef() {
		return tcoef;
	}

	public void setTcoef(Long tcoef) {
		this.tcoef = tcoef;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getExtrememax() {
		return extrememax;
	}

	public void setExtrememax(Double extrememax) {
		this.extrememax = extrememax;
	}

	public Double getExtremmemin() {
		return extremmemin;
	}

	public void setExtremmemin(Double extremmemin) {
		this.extremmemin = extremmemin;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

}
