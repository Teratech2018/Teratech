/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_paie")
public class ConsultationPaie extends BaseElement implements Serializable, Comparable<ConsultationPaie> {

	@Column(name = "DATE_PAI")
	@Predicate(label="DATE PAIEMENT",optional=false,updatable=false,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();
	
	@Column(name = "TYP_PAI")
	@Predicate(label="Type Paiement",optional=false,updatable=false,search=true, target="combobox", values="especes;virement;chèque" , sequence=2 )
	protected String typePaiment="0";
	
	@ManyToOne
	@JoinColumn(name = "F_ID")
	@Predicate(label="SERVICE",updatable=false,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=3)
	protected FichePaiement service = new FichePaiement();
	
//	@ManyToOne
//	@JoinColumn(name = "ECH_ID")
//	@Predicate(label="Echeance de Paiement",updatable=false,type=EcheancierDlt.class ,optional=false, target="many-to-one",search=true ,sequence=4)
//	@Filter(value="[{\"fieldName\":\"fiche\",\"value\":\"object.service\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner un service\"}]")
//	protected EcheancierDlt echeancedlt ;


	@Column(name = "ZMNT" )	
//	@Predicate(label="Montant Total",optional=false,updatable=false,search=true, type=Long.class ,sequence=5, editable=false)
//	@Observer(observable="service",source="field:ztotal")
	protected Long zMnt;
	
	@Transient
	@Column(name = "ZSOLDE" )	
//	@Predicate(label="RESTE A PAYER",optional=false,updatable=false,search=true, type=Long.class ,sequence=5, editable=false)
//	@Observer(observable="service",source="field:solde")
	protected Long zsolde;
	
	@Column(name = "ZMNT_VERSER" )	
	@Predicate(label="Regler ",optional=false,updatable=false,search=true, type=Long.class ,sequence=6)
	protected Long zMntverser;
	
	
	
	
	

	public ConsultationPaie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ConsultationPaie(ConsultationPaie ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datePaiement = ins.datePaiement;
		this.zMnt = ins.zMnt;
		this.zMntverser = ins.zMntverser;
		this.typePaiment=ins.typePaiment;
		if(ins.service!=null){
			this.service= new FichePaiement(ins.service);	
		}
		this.zsolde=ins.zsolde;
//		if(ins.echeancedlt!=null){
//			this.echeancedlt= new EcheancierDlt(ins.echeancedlt);
//		}
		
	
	}
	
	

	public ConsultationPaie(Paiement ins) {
		this.datePaiement = ins.datePaiement;
		this.zMnt = ins.zMnt;
		this.zMntverser = ins.zMntverser;
		this.typePaiment=ins.typePaiment;
		if(ins.service!=null){
			this.service= new FichePaiement(ins.service);	
		}
		this.zsolde=ins.zsolde;
	
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

	public int compareTo(ConsultationPaie o) {
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
		return  service.getService().getDesignation();
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

//
//	public EcheancierDlt getEcheancedlt() {
//		return echeancedlt;
//	}
//
//
//	public void setEcheancedlt(EcheancierDlt echeancedlt) {
//		this.echeancedlt = echeancedlt;
//	}


	public Long getzMntverser() {
		return zMntverser;
	}


	public void setzMntverser(Long zMntverser) {
		this.zMntverser = zMntverser;
	}


	public Long getZsolde() {
		return zsolde;
	}


	public void setZsolde(Long zsolde) {
		this.zsolde = zsolde;
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
		
	

}
