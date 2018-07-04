/**
 * 
 */
package com.kerenedu.stages;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_tachestge")
public class TacheStage extends BaseElement implements Serializable, Comparable<TacheStage> {
	

	@Column(name = "CODE" ,unique=true)	
	@Predicate(label="CODE",optional=false,updatable=false,search=true , sequence=1, colsequence=1)
	protected String code;
	
	@Column(name = "DIFFICULTE" )	
	@Predicate(label="Difficultés Rencontrées",optional=false,updatable=true,search=true , sequence=2, colsequence=2)
	protected String difficultes;
	
	@Column(name = "PROPOSITIONS" )	
	@Predicate(label="Propositions d'améliorations",optional=false,updatable=true,search=true , sequence=3, colsequence=2)
	protected String propositions;
	
	


	public TacheStage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TacheStage(TacheStage filiere) {
		super(filiere.id, filiere.designation, filiere.moduleName,0L);
		this.difficultes = filiere.difficultes;
		this.code=filiere.code;
		this.propositions = filiere.propositions;

	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}




	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Tâches";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Tâches";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	public String getDifficultes() {
		return difficultes;
	}


	public void setDifficultes(String difficultes) {
		this.difficultes = difficultes;
	}


	public String getPropositions() {
		return propositions;
	}


	public void setPropositions(String propositions) {
		this.propositions = propositions;
	}


	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}


	

	public int compareTo(TacheStage o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
