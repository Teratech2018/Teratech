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
	
	@Column(name="CST")
	private Double cumulSalaireTaxable = 0.0 ;

	@Column(name="CSC")
	private Double cumulSalaireCotisable = 0.0 ;

	@Column(name="CSE")
	private Double cumulSalaireExcep = 0.0 ;
	
	@Column(name="CCS")
	private Double cumulChargeSalariale = 0.0;
	
	@Column(name="CCP")
	private Double cumulChargePatronale = 0.0;
	
	@Column(name="CAN")
	private Double cumulAvantageNature = 0.0;
	
	@Column(name="CHT")
	private Double cumulHeureTravailles = 0.0;
	
	@Column(name="CHS")
	private Double cumulHeuresSup = 0.0;
        
        @Column(name="CCOA")
        private Double cumulCongesAcquis =0.0;
        
        @Column(name="CCOP")
        private Double cumulCongesPris = 0.0;
	
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
		this.cumulSalaireTaxable = cumulSalaireTaxable;
		this.cumulSalaireCotisable = cumulSalaireCotisable;
		this.cumulSalaireExcep = cumulSalaireExcep;
		this.cumulChargeSalariale = cumulChargeSalariale;
		this.cumulChargePatronale = cumulChargePatronale;
		this.cumulAvantageNature = cumulAvantageNature;
		this.cumulHeureTravailles = cumulHeureTravailles;
		this.cumulHeuresSup = cumulHeuresSup;
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
		this.cumulSalaireTaxable = cumulSalaireTaxable;
		this.cumulSalaireCotisable = cumulSalaireCotisable;
		this.cumulSalaireExcep = cumulSalaireExcep;
		this.cumulChargeSalariale = cumulChargeSalariale;
		this.cumulChargePatronale = cumulChargePatronale;
		this.cumulAvantageNature = cumulAvantageNature;
		
	}


	public Double getCumulSalaireBrut() {
		return cumulSalaireBrut;
	}

	public void setCumulSalaireBrut(Double cumulSalaireBrut) {
		this.cumulSalaireBrut = cumulSalaireBrut;
	}

	public Double getCumulSalaireTaxable() {
		return cumulSalaireTaxable;
	}

	public void setCumulSalaireTaxable(Double cumulSalaireTaxable) {
		this.cumulSalaireTaxable = cumulSalaireTaxable;
	}

	public Double getCumulSalaireCotisable() {
		return cumulSalaireCotisable;
	}

	public void setCumulSalaireCotisable(Double cumulSalaireCotisable) {
		this.cumulSalaireCotisable = cumulSalaireCotisable;
	}

	public Double getCumulSalaireExcep() {
		return cumulSalaireExcep;
	}

	public void setCumulSalaireExcep(Double cumulSalaireExcep) {
		this.cumulSalaireExcep = cumulSalaireExcep;
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

	public Double getCumulAvantageNature() {
		return cumulAvantageNature;
	}

	public void setCumulAvantageNature(Double cumulAvantageNature) {
		this.cumulAvantageNature = cumulAvantageNature;
	}

	public Double getCumulHeureTravailles() {
		return cumulHeureTravailles;
	}

	public void setCumulHeureTravailles(Double cumulHeureTravailles) {
		this.cumulHeureTravailles = cumulHeureTravailles;
	}

	public Double getCumulHeuresSup() {
		return cumulHeuresSup;
	}

	public void setCumulHeuresSup(Double cumulHeuresSup) {
		this.cumulHeuresSup = cumulHeuresSup;
	}

        public Double getCumulCongesAcquis() {
            return cumulCongesAcquis;
        }

        public void setCumulCongesAcquis(Double cumulCongesAcquis) {
            this.cumulCongesAcquis = cumulCongesAcquis;
        }

        public Double getCumulCongesPris() {
            return cumulCongesPris;
        }

        public void setCumulCongesPris(Double cumulCongesPris) {
            this.cumulCongesPris = cumulCongesPris;
        }

	   

    @Override
    public String toString() {
        return "Cumul{" + "cumulSalaireBrut=" + cumulSalaireBrut + ", cumulSalaireTaxable=" + cumulSalaireTaxable + ", cumulSalaireCotisable=" + cumulSalaireCotisable + ", cumulSalaireExcep=" + cumulSalaireExcep + ", cumulChargeSalariale=" + cumulChargeSalariale + ", cumulChargePatronale=" + cumulChargePatronale + ", cumulAvantageNature=" + cumulAvantageNature + ", cumulHeureTravailles=" + cumulHeureTravailles + ", cumulHeuresSup=" + cumulHeuresSup + '}';
    }
	

}
