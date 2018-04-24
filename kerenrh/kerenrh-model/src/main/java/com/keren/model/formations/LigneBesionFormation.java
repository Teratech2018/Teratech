/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.keren.model.employes.Poste;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_LIBEFORH")
public class LigneBesionFormation extends BaseElement implements Serializable, Comparable<LigneBesionFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 14412318243727866L;
	
	@Predicate(label="Réference",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Description",target="textarea",search=true)
	private String description ;
	
	@ManyToOne
	@JoinColumn(name="POS_ID")
	@Predicate(label="Poste" ,type=Poste.class,target="many-to-one",search=true)
	private Poste poste ;
	
	@Predicate(label="Nbre de Places",type=Short.class,optional=false,min=1,search=true)
	private Short places=0;
	

	/**
	 * 
	 */
	public LigneBesionFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public LigneBesionFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param description
	 * @param poste
	 * @param places
	 */

	public LigneBesionFormation(long id, String designation, String moduleName, String code, String description,
			Poste poste, Short places) {
		super(id, designation, moduleName);
		this.code = code;
		this.description = description;
		this.poste = poste;
		this.places = places;
	}

	/**
	 * 
	 * @param ligne
	 */
	public LigneBesionFormation(LigneBesionFormation ligne) {
		super(ligne.id, ligne.designation, ligne.moduleName);
		this.code = ligne.code;
		this.description = ligne.description;
		if(ligne.poste!=null){
			this.poste = new Poste(ligne.poste);
		}
		this.places = ligne.places;
	}
	
	public LigneBesionFormation(DemandeFormation dmde) {
		super(-1, null, null);
		this.code = dmde.getObjet();
		this.description = dmde.getMotif();		
	    this.poste = new Poste(dmde.getDemandeur().getPoste());		
		this.places = 0;
	}
	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Poste getPoste() {
		return poste;
	}

	public void setPoste(Poste poste) {
		this.poste = poste;
	}

	public Short getPlaces() {
		return places;
	}

	public void setPlaces(Short places) {
		this.places = places;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Detail du besion";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Details du besion";
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
	public int compareTo(LigneBesionFormation arg0) {
		// TODO Auto-generated method stub
		return code.compareTo(arg0.code);
	}

}
