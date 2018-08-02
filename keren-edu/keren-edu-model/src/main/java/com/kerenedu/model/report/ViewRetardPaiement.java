/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_v_rpaie")
public class ViewRetardPaiement extends BaseElement implements Serializable, Comparable<ViewRetardPaiement> {

	
	@Transient
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	@Predicate(label="Section",type=SectionE.class,target="many-to-one",optional=false, sequence=1)
	private SectionE section ;
	
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",type=Classe.class , target="many-to-one",search=true , sequence=2, observable=true)
	@Filter(value="[{\"fieldName\":\"section\",\"value\":\"object.section\",\"searchfield\":\"libelle\",\"optional\":false,\"message\":\"Veuillez sélectionner une Section\"}]")
	protected Classe classe ;
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	//@Predicate(label="Elève",updatable=true,type=Eleve.class , target="many-to-one",search=true	,searchfields="matricule")
	protected Eleve eleve ;
	@Transient
	@Column(name = "LIBELLE")	
	//@Predicate(label="LIBELLE",optional=false,updatable=true,search=true, sequence=1)
	protected String libelle;
	
	@Transient
	@Column(name = "TOTAL_TTC" )	
	//@Predicate(label="TOTAL TTC",optional=true,search=true, type=Long.class , editable=false)
	protected Long ztotal ;
	
	@Transient
	@Column(name = "MNT_PAYER" )	
	//@Predicate(label="PAYER ",optional=false,updatable=false,search=true, type=Long.class , editable=false)
	protected Long mntpayer ;
	
	@Transient
	@Column(name = "SOLDE" )	
	//@Predicate(label="SOLDE ",optional=false,updatable=false,search=true, type=Long.class , editable=false)
	protected Long solde ;
	
	@Transient
	@Column(name = "DELAI")
	//@Predicate(label="DELAI PAIEMENT",optional=false,updatable=true,search=true, type=Date.class, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date delai;
	
	@Transient
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	


	public ViewRetardPaiement() {
		// TODO Auto-generated constructor stub
	}


	public ViewRetardPaiement(ViewRetardPaiement ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(ins.eleve!=null){
			this.eleve = new Eleve(ins.eleve);
		}
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
		}
		if(ins.getSection()!=null){
			this.section=ins.getSection();
		}
	
		
	}
	

	public ViewRetardPaiement(Inscription ins) {
		this.id=ins.getId();
		this.designation=ins.getDesignation();
		this.eleve = new Eleve(ins.getEleve());
		this.classe = new Classe(ins.getClasse());
		if(ins.getSection()!=null){
			this.section=ins.getSection();
		}
		
	}
	
	public ViewRetardPaiement(Inscription ins, FichePaiement fiche) {
		this.id=ins.getId();
		this.designation=ins.getDesignation();
		this.eleve = new Eleve(ins.getEleve());
		this.classe = new Classe(ins.getClasse());
		
		this.libelle = fiche.getService().getLibelle();
		this.ztotal = fiche.getZtotal();
		this.mntpayer =fiche.getMntpayer();
		this.solde = fiche.getSolde();
		this.delai = fiche.getService().getDelai();
		this.anneScolaire=ins.getAnneScolaire();
		
	}



	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}





	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Long getZtotal() {
		return ztotal;
	}


	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}


	public Long getMntpayer() {
		return mntpayer;
	}


	public void setMntpayer(Long mntpayer) {
		this.mntpayer = mntpayer;
	}


	public Long getSolde() {
		return solde;
	}


	public void setSolde(Long solde) {
		this.solde = solde;
	}


	public Date getDelai() {
		return delai;
	}


	public void setDelai(Date delai) {
		this.delai = delai;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewRetardPaiement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Liste des eléves Insolvables";
	}

	public SectionE getSection() {
		return section;
	}


	public void setSection(SectionE section) {
		this.section = section;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Liste des eléves Insolvables";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getMatricule()+"-"+eleve.getNom();
	}
	


}
