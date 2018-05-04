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

import com.core.base.BaseElement;
import com.kerenedu.configuration.Service;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_fpaie")
public class FichePaiement extends BaseElement implements Serializable, Comparable<FichePaiement> {

	@ManyToOne
	@JoinColumn(name = "SER_ID")
	@Predicate(label="SERVICE",updatable=true,type=Service.class , target="many-to-one",search=true , sequence=1)
	protected Service service ;
	
	@Column(name = "QTE" )	
	@Predicate(label="Qte",optional=true,updatable=true,search=true, type=Long.class ,sequence=2)
	protected Long zQte;
	
	@Column(name = "M_HT")	
	@Predicate(label="Montant HT",optional=true,updatable=true,search=true, type=Long.class ,sequence=3, editable=false)
	@Observer(observable="service",source="field:zMnt")
	protected Long zMntHt;
	
	@Column(name = "REMISE" )	
	@Predicate(label="Remise %",optional=true,updatable=true,search=true, type=Long.class ,sequence=4)
	protected Long zremise= new Long(0);
	
	@Column(name = "TVA")	
	@Predicate(label="TVA %",optional=true,updatable=true,search=true, type=Long.class ,sequence=5)
	protected Long ztva = new Long(0);
		
	@Column(name = "TYP_REG")
	@Predicate(label="reglement",optional=false,updatable=true,search=true, target="combobox", values="à la commande;programmé;echeancier" , sequence=6 )
	protected String typePaiment="0";
	
	@Column(name = "TOTAL_TTC" )	
	@Predicate(label="TOTAL TTC",optional=true,search=true, type=Long.class ,sequence=7, editable=false)
	protected Long ztotal= new Long(0);
	
	@Column(name = "MNT_PAYER" )	
	@Predicate(label="Payer ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long mntpayer = new Long(0);
	
	@Column(name = "SOLDE" )	
	@Predicate(label="Solde ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long solde =new Long(0);

	@Column(name = "MNT_PAI_TMP")	
	protected Long zMntTmp =new Long(0);
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	@ManyToOne
	@JoinColumn(name = "INS_ID")
	protected Inscription eleve = new Inscription();

	public FichePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FichePaiement(FichePaiement ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.zQte = ins.zQte;
		this.zMntHt = ins.zMntHt;
		this.typePaiment=ins.typePaiment;
		this.ztotal=ins.ztotal;
		this.zremise=ins.zremise;
		this.ztva=ins.ztva;
		this.service= new Service(ins.service);
		this.mntpayer = ins.mntpayer;
		this.zMntTmp=ins.zMntTmp;
		this.eleve= new Inscription(ins.eleve);
		this.solde=ins.solde;
		this.mntpayer= ins.mntpayer;
	
	}


	public void setTypePaiment(String typePaiment) {
		this.typePaiment = typePaiment;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(FichePaiement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return service.getLibelle()+" /"+eleve.getEleve().getMatricule()+" - "+eleve.getEleve().getNom();
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


	public Long getZtva() {
		return ztva;
	}


	public void setZtva(Long ztva) {
		this.ztva = ztva;
	}


	public Long getZtotal() {
		return ztotal;
	}


	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}


	public Long getZremise() {
		return zremise;
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


	public Long getzMntTmp() {
		return zMntTmp;
	}


	public void setzMntTmp(Long zMntTmp) {
		this.zMntTmp = zMntTmp;
	}


	public void setZremise(Long zremise) {
		this.zremise = zremise;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public String getTypePaiment() {
		return typePaiment;
	}


		
	

}
