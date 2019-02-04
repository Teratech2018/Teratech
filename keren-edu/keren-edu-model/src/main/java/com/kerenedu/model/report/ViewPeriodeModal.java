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
import com.kerenedu.personnel.ProfesseurChoice;
import com.kerenedu.solde.PeriodePaie;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class ViewPeriodeModal extends BaseElement implements Serializable, Comparable<ViewPeriodeModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	@Filter(value = "[{\"fieldName\":\"state\",\"value\":\"ouvert\"}]")
	private PeriodePaie periode ;
	
	//@Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
	@ManyToMany
	//@Predicate(label="EM",type=ProfesseurChoice.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés",hidden="temporalData.porte!='1'")
	private List<ProfesseurChoice> concernes = new ArrayList<ProfesseurChoice>();
	
	@Column(name = "TypeReport")
	@Predicate(label = "TypeReport",updatable = true, search = false, target = "combobox", values = "docb;doccaisse;p", hide=true)
	protected String typereport = "0";
	
	@Predicate(label="Type de rubrique",target="combobox",values="Gain;Retenue",search=true, sequence=3,optional=true, hide=true)
	private String type ="0";
	
	/**
	 * 
	 */
	public ViewPeriodeModal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ViewPeriodeModal(long id, String designation, String moduleName) {
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
	public ViewPeriodeModal(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<ProfesseurChoice> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		this.porte = porte;
		this.concernes = concernes;
		
	}
	
	public ViewPeriodeModal(ViewPeriodeModal prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
		this.porte = prepa.porte;
		this.concernes = new ArrayList<ProfesseurChoice>();
		this.typereport=prepa.typereport;
		this.type=prepa.type;
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

	public List<ProfesseurChoice> getConcernes() {
		return concernes;
	}

	public void setConcernes(List<ProfesseurChoice> concernes) {
		this.concernes = concernes;
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
	public int compareTo(ViewPeriodeModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTypereport() {
		return typereport;
	}

	public void setTypereport(String typereport) {
		this.typereport = typereport;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
