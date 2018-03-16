/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_reglement")
public class Reglement extends BaseElement implements Serializable, Comparable<Reglement> {

	@ManyToOne
	@JoinColumn(name = "EL_ID" )
	@Predicate(label="ETUDIANT",updatable=true,type=Inscription.class , target="many-to-one",search=true , sequence=1	)
	protected Inscription eleve = new Inscription();
	
	@Column(name = "APAYER" )	
	@Predicate(label="Scolarite",updatable=false,search=true, type=Long.class ,sequence=2,editable=false )
	protected Long scolarite;
	
	@Column(name = "PAYER" )	
	@Predicate(label="Payer",updatable=false,search=true, type=Long.class ,sequence=3,editable=false)
	protected Long payer;
	
	@Column(name = "SOLD" )	
	@Predicate(label="Solde",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long solde;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "FICHE_PAIE_ID")
	@Predicate(updatable=true,type=FichePaiement.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Fiche Paiement", groupName="tab1")
	protected List<FichePaiement> service = new ArrayList<FichePaiement>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "PAIE_ID")
	@Predicate(updatable=true,type=Paiement.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Paiements", groupName="tab2")
	protected List<Paiement> paiement = new ArrayList<Paiement>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "Ech_ID")
	@Predicate(updatable=true,type=Echeancier.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Echeancier", groupName="tab3")
	protected List<Echeancier> echeance = new ArrayList<Echeancier>();
	
	@Transient
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "RT_ID")
	@Predicate(updatable=false,type=Retard.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Retards", groupName="tab4" ,editable=false)
	protected List<Retard> retard = new ArrayList<Retard>();
	

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;


	public Reglement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reglement(Reglement ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.eleve = new Inscription(ins.eleve);
		this.service= new ArrayList<FichePaiement>();
		this.paiement= new ArrayList<Paiement>();
		this.retard= new ArrayList<Retard>();
		this.echeance= new ArrayList<Echeancier>();
		this.scolarite=ins.scolarite;
		this.payer=ins.payer;
		this.solde=ins.solde;

	}

	
	public Inscription getEleve() {
		return eleve;
	}


	
	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}



	public List<FichePaiement> getService() {
		return service;
	}


	public void setService(List<FichePaiement> service) {
		this.service = service;
	}


	public List<Paiement> getPaiement() {
		return paiement;
	}


	public List<Echeancier> getEcheance() {
		return echeance;
	}


	public void setEcheance(List<Echeancier> echeance) {
		this.echeance = echeance;
	}


	public Long getScolarite() {
		return scolarite;
	}


	public void setScolarite(Long scolarite) {
		this.scolarite = scolarite;
	}


	public Long getPayer() {
		return payer;
	}


	public void setPayer(Long payer) {
		this.payer = payer;
	}


	public Long getSolde() {
		return solde;
	}


	public void setSolde(Long solde) {
		this.solde = solde;
	}


	public List<Retard> getRetard() {
		return retard;
	}


	public void setRetard(List<Retard> retard) {
		this.retard = retard;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public void setPaiement(List<Paiement> paiement) {
		this.paiement = paiement;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Reglement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements des étudiants ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements des étudiants";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return eleve.getEleve().getMatricule()+"-"+eleve.getEleve().getNom();
	}


	

}
