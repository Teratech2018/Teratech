/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class PeriodePaieOpen extends BaseElement implements Serializable, Comparable<PeriodePaieOpen> {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4582658654096478767L;
	@ManyToOne
	@Predicate(label="Periode de paie",type=PeriodePaie.class,target="many-to-one",optional=true)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	private PeriodePaie periode;

	/**
	 * 
	 */
	public PeriodePaieOpen() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PeriodePaieOpen(long id, String designation, String moduleName) {
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
		return "Ouvrir une Periode de paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ouvrir Periode";
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
	//@Override
	public int compareTo(PeriodePaieOpen o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
