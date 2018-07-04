/**
 * 
 */
package com.keren.model.stages;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_EVASTARH")
public class EvaluationStage extends BaseElement implements Serializable, Comparable<EvaluationStage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324753306872872990L;
	
	@Predicate(label="Critère",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Note",type=Double.class,search=true)	
	private Double note =0.0 ;
	
	@Predicate(label="Validateur",target="many-to-one",type=Employe.class,optional=false,search=true)
	@ManyToOne
	@JoinColumn(name="EMPL_ID")
	private Employe validateur;

	/**
	 * 
	 */
	public EvaluationStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public EvaluationStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param diff
	 * @param propo
	 */

	public EvaluationStage(long id, String designation, String moduleName, String code, Double diff, String propo) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.note = diff;
		
	}
	
	public EvaluationStage(EvaluationStage tache) {
		super(tache.id, tache.designation, tache.moduleName,tache.compareid);
		this.code = tache.code;
		this.note = tache.note;
		if(tache.validateur!=null){
			this.validateur = new Employe(tache.validateur);
		}
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

		

	public Double getNote() {
		return note;
	}

	public void setNote(Double note) {
		this.note = note;
	}

	public Employe getValidateur() {
		return validateur;
	}

	public void setValidateur(Employe validateur) {
		this.validateur = validateur;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Evaluation du Stage";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Evaluation du Stage";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(EvaluationStage o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
