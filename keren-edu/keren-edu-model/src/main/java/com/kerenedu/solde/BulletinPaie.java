/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.configuration.Etablissement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name = "e_bulletin")
public class BulletinPaie extends BaseElement implements Serializable, Comparable<BulletinPaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8274847472533474787L;

	// @Predicate(label="Intutilé",updatable=false,optional=false,search=true)
	private String code;

	@ManyToOne
	@JoinColumn(name = "EMP_ID")
	@Predicate(label = "Employé", type = Professeur.class, target = "many-to-one", updatable = false, optional = false, search = true, sequence = 1)
	private Professeur employe;

	@Predicate(label = "Date de payement", type = Date.class, target = "date", updatable = false, search = true, sequence = 2)
	@Temporal(TemporalType.DATE)
	private Date dpayement;

	@ManyToOne
	@JoinColumn(name = "PEPA_ID")
	@Predicate(label = "Période", type = PeriodePaie.class, target = "many-to-one", updatable = false, optional = false, search = true, sequence = 3)
	private PeriodePaie periode;

	@Predicate(label = "Catégorie", updatable = false, optional = false, search = false, sequence = 4)
	private String categorie;

	@Predicate(label = "Echelon", updatable = false, optional = false, search = false, sequence = 7)
	private String echellon;

	@Column(name = "ANC")
	// @Predicate(label = "Anciennité",type = Double.class,editable =
	// false,updatable = false ,sequence=7)
	private Double anciennite = 0.0;
	
	@Column(name = "NOM")
	//@Predicate(label = "Nom", search = true, optional = false)
	protected String nom;

	@Column(name = "CONTACT")
	//@Predicate(label = "Contacts", search = true, optional = false)
	protected String contacts;
	
	@Column(name = "ADR")
	//@Predicate(label = "Code Postal", search = true, optional = false)
	protected String adresse;

	@Transient
	@Predicate(label = "Anciennité", type = Double.class, editable = false, updatable = false, sequence = 6)
	private String ancienniteString;

	// @Transient
	// @ManyToOne
	// @JoinColumn(name="CAT_ID")
	// @Predicate(label="Catégories" ,type=Categorie.class,target="many-to-one",
	// editable=false)
	// @Observer(observable="employe",source="field:categorie")
	// private Categorie categorie ;
	//
	// @Transient
	// @ManyToOne
	// @JoinColumn(name="ECH_ID")
	// @Predicate(label="Echelon" ,type=Echelon.class,target="many-to-one",
	// editable=false)
	// @Observer(observable="employe",source="field:echelon" )
	// private Echelon echelon ;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "LIBUPA_ID")
	@Predicate(label = "Lignes", type = LigneBulletinPaie.class, target = "one-to-many", updatable = false, editable = false, group = true, groupName = "group1", groupLabel = "VALEURS DE RUBRIQUES", edittable = true)
	private List<LigneBulletinPaie> lignes = new ArrayList<LigneBulletinPaie>();

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "BUPA_ID")
	//@Predicate(label = "VARIABLES", type = LigneElementVariable.class, target = "one-to-many", group = true, groupName = "group2", groupLabel = "VARIABLES", edittable = true)
	private List<LigneElementVariable> variables = new ArrayList<LigneElementVariable>();

	@Column(name = "SBB")
	@Predicate(label = "Salaire Brut", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireBrut = 0.0;
	
	@Column(name = "SNET")
	@Predicate(label = "Salaire Net", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double netapayer = 0.0;
	
	@Column(name = "CPA")
	@Predicate(label = "Charge Patronale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double chargePatronale = 0.0;

	@Column(name = "CSA")
	@Predicate(label = "Charge Salariale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double chargeSalariale = 0.0;
	
	@Column(name = "CSB")
	@Predicate(label = "Cumul Salaire de Base", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulSalaireBrut = 0.0;
	
	@Column(name = "CCS")
	//@Predicate(label = "Cumul Charges Salariale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulChargeSalariale = 0.0;

	@Column(name = "CCP")
	//@Predicate(label = "Cumul Charges Patronale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulChargePatronale = 0.0;
	

	@Column(name = "STA")
	//@Predicate(label = "Salaire Taxable", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireTaxable = 0.0;

	@Column(name = "TAAV")
	//@Predicate(label = "Taxe sur Avantages", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double taxeAvantages = 0.0;

	@Column(name = "SCO")
//	@Predicate(label = "Salaire Cotisable", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireCotisable = 0.0;

	@Column(name = "SEX")
	//@Predicate(label = "Salaire Exceptionel", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireExcep = 0.0;

	@Column(name = "ANG")
//	@Predicate(label = "Anciennité Gélée", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double ancienniteGelee = 0.0;

	

	@Column(name = "ANA")
	//@Predicate(label = "Avantage en nature", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double avantageNature = 0.0;

	@Column(name = "CPR")
	//@Predicate(label = "Congés Pris", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double congespris = 0.0;

	@Column(name = "CRE")
	//@Predicate(label = "Solde Congé", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double congesRestant = 0.0;

	@Column(name = "CACP")
	private Double congesAcquisPeriode = 0.0;

	@Column(name = "CPRP")
	private Double congesprisPeriode = 0.0;

	@Column(name = "CAC")
	//@Predicate(label = "Congés Acquis", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double congesAcquis = 0.0;



	@Column(name = "CST")
	//@Predicate(label = "Cumul Salaire Taxable", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulSalaireTaxable = 0.0;

	@Column(name = "CSC")
	//@Predicate(label = "Cumul Salaire Cotisable", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulSalaireCotisable = 0.0;

	@Column(name = "CSE")
	//@Predicate(label = "Cumul Salaire Exceptionnel", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulSalaireExcep = 0.0;



	@Column(name = "CAN")
	//@Predicate(label = "Cumul Avantages en Nature", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double cumulAvantageNature = 0.0;

	@Column(name = "CHT")
	private Double cumulHeureTravailles = 0.0;

	@Column(name = "CHS")
	private Double cumulHeuresSup = 0.0;

	// parapètre pour etat des bulletins
	@Transient
	private Parametres parametre;

	private String state = "etabli";

	private String netLettre = "";

	

	@Transient
	private String lastperiode;

	/**
	 * 
	 */
	public BulletinPaie() {
		// TODO Auto-generated constructor stub
	}

	public String getAncienniteString() {
		return ancienniteString;
	}

	public void setAncienniteString(String ancienniteString) {
		this.ancienniteString = ancienniteString;
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BulletinPaie(long id, String designation, String moduleName) {
		super(id, designation, moduleName, 0L);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param employe
	 * @param dpayement
	 * @param periode
	 * @param nbrejrstra
	 * @param categorie
	 * @param salbrut
	 * @param echelon
	 * @param salcot
	 * @param ancienite
	 * @param saltax
	 * @param nbreenfts
	 * @param lignes
	 * @param state
	 */

	public BulletinPaie(long id, String designation, String moduleName, String code, Professeur employe, Date dpayement,
			PeriodePaie periode, Short nbrejrstra, Categorie categorie, Double salbrut, Echellon echelon, Double salcot,
			Short ancienite, Double saltax, Short nbreenfts, List<LigneBulletinPaie> lignes, String state) {
		super(id, designation, moduleName, 0L);
		this.code = code;
		this.employe = employe;
		this.dpayement = dpayement;
		this.periode = periode;
		// this.nbrejrstra = nbrejrstra;
		// this.categorie = categorie;
		// this.salbrut = salbrut;
		// this.echelon = echelon;
		// this.salcot = salcot;
		// this.ancienite = ancienite;
		// this.saltax = saltax;
		// this.nbreenfts = nbreenfts;
		this.lignes = lignes;
		this.state = state;
	}

	/**
	 * 
	 * @param code
	 * @param employe
	 * @param dpayement
	 * @param periode
	 */
	public BulletinPaie(String code, Professeur employe, Date dpayement, PeriodePaie periode, Etablissement structure) {
		super(-1, null, null, 0L);
		this.code = code;
		this.employe = employe;
		this.dpayement = dpayement;
		this.periode = periode;
		this.nom=structure.getNom();
		this.adresse=structure.getAdresse();
		this.contacts=structure.getContacts();
	}

	public BulletinPaie(BulletinPaie bulletin) {
		super(bulletin.id, bulletin.designation, bulletin.moduleName, bulletin.compareid);
		this.code = bulletin.code;
		if (bulletin.employe != null) {
			this.employe = new Professeur(bulletin.employe);
			// this.categorie=bulletin.getEmploye().getCategorie();
			// this.echelon=bulletin.getEmploye().getEchelon();
		}
		this.dpayement = bulletin.dpayement;
		if (bulletin.periode != null) {
			this.periode = new PeriodePaie(bulletin.periode);
		}

		this.state = bulletin.state;
		this.nom=bulletin.getNom();
		this.adresse=bulletin.getAdresse();
		this.contacts=bulletin.getContacts();
		salaireBrut = bulletin.salaireBrut;
	
		anciennite = bulletin.anciennite;
		
		chargePatronale = bulletin.chargePatronale;
		chargeSalariale = bulletin.chargeSalariale;
		avantageNature = bulletin.avantageNature;
		
		cumulSalaireBrut = bulletin.cumulSalaireBrut;
		cumulSalaireTaxable = bulletin.cumulSalaireTaxable;
		cumulSalaireCotisable = bulletin.cumulSalaireCotisable;

		cumulChargeSalariale = bulletin.cumulChargeSalariale;
		cumulChargePatronale = bulletin.cumulChargePatronale;
	
		this.netLettre = bulletin.netLettre;
		this.netapayer = bulletin.netapayer;
		if(bulletin.getEmploye().getCategorie()!=null){
		  this.categorie = bulletin.getEmploye().getCategorie().getCode() + "";
		}
		
		if(bulletin.getEmploye().getEchelon()!=null){
		this.echellon = bulletin.getEmploye().getEchelon().getCode();
		}
		this.ancienniteString = this.getAnciennete(this.getAnciennite(), this.periode.getDfin());
	}

//	public BulletinPaie(LivrePaie livre) {
//		super();
//		if (this.periode != null) {
//			this.periode = new PeriodePaie(livre.getPeriode());
//		}
//	}

	public String getCode() {
		return code;
	}

	public String getNom() {
		return nom;
	}

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

	public void setCode(String code) {
		this.code = code;
	}

	public Professeur getEmploye() {
		return employe;
	}

	public void setEmploye(Professeur employe) {
		this.employe = employe;
	}

	public Date getDpayement() {
		return dpayement;
	}

	public void setDpayement(Date dpayement) {
		this.dpayement = dpayement;
	}

	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}

	public List<LigneBulletinPaie> getLignes() {
		return lignes;
	}

	public void setLignes(List<LigneBulletinPaie> lignes) {
		this.lignes = lignes;
	}

	public Double getTaxeAvantages() {
		return taxeAvantages;
	}

	public void setTaxeAvantages(Double taxeAvantages) {
		this.taxeAvantages = taxeAvantages;
	}

	public Double getCongesAcquisPeriode() {
		return congesAcquisPeriode;
	}

	public void setCongesAcquisPeriode(Double congesAcquisPeriode) {
		this.congesAcquisPeriode = congesAcquisPeriode;
	}

	public Double getCongesprisPeriode() {
		return congesprisPeriode;
	}

	public void setCongesprisPeriode(Double congesprisPeriode) {
		this.congesprisPeriode = congesprisPeriode;
	}

	public List<LigneElementVariable> getVariables() {
		return variables;
	}

	public void setVariables(List<LigneElementVariable> variables) {
		this.variables = variables;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getEchellon() {
		return echellon;
	}

	public void setEchellon(String echellon) {
		this.echellon = echellon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//
	//
	// public Categorie getCategorie() {
	// return categorie;
	// }
	//
	// public void setCategorie(Categorie categorie) {
	// this.categorie = categorie;
	// }
	//
	// public Echelon getEchelon() {
	// return echelon;
	// }
	//
	// public void setEchelon(Echelon echelon) {
	// this.echelon = echelon;
	// }

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bulletins de paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return employe.getDesignation();
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return super.isCreateonfield();
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
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
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("valide", "Validé");
		states.add(state);
		// state = new State("constate", "A constater");
		// states.add(state);
		state = new State("transfere", "Transfere en Comptabilité");
		states.add(state);
		// state = new State("ordonne", "Paiement ordonné");
		// states.add(state);
		// state = new State("paye", "Payé");
		// states.add(state);
		return states;
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	public Parametres getParametre() {
		return parametre;
	}

	public void setParametre(Parametres parametre) {
		this.parametre = parametre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	

	public Double getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(Double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public Double getSalaireTaxable() {
		return salaireTaxable;
	}

	public void setSalaireTaxable(Double salaireTaxable) {
		this.salaireTaxable = salaireTaxable;
	}

	public Double getSalaireCotisable() {
		return salaireCotisable;
	}

	public void setSalaireCotisable(Double salaireCotisable) {
		this.salaireCotisable = salaireCotisable;
	}

	public String getNetLettre() {
		return netLettre;
	}

	public void setNetLettre(String netLettre) {
		this.netLettre = netLettre;
	}

	public Double getNetapayer() {
		return netapayer;
	}

	public void setNetapayer(Double netapayer) {
		this.netapayer = netapayer;
	}

	public String getLastperiode() {
		return lastperiode;
	}

	public void setLastperiode(String lastperiode) {
		this.lastperiode = lastperiode;
	}

	public Double getSalaireExcep() {
		return salaireExcep;
	}

	public void setSalaireExcep(Double salaireExcep) {
		this.salaireExcep = salaireExcep;
	}

	public Double getAnciennite() {
		return anciennite;
	}

	public void setAnciennite(Double anciennite) {
		this.anciennite = anciennite;
	}

	public Double getAncienniteGelee() {
		return ancienniteGelee;
	}

	public void setAncienniteGelee(Double ancienniteGelee) {
		this.ancienniteGelee = ancienniteGelee;
	}

	public Double getChargePatronale() {
		return chargePatronale;
	}

	public void setChargePatronale(Double chargePatronale) {
		this.chargePatronale = chargePatronale;
	}

	public Double getChargeSalariale() {
		return chargeSalariale;
	}

	public void setChargeSalariale(Double chargeSalariale) {
		this.chargeSalariale = chargeSalariale;
	}

	public Double getAvantageNature() {
		return avantageNature;
	}

	public void setAvantageNature(Double avantageNature) {
		this.avantageNature = avantageNature;
	}

	public Double getCongespris() {
		return congespris;
	}

	public void setCongespris(Double congespris) {
		this.congespris = congespris;
	}

	public Double getCongesRestant() {
		return congesRestant;
	}

	public void setCongesRestant(Double congesRestant) {
		this.congesRestant = congesRestant;
	}

	public Double getCongesAcquis() {
		return congesAcquis;
	}

	public void setCongesAcquis(Double congesAcquis) {
		this.congesAcquis = congesAcquis;
	}

	public Double getCumulSalaireBrut() {
		return cumulSalaireBrut;
	}

	public void setCumulSalaireBrut(Double cumulSalaireBrut) {
		this.cumulSalaireBrut = cumulSalaireBrut;
	}

	public Double getCumulSalaireTaxable() {
		return cumulSalaireTaxable;
	}

	public void setCumulSalaireTaxable(Double cumulSalaireTaxable) {
		this.cumulSalaireTaxable = cumulSalaireTaxable;
	}

	public Double getCumulSalaireCotisable() {
		return cumulSalaireCotisable;
	}

	public void setCumulSalaireCotisable(Double cumulSalaireCotisable) {
		this.cumulSalaireCotisable = cumulSalaireCotisable;
	}

	public Double getCumulSalaireExcep() {
		return cumulSalaireExcep;
	}

	public void setCumulSalaireExcep(Double cumulSalaireExcep) {
		this.cumulSalaireExcep = cumulSalaireExcep;
	}

	public Double getCumulChargeSalariale() {
		return cumulChargeSalariale;
	}

	public void setCumulChargeSalariale(Double cumulChargeSalariale) {
		this.cumulChargeSalariale = cumulChargeSalariale;
	}

	public Double getCumulChargePatronale() {
		return cumulChargePatronale;
	}

	public void setCumulChargePatronale(Double cumulChargePatronale) {
		this.cumulChargePatronale = cumulChargePatronale;
	}

	public Double getCumulAvantageNature() {
		return cumulAvantageNature;
	}

	public void setCumulAvantageNature(Double cumulAvantageNature) {
		this.cumulAvantageNature = cumulAvantageNature;
	}

	public Double getCumulHeureTravailles() {
		return cumulHeureTravailles;
	}

	public void setCumulHeureTravailles(Double cumulHeureTravailles) {
		this.cumulHeureTravailles = cumulHeureTravailles;
	}

	public Double getCumulHeuresSup() {
		return cumulHeuresSup;
	}

	public void setCumulHeuresSup(Double cumulHeuresSup) {
		this.cumulHeuresSup = cumulHeuresSup;
	}

	@Override
	public String toString() {
		return "BulletinPaie{ id=" + id + "code=" + code + ", employe=" + employe + ", dpayement=" + dpayement
				+ ", periode=" + periode + ", lignes=" + lignes + ", variables=" + variables + ", state=" + state + '}';
	}

	public String getAnciennete(Double nombreMois, Date date) {
		String value = null;
		double annee = new Double(nombreMois) / new Double(12); // divisé par
																// zéro et c'est
																// faux!
																// attention!
		int anneeint = (int) annee;
		double reste = (double) (annee - anneeint);
		int mois = (int) (reste * 12);

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int max = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println("DateHelper.getAnciennete() nombre jous du mois " + max);
		int jour = (int) (((reste * 12) - mois) * max);
		value = anneeint + " ans ," + mois + " mois ," + jour + " jours";
		return value;
	}

	public int compareTo(BulletinPaie o) {
		// TODO Auto-generated method stub
		return employe.compareTo(o.employe);
	}


}
