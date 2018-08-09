/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.reglement.Paiement;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class ViewPaiementJournalier extends BaseElement implements Serializable, Comparable<ViewPaiementJournalier> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label = "Elève", updatable = true, type = Eleve.class, target = "many-to-one", search = true,searchfields="matricule" ,colsequence=2)
	protected Eleve eleve;

	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", updatable = true, type = Classe.class, target = "many-to-one", search = true ,colsequence=1,searchfields="libelle")
	protected Classe classe;

	@Column(name = "MNT_PAYER")
	@Predicate(label = "Payer ", optional = false, updatable = false, search = true, type = Long.class, editable = false ,colsequence=7)
	protected Long mntpayer;
	
	@Transient
	@Column(name = "REMISE" )	
	@Predicate(label="REMISE",optional=true,updatable=false,search=true, type=BigDecimal.class ,colsequence=5)
	protected Long remise ;
	
	@Transient
	@Column(name = "RISTOURNE" )	
	@Predicate(label="RISTOURNE",optional=true,updatable=false,search=true, type=BigDecimal.class ,colsequence=6)
	protected Long ristourne ;

	
	@Transient
	@Column(name = "SOLDE")
	@Predicate(label = "Solde ", optional = false, updatable = false, search = true, type = Long.class, editable = false ,colsequence=8)
	protected Long solde;
	
	@Column(name = "DATE_PAI")
	@Predicate(label = "Date Paiement", optional = false, updatable = true, search = true, type = Date.class, target = "date" ,colsequence=9)
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datepai;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire;
	
	
	@Column(name = "CYCLE_ID")
	protected long cycle ;




	public ViewPaiementJournalier() {
		// TODO Auto-generated constructor stub
	}

	public ViewPaiementJournalier(ViewPaiementJournalier ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
	
		this.datepai = ins.datepai;
		this.eleve = new Eleve(ins.getEleve());
		this.classe = new Classe(ins.getClasse());
		this.mntpayer = ins.mntpayer;
		this.remise=ins.remise;
		this.ristourne=ins.ristourne;
		this.anneScolaire=ins.anneScolaire;
		this.cycle=ins.cycle;


	}
	
	public ViewPaiementJournalier(Paiement ins) {
		this.datepai = ins.getDatePaiement();
		this.eleve = new Eleve(ins.getEleve().getEleve());
		this.classe = new Classe(ins.getEleve().getClasse());
		this.mntpayer = ins.getzMnt();
		this.remise=ins.getZremise();
		this.ristourne=(long) 0;
		this.anneScolaire=ins.getAnneScolaire();
		this.cycle=ins.getEleve().getCycle();


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


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewPaiementJournalier o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Détails des Paiements";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Détails des Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "";
	}

	

	public Long getRemise() {
		return remise;
	}

	public void setRemise(Long remise) {
		this.remise = remise;
	}

	public Long getRistourne() {
		return ristourne;
	}

	public void setRistourne(Long ristourne) {
		this.ristourne = ristourne;
	}

	//
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}

	public Date getDatepai() {
		return datepai;
	}

	

	public void setDatepai(Date datepai) {
		this.datepai = datepai;
	}

	public String getAnneScolaire() {
		return anneScolaire;
	}

	public long getCycle() {
		return cycle;
	}

	public void setCycle(long cycle) {
		this.cycle = cycle;
	}

	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}
	
	@Override
	public boolean isActivatefollower() {
		return true; // To change body of generated methods, choose Tools |
						// Templates.
	}

}
