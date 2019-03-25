/**
 * 
 */
package com.kerenedu.model.report;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Cycle;
import com.kerenedu.personnel.ProfesseurChoice;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

public class FichePresenceModal extends BaseElement implements Serializable, Comparable<FichePresenceModal> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609375799032659501L;
	
	@ManyToOne
	@JoinColumn(name = "CYCLE_ID")
	@Predicate(label = "Cycle", type = Cycle.class, target = "many-to-one", optional = true, sequence = 1)
	private Cycle cycle;
	
	@ManyToOne
	@JoinColumn(name = "CLASSE_ID")
	@Predicate(label = "Classe", type = Classe.class, target = "many-to-one", optional = true, sequence = 2)
	private Classe classe;
	


	@Column(name = "LIBELLE")
	//@Predicate(label = "Type", optional = false, updatable = true, search = true, target = "combobox", values = "1ere Trimestre;2éme Trimestre;3éme Trimestre", sequence = 1, colsequence = 1)
	protected String type = "0";

	/**
	 * 
	 */
	public FichePresenceModal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public FichePresenceModal(long id, String designation, String moduleName) {
		super(id, designation, moduleName, 0L);
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
	public FichePresenceModal(long id, String designation, String moduleName, AnneScolaire periode, String porte,
			List<ProfesseurChoice> concernes) {
		super(id, designation, moduleName, 0L);
		// this.annee = periode;
		// this.porte = porte;
		// this.concernes = concernes;

	}

	public FichePresenceModal(FichePresenceModal prepa) {
		super(prepa.id, prepa.designation, prepa.moduleName, prepa.compareid);
		if (prepa.classe != null) {
			this.classe = new Classe(prepa.classe);
		}
		if (prepa.cycle != null) {
			this.cycle = new Cycle(prepa.cycle);
		}
		this.type = prepa.type;

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Critères";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Critères ";
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	// @Override
	public int compareTo(FichePresenceModal o) {
		// TODO Auto-generated method stub
		return (int) id;
	}

}
