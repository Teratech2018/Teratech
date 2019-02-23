/**
 * 
 */
package com.kerenedu.discipline;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.kerenedu.inscription.Inscription;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_abs_lgn")
public class LigneAbscence extends BaseElement implements Serializable, Comparable<LigneAbscence> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4678610081093002369L;

	@ManyToOne
	@JoinColumn(name = "ELEVE_ID")
	//@Predicate(label = "Elève", updatable = false, type = Inscription.class, target = "many-to-one", search = true, sequence = 1)
	protected Inscription eleve;
	
	@Column(name = "MATRICULE")
	//@Predicate(label = "MATRICULE", optional = true, updatable = false, search = true, type = String.class, sequence=1)
	protected String matricule;
	
	
	@Column(name = "NOM")
	@Predicate(label = "NOM", optional = true, updatable = true, search = true, type = String.class,  sequence=2)
	protected String nom;

	@Column(name = "HD")
//	@Predicate(label = "HEURE DEBUT(Ex:7:30)", optional = false, updatable = false, search = true, sequence = 2, target = "time")
	protected String hdebut;

	@Column(name = "HF")
	//@Predicate(label = "HEURE FIN (Ex:6:30)", optional = false, updatable = false, search = true, sequence = 3, target = "time")
	protected String hfin;
	
	@Column(name = "ABSJUST")
	@Predicate(label = "Absence Just.(H)", updatable = true, search = true, sequence = 3, type = Double.class, editable = true)
	protected Double absjust=(double) 0;
	
	@Column(name = "ABSNJUST")
	@Predicate(label = "Absence Non Just.(H)", updatable = true, search = true, sequence = 4, type = Double.class, editable = true)
	protected Double absnonjust=(double) 0;
		
	@Column(name = "CONSIGNE")
	@Predicate(label = "Consignes.(H)", updatable = true, search = true, sequence = 7, type = Double.class, editable = true)
	protected Double consigne=(double) 0;
	
	@Column(name = "EXCLUSIONS")
	@Predicate(label = "Exclusions.(J)", updatable = true, search = true, sequence = 8, type = Double.class, editable = true)
	protected Double exclusion=(double) 0;
	
	@Column(name = "RETARD")
	@Predicate(label = "Exclusions.(J)", updatable = true, search = true, sequence = 9, type = Double.class, editable = true)
	protected Double retard=(double) 0;
	
	@Predicate(label = "Avertissement Conduite", type = Boolean.class, search = true , sequence =5)
	private Boolean avertconduite = Boolean.FALSE;
	
	@Predicate(label = "Blame Conduite", type = Boolean.class, search = true, sequence = 6)
	private Boolean balmeconduite = Boolean.FALSE;
	
	@Predicate(label = "Conseil Descipline", type = Boolean.class, search = true, sequence = 10)
	private Boolean consiel = Boolean.FALSE;
	
//	@Predicate(label = "Retard", type = Boolean.class, search = true, sequence = 10)
//	private Boolean retard = Boolean.FALSE;

	@Column(name = "HTOTAL")
	//@Predicate(label = "Total Heure", updatable = false, search = true, sequence = 4, type = Double.class, editable = false)
	protected Double heuretotal;

	

	//@Predicate(label = "Absent", type = Boolean.class, search = true)
	private Boolean absent = Boolean.FALSE;

