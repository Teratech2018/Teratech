/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;


public class ConsulterSalaire extends BaseElement implements Serializable, Comparable<ConsulterSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	//@Filter(value="[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	@Filter(value="[{\"fieldName\":\"state\",\"operator\":\"!=\",\"value\":\"etabli\"}]")
	private PeriodePaie periode ;
	
	/**
	 * 
	 */
	public ConsulterSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ConsulterSalaire(long id, String designation, String moduleName) {
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
	public ConsulterSalaire(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<Professeur> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		
	}
	
	public ConsulterSalaire(ConsulterSalaire prepa) {
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
		return "Selectionner la période  ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Selectionner la période ";
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
	public int compareTo(ConsulterSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
