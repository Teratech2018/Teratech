/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_blgn")
public class LignePaie extends BaseElement implements Serializable, Comparable<LignePaie> {

	@Transient
	@Predicate(label="Code",optional=false,search=true,unique=true)
	private String code ;
	
	@Transient
	@Predicate(label="Description",optional=true,search=true,unique=true)
	private String label;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
//	@Predicate(label="Rubriques",type=Rubrique.class,target="many-to-one",optional=false,search=true)
	private RubriquePaie rubrique;
	
	@Predicate(label="Nombre",type=Double.class,editable=false,updatable=false,search=true)
	private Double nombre =0.0;
	
	@Predicate(label="Base",type=Double.class,editable=false,updatable=false,search=true)
	private Double base =0.0;
	
	@Predicate(label="Valeurs",type=Double.class,editable=false,updatable=false,search=true)
	private Double valeur =0.0;
	
	@Predicate(label="Part Salarial",type=Double.class,editable=false,updatable=false,search=true,compute=true,values="this.valeur;*;this.rubrique.tauxsal")
	private Double tauxsal = 0.0;
	
	@Predicate(label="Part Patronal",type=Double.class,editable=false,updatable=false,search=true,compute=true,values="this.valeur;*;this.rubrique.tauxsal")
	private Double tauxpat = 0.0;
	
	


	public int compareTo(LignePaie o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public LignePaie(String code, String label, RubriquePaie rubrique, Double nombre, Double base, Double valeur,
			Double tauxsal, Double tauxpat) {
		super();
		this.code = code;
		this.label = label;
		this.rubrique = rubrique;
		this.nombre = nombre;
		this.base = base;
		this.valeur = valeur;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
	}
	
	public LignePaie(LignePaie entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.label = entity.label;
		this.rubrique = new RubriquePaie(entity.rubrique);
		this.nombre = entity.nombre;
		this.base = entity.base;
		this.valeur = entity.valeur;
		this.tauxsal = entity.tauxsal;
		this.tauxpat = entity.tauxpat;
	}

	public LignePaie() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

	public Double getTauxsal() {
		return tauxsal;
	}

	public void setTauxsal(Double tauxsal) {
		this.tauxsal = tauxsal;
	}

	public Double getTauxpat() {
		return tauxpat;
	}

	public void setTauxpat(Double tauxpat) {
		this.tauxpat = tauxpat;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	public Double getNombre() {
		return nombre;
	}

	public void setNombre(Double nombre) {
		this.nombre = nombre;
	}

	public Double getBase() {
		return base;
	}

	public void setBase(Double base) {
		this.base = base;
	}

	public Double getValeur() {
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
	}
	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "ligne Bulletin Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "ligne Bulletin Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return id +"";
	}

}
