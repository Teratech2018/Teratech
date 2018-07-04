/**
 * 
 */
package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author WOPA
 *
 */
public class LivrePaie extends BaseElement implements Serializable, Comparable<LivrePaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	@Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	private PeriodePaie periode ;
	
	@Predicate(label="Model ?",target="combobox",values="Détaillé;Synthèse",optional=true)
	private String model ="0";
	
	
	/**
	 * 
	 */
	public LivrePaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LivrePaie(long id, String designation, String moduleName) {
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
	public LivrePaie(long id, String designation, String moduleName, PeriodePaie periode, String model,
			List<Employe> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		this.model = model;
	}
	
	public LivrePaie(LivrePaie prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}//end if(prepa.periode!=null){
		this.model = prepa.model;
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
		return "Impression du Livre de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Impression du Livre de Paie";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
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
	public int compareTo(LivrePaie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
