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
import com.keren.model.structures.Ville;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_ESCALE")
public class Escale extends BaseElement implements Serializable, Comparable<Escale> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 134411708637529378L;
	
	@ManyToOne
	@JoinColumn(name="SOU_ID")
	@Predicate(label="Ville de départ",type=Ville.class,target="many-to-one",optional=false,search=true)
	private Ville source ;
	
	@ManyToOne
	@JoinColumn(name="CIB_ID")
	@Predicate(label="Ville d'arrivée",type=Ville.class,target="many-to-one",optional=false,search=true)
    private Ville cible ;
    
	@Predicate(label="Frais de l'escale",type=Double.class,optional=false,search=true)
    private Double montant ;
	/**
	 * 
	 */
	public Escale() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Escale(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param source
	 * @param cible
	 * @param montant
	 */

	public Escale(long id, String designation, String moduleName, Ville source, Ville cible, Double montant) {
		super(id, designation, moduleName);
		this.source = source;
		this.cible = cible;
		this.montant = montant;
	}
	
	public Escale(Escale escale) {
		super(escale.id, escale.designation, escale.moduleName);
		this.source = escale.source;
		this.cible = escale.cible;
		this.montant = escale.montant;
	}
	
	

	public Ville getSource() {
		return source;
	}

	public void setSource(Ville source) {
		this.source = source;
	}

	public Ville getCible() {
		return cible;
	}

	public void setCible(Ville cible) {
		this.cible = cible;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Escale";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Escales";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenrh";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return super.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Escale o) {
		// TODO Auto-generated method stub
		return source.compareTo(o.source);
	}

}
