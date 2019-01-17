/**
 * 
 */
package com.kerenedu.notes;

import java.io.Serializable;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
public class StatistiqueNotes extends BaseElement implements Serializable, Comparable<StatistiqueNotes> {

	//@Predicate(label="Reference",optional=false,search=true, sequence=1)
	private String code ;
	
	@Predicate(label="Description",optional=false,search=true, sequence=2)
	private String label ;
	
	
	
	
	public StatistiqueNotes(String code, String label) {
		super();
		this.code = code;
		this.label = label;
	}

	public StatistiqueNotes(StatistiqueNotes entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.label = "Encours d'implementation .......";
		
	}





	public StatistiqueNotes() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}




	public void setCode(String code) {
		this.code = code;
	}




	public String getLabel() {
		return label;
	}




	public void setLabel(String label) {
		this.label = label;
	}

	public int compareTo(StatistiqueNotes o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Statistiques";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Statistiques";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"-"+label;
	}
}
