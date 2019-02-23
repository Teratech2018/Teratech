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
import com.kerenedu.solde.PrepaSalaire;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Observer;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class EdtPeriodeModal extends BaseElement implements Serializable, Comparable<EdtPeriodeModal> {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	@ManyToOne
	@JoinColumn(name="PERI_ID")
	@Predicate(label="Période concernée",type=PeriodePaie.class,target="many-to-one",optional=false)
	@Filter(value="[{\"fieldName\":\"state\",\"operator\":\"!=\",\"value\":\"etabli\"}]")
	private PeriodePaie periode ;
	
	@Predicate(label="Concerne ?",target="combobox",values="Tous les employés;Seulement les employés selectionnés",optional=false)
	private String porte ="0";
	
	@ManyToMany
	@Predicate(label="EM",type=ProfesseurChoice.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Liste des Employés",hidden="temporalData.porte!='1'")
	private List<ProfesseurChoice> concernes = new ArrayList<ProfesseurChoice>();
	
	/**
	 * 
	 */
	public EdtPeriodeModal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EdtPeriodeModal(long id, String designation, String moduleName) {
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
	public EdtPeriodeModal(long id, String designation, String moduleName, PeriodePaie periode, String porte,
			List<ProfesseurChoice> concernes) {
		super(id, designation, moduleName,0L);
		this.periode = periode;
		this.porte = porte;
		this.concernes = concernes;
	}
	
	public EdtPeriodeModal(EdtPeriodeModal prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName,prepa.compareid);
		if(prepa.periode!=null){
			this.periode = new PeriodePaie(prepa.periode);
		}
		this.porte = prepa.porte;
		this.concernes = new ArrayList<ProfesseurChoice>();
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
	public int compareTo(EdtPeriodeModal o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
