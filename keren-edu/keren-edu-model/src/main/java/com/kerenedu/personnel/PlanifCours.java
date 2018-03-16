/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_plcours")
public class PlanifCours extends BaseElement implements Serializable, Comparable<PlanifCours> {
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID", unique=true)
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1	)
	protected Classe classe;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "JOURS_COURS_ID")
	@Predicate(label="jours",group = true,groupName = "tab1",groupLabel = "Journée de cours",target = "one-to-many",type = JoursCours.class,
	search = true)
	private List<JoursCours> jourscours = new ArrayList<JoursCours>();

	


	public PlanifCours() {
		super();
		// TODO Auto-generated constructor stub
	}



	public PlanifCours(Classe classe, List<JoursCours> jourscours, AnneScolaire anneScolaire) {
		super();
		this.classe = classe;
		this.jourscours = jourscours;
		//this.anneScolaire = anneScolaire;
	}

	public PlanifCours(PlanifCours ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.classe =  new Classe(ins.classe);
		this.jourscours = new ArrayList<JoursCours>();
		//this.anneScolaire= new AnneScolaire(ins.anneScolaire);
	
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(PlanifCours o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Plannifier les cours ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Plannifier les cours";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return classe.getDesignation();
	}


//	public AnneScolaire getAnneScolaire() {
//		return anneScolaire;
//	}
//
//
//	public void setAnneScolaire(AnneScolaire anneScolaire) {
//		this.anneScolaire = anneScolaire;
//	}



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



	public List<JoursCours> getJourscours() {
		return jourscours;
	}



	public void setJourscours(List<JoursCours> jourscours) {
		this.jourscours = jourscours;
	}


	

}
