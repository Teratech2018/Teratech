/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

@Table
@Entity(name = "e_periode")
public class PeriodeScolaire extends BaseElement implements Serializable, Comparable<PeriodeScolaire> {
	
	@Column(name = "LIBELLE" )	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true,sequence=1)
	protected String libelle;
	
	@Column(name = "D_DEBUT" )	
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="DEBUT",optional=false,updatable=false,search=true, type=Date.class, target="date", sequence=3)
	protected String dDeb;
	
	@Column(name = "D_FIN" )	
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="FIN",optional=false,updatable=false,search=true, target="date", type=Date.class, sequence=2)
	protected String dFin;
	
	@Column(name = "D_DEBUT_SAI_NOTE")	
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="DEBUT SAISIR NOTES",optional=true,updatable=false,search=true, target="date", sequence=5)
	protected String dDebSai;
	
	@Column(name = "D_FIN_SAI_NOTE")	
	//@Temporal(javax.persistence.TemporalType.TIME)
	@Predicate(label="FIN SAISIR NOTES",optional=true,updatable=false,search=true,target="date", sequence=4)
	protected String dFinSai;
	
	

	public PeriodeScolaire() {
		
	}

	public PeriodeScolaire(PeriodeScolaire periode) {
		super(periode.id, periode.designation, periode.moduleName,0L);
		this.libelle = periode.libelle;
		this.dDeb = periode.dDeb;
		this.dFin = periode.dFin;
		this.dDebSai = periode.dDebSai;
		this.dFinSai = periode.dFinSai;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(PeriodeScolaire o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Periode Scolaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Periode Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle;
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
	 * @return the dDeb
	 */
	public String getdDeb() {
		return dDeb;
	}

	/**
	 * @param dDeb the dDeb to set
	 */
	public void setdDeb(String dDeb) {
		this.dDeb = dDeb;
	}

	/**
	 * @return the dFin
	 */
	public String getdFin() {
		return dFin;
	}

	/**
	 * @param dFin the dFin to set
	 */
	public void setdFin(String dFin) {
		this.dFin = dFin;
	}

	/**
	 * @return the dDebSai
	 */
	public String getdDebSai() {
		return dDebSai;
	}

	/**
	 * @param dDebSai the dDebSai to set
	 */
	public void setdDebSai(String dDebSai) {
		this.dDebSai = dDebSai;
	}

	/**
	 * @return the dFinSai
	 */
	public String getdFinSai() {
		return dFinSai;
	}

	/**
	 * @param dFinSai the dFinSai to set
	 */
	public void setdFinSai(String dFinSai) {
		this.dFinSai = dFinSai;
	}

}
