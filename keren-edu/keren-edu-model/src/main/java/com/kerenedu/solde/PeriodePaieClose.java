/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class PeriodePaieClose extends BaseElement implements Serializable, Comparable<PeriodePaieClose> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4484568491154630939L;
	
	@ManyToOne
	@Predicate(label="Periode de paie",type=PeriodePaie.class,target="many-to-one",optional=true)
	private PeriodePaie periode;

	/**
	 * 
	 */
	public PeriodePaieClose() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PeriodePaieClose(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
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
		return "Fermer une Periode";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Fermer une Periode de paie";
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
	@Override
	public int compareTo(PeriodePaieClose o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
