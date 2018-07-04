/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.school.Nationalite;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_reduction")
public class Reduction extends BaseElement implements Serializable, Comparable<Reduction> {
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=false,search=true, sequence=1)
	protected String libelle;
	
	@Column(name = "MNT")	
	@Predicate(label="MONTANT",optional=true,search=true, type=BigDecimal.class, sequence=2)
	protected BigDecimal zMnt;
	
	@Column(name = "POURCENTAGE" )	
	@Predicate(label="POURCENTAGE",optional=true,search=true, type=Long.class, sequence=3)
	protected BigDecimal dpour;
	
	
	public Reduction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reduction(Reduction reduction) {
		super(reduction.id, reduction.designation, reduction.moduleName,0L);
		this.libelle = reduction.libelle;
		this.zMnt = reduction.zMnt;
		this.dpour = reduction.dpour;
	}

	

	
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * @return the zMnt
	 */
	public BigDecimal getzMnt() {
		return zMnt;
	}

	/**
	 * @param zMnt the zMnt to set
	 */
	public void setzMnt(BigDecimal zMnt) {
		this.zMnt = zMnt;
	}

	/**
	 * @return the dpour
	 */
	public BigDecimal getDpour() {
		return dpour;
	}

	/**
	 * @param dpour the dpour to set
	 */
	public void setDpour(BigDecimal dpour) {
		this.dpour = dpour;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(Reduction o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Reductions";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Reductions";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id+"";
	}
	
	

}
