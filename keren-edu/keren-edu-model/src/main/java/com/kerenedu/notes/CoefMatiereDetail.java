/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Matiere;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
@Table
@Entity(name = "e_coefmatdtl")
public class CoefMatiereDetail extends BaseElement implements Serializable, Comparable<CoefMatiereDetail> {
	
  
	
	@ManyToOne
    @JoinColumn(name = "MATIERE_ID")
	@Predicate(label="Matiere", target = "many-to-one",type = Matiere.class,search = true, editable=false, sequence=1,colsequence=1)
	private Matiere matiere = new Matiere();
	

	@Column(name = "COEF")
	@Predicate(label = "Coef",type = Long.class,search = true  , sequence=2, colsequence=2)
	private Long coef = new Long(0);
	
		


	public CoefMatiereDetail() {
		super();
	}


	public CoefMatiereDetail(CoefMatiereDetail cmatdetail) {
		super(cmatdetail.id, cmatdetail.designation, cmatdetail.moduleName);
		this.matiere = new Matiere(cmatdetail.matiere);
		this.coef = cmatdetail.coef;

	}

	
	public CoefMatiereDetail(Matiere matiere) {
		this.matiere = new Matiere(matiere);
		this.coef = new Long(0);

	}


	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Coeficient Matiere";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Coeficient Matiere";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return "Coeficient "+matiere.getLibelle();
	}



	public Long getCoef() {
		return coef;
	}


	public void setCoef(Long coef) {
		this.coef = coef;
	}


	public Matiere getMatiere() {
		return matiere;
	}


	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	public int compareTo(CoefMatiereDetail o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
