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
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_reg_prof")
public class ReglementProf extends BaseElement implements Serializable, Comparable<ReglementProf> {

	@ManyToOne
	@JoinColumn(name = "PROF_ID" )
	@Predicate(label="PROF.",updatable=true,type=Professeur.class , target="many-to-one",search=true , sequence=1	)
	protected Professeur prof = new Professeur();
	
	@Column(name = "APAYER" )	
	@Predicate(label="Salaire Global",updatable=false,search=true, type=Long.class ,sequence=2,editable=false )
	protected Long salmax;
	
	@Column(name = "PAYER" )	
	@Predicate(label="Perçu",updatable=false,search=true, type=Long.class ,sequence=3,editable=false)
	protected Long payer;
	
	@Column(name = "SOLD" )	
	@Predicate(label="Solde",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long solde;
	
	@Column(name = "PRIME" )	
	@Predicate(label="Total Prime",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zprime;
	
	@Column(name = "RETENU" )	
	@Predicate(label="Total Retenue",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zretenu;
	
	@Column(name = "AVANCE" )	
	@Predicate(label="Total Avance",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zavance;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "HIS_PAIE_ID")
	@Predicate(updatable=true,type=FichePaiementProf.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Fiche Paiement", groupName="tab1")
	protected List<FichePaiementProf> ficheProf = new ArrayList<FichePaiementProf>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "PAIE_ID")
	@Predicate(updatable=true,type=PaiementProf.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Paiements", groupName="tab2")
	protected List<PaiementProf> paiement = new ArrayList<PaiementProf>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "PAIE_ID")
	@Predicate(updatable=true,type=AvanceProf.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Avance", groupName="tab3")
	protected List<AvanceProf> avance = new ArrayList<AvanceProf>();
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "PAIE_ID")
	@Predicate(updatable=true,type=PrimeProf.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Primes", groupName="tab4")
	protected List<PrimeProf> prime = new ArrayList<PrimeProf>();
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "PAIE_ID")
	@Predicate(updatable=true,type=RetenueProf.class , target="one-to-many",search=true , sequence=2,group=true,
	groupLabel="Retenues", groupName="tab5")
	protected List<RetenueProf> retenue = new ArrayList<RetenueProf>();
	
	

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;


	public ReglementProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReglementProf(ReglementProf ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.prof = new Professeur(ins.prof);
		this.ficheProf= new ArrayList<FichePaiementProf>();
		this.paiement= new ArrayList<PaiementProf>();
		this.salmax=ins.salmax;
		this.payer=ins.payer;
		this.solde=ins.solde;
		this.zprime=ins.zprime;
		this.zretenu=ins.zretenu;
		this.zavance=ins.zavance;

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




	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	public Long getSalmax() {
		return salmax;
	}


	public void setSalmax(Long salmax) {
		this.salmax = salmax;
	}


	public List<FichePaiementProf> getFicheProf() {
		return ficheProf;
	}


	public void setFicheProf(List<FichePaiementProf> ficheProf) {
		this.ficheProf = ficheProf;
	}


	public List<PaiementProf> getPaiement() {
		return paiement;
	}


	public void setPaiement(List<PaiementProf> paiement) {
		this.paiement = paiement;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ReglementProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements des Professeurs ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements des Professeurs";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	


	public Long getZprime() {
		return zprime;
	}


	public void setZprime(Long zprime) {
		this.zprime = zprime;
	}


	public Long getZretenu() {
		return zretenu;
	}


	public void setZretenu(Long zretenu) {
		this.zretenu = zretenu;
	}


	public Long getZavance() {
		return zavance;
	}


	public void setZavance(Long zavance) {
		this.zavance = zavance;
	}


	public List<AvanceProf> getAvance() {
		return avance;
	}


	public void setAvance(List<AvanceProf> avance) {
		this.avance = avance;
	}


	public List<PrimeProf> getPrime() {
		return prime;
	}


	public void setPrime(List<PrimeProf> prime) {
		this.prime = prime;
	}


	public List<RetenueProf> getRetenue() {
		return retenue;
	}


	public void setRetenue(List<RetenueProf> retenue) {
		this.retenue = retenue;
	}


	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return prof.getStatus()+" /"+ prof.getNom();
	}


	

}
