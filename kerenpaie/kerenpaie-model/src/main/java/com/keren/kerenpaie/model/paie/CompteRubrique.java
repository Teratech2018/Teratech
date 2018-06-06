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
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity 
@Table(name="T_COMRUBRP")
public class CompteRubrique extends BaseElement implements Serializable, Comparable<CompteRubrique> {

	/**
	 *   
	 */
	private static final long serialVersionUID = 4252830328637067549L;
	
	@ManyToOne
	@JoinColumn(name="SOC_ID")
	@Predicate(label="Agence",type=Societe.class,target="many-to-one",search=true)
	private Societe agence ;
	
	@ManyToOne
	@JoinColumn(name="CHSAL_ID")
	@Predicate(label="Compte de charge sal.",type=Compte.class,target="many-to-one",search=true)
	private Compte chargesalarial ;
	
	@ManyToOne
	@JoinColumn(name="TIERSAL_ID")
	@Predicate(label="Compte de tiers sal.",type=Compte.class,target="many-to-one",search=true)
	private Compte tiersal ;
	
	@ManyToOne
	@JoinColumn(name="CHPAT_ID")
	@Predicate(label="Compte de charge pat.",type=Compte.class,target="many-to-one",search=true)
	private Compte chargepatronal ;
	
	@ManyToOne
	@JoinColumn(name="TIERPAT_ID")
	@Predicate(label="Compte de tier pat.",type=Compte.class,target="many-to-one",search=true)
	private Compte tierpatronal ;

	/**
	 * 
	 */
	public CompteRubrique() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public CompteRubrique(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param agence
	 * @param chargesalarial
	 * @param comptetiersal
	 * @param chargepatronal
	 * @param chargetierpatronal
	 */

	public CompteRubrique(long id, String designation, String moduleName, Societe agence, Compte chargesalarial,
			Compte comptetiersal, Compte chargepatronal, Compte chargetierpatronal) {
		super(id, designation, moduleName,0L);
		this.agence = agence;
		this.chargesalarial = chargesalarial;
		this.tiersal = comptetiersal;
		this.chargepatronal = chargepatronal;
		this.tierpatronal = chargetierpatronal;
	}

	public CompteRubrique(CompteRubrique rub) {
		super(rub.id, rub.designation, rub.moduleName,rub.compareid);
		if(rub.agence!=null){
			this.agence = new Societe(rub.agence);
		}
		if(rub.chargesalarial!=null){
			this.chargesalarial = new Compte(rub.chargesalarial);
		}
		if(rub.tiersal!=null){
			this.tiersal = new Compte(rub.tiersal);
		}
		if(rub.chargepatronal!=null){
			this.chargepatronal = new Compte(rub.chargepatronal);
		}
		if(rub.tierpatronal!=null){
			this.tierpatronal = new Compte(rub.tierpatronal);
		}
	}
	
	
	
	
	public Societe getAgence() {
		return agence;
	}

	public void setAgence(Societe agence) {
		this.agence = agence;
	}

	public Compte getChargesalarial() {
		return chargesalarial;
	}

	public void setChargesalarial(Compte chargesalarial) {
		this.chargesalarial = chargesalarial;
	}

	public Compte getTiersal() {
		return tiersal;
	}

	public void setTiersal(Compte tiersal) {
		this.tiersal = tiersal;
	}

	public Compte getChargepatronal() {
		return chargepatronal;
	}

	public void setChargepatronal(Compte chargepatronal) {
		this.chargepatronal = chargepatronal;
	}

	public Compte getTierpatronal() {
		return tierpatronal;
	}

	public void setTierpatronal(Compte tierpatronal) {
		this.tierpatronal = tierpatronal;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Comptabilite";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Comptabilite";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return agence.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CompteRubrique o) {
		// TODO Auto-generated method stub
		return agence.compareTo(o.agence);
	}

}
