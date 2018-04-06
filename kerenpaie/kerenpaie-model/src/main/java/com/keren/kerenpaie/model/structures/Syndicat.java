/**
 * 
 */
package com.keren.kerenpaie.model.structures;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_SYNDICATP")
public class Syndicat extends BaseElement implements Serializable, Comparable<Syndicat> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8374372271469119808L;
	
	@Predicate(label="Nom de l'organisation",optional=false,unique=true,search=true)
	private String code ;
	
	@ManyToOne
	@JoinColumn(name="COMP_ID")
	@Predicate(label="Compte de tiers",type=Compte.class,target="many-to-one",search=true)
	private Compte comptetier ;
	
	@ManyToOne
	@JoinColumn(name="TYPCAIS_ID")
	@Predicate(label="Type de caisse",type=TypeCaisse.class,target="many-to-one",search=true)
	private TypeCaisse typecaisse ;
	
	@ManyToOne
	@JoinColumn(name="STRUC_ID")
	@Predicate(label="Dossier de paie",type=Societe.class,target="many-to-one",search=true)
	private Societe structure ;
	
	

	/**
	 * 
	 */
	public Syndicat() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Syndicat(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param comptetier
	 * @param typecaisse
	 * @param structure
	 */

	public Syndicat(long id, String designation, String moduleName, String code, Compte comptetier,
			TypeCaisse typecaisse, Societe structure) {
		super(id, designation, moduleName);
		this.code = code;
		this.comptetier = comptetier;
		this.typecaisse = typecaisse;
		this.structure = structure;
	}
	
	/**
	 * 
	 * @param syndicat
	 */
	public Syndicat(Syndicat syndicat) {
		super(syndicat.id, syndicat.designation, syndicat.moduleName);
		this.code = syndicat.code;
		if(syndicat.comptetier!=null){
			this.comptetier = new Compte(syndicat.comptetier);
		}
		this.typecaisse = syndicat.typecaisse;
		if(syndicat.structure!=null){
			this.structure = new Societe(syndicat.structure);
		}
	}
	
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Compte getComptetier() {
		return comptetier;
	}

	public void setComptetier(Compte comptetier) {
		this.comptetier = comptetier;
	}

	public TypeCaisse getTypecaisse() {
		return typecaisse;
	}

	public void setTypecaisse(TypeCaisse typecaisse) {
		this.typecaisse = typecaisse;
	}

	public Societe getStructure() {
		return structure;
	}

	public void setStructure(Societe structure) {
		this.structure = structure;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Syndicat";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Syndicats";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Syndicat o) {
		// TODO Auto-generated method stub
		return code.trim().compareTo(o.code.trim());
	}

}
