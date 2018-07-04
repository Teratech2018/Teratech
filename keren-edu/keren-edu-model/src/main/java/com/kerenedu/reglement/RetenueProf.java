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
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_retenue_prof")
public class RetenueProf extends BaseElement implements Serializable, Comparable<RetenueProf> {

	
	@ManyToOne
	@JoinColumn(name = "FM_ID")
	@Predicate(label="Mois",updatable=true,type=FichePaiementProf.class ,optional=false, target="many-to-one",search=true , sequence=3)
	protected FichePaiementProf ficheprof = new FichePaiementProf();

	@Column(name = "ZMNT" )	
	@Predicate(label="Montant Retenu",optional=false,updatable=false,search=true, type=Long.class ,sequence=4)
	protected Long zMnt;
		
	@Column(name = "OBS")
	@Predicate(label="Observation",optional=false,updatable=true,search=false, target="areatext", sequence=5 )
	protected String obs;
	
	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	

	public RetenueProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RetenueProf(RetenueProf ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.obs = ins.obs;
		this.zMnt=ins.zMnt;
		this.ficheprof= new FichePaiementProf(ins.ficheprof);
		this.zMnt=ins.zMnt;
	
	}




	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(PrimeProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Retenue ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Retenue";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}


	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}


	
	public FichePaiementProf getFicheprof() {
		return ficheprof;
	}


	public void setFicheprof(FichePaiementProf ficheprof) {
		this.ficheprof = ficheprof;
	}


	public Long getzMnt() {
		return zMnt;
	}


	public void setzMnt(Long zMnt) {
		this.zMnt = zMnt;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public String getObs() {
		return obs;
	}


	public void setObs(String obs) {
		this.obs = obs;
	}


	public int compareTo(RetenueProf o) {
		// TODO Auto-generated method stub
		return 0;
	}


		
	
}
