/**
 * 
 */
package com.keren.kerenpaie.model.structures;

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
@Table(name="T_PLANP")
public class Planification extends BaseElement implements Serializable, Comparable<Planification> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5991012280225727402L;

	@Predicate(label="JOUR",target = "combobox",values = "Lundi;Mardi;Mercredi;Jeudi;Vendredi;Samedi;Dimanche",optional=false,search=true)
	private String code;
	
	@Predicate(label="Est Ouvert?",type=Boolean.class,optional=false,search=true)
	private Boolean ouvert = Boolean.FALSE;
	
	@Predicate(label="Numbres Heures de travail",type=Double.class,optional=false,search=true)
	private Double heures = 0.0;
	/**
	 * 
	 */
	public Planification() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Planification(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	public Planification(long id, String designation, String moduleName, Boolean ouvert, Double heures) {
		super(id, designation, moduleName,0L);
		this.ouvert = ouvert;
		this.heures = heures;
	}
	
	public Planification(String jour, Boolean ouvert, Double heures) {
		super(-1, null, null,0L);
		this.code = jour;
		this.ouvert = ouvert;
		this.heures = heures;
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param ouvert
	 * @param heures
	 */
	public Planification(Planification plan) {
		super(plan.id, plan.designation, plan.moduleName,plan.compareid);
		this.ouvert = plan.ouvert;
		this.heures = plan.heures;
		this.code = plan.code;
	}

	public Boolean getOuvert() {
		return ouvert;
	}

	public void setOuvert(Boolean ouvert) {
		this.ouvert = ouvert;
	}

	public Double getHeures() {
		return heures;
	}

	public void setHeures(Double heures) {
		this.heures = heures;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(Planification arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Planification";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Planifications";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}
	
	

}
