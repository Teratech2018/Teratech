/**
 * 
 */
package com.keren.kerenpaie.model.paie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.Predicate;

/**
 * @author BEKO
 *
 */
@Entity
@Table(name="T_PRPA")
public class ProfilPaie extends BaseElement implements Serializable, Comparable<ProfilPaie> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1406171594167272372L;
	
	@Predicate(label="Reference",optional=false,search=true)
	private String code ;
	
	@Predicate(label="Description",optional=false,search=true)
	private String label ;
	
	@ManyToOne
	@JoinColumn(name="SOCI_ID")
	@Predicate(label="Sociète",type=Societe.class,target="many-to-one",search=true)
	private Societe societe;
	
	private Boolean actif = Boolean.FALSE;
	
	private String state="etabli";
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="T_PRPARUBR" , joinColumns=@JoinColumn(name="PRPA_ID"),inverseJoinColumns=@JoinColumn(name="RUBR_ID"))
	@Predicate(label="Lignes",type=Rubrique.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Lignes de la grille salariale")
	private List<Rubrique> rubriques = new ArrayList<Rubrique>();
	
	

	/**
	 * 
	 */
	public ProfilPaie() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public ProfilPaie(long id, String designation, String moduleName) {
		super(id, designation, moduleName,0L);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param id
	 * @param designation
	 * @param moduleName
	 * @param code
	 * @param label
	 * @param societe
	 * @param actif
	 * @param state
	 * @param rubriques
	 */

	public ProfilPaie(long id, String designation, String moduleName, String code, String label, Societe societe,
			Boolean actif, String state, List<Rubrique> rubriques) {
		super(id, designation, moduleName,0L);
		this.code = code;
		this.label = label;
		this.societe = societe;
		this.actif = actif;
		this.state = state;
		this.rubriques = rubriques;
	}
	
	public ProfilPaie(ProfilPaie profil) {
		super(profil.id, profil.designation, profil.moduleName,profil.compareid);
		this.code = profil.code;
		this.label = profil.label;
		if(profil.societe!=null){
			this.societe = new Societe(profil.societe);
		}
		this.actif = profil.actif;
		this.state = profil.state;
//		this.rubriques = rubriques;
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

	public Societe getSociete() {
		return societe;
	}

	public void setSociete(Societe societe) {
		this.societe = societe;
	}

	public Boolean getActif() {
		return actif;
	}

	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Rubrique> getRubriques() {
		return rubriques;
	}

	public void setRubriques(List<Rubrique> rubriques) {
		this.rubriques = rubriques;
	}
	
	

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Profil de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Profils de Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kerenpaie";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code+" - "+label;
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
	public int compareTo(ProfilPaie arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
