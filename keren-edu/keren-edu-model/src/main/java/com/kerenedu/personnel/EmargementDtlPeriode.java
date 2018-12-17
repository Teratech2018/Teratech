/**
 * 
 */
package com.kerenedu.personnel;

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
import com.core.tools.DateHelper;
import com.kerenedu.configuration.MatiereDlt;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_emarge_dlt_periode")
public class EmargementDtlPeriode extends BaseElement implements Serializable, Comparable<EmargementDtlPeriode> {
	

	
	@Column(name = "MAT", unique = true)
	@Predicate(label = "Matricule", optional = true, updatable = true, search = true, sequence = 1,editable=false)
	protected String matricule;

	@Column(name = "NOM", unique = true)
	@Predicate(label = "NOM", optional = false, updatable = true, search = true, sequence = 2)
	protected String nom;
	
	@ManyToOne
	@JoinColumn(name = "P_ID")
	//@Predicate(label="Professeur",updatable=false,type=ProfesseurChoice.class , target="many-to-one",search=true , sequence=1	,colsequence=1)
	protected EnseignantSecondaire prof;

	
	@Column(name = "HTEMARG")
	@Predicate(label="Total Heure",updatable=false,search=true,  sequence=5, type=Double.class, editable=false,colsequence=5)
	protected Double heuretotal;
	
	@Column(name = "STATUT")
	@Predicate(label="Statut",type=Boolean.class,search=true,colsequence=6)
	private Boolean statut = Boolean.FALSE;
	
	@ManyToOne
	@JoinColumn(name="PERIODE_ID")
	private PeriodePaie periode ;

	public EmargementDtlPeriode() {
		super();
		// TODO Auto-generated constructor stub
	}





	

	public EmargementDtlPeriode(EnseignantSecondaire prof, Double heuretotal, Boolean statut) {
		super();
		this.prof = prof;
		this.heuretotal = heuretotal;
		this.statut = statut;
		
	}




	public EmargementDtlPeriode(EmargementDtlPeriode entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		if(entity.prof!=null){
		this.prof = new EnseignantSecondaire(entity.prof) ;
		this.matricule=entity.matricule;
		this.nom=entity.nom;
		}
		if(this.periode!=null){
			this.periode= new PeriodePaie(entity.getPeriode());
			}
		this.heuretotal = entity.heuretotal;
		this.statut = entity.statut;
		
	}





	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EmargementDtlPeriode o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des cours";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Emargements des cours";
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



	public Boolean getStatut() {
		return statut;
	}


	public void setStatut(Boolean statut) {
		this.statut = statut;
	}



	public EnseignantSecondaire getProf() {
		return prof;
	}







	public void setProf(EnseignantSecondaire prof) {
		this.prof = prof;
	}







	public Double getHeuretotal() {
		return heuretotal;
	}




	public void setHeuretotal(Double heuretotal) {
		this.heuretotal = heuretotal;
	}







	public String getMatricule() {
		return matricule;
	}







	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}







	public String getNom() {
		return nom;
	}







	public void setNom(String nom) {
		this.nom = nom;
	}







	public PeriodePaie getPeriode() {
		return periode;
	}







	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}



}
