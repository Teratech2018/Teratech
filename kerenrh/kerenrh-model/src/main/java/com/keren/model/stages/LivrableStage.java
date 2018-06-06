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
@Table(name="T_LIVSTARH")
public class LivrableStage extends BaseElement implements Serializable, Comparable<LivrableStage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4324753306872872990L;
	
	@Predicate(label="Libellé",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Quantité",type=Double.class,search=true)	
	private Double quantite =0.0 ;
	
	@Predicate(label="Description",target="textarea",search=true)
	@Lob
	private String propo;

	/**
	 * 
	 */
	public LivrableStage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LivrableStage(long id, String designation, String moduleName) {
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

	public LivrableStage(long id, String designation, String moduleName, String code, Double diff, String propo) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.quantite = diff;
		this.propo = propo;
	}
	
	public LivrableStage(LivrableStage tache) {
		super(tache.id, tache.designation, tache.moduleName,tache.compareid);
		this.code = tache.code;
		this.quantite = tache.quantite;
		this.propo = tache.propo;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public Double getQuantite() {
		return quantite;
	}

	public void setQuantite(Double quantite) {
		this.quantite = quantite;
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
		return "Outil Livré";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Outils Livré";
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
	public int compareTo(LivrableStage o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
