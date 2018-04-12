/**
 * 
 */
package com.keren.model.recrutement;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_DETRECRH")
public class DetailRecrutement extends BaseElement implements Serializable, Comparable<DetailRecrutement> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3386861521434770874L;
	
	@ManyToOne
	@JoinColumn(name="ETAREC_ID")
	@Predicate(label="Etape Recrutement",type=EtapeRecrutement.class,target="many-to-one")
	private EtapeRecrutement etape ;
	
	@Predicate(label="Appréciation",target="combobox",values="Faible;Moyen;Bon;Excellent;Parfait")
	private String niveau ;
	
	@Predicate(label=".",target="textarea",group=true,groupName="group1",groupLabel="Appréciations")
	private String note;

	/**
	 * 
	 */
	public DetailRecrutement() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DetailRecrutement(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param etape
	 * @param niveau
	 * @param note
	 */

	public DetailRecrutement(long id, String designation, String moduleName, EtapeRecrutement etape, String niveau,
			String note) {
		super(id, designation, moduleName);
		this.etape = etape;
		this.niveau = niveau;
		this.note = note;
	}
	
	public DetailRecrutement(DetailRecrutement detail) {
		super(detail.id, detail.designation, detail.moduleName);
		this.etape = detail.etape;
		this.niveau = detail.niveau;
		this.note = detail.note;
	}
	
	

	public EtapeRecrutement getEtape() {
		return etape;
	}

	public void setEtape(EtapeRecrutement etape) {
		this.etape = etape;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Suivi du Recrutement de ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Suivi des Recrutements ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return etape.getDesignation();
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	

	@Override
	public int compareTo(DetailRecrutement o) {
		// TODO Auto-generated method stub
		return etape.compareTo(o.etape);
	}

}
