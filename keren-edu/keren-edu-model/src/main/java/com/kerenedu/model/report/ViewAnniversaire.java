/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_v_anniv")
public class ViewAnniversaire extends BaseElement implements Serializable, Comparable<ViewAnniversaire> {

		
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label="Classe",updatable=true,type=Classe.class , target="many-to-one",search=true,searchfields="libelle" )
	protected Classe classe ;
	
	@Transient
	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	@Predicate(label="Elève",updatable=true,type=Eleve.class , target="many-to-one",search=true,searchfields="matricule"	)
	protected Eleve eleve ;
	
	
	@Transient
	@Column(name = "DATE_INS")
	@Predicate(label="Date Anniversaire",optional=false,updatable=true,search=true, type=Date.class,target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datIns ;
	
	@Transient
	@Predicate(label="Lieu Naissance",optional=false,updatable=true,search=true, sequence=4)
	protected String lieu ;
	
	@Transient
	@Predicate(label="Mois",optional=false,updatable=true,search=true, sequence=5)
	protected String Mois ;
	
	@Transient
	@Column(name = "CYCLE_ID")
	protected long cycle ;
	

	@Column(name = "ANNEE_ID")
	protected String anneScolaire ;
	

	
	


	public ViewAnniversaire() {
		// TODO Auto-generated constructor stub
	}


	public ViewAnniversaire(ViewAnniversaire ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(ins.eleve!=null){
			this.eleve = new Eleve(ins.eleve);
			this.datIns=ins.getEleve().getDateNais();
			this.Mois=DateHelper.getMonthName(ins.getEleve().getDateNais());
			this.lieu=ins.getEleve().getlNais();
		}
		if(ins.classe!=null){
			this.classe = new Classe(ins.classe);
			this.cycle=ins.classe.getCycle();
		}
	
		
	}
	

	public ViewAnniversaire(Inscription ins) {
		this.id=ins.getId();
		this.designation=ins.getDesignation();
		this.eleve = new Eleve(ins.getEleve());
		this.classe = new Classe(ins.getClasse());
		this.datIns=ins.getEleve().getDateNais();
		this.Mois=DateHelper.getMonthName(ins.getEleve().getDateNais());
		this.lieu=ins.getEleve().getlNais();
		this.anneScolaire=ins.getAnneScolaire();
		
	}




//	public void setServiceList(Service serviceList) {
//		this.serviceList = serviceList;
//	}


	public Eleve getEleve() {
		return eleve;
	}


	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}


	public Classe getClasse() {
		return classe;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}


	

	public Date getDatIns() {
		return datIns;
	}


	public void setDatIns(Date datIns) {
		this.datIns = datIns;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public String getMois() {
		return Mois;
	}


	public void setMois(String mois) {
		Mois = mois;
	}


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(ViewAnniversaire o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Anniversaires";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Anniversaires";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return eleve.getMatricule()+"-"+eleve.getNom();
	}
	



	public long getCycle() {
		return cycle;
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public void setCycle(long cycle) {
		this.cycle = cycle;
	}



	


}
