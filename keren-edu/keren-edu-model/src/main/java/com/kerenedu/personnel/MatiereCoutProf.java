/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Matiere;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_matierecoutprof")
public class MatiereCoutProf extends BaseElement implements Serializable, Comparable<MatiereCoutProf> {
	
	@ManyToOne
	@JoinColumn(name = "MATIERE_ID")
	@Predicate(label="MATIERE",updatable=true,type=Matiere.class , target="many-to-one",search=true , sequence=1	)
	protected Matiere matiere;
	
	@Column(name = "HEURE_TOTAL")
	@Predicate(label="HEURE TOTAL",optional=false,updatable=false,search=true, type=Long.class ,target="time", sequence=2)
	protected Long heuretotal;
	
	@Column(name = "COUT_HEURE")
	@Predicate(label="COUT/HEURE",optional=false,updatable=false,search=true, type=Long.class, target="time", sequence=3)
	protected Long coutheure;


	@ManyToOne
	@JoinColumn(name = "ANNEE_ID")
	protected AnneScolaire anneScolaire;
	


	public MatiereCoutProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MatiereCoutProf(Matiere matiere, Long heuretotal, Long coutheure, AnneScolaire anneScolaire) {
		super();
		this.matiere = matiere;
		this.heuretotal = heuretotal;
		this.coutheure = coutheure;
		this.anneScolaire = anneScolaire;
	}


	public MatiereCoutProf(MatiereCoutProf ins) {
		super(ins.id, ins.designation, ins.moduleName);
		
		this.anneScolaire= new AnneScolaire(ins.anneScolaire);
		this.matiere = new Matiere(ins.matiere);
		this.heuretotal = ins.heuretotal;
		this.coutheure = ins.coutheure;

	
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(MatiereCoutProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Paiements ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Attributions de Matières au Professeur";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return "Matiere";
	}


	public AnneScolaire getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(AnneScolaire anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public Long getHeuretotal() {
		return heuretotal;
	}


	public void setHeuretotal(Long heuretotal) {
		this.heuretotal = heuretotal;
	}


	public Long getCoutheure() {
		return coutheure;
	}


	public void setCoutheure(Long coutheure) {
		this.coutheure = coutheure;
	}

	
	

}
