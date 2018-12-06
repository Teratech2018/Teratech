package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.referentiels.Societe;
import com.kerenedu.configuration.Cycle;
import com.megatim.common.annotations.Predicate;

@Entity
@Table(name="e_forfcycle")
public class ForfaitCycle extends BaseElement implements Serializable, Comparable<ForfaitCycle> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2290955710589999766L;
	
	@ManyToOne
	@JoinColumn(name="CYCLE_ID")
	@Predicate(label="Cycle ",type=Cycle.class,target="many-to-one",optional=false,search=true)
	private Cycle cycle ;
	
//	@ManyToOne
//	@JoinColumn(name="SOC_ID")
//	@Predicate(label="Structure",type=Societe.class,target="many-to-one",search=true)
//	private Societe sructure ;
	
	
	
	@Predicate(label="Valeur",type=Double.class,optional=false,search=true)
	private Double valeur =0.0;

	@Predicate(label="Mesure",target="combobox",values="Montant Fixe;Pourcentage salaire de base" ,search=true)
	private String mesure="0";
	
	
	/**
	 * 
	 */
	public ForfaitCycle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ForfaitCycle(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param categorie
	 * @param societe
	 * @param service
	 * @param valeur
	 * @param mesure
	 */

	public ForfaitCycle(long id, String designation, String moduleName, Cycle cycle, Societe societe,
 Double valeur, String mesure) {
		super(id, designation, moduleName,0L);
		this.cycle = cycle;
        this.valeur = valeur;
		this.mesure = mesure;
	}

	public ForfaitCycle(ForfaitCycle forfait) {
		super(forfait.id, forfait.designation, forfait.moduleName,forfait.compareid);
		this.cycle = new Cycle(forfait.cycle);
//		this.societe = forfait.societe;
		this.valeur = forfait.valeur;
		this.mesure = forfait.mesure;
	}
	
	public ForfaitCycle(Cycle forfait) {
		this.id=+forfait.getId();
		this.cycle = new Cycle(forfait);
		this.valeur = new Double(0);
		this.mesure = "0";
	}
	
	

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}

	public String getMesure() {
		return mesure;
	}

	public void setMesure(String mesure) {
		this.mesure = mesure;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Forfait";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return super.getListTitle();
	}

	public Cycle getCycle() {
		return cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return cycle.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(ForfaitCycle arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
