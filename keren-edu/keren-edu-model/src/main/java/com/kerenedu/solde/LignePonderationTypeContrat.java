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
@Table(name="e_pontycon")
public class LignePonderationTypeContrat extends BaseElement implements Serializable, Comparable<LignePonderationTypeContrat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7479378818427457839L;
	
	@ManyToOne
	@JoinColumn(name="FONC_ID")
	@Predicate(label="Type de contrat",type=TypeContrat.class,target="many-to-one",optional=false,search=true)
	private TypeContrat fonction ;
	
	@Predicate(label="Taux de Majoration(%)",type=Double.class,optional=false,search=true)
	private Double taux = 0.0;

	/**
	 * 
	 */
	public LignePonderationTypeContrat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LignePonderationTypeContrat(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
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

	public LignePonderationTypeContrat(long id, String designation, String moduleName, TypeContrat fonction, Double taux) {
		super(id, designation, moduleName,0L);
		this.fonction = fonction;
		this.taux = taux;
	}
	
	/**
	 * 
	 * @param fonction
	 * @param taux
	 */
	public LignePonderationTypeContrat(TypeContrat fonction, Double taux) {
		super(-1, null, null,0L);
		this.fonction = fonction;
		this.taux = taux;
	}
	
	/**
	 * 
	 * @param ponderation
	 */
	public LignePonderationTypeContrat(LignePonderationTypeContrat ponderation) {
		super(ponderation.id, ponderation.designation, ponderation.moduleName,ponderation.compareid);
		if(ponderation.fonction!=null){
			this.fonction = new TypeContrat(ponderation.fonction);
		}
		this.taux = ponderation.taux;
	}
	

	public TypeContrat getFonction() {
		return fonction;
	}

	public void setFonction(TypeContrat fonction) {
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
		return "Type Contrat";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return fonction.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(LignePonderationTypeContrat arg0) {
		// TODO Auto-generated method stub
		return fonction.compareTo(arg0.fonction);
	}

}
