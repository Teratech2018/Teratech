/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.employes.Fonction;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIPOSAP")
public class LignePonderationSalaire extends BaseElement implements Serializable, Comparable<LignePonderationSalaire> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7479378818427457839L;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Fonction",type=Fonction.class,target="many-to-one",optional=false,search=true)
	private Fonction fonction ;
	
	@Predicate(label="Taux de Majoration(%)",type=Double.class,optional=false,search=true)
	private Double taux = 0.0;

	/**
	 * 
	 */
	public LignePonderationSalaire() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LignePonderationSalaire(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param fonction
	 * @param taux
	 */

	public LignePonderationSalaire(long id, String designation, String moduleName, Fonction fonction, Double taux) {
		super(id, designation, moduleName);
		this.fonction = fonction;
		this.taux = taux;
	}
	
	/**
	 * 
	 * @param fonction
	 * @param taux
	 */
	public LignePonderationSalaire(Fonction fonction, Double taux) {
		super(-1, null, null);
		this.fonction = fonction;
		this.taux = taux;
	}
	
	/**
	 * 
	 * @param ponderation
	 */
	public LignePonderationSalaire(LignePonderationSalaire ponderation) {
		super(ponderation.id, ponderation.designation, ponderation.moduleName);
		if(ponderation.fonction!=null){
			this.fonction = new Fonction(ponderation.fonction);
		}
		this.taux = ponderation.taux;
	}
	

	public Fonction getFonction() {
		return fonction;
	}

	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Fonction";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return fonction.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LignePonderationSalaire arg0) {
		// TODO Auto-generated method stub
		return fonction.compareTo(arg0.fonction);
	}

}
