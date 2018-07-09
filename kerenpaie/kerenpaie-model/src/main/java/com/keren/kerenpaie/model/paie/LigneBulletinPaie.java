/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIBUPA")
public class LigneBulletinPaie extends BaseElement implements Serializable, Comparable<LigneBulletinPaie> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2909281068129108868L;
	
	@Transient
	@Predicate(label="Code",optional=false,search=true,unique=true)
	private String code ;
	
	@Transient
	@Predicate(label="Description",optional=true,search=true,unique=true)
	private String label;
	
	@ManyToOne
	@JoinColumn(name="RUBR_ID")
//	@Predicate(label="Rubriques",type=Rubrique.class,target="many-to-one",optional=false,search=true)
	private Rubrique rubrique;
	
	@Predicate(label="Valeurs",type=Double.class,editable=false,updatable=false,search=true)
	private Double valeur =0.0;
	
	@Predicate(label="Part Salarial",type=Double.class,editable=false,updatable=false,search=true,compute=true,values="this.valeur;*;this.rubrique.tauxsal")
	private Double tauxsal = 0.0;
	
	@Predicate(label="Part Patronal",type=Double.class,editable=false,updatable=false,search=true,compute=true,values="this.valeur;*;this.rubrique.tauxsal")
	private Double tauxpat = 0.0;
	

	/**
	 * 
	 */
	public LigneBulletinPaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneBulletinPaie(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param rubrique
	 * @param valeur
	 * @param tauxsal
	 * @param tauxpat
	 */
	public LigneBulletinPaie(long id, String designation, String moduleName, Rubrique rubrique, Double valeur,
			Double tauxsal, Double tauxpat) {
		super(id, designation, moduleName,0L);
		this.rubrique = rubrique;
		this.valeur = valeur;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
	}
	
	/**
	 * 
	 * @param rubrique
	 * @param valeur
	 * @param tauxsal
	 * @param tauxpat
	 */
	public LigneBulletinPaie(Rubrique rubrique, Double valeur,
			Double tauxsal, Double tauxpat) {
		super(-1, null, null,0L);
		this.rubrique = rubrique;
		this.valeur = valeur;
		this.tauxsal = tauxsal;
		this.tauxpat = tauxpat;
		
	}

	/**
	 * 
	 * @param ligne
	 */
	public LigneBulletinPaie(LigneBulletinPaie ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName,ligne.compareid);
		if(ligne.rubrique!=null){
			this.rubrique = new Rubrique(ligne.rubrique);
			this.code=ligne.getRubrique().getCode();
			this.label=ligne.getRubrique().getLabel();
		}
		this.valeur = ligne.valeur;
		this.tauxsal = ligne.tauxsal;
		this.tauxpat = ligne.tauxpat;
	}
	
	
	
	public Rubrique getRubrique() {
		return rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	public Double getValeur() {		
		return valeur;
	}

	public void setValeur(Double valeur) {
		this.valeur = valeur;
		
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
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Lignes bulletin";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Ligne bulletin";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return rubrique.getDesignation();
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(LigneBulletinPaie o) {
		// TODO Auto-generated method stub
		return rubrique.compareTo(o.rubrique);
	}

    @Override
    public String toString() {
        return "LigneBulletinPaie{" + "rubrique=" + rubrique + ", valeur=" + valeur + ", tauxsal=" + tauxsal + ", tauxpat=" + tauxpat + '}';
    }
        
        

}
