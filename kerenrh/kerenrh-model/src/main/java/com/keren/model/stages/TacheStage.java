/**
 * 
 */
package com.keren.model.stages;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_TACSTARH")
public class TacheStage extends BaseElement implements Serializable, Comparable<TacheStage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324753306872872990L;
	
	@Predicate(label="Tâche",optional=false)
	private String code ;
	
	@Predicate(label="Difficulté rencontrées",target="textarea")
	@Lob
	private String diff ;
	
	@Predicate(label="Propositions d'améliorations",target="textarea")
	@Lob
	private String propo;

	/**
	 * 
	 */
	public TacheStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public TacheStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
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

	public TacheStage(long id, String designation, String moduleName, String code, String diff, String propo) {
		super(id, designation, moduleName);
		this.code = code;
		this.diff = diff;
		this.propo = propo;
	}
	
	public TacheStage(TacheStage tache) {
		super(tache.id, tache.designation, tache.moduleName);
		this.code = tache.code;
		this.diff = tache.diff;
		this.propo = tache.propo;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDiff() {
		return diff;
	}

	public void setDiff(String diff) {
		this.diff = diff;
	}

	public String getPropo() {
		return propo;
	}

	public void setPropo(String propo) {
		this.propo = propo;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Tâche";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Tâches";
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
	public int compareTo(TacheStage o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
