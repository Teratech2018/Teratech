/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.core.tools.DateHelper;
import com.core.tools.EnmHeureCours;
import com.kerenedu.configuration.Classe;
import com.kerenedu.notes.CoefMatiereDetail;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_th_cours")
public class TrancheHoraireCours extends BaseElement implements Serializable, Comparable<TrancheHoraireCours> {
	
		
	@Column(name = "HEURE_DEBUT")
	@Predicate(label="HEURE DEBUT (Ex:6:30)",optional=false,updatable=true,search=true,   sequence=2, target="time", type=String.class)
	protected String heuredebut;
	
	@Column(name = "HEURE_FIN")
	@Predicate(label="HEURE FIN (Ex:7:30)",optional=false,updatable=true,search=true,  sequence=4,  target="time" ,type=String.class)
	protected String heurefin;
	
	@Column(name = "ZNHT")
	@Predicate(label="Total Heure",updatable=false,search=true,  sequence=4, type=Double.class, editable=false)
	protected Double heuretotal;

//	@ManyToOne
//	@JoinColumn(name="CLASSE_ID")
//	@Predicate(label="CLASSE.",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1,hide=true	 , pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
//	private Classe classe ;
	
	@ManyToOne
	@JoinColumn(name = "MAT_ID")
	@Predicate(label="MATIERE",updatable=true,type=CoefMatiereDetail.class , target="many-to-one",search=true , sequence=1, optional=false	)
//	@Filter(value="[{\"fieldName\":\"classe\",\"value\":\"object.classe\",\"searchfield\":\"code\"}]")
	protected CoefMatiereDetail matiere ;
	

//	@ManyToOne
//	@JoinColumn(name = "PROF_ID")
//	//@Predicate(label="MATIERE.",updatable=true,type=Matiere.class , target="many-to-one",search=true , sequence=1	)
//	protected Professeur prof;
	
	


//	@ManyToOne
//	@JoinColumn(name = "ANNEE_ID")
//	protected AnneScolaire anneScolaire;
	


	public TrancheHoraireCours() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TrancheHoraireCours(CoefMatiereDetail matiere,String heuredebut, String heurefin, Double heuretotal,Classe classe) {
		super();
		this.heuredebut = heuredebut;
		this.heuretotal = heuretotal;
		this.heurefin = heurefin;
//		this.classe=classe;
		//this.anneScolaire = anneScolaire;
		
		this.matiere=matiere;
	}


	public TrancheHoraireCours(TrancheHoraireCours ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		if(ins.matiere!=null){
		  this.matiere= new CoefMatiereDetail(ins.matiere);
		}
//		if(ins.classe!=null){
//			  this.classe= new Classe(ins.classe);
//			}

		this.heurefin = ins.heurefin;
		this.heuredebut = ins.heuredebut;
		this.heuretotal = ins.heuretotal;
	
	}

	public TrancheHoraireCours(PlanifCours jc, EnmHeureCours ins) {		
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.heurefin = ins.getHfin();
		this.heuredebut =ins.getHdeb();
		this.heuretotal =DateHelper.hours(heuredebut,heurefin, new Date());
//		this.classe=jc.getClasse();
	
	}
	
	public TrancheHoraireCours(EnmHeureCours ins) {		
		//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
			this.heurefin = ins.getHfin();
			this.heuredebut =ins.getHdeb();		
		}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(TrancheHoraireCours o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Tranche Horaire ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Tranche Horaire ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return heuredebut+"-"+heurefin;
	}


	public String getHeuredebut() {
		return heuredebut;
	}


	public void setHeuredebut(String heuredebut) {
		this.heuredebut = heuredebut;
	}


	public String getHeurefin() {
		return heurefin;
	}


	public Double getHeuretotal() {
		return heuretotal;
	}


	public void setHeuretotal(Double heuretotal) {
		this.heuretotal = heuretotal;
	}


	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}


	public CoefMatiereDetail getMatiere() {
		return matiere;
	}



	public void setMatiere(CoefMatiereDetail matiere) {
		this.matiere = matiere;
	}


//	public Classe getClasse() {
//		return classe;
//	}
//
//
//	public void setClasse(Classe classe) {
//		this.classe = classe;
//	}



	
	

}
