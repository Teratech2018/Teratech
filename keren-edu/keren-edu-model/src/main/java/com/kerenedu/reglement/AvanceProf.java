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
@Entity(name = "e_avance_prof")
public class AvanceProf extends BaseElement implements Serializable, Comparable<AvanceProf> {

	
	@Column(name = "CODE" )	
	@Predicate(label="Numero du Document",optional=false,updatable=false,search=true, type=Long.class ,sequence=1)
	protected String code;
	
	@Column(name = "DATE_PAI")
	@Predicate(label="DATE PAIEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=2, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datePaiement = new Date();
	
	@ManyToOne
	@JoinColumn(name = "FM_ID")
	@Predicate(label="Mois",updatable=true,type=FichePaiementProf.class ,optional=false, target="many-to-one",search=true , sequence=3)
	protected FichePaiementProf ficheprof = new FichePaiementProf();

	@Column(name = "ZMNT" )	
	@Predicate(label="Montant Paiement",optional=false,updatable=false,search=true, type=Long.class ,sequence=4)
	protected Long avance;
		
	@Column(name = "TYP_PAI")
	@Predicate(label="Mode Paiement",optional=false,updatable=true,search=false, target="combobox", values="especes;virement;chèque" , sequence=5 )
	protected String typePaiment="0";
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	

	public AvanceProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AvanceProf(AvanceProf ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.code = ins.code;
		this.datePaiement = ins.datePaiement;
		this.typePaiment=ins.typePaiment;
		this.avance=ins.avance;
		this.ficheprof= new FichePaiementProf(ins.ficheprof);
		this.typePaiment=ins.typePaiment;
	
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

	public int compareTo(AvanceProf o) {
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


	public String getTypePaiment() {
		return typePaiment;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public Date getDatePaiement() {
		return datePaiement;
	}


	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}


	public FichePaiementProf getFicheprof() {
		return ficheprof;
	}


	public void setFicheprof(FichePaiementProf ficheprof) {
		this.ficheprof = ficheprof;
	}



	public Long getAvance() {
		return avance;
	}


	public void setAvance(Long avance) {
		this.avance = avance;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


		
	

}
