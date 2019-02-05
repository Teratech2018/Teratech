/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Classe;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.Examen;
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class EdtMasseSalModal extends BaseElement implements Serializable, Comparable<EdtMasseSalModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	

	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=true)
	@Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	private PeriodePaie periode ;

	
	/**
	 * 
	 */
	public EdtMasseSalModal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EdtMasseSalModal(long id, String designation, String moduleName) {
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
	public EdtMasseSalModal(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<ProfesseurChoice> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
	
	}
	
	public EdtMasseSalModal(EdtMasseSalModal prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
	
	}
	
	

	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}


	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Masse Salariale";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Masse Salariale";
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
	public int compareTo(EdtMasseSalModal o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
