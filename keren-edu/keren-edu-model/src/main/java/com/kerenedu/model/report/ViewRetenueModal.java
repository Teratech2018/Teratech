/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.solde.PeriodePaie;
import com.kerenedu.solde.RubriquePaie;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class ViewRetenueModal extends BaseElement implements Serializable, Comparable<ViewRetenueModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période ",type=AnneScolaire.class,target="many-to-one",optional=true, sequence=1)
	private AnneScolaire annee ;
	
	@ManyToOne
	@JoinColumn(name="RUB_ID")
	@Predicate(label="Retenue ",type=RubriquePaie.class,target="many-to-one",optional=false, sequence=2)
	@Filter(value = "[{\"fieldName\":\"type\",\"value\":\"1\"}]")
	private RubriquePaie rubrique ;

	
	/**
	 * 
	 */
	public ViewRetenueModal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ViewRetenueModal(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param periode
	 * @param porte
	 * @param concernes
	 */
	public ViewRetenueModal(long id, String designation, String moduleName, AnneScolaire periode, String porte,
			List<ProfesseurChoice> concernes) {
		super(id, designation, moduleName,0L);
		this.annee = periode;
		//this.porte = porte;
		//this.concernes = concernes;
		
	}
	
	public ViewRetenueModal(ViewRetenueModal prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.annee!=null){
			this.annee = new AnneScolaire(prepa.annee);
		}
		
		if(prepa.rubrique!=null){
			this.rubrique = new RubriquePaie(prepa.rubrique);
		}
	
	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "  Critères";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Critères ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
//	@Override
	public int compareTo(ViewRetenueModal o) {
		// TODO Auto-generated method stub
		return (int) id;
	}

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public AnneScolaire getAnnee() {
		return annee;
	}

	public void setAnnee(AnneScolaire annee) {
		this.annee = annee;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}



	

}
