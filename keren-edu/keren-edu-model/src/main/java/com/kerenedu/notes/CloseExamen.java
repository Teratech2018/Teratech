/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */
public class CloseExamen extends BaseElement implements Serializable, Comparable<CloseExamen> {

	@ManyToOne
	@JoinColumn(name = "SEQ_ID")
	@Predicate(label = "Sequence", updatable = true, type = Examen.class, target = "many-to-one", sequence = 1)
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"etabli\"}]")
	protected Examen examen;

	public CloseExamen() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CloseExamen(CloseExamen filiere) {

	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Cloturer les Saisies des notes ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Cloturer les Saisies des notes";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		return "";
	}

	public int compareTo(CloseExamen o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

}
