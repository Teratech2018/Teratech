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
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.core.tools.DateHelper;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.SectionE;
import com.kerenedu.notes.HelpProfClasse;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_emarge_periode")
public class EmargementPeriode extends BaseElement implements Serializable, Comparable<EmargementPeriode> {
	
	
	//D_EMARG
	
	@ManyToOne
	@JoinColumn(name="PERIODE_ID")
	@Predicate(label="Periode",type=PeriodePaie.class,target="many-to-one",optional=true, sequence=1, observable=true)
	private PeriodePaie periode ;
	
		
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "EMARG_DLT_ID")
	@Predicate(group = true,groupName = "tab1",groupLabel = "Emargement des cours",target ="one-to-many",type = EmargementDtlPeriode.class,search = false, edittable=true)
	@Observer(observable="periode",source="method:findmatiereprof",parameters="classe,datemarg,prof")
	private List<EmargementDtlPeriode> emagementdlt = new ArrayList<EmargementDtlPeriode>();
	


	public EmargementPeriode() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmargementPeriode(Classe classe, Professeur prof, Date datemarg, String anneScolaire) {
		super();
	}


	public EmargementPeriode(EmargementPeriode ins) {
		super(ins.id, ins.designation, ins.moduleName,0L);
		if(this.periode!=null){
		this.periode= new PeriodePaie(ins.getPeriode());
		}
		this.emagementdlt= new ArrayList<EmargementDtlPeriode>();
	}

	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(EmargementPeriode o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Emargement des Cours ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Emargement des Cours";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}



	@Override
	public String getDesignation() {
//		 TODO Auto-generated method stub
		return "" ;
	}


	public PeriodePaie getPeriode() {
		return periode;
	}


	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}


	public List<EmargementDtlPeriode> getEmagementdlt() {
		return emagementdlt;
	}


	public void setEmagementdlt(List<EmargementDtlPeriode> emagementdlt) {
		this.emagementdlt = emagementdlt;
	}



	
	

}
