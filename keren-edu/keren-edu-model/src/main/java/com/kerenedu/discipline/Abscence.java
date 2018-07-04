/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
import java.sql.Time;
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
import javax.persistence.*;


import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_abscence")
public class Abscence extends BaseElement implements Serializable, Comparable<Abscence> {

	
	@Column(name = "DATE_ABS")
	@Predicate(label="DATE ABSCENCE",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datAbs;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=2)
	protected Classe classe;
	
	@ManyToOne
	@JoinColumn(name = "TYPE_ABS_ID")
	@Predicate(label="TYPE ABSCENCE",updatable=true,type=TypeAbscence.class , target="many-to-one",search=true , sequence=3)
	protected TypeAbscence tAbscence;
	
	@Column(name = "HD")
	//@Temporal(TemporalType.TIME)
	@Predicate(label="HEURE DEBUT(Ex:7:30)",optional=false,updatable=false,search=true, type=Date.class,sequence=5, pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String hdebut;
	
	@Column(name = "HF")
	//@Temporal(TemporalType.TIME)
	@Predicate(label="HEURE FIN (Ex:6:30)",optional=false,updatable=false,search=true, type=Date.class, sequence=4, pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]" )
	protected String hfin;

	@ManyToMany(fetch = FetchType.LAZY )
    @JoinColumn(name ="ELEVE_ID")
	@Predicate(label = "ETUDIANTS CONCERNES",group = true,groupName = "tab1",groupLabel = "ETUDIANTS CONCERNES",target = "many-to-many-list",
	type = Eleve.class,search = false, sequence=6)
	private List<Eleve> eleveList = new ArrayList<Eleve>();
	
	@Column(name = "OBS")
	@Predicate(group = true, groupName = "tab2", groupLabel = "Observation", target = "textarea", search = false, sequence=7)
	protected String observation;
	
	@ManyToOne
	@JoinColumn(name = "ANNEE_ID")
	protected AnneScolaire anneScolaire;
	

	

	public Abscence() {
		super();

	}


	public Abscence(Date datAbs, Classe classe, String hdebut, String hfin, List<Eleve> eleveList, String observation,
			AnneScolaire anneScolaire, TypeAbscence tAbscence) {
		super();
		this.datAbs = datAbs;
		this.classe = classe;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.eleveList = eleveList;
		this.observation = observation;
		this.anneScolaire = new AnneScolaire(anneScolaire);
		this.tAbscence=new TypeAbscence(tAbscence) ;
	}


	public Abscence(Abscence ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datAbs = ins.datAbs;
		this.hdebut = ins.hdebut;
		this.hfin = ins.hfin;
		this.eleveList = new ArrayList<Eleve>();
		this.observation = ins.observation;
		this.classe = new Classe(ins.classe);
		this.anneScolaire=new AnneScolaire(ins.anneScolaire);
		this.tAbscence= new TypeAbscence(ins.tAbscence);
	
	
	}


	public Date getDatAbs() {
		return datAbs;
	}


	public void setDatAbs(Date datAbs) {
		this.datAbs = datAbs;
	}


	public String getHdebut() {
		return hdebut;
	}


	public void setHdebut(String hdebut) {
		this.hdebut = hdebut;
	}


	public String getHfin() {
		return hfin;
	}


	public void setHfin(String hfin) {
		this.hfin = hfin;
	}


	public List<Eleve> getEleveList() {
		return eleveList;
	}


	public void setEleveList(List<Eleve> eleveList) {
		this.eleveList = eleveList;
	}


	public String getObservation() {
		return observation;
	}


	public void setObservation(String observation) {
		this.observation = observation;
	}


	public Classe getClasse() {
		return classe;
	}


	public TypeAbscence gettAbscence() {
		return tAbscence;
	}


	public void settAbscence(TypeAbscence tAbscence) {
		this.tAbscence = tAbscence;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Abscence o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Abscences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Abscences";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return this.id+"";
	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	
	

}
