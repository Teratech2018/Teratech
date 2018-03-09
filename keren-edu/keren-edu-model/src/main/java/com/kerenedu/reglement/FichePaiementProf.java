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
import com.core.tools.EnmMois;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_fpaie_prof")
public class FichePaiementProf extends BaseElement implements Serializable, Comparable<FichePaiementProf> {

	@Column(name = "MOIS")
	@Predicate(label="Mois",updatable=true,search=true , sequence=1, target="combobox", values="JANVIER;FEVIER;MARS")
	protected String mois ;
	
	@Column(name = "NHPLANIF" )	
	@Predicate(label="TOTAL HEURE PLANIF.",optional=true,updatable=true,search=true, type=Long.class ,sequence=2)
	protected Long tplanif;
	
	@Column(name = "NHEMARGE")	
	@Predicate(label="TOTAL HEURE EMARGER.",optional=true,updatable=true,search=true, type=Long.class ,sequence=3)
	protected Long temarge;

	@Column(name = "COUT_TOTAL" )	
	@Predicate(label="COUT TOTAL",optional=true,search=true, type=Long.class ,sequence=7, editable=false)
	protected Long ctotal= new Long(0);
	
	@Column(name = "PRIME" )	
	@Predicate(label="Total Prime",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zprime;
	
	@Column(name = "RETENU" )	
	@Predicate(label="Total Retenue",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zretenu;
	
	@Column(name = "AVANCE" )	
	@Predicate(label="Total Avance",updatable=false,search=true, type=Long.class ,sequence=4,editable=false)
	protected Long zavance;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	
	@ManyToOne
	@JoinColumn(name = "P_ID")
	protected Professeur prof = new Professeur();

	public FichePaiementProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FichePaiementProf(FichePaiementProf ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.mois = ins.mois;
		this.tplanif = ins.tplanif;
		this.temarge=ins.temarge;
		this.ctotal=ins.ctotal;
		this.zprime=ins.zprime;
		this.zretenu=ins.zretenu;
		this.zavance=ins.zavance;
		this.anneScolaire=ins.anneScolaire;
		this.prof= new Professeur(ins.prof);
	
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(FichePaiementProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements Professeur ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Fiche de Paiements Professeur";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return getMois()+" "+prof.getNom();
	}


	public String getMois() {
		return mois;
	}


	public void setMois(String mois) {
		this.mois = mois;
	}


	public Long getTplanif() {
		return tplanif;
	}


	public void setTplanif(Long tplanif) {
		this.tplanif = tplanif;
	}


	public Long getTemarge() {
		return temarge;
	}


	public void setTemarge(Long temarge) {
		this.temarge = temarge;
	}


	public Long getCtotal() {
		return ctotal;
	}


	public void setCtotal(Long ctotal) {
		this.ctotal = ctotal;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Professeur getProf() {
		return prof;
	}


	public Long getZprime() {
		return zprime;
	}


	public void setZprime(Long zprime) {
		this.zprime = zprime;
	}


	public Long getZretenu() {
		return zretenu;
	}


	public void setZretenu(Long zretenu) {
		this.zretenu = zretenu;
	}


	public Long getZavance() {
		return zavance;
	}


	public void setZavance(Long zavance) {
		this.zavance = zavance;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	

}
