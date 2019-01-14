/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_presence")
public class Presence extends BaseElement implements Serializable, Comparable<Presence> {

	
	@Column(name = "DATE_PRS")
	@Predicate(label="DATE ",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datPrs;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=2)
	protected Classe classe;
		
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
	

	

	public Presence() {
		super();

	}


	public Presence(Date datAbs, Classe classe, String hdebut, String hfin, List<Eleve> eleveList, String observation,
			AnneScolaire anneScolaire, TypeAbscence tAbscence) {
		super();
		this.datPrs = datPrs;
		this.classe = classe;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.eleveList = eleveList;
		this.observation = observation;
		this.anneScolaire = new AnneScolaire(anneScolaire);
	}


	public Presence(Presence ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		this.datPrs = ins.datPrs;
		this.hdebut = ins.hdebut;
		this.hfin = ins.hfin;
		this.eleveList = new ArrayList<Eleve>();
		this.observation = ins.observation;
		this.classe = new Classe(ins.classe);
		this.anneScolaire=new AnneScolaire(ins.anneScolaire);
	
	
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

	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	

	public Date getDatPrs() {
		return datPrs;
	}


	public void setDatPrs(Date datPrs) {
		this.datPrs = datPrs;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}
	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return "";
	}
	

	public int compareTo(Presence o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Presences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Presences";
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
