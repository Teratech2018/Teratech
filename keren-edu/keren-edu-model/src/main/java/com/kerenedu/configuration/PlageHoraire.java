/**
 * 
 */
package com.kerenedu.configuration;

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
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Matiere;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_phoraire")
public class PlageHoraire extends BaseElement implements Serializable, Comparable<PlageHoraire> {
	
		
	@Column(name = "JOURS_DEB")
	@Predicate(label="JOURS DEBUT",optional=false,updatable=true,search=true, target="combobox", values="Lundi;Mardi;Mercredi;Jeudi;Vendredi;Samedi;Dimanche" , sequence=1)
	protected String jdeb="0";
	
	@Column(name = "JOURS_FIN")
	@Predicate(label="JOURS FIN",optional=false,updatable=true,search=true, target="combobox", values="Lundi;Mardi;Mercredi;Jeudi;Vendredi;Samedi;Dimanche" , sequence=1)
	protected String jfin="0";
	
	@Column(name = "HD")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE DEBUT (Ex:6:30)",optional=false,updatable=true,search=true, type=String.class , sequence=2 , pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heuredebut;
	
	@Column(name = "HF")
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="HEURE FIN (Ex:7:30)",optional=false,updatable=true,search=true, type=String.class, sequence=3, pattern="([01]?[0-9]|2[0-3]):[0-5][0-9]")
	protected String heurefin;


	public PlageHoraire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PlageHoraire(Matiere matiere,String heuredebut, String heurefin, String jfin, String jdeb) {
		super();
		this.heuredebut = heuredebut;
		this.heurefin = heurefin;
		this.jdeb = jdeb;
		this.jfin = jfin;
	}


	public PlageHoraire(PlageHoraire ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		
		this.heurefin = ins.heurefin;
		this.heuredebut = ins.heuredebut;
		this.jdeb = ins.jdeb;
		this.jfin = ins.jfin;

	
	
	}

	

	public String getJdeb() {
		return jdeb;
	}


	public void setJdeb(String jdeb) {
		this.jdeb = jdeb;
	}


	public String getJfin() {
		return jfin;
	}


	public void setJfin(String jfin) {
		this.jfin = jfin;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(PlageHoraire o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Plage Horaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Plage Horaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return heuredebut+""+heurefin;
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




	public void setHeurefin(String heurefin) {
		this.heurefin = heurefin;
	}



	
	

}
