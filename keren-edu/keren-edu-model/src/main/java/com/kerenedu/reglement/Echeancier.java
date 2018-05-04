/**
 * 
 */
package com.kerenedu.reglement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_echeance")
public class Echeancier extends BaseElement implements Serializable, Comparable<Echeancier> {

	@Column(name = "TYP_PLAN")
	@Predicate(label="Type Planiffictaion",optional=false,updatable=true,search=false, target="combobox", values="Automatique;Manuelle" , sequence=1 )
	protected String typePlanif="0";
	
	@ManyToOne
	@JoinColumn(name = "FICHE_PAI_ID")
	@Predicate(label="SERVICE",updatable=true,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=2)
	@Filter(value = "[{\"fieldName\":\"typePaiment\",\"value\":\"echeancier\"}]")
	protected FichePaiement service = new FichePaiement();
	
	
	@Column(name = "TOTAL " )	
	@Predicate(label="MONTANT ECH.",optional=true,search=false, type=Long.class ,sequence=3, editable=false)
	@Observer(observable="service",source="field:ztotal")
	protected Long ztotal= new Long(0);
	
	
	@Column(name = "TOTAL_ECH" )	
	@Predicate(label="MONTANT TOTAL ",optional=true,search=true, type=Long.class ,sequence=4, editable=false)
	protected Long mnttotal= new Long(0);
	
	@Column(name = "DATE_DEBUT")
	//@Predicate(label="Date Début",optional=false,updatable=true,search=true, type=Date.class,sequence=5, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateDeb = new Date();

		
	@Column(name = "PERIODE")
	//@Predicate(label="Période",optional=false,updatable=true,search=false, target="combobox", values="Annuel;Trimestriel;Mensuel" , sequence=6 ,
	//hidden="temporalData.typePlanif=='0'")
	protected String periode="0";
	
	@Column(name = "Nbre_ECH" )	
	@Predicate(label="Nb Echéances ",optional=false,updatable=false,search=true,editable=false, type=Long.class ,sequence=7, hidden="temporalData.typePlanif=='0'")
	protected Long znbreEch = new Long(0);
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "ECH_ID")
	@Predicate(updatable=true,type=EcheancierDlt.class , target="one-to-many",search=true ,group=true, groupLabel="Echeancier Détails", 
	groupName="tab1",edittable=true,hidden="temporalData.typePlanif=='0'")
	protected List<EcheancierDlt> echeancedtl = new ArrayList<EcheancierDlt>();
	
	

	public Echeancier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Echeancier(Echeancier ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.dateDeb = ins.dateDeb;
		this.znbreEch = ins.znbreEch;
		this.periode=ins.periode;
		this.service= new FichePaiement(ins.service);
		this.typePlanif= ins.typePlanif;
		this.periode=ins.periode;
		this.mnttotal=ins.mnttotal;
		this.echeancedtl= new ArrayList<EcheancierDlt>();
	
	}




	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Echeancier o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Echeancier ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Echeancier";
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

	public FichePaiement getService() {
		return service;
	}


	public void setService(FichePaiement service) {
		this.service = service;
	}


	public Date getDateDeb() {
		return dateDeb;
	}


	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}


	public Long getZnbreEch() {
		return znbreEch;
	}


	public void setZnbreEch(Long znbreEch) {
	
		this.znbreEch = znbreEch;
	}


	public String getPeriode() {
		return periode;
	}


	public void setPeriode(String periode) {
		this.periode = periode;
	}


	public List<EcheancierDlt> getEcheancedtl() {
		return echeancedtl;
	}


	public String getTypePlanif() {
		return typePlanif;
	}


	public void setTypePlanif(String typePlanif) {
		this.typePlanif = typePlanif;
	}


	public Long getMnttotal() {
		return mnttotal;
	}


	public void setMnttotal(Long mnttotal) {
		this.mnttotal = mnttotal;
	}


	public Long getZtotal() {
		return ztotal;
	}


	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}


	public void setEcheancedtl(List<EcheancierDlt> echeancedtl) {
		this.echeancedtl = echeancedtl;
	}




		
	

}
