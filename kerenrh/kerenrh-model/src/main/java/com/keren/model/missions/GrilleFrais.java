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
import com.keren.model.employes.Fonction;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_GRILFRARH")
public class GrilleFrais extends BaseElement implements Serializable, Comparable<GrilleFrais> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1596928207208504829L;
	
	@Predicate(label="Intitulé",optional=false,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Fonction",type=Fonction.class,target="many-to-one",optional=false,search=true)
	private Fonction fonction ;
	
	@Predicate(label="Montant Interne",type=Double.class,optional=false,search=true)
	private Double interne =0.0;
	
	@Predicate(label="Montant Externe",type=Double.class,optional=false,search=true)
	private Double externe = 0.0;

	/**
	 * 
	 */
	public GrilleFrais() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public GrilleFrais(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param fonction
	 * @param interne
	 * @param externe
	 */

	public GrilleFrais(long id, String designation, String moduleName, String code, Fonction fonction, Double interne,
			Double externe) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.fonction = fonction;
		this.interne = interne;
		this.externe = externe;
	}
	
	public GrilleFrais(GrilleFrais grille) {
		super(grille.id, grille.designation, grille.moduleName,grille.compareid);
		this.code = grille.code;
		if(grille.fonction!=null){
			this.fonction = new Fonction(grille.fonction);
		}
		this.interne = grille.interne;
		this.externe = grille.externe;
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Double getInterne() {
		return interne;
	}

	public void setInterne(Double interne) {
		this.interne = interne;
	}

	public Double getExterne() {
		return externe;
	}

	public void setExterne(Double externe) {
		this.externe = externe;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Grille de frais";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Grilles de frais";
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
	public int compareTo(GrilleFrais o) {
		// TODO Auto-generated method stub
		return code.compareTo(o.code);
	}

}
