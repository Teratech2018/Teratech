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
@Table(name="e_griligne")
public class LigneConvension extends BaseElement implements Serializable, Comparable<LigneConvension> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2004133814270070750L;


	
	@ManyToOne
	@JoinColumn(name="CATE_ID")
	@Predicate(label="Catégorie",type=Categorie.class,target="many-to-one",optional=false,search=true,colsequence=1)
	private Categorie categorie ;
	
	
	@ManyToOne
	@JoinColumn(name="ECHE_ID")
	@Predicate(label="Echélon",type=Echellon.class,target="many-to-one",optional=false,search=true,colsequence=2)
	private Echellon echelon ;
	
	
	@Predicate(label="Salire de base",type=Double.class,optional=false,search=true,colsequence=3)
	private Double salbase =0.0;
	
	
	@Predicate(label="Status")
	private String state = "etabli";
	
	/**
	 * 
	 */
	public LigneConvension() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneConvension(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param categorie
	 * @param echelon
	 * @param salbase
	 * @param state
	 */

	public LigneConvension(long id, String designation, String moduleName, Categorie categorie, Echellon echelon,
			Double salbase, String state) {
		super(id, designation, moduleName,0L);
		this.categorie = categorie;
		this.echelon = echelon;
		this.salbase = salbase;
		this.state = state;
	}
	
	/**
	 * 
	 * @param categorie
	 * @param echelon
	 * @param salbase
	 */
	public LigneConvension(Categorie categorie, Echellon echelon,Double salbase) {
		super(-1, null, null,0L);
		this.categorie = categorie;
		this.echelon = echelon;
		this.salbase = salbase;
		this.state = "etabli";
	}
	
	
	/**
	 * 
	 * @param ligne
	 */
	public LigneConvension(LigneConvension ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
		if(ligne.categorie!=null){
			this.categorie = new Categorie(ligne.categorie);
		}
		if(ligne.echelon!=null){
			this.echelon = new Echellon(ligne.echelon);
		}
		this.salbase = ligne.salbase;
		this.state = ligne.state;
	}
	
	

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Echellon getEchelon() {
		return echelon;
	}

	public void setEchelon(Echellon echelon) {
		this.echelon = echelon;
	}

	public Double getSalbase() {
		return salbase;
	}

	public void setSalbase(Double salbase) {
		this.salbase = salbase;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Ligne Convension collective";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Lignes Convension collective";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return categorie.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
//	@Override
	public int compareTo(LigneConvension arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
