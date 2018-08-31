/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Entity
@Table(name = "e_p_fiche_opt")
public class FichePaiementOptionel extends BaseElement implements Serializable, Comparable<FichePaiementOptionel> {
	
	@ManyToOne
	@JoinColumn(name = "INS_ID")
	@Predicate(label = "Elève", type = Inscription.class, target = "many-to-one", optional = false, search = true, sequence = 1, observable = true, searchfields = "eleve.nom",updatable=false)
	private Inscription eleve;


	@ManyToOne
	@JoinColumn(name = "SER_ID")
	@Predicate(label="SERVICE",updatable=true,type=Service.class , target="many-to-one",search=true , sequence=2, observable=true)
	@Filter(value = "[{\"fieldName\":\"type\",\"value\":\"4\"}]")
	protected Service service ;
		
	@Column(name = "M_HT")	
	@Predicate(label="Montant Attendu",search=false, type=Long.class ,sequence=3, editable=false)
	@Observer(observable = "service", source = "method:montant", parameters = "service")
	protected Long zMntHt ;
	
	@Column(name = "QTE" )	
	@Predicate(label="Qte",optional=false,updatable=true, type=Long.class ,sequence=4, search=true)
	protected Long zQte;
	
	@Column(name = "MNT_PAYER" )	
	@Predicate(label="Versement ",optional=false,updatable=false,search=true, type=Long.class ,sequence=5)
	protected Long mntpayer ;
	
	@Column(name = "TOTAL_TTC" )	
	//@Predicate(label="TOTAL TTC",optional=true, type=Long.class ,sequence=5,search=true, editable=false ,hide=true)
	protected Long ztotal ;
	
		
	@Column(name = "SOLDE" )	
	protected Long solde ;

	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	@Column(name = "MAT_ID")
	protected String matricule ;
	
	protected Boolean payer =false;
	

	
	
	public FichePaiementOptionel(Service service, Long zQte, Long zMntHt, Long zremise, Long zristourne, Long ztotal,
			Long mntpayer, Long solde, Long zMntTmp, String anneScolaire, Boolean payer) {
		super();
		this.service = service;
		this.zQte = zQte;
		this.zMntHt = zMntHt;
		this.ztotal = ztotal;
		this.mntpayer = mntpayer;
		this.solde = solde;
		this.anneScolaire = anneScolaire;
		this.payer = payer;
	}


	public FichePaiementOptionel() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FichePaiementOptionel(FichePaiementOptionel ins) {
		super(ins.id, ins.designation, ins.moduleName,ins.compareid);
		this.zQte = ins.zQte;
		this.zMntHt = ins.zMntHt;
		//this.ztotal=ins.zQte*ins.zMntHt;
		if(ins.service!=null){
		  this.service= new Service(ins.service);
		}
		
		if(ins.eleve!=null){
			  this.eleve= new Inscription(ins.eleve);
			}
		this.mntpayer = ins.mntpayer;
		this.solde=(long) 0;
		this.mntpayer= ins.mntpayer;
		this.payer=true;
		
	
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements /Services Optionel";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements /Services Optionel";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return service.getLibelle();
	}


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}


	public Long getzQte() {
		return zQte;
	}


	public void setzQte(Long zQte) {
		this.zQte = zQte;
	}


	public Long getzMntHt() {
		return zMntHt;
	}


	public void setzMntHt(Long zMntHt) {
		this.zMntHt = zMntHt;
	}


	public Long getZtotal() {
		return ztotal;
	}


	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}


	


	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public Long getMntpayer() {
		return mntpayer;
	}



	public void setMntpayer(Long mntpayer) {
		this.mntpayer = mntpayer;
	}


	public Long getSolde() {
		return this.solde;
	}


	public void setSolde(Long solde) {
		this.solde = solde;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}





	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Boolean getPayer() {
		return payer;
	}


	public void setPayer(Boolean payer) {
		this.payer = payer;
	}





	@Override
	public boolean isDesableupdate() {
		// TODO Auto-generated method stub
		return true;
	}


	public String getMatricule() {
		return matricule;
	}


	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public void addMontant(long montant){
		this.mntpayer+=montant;
		this.solde-=montant;
	}
	
	public void subtractMontant(long montant){
		this.mntpayer=this.mntpayer-montant;
		this.solde=this.solde+montant;
	}


	public int compareTo(FichePaiementOptionel o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
