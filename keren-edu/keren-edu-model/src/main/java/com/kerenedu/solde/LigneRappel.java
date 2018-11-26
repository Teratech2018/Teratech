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
@Table(name="e_lirappel")
public class LigneRappel extends BaseElement implements Serializable, Comparable<LigneRappel> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5812955839047444402L;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
	@Predicate(label="Rubique de paie",type=RubriquePaie.class,target="many-to-one",optional=false,search=true)
	private RubriquePaie rubrique ;
	
	@Predicate(label="Montant réel",type=Double.class,search=true)
	private Double montant =0.0;
	
	@Predicate(label="Montant perçu",type=Double.class,search=true)
	private Double percu =0.0;
	
	@Predicate(label="Rappel",type=Double.class,search=true,hide=true,editable=false,updatable=false,compute=true,values="this.montant;-;this.percu")
	private Double solde = 0.0;

	/**
	 * 
	 */
	public LigneRappel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneRappel(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	
/**
 * 
 * @param id
 * @param designation
 * @param moduleName
 * @param rubrique
 * @param montant
 * @param percu
 * @param solde
 */
	public LigneRappel(long id, String designation, String moduleName, RubriquePaie rubrique, Double montant, Double percu,
			Double solde) {
		super(id, designation, moduleName,0L);
		this.rubrique = rubrique;
		this.montant = montant;
		this.percu = percu;
		this.solde = solde;
	}
	
	/**
	 * 
	 * @param ligne
	 */
	public LigneRappel(LigneRappel ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
		if(ligne.rubrique!=null){
			this.rubrique = new RubriquePaie(ligne.rubrique);
		}
		this.montant = ligne.montant;
		this.percu = ligne.percu;
		this.solde = ligne.solde;
	}
	
	

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Double getPercu() {
		return percu;
	}

	public void setPercu(Double percu) {
		this.percu = percu;
	}

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Rappel";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Rappels";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	//@Override
	public int compareTo(LigneRappel o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
