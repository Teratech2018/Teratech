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
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_p_ech")
public class Echeancier extends BaseElement implements Serializable, Comparable<Echeancier> {


	@Transient
	@ManyToOne
	@JoinColumn(name="CLASSE_ID")
	@Predicate(label="Sélectionner la Classe",type=Classe.class,target="many-to-one",optional=false , sequence=1 )
	private Classe classe ;
	
	@Transient
	@ManyToOne
	@JoinColumn(name="ElEVE_ID")
	@Predicate(label="Sélectionner la Eléve",type=Inscription.class,target="many-to-one",optional=false , sequence=2 )
	@Filter(value="[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner la classe\"}]")
	private Inscription eleve ;
	
	@Column(name = "TYP_PLAN")
	@Predicate(label="Type Planiffictaion",optional=false,updatable=true,search=false, target="combobox", values="Automatique;Manuelle" , sequence=3  )
	protected String typePlanif="0";
	
	@Column(name = "DATE_DEBUT")
	@Predicate(label="Date Début",optional=false,updatable=true,search=true, type=Date.class,sequence=4, target="date" ,	hidden="currentObject.typePlanif=='1'")
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date dateDeb ;

		
	@Column(name = "Nombre Echéance")
	@Predicate(label="Durée" , optional=false, updatable=true,search=false, type=Long.class, sequence=5 ,hidden="currentObject.typePlanif=='1'")
	protected Long periode ;       
	
	@ManyToOne
	@JoinColumn(name = "FICHE_PAI_ID")
	@Predicate(label="SERVICE",updatable=true,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=7,hidden="currentObject.eleve.id==null",observable=true)
	@Filter(value = "[{\"fieldName\":\"eleve\",\"value\":\"object.eleve\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner un eleve\"}]")
	protected FichePaiement service ;
	
	@Column(name = "TOTAL " )	
	@Predicate(label="TOTAL ECH.",optional=true,search=false, type=Long.class ,sequence=8, editable=false,hidden="currentObject.eleve.id==null")
	@Observer(observable="service",source="field:ztotal")
	protected Long ztotal ;
	
	
	@Column(name = "TOTAL_ECH" )	
	@Predicate(label="TOTAL PAYER ",optional=true,search=true, type=Long.class ,sequence=9, editable=false,hidden="currentObject.eleve.id==null")
	protected Long mnttotal;

	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "ECH_ID")
	@Predicate(updatable=true,type=EcheancierDlt.class , target="one-to-many",search=true ,group=true, groupLabel="Echeancier Détails", groupName="tab1",edittable=true,hidden="currentObject.eleve.id==null")
	@Observer(observable="service",source="method:generateecheance",parameters="periode,dateDeb,typePlanif")
	protected List<EcheancierDlt> echeancedtl = new ArrayList<EcheancierDlt>();
	
	

	public Echeancier() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Echeancier(Echeancier ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.dateDeb = ins.dateDeb;
		this.periode=ins.periode;
		this.service= new FichePaiement(ins.service);
		this.typePlanif= ins.typePlanif;
		this.periode=ins.periode;
		this.mnttotal=ins.mnttotal;
		this.echeancedtl= new ArrayList<EcheancierDlt>();
//		this.classe=new Classe(ins.getService().getEleve().getClasse());
//		this.eleve=new Inscription(ins.getService().getEleve());
	
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


	public Long getPeriode() {
		return periode;
	}


	public void setPeriode(Long periode) {
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


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public void setZtotal(Long ztotal) {
		this.ztotal = ztotal;
	}


	public void setEcheancedtl(List<EcheancierDlt> echeancedtl) {
		this.echeancedtl = echeancedtl;
	}




		
	

}
