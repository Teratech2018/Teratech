/**
 * 
 */
package com.keren.kerenpaie.model.rapports;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author WOPA
 *
 */
public class BPaie extends BaseElement implements Serializable, Comparable<BPaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4083876520606273661L;

	//

	
    
    @ManyToOne
    @JoinColumn(name = "PERIODE_ID")
    @Predicate(label = "Periode:",type = PeriodePaie.class,target = "many-to-one",optional=false)
    @Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
    private PeriodePaie periode ;
    
    @Transient
    @Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
    
	@Column(name = "MATRICULE")
	@Predicate(label = "Matricule:",type = String.class, search=true,
	hidden="temporalData.porte=='0'||temporalData.periode==null||temporalData.periode.id=='load'")
    private String matricule ;
	
	
	
	/**
	 * 
	 */
	public BPaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BPaie(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
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
	public BPaie(long id, String designation, String moduleName, PeriodePaie periode, String model,
			List<Employe> concernes) {
		super(id, designation, moduleName);
		this.periode = periode;
		this.porte = model;
	}
	
	public BPaie(BPaie prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
		this.porte = prepa.porte;
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

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Impression du Bulletin de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Impression du Bulletin de Paie";
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
	public int compareTo(BPaie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}

	

}
