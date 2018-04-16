/**
 * 
 */
package com.keren.model.formations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.core.base.BaseElement;
import com.keren.model.structures.Societe;
import com.megatim.common.annotations.Filter;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
public class GenererBesionFormation extends BaseElement implements Serializable, Comparable<GenererBesionFormation> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5430441740256544687L;
	
	@ManyToOne
	@Predicate(label="Pour la Structure",type=Societe.class,target="many-to-one")
	private Societe structure ;
	
	@Predicate(label="Reference",optional=false)
	private String code ;
	
	@Predicate(label="Intitulé",optional=false)
	private String intitule ;
	
	@ManyToMany
	@Predicate(label=".",type=DemandeFormation.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Requêtes concernées")
	@Filter(value="[{\"fieldName\":\"state\",\"value\":\"valide\"}]")
	private List<DemandeFormation> demandes = new ArrayList<DemandeFormation>();
	

	/**
	 * 
	 */
	public GenererBesionFormation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public GenererBesionFormation(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param structure
	 * @param code
	 * @param intitule
	 * @param demandes
	 */

	public GenererBesionFormation(long id, String designation, String moduleName, Societe structure, String code,
			String intitule, List<DemandeFormation> demandes) {
		super(id, designation, moduleName);
		this.structure = structure;
		this.code = code;
		this.intitule = intitule;
		this.demandes = demandes;
	}
	
	public GenererBesionFormation(GenererBesionFormation bes) {
		super(bes.id, bes.designation, bes.moduleName);
		this.structure = bes.structure;
		this.code = bes.code;
		this.intitule = bes.intitule;
//		this.demandes = bes.demandes;
	}
	
	

	public Societe getStructure() {
		return structure;
	}

	public void setStructure(Societe structure) {
		this.structure = structure;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public List<DemandeFormation> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<DemandeFormation> demandes) {
		this.demandes = demandes;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Besions de Formation";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return super.getListTitle();
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
	public int compareTo(GenererBesionFormation arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
