/**
 * 
 */
package com.keren.model.missions;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ACTMISRH")
public class ActionMission extends BaseElement implements Serializable, Comparable<ActionMission> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6919606200359046117L;

	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="INDPER_ID")
	@Predicate(label="Indicateur ",type=IndicateurPerformance.class,target="many-to-one",optional=false,search=true)
	private IndicateurPerformance indicateur ;
	
	@Predicate(label="Objectif",optional=false,search=true)
	private String objectif ;
	
	@Predicate(label="Resultat",search=true)
	private String resultat ;
	/**
	 * 
	 */
	public ActionMission() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ActionMission(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param indicateur
	 * @param objectif
	 * @param resultat
	 */

	public ActionMission(long id, String designation, String moduleName, String code, IndicateurPerformance indicateur,
			String objectif, String resultat) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.indicateur = indicateur;
		this.objectif = objectif;
		this.resultat = resultat;
	}
	
	public ActionMission(ActionMission action) {
		super(action.id, action.designation, action.moduleName,action.compareid);
		this.code = action.code;
		this.indicateur = action.indicateur;
		this.objectif = action.objectif;
		this.resultat = action.resultat;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public IndicateurPerformance getIndicateur() {
		return indicateur;
	}

	public void setIndicateur(IndicateurPerformance indicateur) {
		this.indicateur = indicateur;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getResultat() {
		return resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Activite Mission";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Activites Mission";
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
	public int compareTo(ActionMission o) {
		// TODO Auto-generated method stub
		return indicateur.compareTo(o.indicateur);
	}

}
