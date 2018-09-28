/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_bpaie")
public class BulletinPaie extends BaseElement implements Serializable, Comparable<BulletinPaie> {

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

	@Predicate(label = "Echelon", updatable = false, optional = false, search = false, sequence = 5)
	private String echellon;

	@Column(name = "ANC")
	// @Predicate(label = "Anciennité",type = Double.class,editable =
	// false,updatable = false ,sequence=7)
	private Double anciennite = 0.0;

	@Transient
	@Predicate(label = "Anciennité", type = Double.class, editable = false, updatable = false, sequence = 6)
	private String ancienniteString;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "LIGNPAIE_ID")
	@Predicate(label = "Lignes", type = LignePaie.class, target = "one-to-many", updatable = false, editable = false, group = true, groupName = "group1", groupLabel = "VALEURS DE RUBRIQUES", edittable = true)
	private List<LignePaie> lignes = new ArrayList<LignePaie>();

	@Column(name = "SBB")
	@Predicate(label = "Salaire Brut", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireBrut = 0.0;

	@Column(name = "SNET")
	@Predicate(label = "Salaire Net", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double salaireNet = 0.0;

	@Column(name = "CPA")
	@Predicate(label = "Charge Patronale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double chargePatronale = 0.0;

	@Column(name = "CSA")
	@Predicate(label = "Charge Salariale", type = Double.class, editable = false, updatable = false, group = true, groupName = "group3", groupLabel = "RECAPITULATIF")
	private Double chargeSalariale = 0.0;
	
	
	

	public BulletinPaie(String code, Professeur employe, Date dpayement, PeriodePaie periode, String categorie,
			String echellon, Double anciennite, String ancienniteString, List<LignePaie> lignes, Double salaireBrut,
			Double salaireNet, Double chargePatronale, Double chargeSalariale) {
		super();
		this.code = code;
		this.employe = employe;
		this.dpayement = dpayement;
		this.periode = periode;
		this.categorie = categorie;
		this.echellon = echellon;
		this.anciennite = anciennite;
		this.ancienniteString = ancienniteString;
		this.lignes = lignes;
		this.salaireBrut = salaireBrut;
		this.salaireNet = salaireNet;
		this.chargePatronale = chargePatronale;
		this.chargeSalariale = chargeSalariale;
	}
	

	public BulletinPaie(BulletinPaie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		if(entity.employe!=null){
		this.employe = new Professeur(entity.employe);
		}
		
		this.dpayement = entity.dpayement;
		if(entity.periode!=null){
		   this.periode = new PeriodePaie(entity.periode) ;
		}
		
		this.categorie = entity.categorie;
		this.echellon = entity.echellon;
		this.anciennite = entity.anciennite;
		this.ancienniteString = entity.ancienniteString;
		this.lignes = new ArrayList<LignePaie>();
		this.salaireBrut = entity.salaireBrut;
		this.salaireNet = entity.salaireNet;
		this.chargePatronale = entity.chargePatronale;
		this.chargeSalariale = entity.chargeSalariale;
	}

	public BulletinPaie() {
		// TODO Auto-generated constructor stub
	}


	public int compareTo(BulletinPaie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCode() {
		return code;
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

	public Double getAnciennite() {
		return anciennite;
	}

	public void setAnciennite(Double anciennite) {
		this.anciennite = anciennite;
	}

	public String getAncienniteString() {
		return ancienniteString;
	}

	public void setAncienniteString(String ancienniteString) {
		this.ancienniteString = ancienniteString;
	}

	public List<LignePaie> getLignes() {
		return lignes;
	}

	public void setLignes(List<LignePaie> lignes) {
		this.lignes = lignes;
	}

	public Double getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(Double salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public Double getSalaireNet() {
		return salaireNet;
	}

	public void setSalaireNet(Double salaireNet) {
		this.salaireNet = salaireNet;
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

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bulletin de Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+"/"+employe.getNom();
	}


}
