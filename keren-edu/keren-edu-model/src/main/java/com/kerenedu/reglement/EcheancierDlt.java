/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_p_ech_dlt")
public class EcheancierDlt extends BaseElement implements Serializable, Comparable<EcheancierDlt> {

	@Column(name = "DATE_ECH")
	@Predicate(label="Date Echéance",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateEch ;
	
	@Column(name = "MNT" )	
	@Predicate(label="Montant ",optional=false,updatable=false,search=true, type=Long.class ,sequence=2)
	protected Long mnt;
	
	@Column(name = "MNT_PAYER" )	
	//@Predicate(label="Payer ",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long mntpayer = new Long(0);
	
	@Column(name = "SOLDE" )	
	//@Predicate(label="Solde ",optional=false,updatable=false,search=true, type=Long.class ,sequence=4)
	protected Long solde =new Long(0);
	
	@Predicate(label="ETAT ",optional=false,updatable=false,search=true, type=String.class ,sequence=5)
	@Column(name = "ETAT" )	
	private String state="etabli" ;
	
	// id fiche paiement concerné (service)
	@Column(name = "ID_PAIE")
	protected Long idPaie;
	
	

	
	

	public EcheancierDlt() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EcheancierDlt(EcheancierDlt ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.dateEch = ins.dateEch;
		this.mnt = ins.mnt;
		this.mntpayer = ins.mntpayer;
		this.solde = (ins.mnt-ins.mntpayer);
		this.idPaie= ins.idPaie;
		this.state=ins.state;
		
	
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
		return id +"";
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


	public Long getIdPaie() {
		return idPaie;
	}


	public void setIdPaie(Long idPaie) {
		this.idPaie = idPaie;
	}


	public void setMnt(Long mnt) {
		this.mnt = mnt;
	}


	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Encours");
		states.add(state);
		state = new State("Payer", "Payé");
		states.add(state);
		return states;
	}
		
	

}
