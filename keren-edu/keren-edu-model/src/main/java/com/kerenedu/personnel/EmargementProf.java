/**
 * 
 */
package com.kerenedu.personnel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Matiere;
import com.kerenedu.notes.NoteDetail;

import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_emarge")
public class EmargementProf extends BaseElement implements Serializable, Comparable<EmargementProf> {
	
	
	//D_EMARG
	@Column(name = "D_EMARG")
	@Predicate(label="DATE EMARGEMENT",optional=false,updatable=true,search=true, type=Date.class,sequence=1, target="date" )
	@Temporal(javax.persistence.TemporalType.DATE)
	protected Date datemarg = new Date();
	
	@ManyToOne
	@JoinColumn(name = "PROF_ID")
	@Predicate(label="PROF.",updatable=true,type=Professeur.class , target="many-to-one",search=true , sequence=1	)
	protected Professeur prof;
	
	@ManyToOne
	@JoinColumn(name = "CLS_ID")
	@Predicate(label="CLASSE",updatable=true,type=Classe.class , target="many-to-one",search=true , sequence=1	)
	protected Classe classe;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EMARG_DLT_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Emargement des cours",target ="one-to-many",type = EmargementProfDetails.class,search = false)
	private List<EmargementProfDetails> emagementdlt = new ArrayList<EmargementProfDetails>();

	@Column(name = "ANNEE_ID")
	protected String anneScolaire=new String();
	


	public EmargementProf() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmargementProf(Classe classe, Professeur prof, Date datemarg, String anneScolaire) {
		super();
		this.classe = classe;
		this.prof = prof;
		this.datemarg = datemarg;
		this.anneScolaire = anneScolaire;
	}


	public EmargementProf(EmargementProf ins) {
		super(ins.id, ins.designation, ins.moduleName);
		this.anneScolaire= ins.anneScolaire;
		this.classe = new Classe(ins.classe);
		this.prof = new Professeur( ins.prof);
		this.datemarg = ins.datemarg;
		this.emagementdlt= new ArrayList<EmargementProfDetails>();
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EmargementProf o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Pointage des Cours ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Pointage des Cours";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return getProf().getNom()+""+getClasse().getLibelle();
	}


	public String getAnneScolaire() {
		return anneScolaire;
	}


	public void setAnneScolaire(String anneScolaire) {
		this.anneScolaire = anneScolaire;
	}


	public Date getDatemarg() {
		return datemarg;
	}


	public void setDatemarg(Date datemarg) {
		this.datemarg = datemarg;
	}


	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	public Classe getClasse() {
		return classe;
	}


	public List<EmargementProfDetails> getEmagementdlt() {
		return emagementdlt;
	}


	public void setEmagementdlt(List<EmargementProfDetails> emagementdlt) {
		this.emagementdlt = emagementdlt;
	}


	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	
	

}
