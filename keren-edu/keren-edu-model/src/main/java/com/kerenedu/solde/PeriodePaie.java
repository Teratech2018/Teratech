/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Etablissement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_ppaie")
public class PeriodePaie extends BaseElement implements Serializable, Comparable<PeriodePaie> {


	@Predicate(label="Reference période",optional=false,search=true , sequence=1)
	private String code ;
			
	@ManyToOne
	@JoinColumn(name="EXE_ID")
	@Predicate(label="Année Scolaire concerné",type=AnneScolaire.class,target="many-to-one",optional=false,
	search=true, sequence=2)
	private AnneScolaire exercice ;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de debut",type=Date.class,target="date",search=true, sequence=3)
	private Date ddebut;
	
	@Temporal(TemporalType.DATE)
	@Predicate(label="Date de fin",type=Date.class,target="date",search=true, sequence=4)
	private Date dfin ;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Dossier de paie",type=Etablissement.class,target="many-to-one",optional=false,search=true,
	sequence=5)
	private Etablissement societe;
	
	@Predicate(label="Actif",type=Boolean.class,editable=false,updatable=false, sequence=6)
	private Boolean actif = Boolean.TRUE;
	
		
    @Predicate(label = "Statut",search = true,hide = true, sequence=7)
	private String state="etabli";

	


	public PeriodePaie(String code, Boolean actif, Etablissement societe, AnneScolaire exercice, Date ddebut, Date dfin,
			String state) {
		super();
		this.code = code;
		this.actif = actif;
		this.societe = societe;
		this.exercice = exercice;
		this.ddebut = ddebut;
		this.dfin = dfin;
		this.state = state;
	}

	

	public PeriodePaie(PeriodePaie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.actif = entity.actif;
		if(entity.societe!=null){
			this.societe = new Etablissement(entity.societe);
		}
		if(entity.exercice!=null){
			this.exercice = new AnneScolaire(entity.exercice);
		}
	
		this.ddebut = entity.ddebut;
		this.dfin = entity.dfin;
		this.state = entity.state;
	}



	public PeriodePaie() {
		// TODO Auto-generated constructor stub
	}



	public int compareTo(PeriodePaie o) {
		// TODO Auto-generated method stub
		return 0;
	}



	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}



	public Boolean getActif() {
		return actif;
	}



	public void setActif(Boolean actif) {
		this.actif = actif;
	}



	public Etablissement getSociete() {
		return societe;
	}



	public void setSociete(Etablissement societe) {
		this.societe = societe;
	}



	public AnneScolaire getExercice() {
		return exercice;
	}



	public void setExercice(AnneScolaire exercice) {
		this.exercice = exercice;
	}



	public Date getDdebut() {
		return ddebut;
	}



	public void setDdebut(Date ddebut) {
		this.ddebut = ddebut;
	}



	public Date getDfin() {
		return dfin;
	}



	public void setDfin(Date dfin) {
		this.dfin = dfin;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Periode de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Periode Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return ddebut +"-"+dfin;
	}


}
