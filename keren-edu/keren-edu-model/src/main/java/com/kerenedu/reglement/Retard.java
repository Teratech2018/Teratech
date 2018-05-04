/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_paie")
public class Retard extends BaseElement implements Serializable, Comparable<Retard> {

	@Transient
	@ManyToOne
	@JoinColumn(name = "SER_ID")
	@Predicate(label="SERVICE",updatable=false,type=Service.class , target="many-to-one",search=true , sequence=1 ,editable=false)
	protected Service service ;
	
	@Transient
	@Predicate(label="MATRICULE",updatable=false,type=String.class ,search=true , sequence=2)
	protected String matricule = "";
	
	@Transient
	@Predicate(label="NOM PRENOM",updatable=false,type=String.class ,search=true , sequence=3)
	protected String eleve = "";
	
	@Transient
	@Predicate(label="CLASSE",updatable=false,type=String.class ,search=true , sequence=4)
	protected String classe = "";
	
	@Transient
	@Predicate(label="MONTANT",updatable=false,type=Long.class ,search=true , sequence=5)
	protected Long montant;
	
	@Transient
	@Predicate(label="MONTANT REGLER",updatable=false,type=Long.class ,search=true , sequence=6)
	protected Long montantregler;
	
	@Transient
	@Predicate(label="DATE REGL.",updatable=false,type=Date.class ,search=true , sequence=7)
	protected Date date;
	
	
	

	public Retard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Retard(Service service, String matricule, String eleve, String classe, Long montant, Long montantregler,
			Date date) {
		super();
		this.service = service;
		this.matricule = matricule;
		this.eleve = eleve;
		this.classe = classe;
		this.montant = montant;
		this.montantregler = montantregler;
		this.date = date;
	}


	public Retard(Retard ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.service = new Service(ins.service) ;
		this.matricule = ins.matricule;
		this.eleve = ins.eleve;
		this.classe = ins.classe;
		this.montant = ins.montant;
		this.montantregler = ins.montantregler;
		this.date = ins.date;
	
	}
	
	public Retard(FichePaiement fiche) {
		this.service = new Service(fiche.service) ;
		this.matricule = fiche.getEleve().getEleve().getMatricule();
		this.eleve = fiche.getEleve().getEleve().getNom();
		this.classe = fiche.getEleve().getClasse().getDesignation();
		this.montant = fiche.getZtotal();
		this.montantregler = fiche.getMntpayer();
		this.date =fiche.getService().getDelai();
	
	}
	
	public Retard(EcheancierDlt ech) {
		this.service = new Service(ech.fiche.getService()) ;
		this.matricule = ech.fiche.getEleve().getEleve().getMatricule();
		this.eleve = ech.fiche.getEleve().getEleve().getNom();
		this.classe = ech.fiche.getEleve().getClasse().getDesignation();
		this.montant = ech.getMnt();
		this.montantregler =ech.getMntpayer();
		this.date =ech.getDateEch();
	
	}


	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Retard o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Retards ";
	}

	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}


	public String getEleve() {
		return eleve;
	}


	public void setEleve(String eleve) {
		this.eleve = eleve;
	}


	public String getClasse() {
		return classe;
	}


	public void setClasse(String classe) {
		this.classe = classe;
	}


	public Long getMontant() {
		return montant;
	}


	public void setMontant(Long montant) {
		this.montant = montant;
	}


	public Long getMontantregler() {
		return montantregler;
	}


	public void setMontantregler(Long montantregler) {
		this.montantregler = montantregler;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}

	
	

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Retards";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return id+"";
	}




			
	

}
