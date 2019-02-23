/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.base.State;
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
	@Predicate(label="Année Scolaire concerné",type=AnneScolaire.class,target="many-to-one",optional=false,search=true, sequence=2)
	private AnneScolaire exercice ;
	
	@Temporal(javax.persistence.TemporalType.DATE)
	@Predicate(label="Date de debut",type=Date.class,target="date",search=true, sequence=3)
	private Date ddebut;
	
	@Temporal(javax.persistence.TemporalType.DATE)
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
		super(entity.id, entity.designation, entity.moduleName,entity.compareid);
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
		return (int) o.getId();
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
		return formatdate(ddebut) +"/"+formatdate(dfin);
	}
	
	private String formatdate(Date date){
		SimpleDateFormat   sdf = new SimpleDateFormat("d-MMMM-YYYY");
		String newdate=sdf.format(date);
	//	System.out.println("PeriodePaie.formatdate() new date "+newdate);
		return newdate;
		
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "etablie");
		states.add(state);
		state = new State("ouvert", "Ouverte");
		states.add(state);
		state = new State("ferme", "Fermée");
		states.add(state);
	
		return states;
	}

	@Override
	public String toString() {
		return "PeriodePaie [code=" + code + ", exercice=" + exercice + ", ddebut=" + ddebut + ", dfin=" + dfin
				+ ", societe=" + societe + ", actif=" + actif + ", state=" + state + "]";
	}

	
	

}
