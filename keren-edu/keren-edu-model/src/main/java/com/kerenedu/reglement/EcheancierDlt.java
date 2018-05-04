/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_ech_dlt")
public class EcheancierDlt extends BaseElement implements Serializable, Comparable<EcheancierDlt> {

	@Column(name = "DATE_ECH")
	@Predicate(label="Date Echéance",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateEch = new Date();
	
	@Column(name = "MNT" )	
	@Predicate(label="Montant ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long mnt;
	
	@Column(name = "MNT_PAYER" )	
	@Predicate(label="Payer ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long mntpayer = new Long(0);
	
	@Column(name = "SOLDE" )	
	@Predicate(label="Solde ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long solde =new Long(0);;
	
	@ManyToOne
	@JoinColumn(name = "FICHE_PAI_ID")
	protected FichePaiement fiche = new FichePaiement();
	
	

	
	

	public EcheancierDlt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EcheancierDlt(EcheancierDlt ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.dateEch = ins.dateEch;
		this.mnt = ins.mnt;
		this.mntpayer = ins.mntpayer;
		this.solde = (ins.mnt-ins.mntpayer);
		if(ins.fiche!=null){
			this.fiche= new FichePaiement(ins.fiche);
		}
		
	
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EcheancierDlt o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Echeancier détails ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Echeancier détails";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return fiche.getService().getDesignation()+"/"+mnt;
	}


	public Date getDateEch() {
		return dateEch;
	}




	public void setDateEch(Date dateEch) {
		this.dateEch = dateEch;
	}


	public Long getMnt() {
		return mnt;
	}


	public FichePaiement getFiche() {
		return fiche;
	}


	public void setFiche(FichePaiement fiche) {
		this.fiche = fiche;
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


	public void setMnt(Long mnt) {
		this.mnt = mnt;
	}


	

		
	

}
