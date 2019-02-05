/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.kerenedu.configuration.Etablissement;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_profil")
public class ProfilPaielight extends BaseElement implements Serializable, Comparable<ProfilPaielight> {

	@Predicate(label="Reference",optional=false,search=true, sequence=1)
	private String code ;
	
	@Predicate(label="Description",optional=false,search=true, sequence=2)
	private String label ;
	
/*	@ManyToOne
	@JoinColumn(name="SOCI_ID")
	@Predicate(label="Sociète",type=Etablissement.class,target="many-to-one",search=true, sequence=3)
	private Etablissement societe;*/
	
	private Boolean actif = Boolean.FALSE;
	
	private String state="etabli";
	
//	@ManyToMany(fetch=FetchType.LAZY)
//	@JoinTable(name="e_rub_profil" , joinColumns=@JoinColumn(name="PRO_ID"),inverseJoinColumns=@JoinColumn(name="RUBR_ID"))
//	@Predicate(label="Lignes",type=RubriquePaie.class,target="many-to-many-list",group=true,groupName="group1",groupLabel="Rubriques")
//	private List<RubriquePaie> rubriques = new ArrayList<RubriquePaie>();
//	
	
	

	public ProfilPaielight(String code, String label, Etablissement societe, Boolean actif, String state,
			List<RubriquePaie> rubriques) {
		super();
		this.code = code;
		this.label = label;
	//	this.societe = societe;
		this.actif = actif;
		this.state = state;
		//this.rubriques = rubriques;
	}

	
	public ProfilPaielight(ProfilPaielight entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		this.label = entity.label;
		this.actif = entity.actif;
		this.state = entity.state;
	//	this.rubriques = new ArrayList<RubriquePaie>();
	}

	public ProfilPaielight() {
		// TODO Auto-generated constructor stub
	}


	public int compareTo(ProfilPaielight o) {
		// TODO Auto-generated method stub
		return 0;
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

//
//	public Etablissement getSociete() {
//		return societe;
//	}
//
//
//	public void setSociete(Etablissement societe) {
//		this.societe = societe;
//	}


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

//
//	public List<RubriquePaie> getRubriques() {
//		return rubriques;
//	}
//
//
//	public void setRubriques(List<RubriquePaie> rubriques) {
//		this.rubriques = rubriques;
//	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Profil de Paie";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Profil de  Paie";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"-"+label;
	}


}
