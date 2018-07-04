/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_evastge")
public class EvaluationStage extends BaseElement implements Serializable, Comparable<EvaluationStage> {
	

	@Column(name = "CRITERE" ,unique=true)	
	@Predicate(label="Critère",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String critere;
	
	@Column(name = "NOTE" )	
	@Predicate(label="Note",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String note;
	
	@ManyToOne
	@JoinColumn(name = "VAL_ID")
	@Predicate(label = "Ref. Validateur", target = "many-to-one", type = Professeur.class, search = true, sequence = 3)
	private Professeur prof;
	
	


	public EvaluationStage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EvaluationStage(EvaluationStage filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.note = filiere.note;
		this.critere=filiere.critere;
		this.prof = new Professeur(filiere.prof);

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
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id+"";
	}


	

	public String getCritere() {
		return critere;
	}


	public void setCritere(String critere) {
		this.critere = critere;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public Professeur getProf() {
		return prof;
	}


	public void setProf(Professeur prof) {
		this.prof = prof;
	}


	public int compareTo(EvaluationStage o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
