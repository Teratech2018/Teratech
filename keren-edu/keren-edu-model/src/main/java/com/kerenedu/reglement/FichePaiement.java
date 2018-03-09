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
	@Predicate(label="Montant HT",optional=true,updatable=true,search=true, type=Long.class ,sequence=3)
	protected Long zMntHt;
	
	@Column(name = "REMISE" )	
	@Predicate(label="Remise %",optional=true,updatable=true,search=true, type=Long.class ,sequence=4)
	protected Long zremise= new Long(0);
	
	@Column(name = "TVA")	
	@Predicate(label="TVA %",optional=true,updatable=true,search=true, type=Long.class ,sequence=5)
	protected Long ztva = new Long(0);
		
	@Column(name = "TYP_REG")
	@Predicate(label="reglement",optional=false,updatable=true,search=false, target="combobox", values="a la commande;programmé;echeancier" , sequence=6 )
	protected String typePaiment="0";
	
	@Column(name = "TOTAL_TTC" )	
	@Predicate(label="TOTAL TTC",optional=true,search=true, type=Long.class ,sequence=7, editable=false)
	protected Long ztotal= new Long(0);
	


	
	@Column(name = "MNT_PAI")	
	protected Long zMnt;;

	@Column(name = "MNT_PAI_TMP")	
	protected BigDecimal zMntTmp =BigDecimal.ZERO;
	
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
		this.zMnt=ins.zMnt;
		this.zMntTmp=ins.zMntTmp;
		this.eleve= new Inscription(ins.eleve);
	
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


	public Long getzMnt() {
		return zMnt;
	}


	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}


	public BigDecimal getzMntTmp() {
		return zMntTmp;
	}


	public void setzMntTmp(BigDecimal zMntTmp) {
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
