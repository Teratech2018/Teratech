/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Column;

/**
 * @author BEKO
 *
 */
public class Cumul implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name="CSB")
	private Double cumulSalaireBrut = 0.0;
	

	@Column(name="CCS")
	private Double cumulChargeSalariale = 0.0;
	
	@Column(name="CCP")
	private Double cumulChargePatronale = 0.0;
	
		/**
	 * 
	 */
	public Cumul() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param cumulSalaireBrut
	 * @param cumulSalaireTaxable
	 * @param cumulSalaireCotisable
	 * @param cumulSalaireExcep
	 * @param cumulChargeSalariale
	 * @param cumulChargePatronale
	 * @param cumulAvantageNature
	 * @param cumulHeureTravailles
	 * @param cumulHeuresSup
	 */
	public Cumul(Double cumulSalaireBrut, Double cumulSalaireTaxable, Double cumulSalaireCotisable,
			Double cumulSalaireExcep, Double cumulChargeSalariale, Double cumulChargePatronale,
			Double cumulAvantageNature, Double cumulHeureTravailles, Double cumulHeuresSup) {
		super();
		this.cumulSalaireBrut = cumulSalaireBrut;
	
		this.cumulChargeSalariale = cumulChargeSalariale;
		this.cumulChargePatronale = cumulChargePatronale;
		
	}
	
	/**
	 * 
	 * @param cumulSalaireBrut
	 * @param cumulSalaireTaxable
	 * @param cumulSalaireCotisable
	 * @param cumulSalaireExcep
	 * @param cumulChargeSalariale
	 * @param cumulChargePatronale
	 * @param cumulAvantageNature
	 */
	public Cumul(Double cumulSalaireBrut, Double cumulSalaireTaxable, Double cumulSalaireCotisable,
			Double cumulSalaireExcep, Double cumulChargeSalariale, Double cumulChargePatronale,
			Double cumulAvantageNature) {
		super();
		this.cumulSalaireBrut = cumulSalaireBrut;
	
		this.cumulChargeSalariale = cumulChargeSalariale;
		this.cumulChargePatronale = cumulChargePatronale;
		
		
	}


	public Double getCumulSalaireBrut() {
		return cumulSalaireBrut;
	}

	public void setCumulSalaireBrut(Double cumulSalaireBrut) {
		this.cumulSalaireBrut = cumulSalaireBrut;
	}

	

	public Double getCumulChargeSalariale() {
		return cumulChargeSalariale;
	}

	public void setCumulChargeSalariale(Double cumulChargeSalariale) {
		this.cumulChargeSalariale = cumulChargeSalariale;
	}

	public Double getCumulChargePatronale() {
		return cumulChargePatronale;
	}

	public void setCumulChargePatronale(Double cumulChargePatronale) {
		this.cumulChargePatronale = cumulChargePatronale;
	}

	@Override
	public String toString() {
		return "Cumul [cumulSalaireBrut=" + cumulSalaireBrut + ", cumulChargeSalariale=" + cumulChargeSalariale
				+ ", cumulChargePatronale=" + cumulChargePatronale + "]";
	}

	

	   


}
