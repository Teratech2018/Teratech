/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.tools.EnmJoursCours;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_jcours")
public class JoursCours extends BaseElement implements Serializable, Comparable<JoursCours> {
	
	@Column(name = "JOURS")
	@Predicate(label="JOURS",optional=false,updatable=true,search=true , sequence=1, editable=false)
	protected String journne ;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "TRANCHE_COURS_ID")
	@Predicate(label="tranche", group = true,groupName = "tab1",groupLabel = "Tranche Horaire de cours",target ="one-to-many",type = TrancheHoraireCours.class,search = true)
	private List<TrancheHoraireCours> tranchehorairecours = new ArrayList<TrancheHoraireCours>();

//	@ManyToOne
//	@JoinColumn(name = "ANNEE_ID")
//	protected AnneScolaire anneScolaire;
//	


	public JoursCours() {
		super();
		// TODO Auto-generated constructor stub
	}



	public JoursCours(String journne, List<TrancheHoraireCours> tranchehorairecours) {
		super();
		this.journne = journne;
		this.tranchehorairecours = tranchehorairecours;
	//	this.anneScolaire = new AnneScolaire(anneScolaire);
	}



	public JoursCours(JoursCours ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.journne = ins.journne;
		this.tranchehorairecours = new ArrayList<TrancheHoraireCours>();
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
	
	}
	
	public JoursCours(EnmJoursCours ins, List<TrancheHoraireCours> tranchehoraire) {
		this.journne = ins.name();
		this.tranchehorairecours =tranchehoraire ;
	//	this.anneScolaire= new AnneScolaire(ins.anneScolaire);
	
	}
	


	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(JoursCours o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Journée de  ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Journée de ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return journne;
	}


	
	public String getJournne() {
		return journne;
	}






	public void setJournne(String journne) {
		this.journne = journne;
	}






	public List<TrancheHoraireCours> getTranchehorairecours() {
		return tranchehorairecours;
	}






	public void setTranchehorairecours(List<TrancheHoraireCours> tranchehorairecours) {
		this.tranchehorairecours = tranchehorairecours;
	}





    

	
	

}
