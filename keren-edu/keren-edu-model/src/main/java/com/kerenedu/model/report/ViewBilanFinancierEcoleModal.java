/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

public class ViewBilanFinancierEcoleModal extends BaseElement implements Serializable, Comparable<ViewBilanFinancierEcoleModal> {


	
	@ManyToOne
	@JoinColumn(name = "ANNEE")
	@Predicate(label = "Annee Scolaire", type = AnneScolaire.class, target = "many-to-one", optional = true, sequence = 1)
	private AnneScolaire annee;
	
	@Column(name = "CYCLE")
	@Predicate(label="Cycle",optional=false,updatable=true,search=true, target="combobox", values="Maternelle;Primaire;Secondaire;Tous" , sequence=2)
	protected String typecycle="0";
	
	public ViewBilanFinancierEcoleModal() {
		// TODO Auto-generated constructor stub
	}

	public ViewBilanFinancierEcoleModal(Classe classe, Long zInscription, Long zInscriptionEnc, Long tranche1,
			Long tranche1Enc, Long tranche2, Long tranche2Enc, Long tranche3, Long tranche3Enc, Long remise,
			Long ristourne, Long zTotalA, Long zTotalR, Long zSolde) {
		super();
		
	}

	public ViewBilanFinancierEcoleModal(ViewBilanFinancierEcoleModal ins) {
		super(ins.id, ins.designation, ins.moduleName, 0L);
		this.typecycle=ins.typecycle;
		if(ins.annee!=null){
			this.annee= new AnneScolaire(ins.annee);
		}
	}

	public int compareTo(ViewBilanFinancierEcoleModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTypecycle() {
		return typecycle;
	}

	public void setTypecycle(String typecycle) {
		this.typecycle = typecycle;
	}

	public AnneScolaire getAnnee() {
		return annee;
	}

	public void setAnnee(AnneScolaire annee) {
		this.annee = annee;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Bilan Financier Global";
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers Global";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Bilan Financiers Global";
	}

	
//
//	@Override
//	public boolean isDesabledelete() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
