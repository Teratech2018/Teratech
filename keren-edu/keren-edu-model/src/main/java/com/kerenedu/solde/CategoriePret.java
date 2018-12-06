/**
 * 
 */
package com.kerenedu.solde;

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
@Table(name="e_catpret")
public class CategoriePret extends BaseElement implements Serializable, Comparable<CategoriePret> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6014157570232699624L;
	
	@Predicate(label="Type de prêt",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Durée du remboursement",type=Short.class,search=true)
	private Short duree =0;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubrique associée",type=RubriquePaie.class,target="many-to-one",optional=false,search=true)
	private RubriquePaie rubrique ;
	
	@Predicate(label="Echéancier modifiable?",type=Boolean.class,search=true)
	private Boolean gelee = false;

	/**
	 * 
	 */
	public CategoriePret() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CategoriePret(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param duree
	 * @param rubrique
	 * @param gelee
	 */

	public CategoriePret(long id, String designation, String moduleName, String code, Short duree, RubriquePaie rubrique,
			Boolean gelee) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.duree = duree;
		this.rubrique = rubrique;
		this.gelee = gelee;
	}
	
	/**
	 * 
	 * @param cat
	 */
	public CategoriePret(CategoriePret cat) {
		super(cat.id, cat.designation, cat.moduleName,cat.compareid);
		this.code = cat.code;
		this.duree = cat.duree;
		if(cat.rubrique!=null){
			this.rubrique = new RubriquePaie(cat.rubrique);
		}
		this.gelee = cat.gelee;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Short getDuree() {
		return duree;
	}

	public void setDuree(Short duree) {
		this.duree = duree;
	}

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	public Boolean getGelee() {
		return gelee;
	}

	public void setGelee(Boolean gelee) {
		this.gelee = gelee;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Catégorie de Prêt";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Catégories de Prêts";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(CategoriePret o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
