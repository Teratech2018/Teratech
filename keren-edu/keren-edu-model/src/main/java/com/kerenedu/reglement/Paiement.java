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

@Table
@Entity(name = "e_paie")
public class Paiement extends BaseElement implements Serializable, Comparable<Paiement> {

	@Column(name = "DATE_PAI")
	@Predicate(label="DATE PAIEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();
	
	@ManyToOne
	@JoinColumn(name = "F_ID")
	@Predicate(label="SERVICE",updatable=true,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=2)
	protected FichePaiement service = new FichePaiement();

	@Column(name = "ZMNT" )	
	@Predicate(label="Montant HT",optional=false,updatable=false,search=true, type=Long.class ,sequence=3)
	protected Long zMnt;
	
	
	@Column(name = "TYP_PAI")
	@Predicate(label="Typpe Paiement",optional=false,updatable=true,search=false, target="combobox", values="especes;virement;chèque" , sequence=4 )
	protected String typePaiment="0";
	
	

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Paiement(Paiement ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.datePaiement = ins.datePaiement;
		this.zMnt = ins.zMnt;
		this.typePaiment=ins.typePaiment;
		this.service= new FichePaiement(ins.service);
	
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

	public int compareTo(Paiement o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Paiements ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Paiements";
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


	


	public String getTypePaiment() {
		return typePaiment;
	}


	public Date getDatePaiement() {
		return datePaiement;
	}


	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}


	public FichePaiement getService() {
		return service;
	}


	public void setService(FichePaiement service) {
		this.service = service;
	}


	public Long getzMnt() {
		return zMnt;
	}


	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}


		
	

}
