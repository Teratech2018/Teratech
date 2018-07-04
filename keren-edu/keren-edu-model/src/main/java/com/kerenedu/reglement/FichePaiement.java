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
@Entity(name = "e_p_fiche")
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
	protected Long zremise ;
	
	@Column(name = "RISTOURNE")	
	@Predicate(label="RISTOURNE",optional=true,updatable=true,search=true, type=Long.class ,sequence=5)
	protected Long zristourne = new Long(0);
		
//	@Column(name = "TYP_REG")
//	@Predicate(label="reglement",optional=false,updatable=true,search=true, target="combobox", values="à la commande;programmé;echeancier" , sequence=6 )
//	protected String typePaiment="0";
	
	@Column(name = "TOTAL_TTC" )	
	@Predicate(label="TOTAL TTC",optional=true,search=true, type=Long.class ,sequence=6, editable=false)
	protected Long ztotal ;
	
	@Column(name = "MNT_PAYER" )	
	@Predicate(label="Payer ",optional=false,updatable=false,search=true, type=Long.class ,sequence=7, editable=false)
	protected Long mntpayer ;
	
	@Column(name = "SOLDE" )	
	@Predicate(label="Solde ",optional=false,updatable=false,search=true, type=Long.class ,sequence=8, editable=false)
	protected Long solde ;

	@Column(name = "MNT_PAI_TMP")	
	protected Long zMntTmp ;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	protected boolean payer =false;
	

	public FichePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FichePaiement(FichePaiement ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.zQte = ins.zQte;
		this.zMntHt = ins.zMntHt;
		this.zristourne=ins.zristourne;
		this.ztotal=ins.ztotal;
		this.zremise=ins.zremise;
		if(ins.service!=null){
		this.service= new Service(ins.service);
		}
		this.mntpayer = ins.mntpayer;
		this.zMntTmp=ins.zMntTmp;
		this.solde=ins.solde;
		this.mntpayer= ins.mntpayer;
		this.payer=ins.payer;
	
	
	}

	public FichePaiement(Service ins) {
		this.service= new Service(ins);
		this.zQte=new Long(1);
		this.zMntHt=ins.getzMnt().longValue();
		this.ztotal=ins.getzMnt().longValue();
		this.zremise=(long) 0;
		this.zristourne=(long) 0;
		this.mntpayer =(long) 0;
		this.solde=ztotal-mntpayer;
	
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




	public Long getZristourne() {
		return zristourne;
	}


	public void setZristourne(Long zristourne) {
		this.zristourne = zristourne;
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


	public boolean isPayer() {
		return payer;
	}


	public void setPayer(boolean payer) {
		this.payer = payer;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	@Override
	public boolean isDesabledelete() {
		return true;
	}


		
	

}
