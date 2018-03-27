/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_PAAVP")
public class ParametreAvance extends BaseElement implements Serializable, Comparable<ParametreAvance> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4361315865563218517L;
	
	@Predicate(label="Type de Parametrage",target="combobox",values="Pondération salaire;Taux par Type de contrat",search=true)
	private String type="0";
	
	@OneToMany
	@JoinColumn(name="LIPOTC_ID")
	@Predicate(label="Lignes",type=LignePonderationSalaire.class,target="one-to-many",group=true,groupName="group1",groupLabel="DETAILS",hidden="currentObject.type!=1")
	private List<LignePonderationTypeContrat> typescontrats = new ArrayList<LignePonderationTypeContrat>();
	
	@OneToMany
	@JoinColumn(name="LIPOSA_ID")
	@Predicate(label="Lignes",type=LignePonderationSalaire.class,target="one-to-many",group=true,groupName="group1",groupLabel="DETAILS",hidden="currentObject.type!=0")
	private List<LignePonderationSalaire> fonctions = new ArrayList<LignePonderationSalaire>();
	
	

	/**
	 * 
	 */
	public ParametreAvance() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ParametreAvance(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param type
	 * @param fonctions
	 * @param typescontrats
	 */

	public ParametreAvance(long id, String designation, String moduleName, String type,
			List<LignePonderationSalaire> fonctions, List<LignePonderationTypeContrat> typescontrats) {
		super(id, designation, moduleName);
		this.type = type;
		this.fonctions = fonctions;
		this.typescontrats = typescontrats;
	}
	
	/**
	 * 
	 * @param pa
	 */
	public ParametreAvance(ParametreAvance pa) {
		super(pa.id, pa.designation, pa.moduleName);
		this.type = pa.type;
//		this.fonctions = fonctions;
//		this.typescontrats = typescontrats;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<LignePonderationSalaire> getFonctions() {
		return fonctions;
	}

	public void setFonctions(List<LignePonderationSalaire> fonctions) {
		this.fonctions = fonctions;
	}

	public List<LignePonderationTypeContrat> getTypescontrats() {
		return typescontrats;
	}

	public void setTypescontrats(List<LignePonderationTypeContrat> typescontrats) {
		this.typescontrats = typescontrats;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Paramètrage Avancé ";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Paramètrages Avancés ";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSerial() {
		// TODO Auto-generated method stub
		return Long.toString(serialVersionUID);
	}

	@Override
	public boolean isActivefilelien() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		return super.getStates();
	}

	@Override
	public boolean isActivatefollower() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ParametreAvance arg0) {
		// TODO Auto-generated method stub
		return type.compareTo(arg0.type);
	}

}
