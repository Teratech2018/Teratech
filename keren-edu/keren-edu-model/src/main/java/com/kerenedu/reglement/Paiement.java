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
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_p_paie")
public class Paiement extends BaseElement implements Serializable, Comparable<Paiement> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Column(name="CODE",unique=true)
	@Predicate(label="Num. Pièce de Caisse",optional=false , sequence=1 )
	private String code ;
	
	
	@ManyToOne
	@JoinColumn(name = "F_ID")
	@Predicate(label="SERVICE",updatable=false,type=FichePaiement.class ,optional=false, target="many-to-one",search=true , sequence=2,observable=true)
	//@Filter(value="[{\"fieldName\":\"eleve\",\"value\":\"object.eleve\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner un eleve\"}]")
	protected FichePaiement service ;
	
	
	@Column(name = "DATE_PAI")
	@Predicate(label="DATE PAIEMENT",optional=false,updatable=false,search=true, type=Date.class,sequence=3, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();
	
	@Column(name = "TYP_PAI")
//	@Predicate(label="Type Paiement",optional=false,updatable=false,search=true, target="combobox", values="especes;virement;chèque" , sequence=5 )
	@Predicate(label="Type Paiement",optional=false,updatable=false,search=true, target="combobox", values="especes;Espress Union" , sequence=4 )
	protected String typePaiment="0";
	
	@Column(name = "ZMNT_VERSER" )	
	//@Predicate(label="Montant à Règler ",optional=false,updatable=false,search=true, type=Long.class ,sequence=6,hidden="currentObject.eleve.id==null")
	@Predicate(label="Montant à Règler ",optional=false,updatable=false,search=true, type=Long.class ,sequence=5)
	protected Long zMntverser;
	
	
//	@Transient
//	@ManyToOne
//	@JoinColumn(name="CLASSE_ID")
//	//@Predicate(label="Sélectionner la Classe",type=Classe.class,target="many-to-one",optional=false , sequence=1 )
//	private Classe classe ;
//	
	@ManyToOne
	@JoinColumn(name="ElEVE_ID")
	@Predicate(label="Elève",type=Inscription.class,target="many-to-one",optional=false , sequence=6 ,editable=false )
	//@Filter(value="[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"id\",\"optional\":false,\"message\":\"Veuillez sélectionner la classe\"}]")
	private Inscription eleve ;
	
	@Column(name = "ZMNT" )	
	@Predicate(label="Total Frais",optional=false,updatable=false,search=true, type=Long.class ,sequence=7, editable=false)
	@Observer(observable="service",source="field:ztotal")
	protected Long zMnt;
	
	@Transient
	@Column(name = "ZSOLDE" )	
	@Predicate(label="Solde" ,search=true, type=Long.class ,sequence=8, editable=false)
	@Observer(observable="service",source="field:solde")
	protected Long zsolde;
	
	@Column(name = "TOTAL_A_PAYER" )	
	protected Long totalapayer;
	
	@Column(name = "TOTAL_PAYER" )	
	protected Long totalpayer;
	
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	

	public Paiement() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Paiement(Paiement ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datePaiement = ins.datePaiement;
		this.zMnt = ins.zMnt;
		this.zMntverser = ins.zMntverser;
		this.typePaiment=ins.typePaiment;
		if(ins.service!=null){
			this.service= new FichePaiement(ins.service);	
		}
		this.zsolde=ins.zsolde;
		if(ins.getEleve()!=null){
//			this.classe=new Classe(ins.getEleve().getClasse());
			this.eleve=new Inscription(ins.getEleve());
		}

		
		this.totalapayer=ins.totalapayer;
		this.totalpayer=ins.totalpayer;
		this.code=ins.code;
		this.anneScolaire=ins.anneScolaire;

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


//	public Classe getClasse() {
//		return classe;
//	}
//
//
//	public void setClasse(Classe classe) {
//		this.classe = classe;
//	}


	public Inscription getEleve() {
		return eleve;
	}


	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}


	public Long getTotalapayer() {
		return totalapayer;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public void setTotalapayer(Long totalapayer) {
		this.totalapayer = totalapayer;
	}


	public Long getTotalpayer() {
		return totalpayer;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public void setTotalpayer(Long totalpayer) {
		this.totalpayer = totalpayer;
	}

//
//	@Override
//	public boolean isDesabledelete() {
//		// TODO Auto-generated method stub
//		return true;
//	}

	

		
	

}