//	@Predicate(label = "Absent Justifié", type = Boolean.class, search = true)
	private Boolean absencepaye = Boolean.FALSE;

	public LigneAbscence() {
		
	}


	
	
	public LigneAbscence(Inscription eleve, String hdebut, String hfin, Double absjust, Double absnonjust,
			Boolean avertconduite, Boolean balmeconduite, Double consigne, Double exclusion, Boolean consiel,
			Double retard, Double heuretotal, Boolean absent, Boolean absencepaye) {
		super();
		this.eleve = eleve;
		this.hdebut = hdebut;
		this.hfin = hfin;
		this.absjust = absjust;
		this.absnonjust = absnonjust;
		this.avertconduite = avertconduite;
		this.balmeconduite = balmeconduite;
		this.consigne = consigne;
		this.exclusion = exclusion;
		this.consiel = consiel;
		this.retard = retard;
		this.heuretotal = heuretotal;
		this.absent = absent;
		this.absencepaye = absencepaye;
		
	}




	public LigneAbscence(LigneAbscence ins) {
		super(ins.id, ins.designation, ins.moduleName, ins.compareid);
		if (ins.eleve != null) {
			this.eleve = new Inscription(ins.getEleve());
		
		}
		this.hdebut = ins.hdebut;
		this.hfin = ins.hfin;
		this.retard = ins.retard;
		this.absent = ins.absent;
		this.absencepaye = ins.absencepaye;
		this.heuretotal=ins.getHeuretotal();
		this.absjust = ins.absjust;
		this.absnonjust = ins.absnonjust;
		this.avertconduite = ins.avertconduite;
		this.balmeconduite = ins.balmeconduite;
		this.consigne = ins.consigne;
		this.exclusion = ins.exclusion;
		this.consiel = ins.consiel;
		this.matricule = ins.matricule;
		this.nom=ins.nom;
	

	}
	
	public LigneAbscence(Inscription ins) {
		this.eleve = new Inscription(ins);
		this.matricule = ins.getEleve().getMatricule();
		this.nom=ins.getNom();
		this.absjust = (double) 0;
		this.absnonjust =(double) 0;
		this.consigne =(double) 0;
		this.exclusion =(double) 0;
		//this.hdebut = "00:00";
		//this.hfin = "00:00";
		

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

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gérer des Abscences";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gérer des Abscences";
	}

	public Inscription getEleve() {
		return eleve;
	}

	public void setEleve(Inscription eleve) {
		this.eleve = eleve;
	}

	public Double getHeuretotal() {
		return heuretotal;
	}

	public void setHeuretotal(Double heuretotal) {
		this.heuretotal = heuretotal;
	}

	

	public Boolean getAbsent() {
		return absent;
	}

	public void setAbsent(Boolean absent) {
		this.absent = absent;
	}

	public Boolean getAbsencepaye() {
		return absencepaye;
	}

	public Double getAbsjust() {
		return absjust;
	}

	public void setAbsjust(Double absjust) {
		this.absjust = absjust;
	}

	public Double getAbsnonjust() {
		return absnonjust;
	}

	public void setAbsnonjust(Double absnonjust) {
		this.absnonjust = absnonjust;
	}

	public Boolean getAvertconduite() {
		return avertconduite;
	}

	public void setAvertconduite(Boolean avertconduite) {
		this.avertconduite = avertconduite;
	}

	public Boolean getBalmeconduite() {
		return balmeconduite;
	}

	public void setBalmeconduite(Boolean balmeconduite) {
		this.balmeconduite = balmeconduite;
	}

	public Double getConsigne() {
		return consigne;
	}

	public void setConsigne(Double consigne) {
		this.consigne = consigne;
	}

	public Double getExclusion() {
		return exclusion;
	}

	public void setExclusion(Double exclusion) {
		this.exclusion = exclusion;
	}

	public Boolean getConsiel() {
		return consiel;
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




	public void setConsiel(Boolean consiel) {
		this.consiel = consiel;
	}

	@Override
	public boolean isDesabledelete() {
		// TODO Auto-generated method stub
		return true;
	}




	public Double getRetard() {
		return retard;
	}




	public void setRetard(Double retard) {
		this.retard = retard;
	}




	public void setAbsencepaye(Boolean absencepaye) {
		this.absencepaye = absencepaye;
	}



	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return this.id + "";
	}

	@Override
	public String getSearchkeys() {
		// TODO Auto-generated method stub
		return matricule+","+nom;
	}
	

	public int compareTo(LigneAbscence o) {
		// TODO Auto-generated method stub
		return (int)o.getId();
	}


}
