/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class PrepaSalaire extends BaseElement implements Serializable, Comparable<PrepaSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	@Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	private PeriodePaie periode ;
	
	@Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
	@ManyToMany
	@Predicate(label="EM",type=Employe.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés",hidden="temporalData.porte=='0' || temporalData.porte==null")
	private List<Employe> concernes = new ArrayList<Employe>();
	
	/**
	 * 
	 */
	public PrepaSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public PrepaSalaire(long id, String designation, String moduleName) {
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
	public PrepaSalaire(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<Employe> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		this.porte = porte;
		this.concernes = concernes;
	}
	
	public PrepaSalaire(PrepaSalaire prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
		this.porte = prepa.porte;
//		this.concernes = concernes;
	}
	
	

	public PeriodePaie getPeriode() {
		return periode;
	}

	public void setPeriode(PeriodePaie periode) {
		this.periode = periode;
	}

	public String getPorte() {
		return porte;
	}

	public void setPorte(String porte) {
		this.porte = porte;
	}

	public List<Employe> getConcernes() {
		return concernes;
	}

	public void setConcernes(List<Employe> concernes) {
		this.concernes = concernes;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Préparation  de la Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Préparation  de la Paie";
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
	public int compareTo(PrepaSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
