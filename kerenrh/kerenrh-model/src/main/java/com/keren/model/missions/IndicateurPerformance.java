/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_INDPERFRH")
public class IndicateurPerformance extends BaseElement implements Serializable, Comparable<IndicateurPerformance> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7599030349300226646L;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Type d'indicateur",target="combobox",values="Quantité;Pourcent;Autre")
	private String type = "0";

	/**
	 * 
	 */
	public IndicateurPerformance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public IndicateurPerformance(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param type
	 */

	public IndicateurPerformance(long id, String designation, String moduleName, String code, String type) {
		super(id, designation, moduleName);
		this.code = code;
		this.type = type;
	}
	
	public IndicateurPerformance(IndicateurPerformance indicateur) {
		super(indicateur.id, indicateur.designation, indicateur.moduleName);
		this.code = indicateur.code;
		this.type = indicateur.type;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Indicateur de performance";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Indicateurs de performance";
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
	public int compareTo(IndicateurPerformance o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
