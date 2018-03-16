/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author ntchuente
 *
 */

//@Table
//@Entity(name = "e_frais")
public class FraisScolaire extends BaseElement implements Serializable, Comparable<FraisScolaire> {
	
	@Column(name = "LIBELLE")	
	@Predicate(label="LIBELLE",optional=false,updatable=true,search=true, sequence=1,colsequence=1)
	protected String libelle;
	
	@Column(name = "MNT" )	
	@Predicate(label="MONTANT",optional=false,updatable=true,search=true, type=BigDecimal.class, sequence=3,colsequence=3)
	protected BigDecimal zMnt;
	
	@Column(name = "TVA" )	
	@Predicate(label="TVA",optional=false,updatable=true,search=true, type=Long.class, sequence=5,colsequence=2)
	protected BigDecimal ztva;
	
	@Column(name = "DATE_LIMITE" )	
	@Predicate(label="DATELINE PAIEMENT",optional=false,updatable=true,search=false, type=Date.class, sequence=4 , target="date")
	protected Date dateLine;

	@Column(name = "TYP_FRAIS")
	@Predicate(label="TYPE FRAIS",optional=false,updatable=true,search=false, target="combobox", values="à la commande;Mensuel;Trimestriel;Semestriel;Annuel" , sequence=2 )
	protected String typeFrais="0";
	

	public FraisScolaire() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FraisScolaire(FraisScolaire service) {
		super(service.id, service.designation, service.moduleName);
		this.libelle = service.libelle;
		this.typeFrais=service.typeFrais;
		this.dateLine=service.dateLine;
		this.zMnt=service.zMnt;
		this.ztva=service.ztva;
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


	

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		return hash;
	}

	public int compareTo(FraisScolaire o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Gestion des frais Scolaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Gestion des Frais Scolaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return libelle+"";
	}


	public BigDecimal getzMnt() {
		return zMnt;
	}


	public void setzMnt(BigDecimal zMnt) {
		this.zMnt = zMnt;
	}


	public BigDecimal getZtva() {
		return ztva;
	}


	public void setZtva(BigDecimal ztva) {
		this.ztva = ztva;
	}



	public String getTypeFrais() {
		return typeFrais;
	}


	public Date getDateLine() {
		return dateLine;
	}


	public void setDateLine(Date dateLine) {
		this.dateLine = dateLine;
	}


	public void setTypeFrais(String typeFrais) {
		this.typeFrais = typeFrais;
	}
	
	

}
