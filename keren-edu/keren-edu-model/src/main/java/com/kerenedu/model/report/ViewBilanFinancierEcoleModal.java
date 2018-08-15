/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.math.BigDecimal;
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.school.Eleve;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 */

public class ViewBilanFinancierEcoleModal extends BaseElement implements Serializable, Comparable<ViewBilanFinancierEcoleModal> {


	@Column(name = "CYCLE")
	@Predicate(label="Cycle",optional=false,updatable=true,search=true, target="combobox", values="Maternelle;Primare;Secondaire;Tous" , sequence=11)
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

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Bilan Financier Global";
	}

	
//
//	@Override
//	public boolean isDesabledelete() {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
