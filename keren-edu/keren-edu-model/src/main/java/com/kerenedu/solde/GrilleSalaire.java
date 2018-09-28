/**
 * 
 */
package com.kerenedu.solde;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.core.base.BaseElement;
import com.core.base.State;
import com.megatim.common.annotations.Predicate;

/**
 * @author Nadege
 *
 */
@Entity
@Table(name = "e_gsal")
public class GrilleSalaire extends BaseElement implements Serializable, Comparable<GrilleSalaire> {

	// @Predicate(label="Intutilé",updatable=false,optional=false,search=true)
	private String code;

	@ManyToOne
	@JoinColumn(name = "RUB_ID")
	@Predicate(label = "Rubique", type = RubriquePaie.class, target = "many-to-one", updatable = false, optional = false, search = true, sequence = 1)
	private RubriquePaie rubrique;

	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.LAZY)
	@JoinColumn(name="GRILLE_ID")
	@Predicate(label="Grille Salaire",type=LigneGrilleSalaire.class,target="one-to-many",edittable=true,group=true,groupLabel="Grille Salaire",groupName="group1")
	private List<LigneGrilleSalaire> ligne = new ArrayList<LigneGrilleSalaire>();
	
	private String state = "etabli";
	
	
	

	public GrilleSalaire(String code, RubriquePaie rubrique, List<LigneGrilleSalaire> ligne, String state) {
		super();
		this.code = code;
		this.rubrique = rubrique;
		this.ligne = ligne;
		this.state = state;
	}

	

	public GrilleSalaire(GrilleSalaire entity) {
		super(entity.id, entity.designation, entity.moduleName,0L);
		this.code = entity.code;
		if(entity.rubrique!=null){
			this.rubrique = new RubriquePaie(entity.rubrique);	
		}
		this.ligne = new ArrayList<LigneGrilleSalaire>();
		this.state = entity.state;
	}
	public GrilleSalaire() {
		// TODO Auto-generated constructor stub
	}



	public int compareTo(GrilleSalaire o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	
	public RubriquePaie getRubrique() {
		return rubrique;
	}

	public void setRubrique(RubriquePaie rubrique) {
		this.rubrique = rubrique;
	}

	public List<LigneGrilleSalaire> getIndicessolde() {
		return ligne;
	}

	public void setIndicessolde(List<LigneGrilleSalaire> ligne) {
		this.ligne = ligne;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
		List<State> states = new ArrayList<State>();
		State state = new State("etabli", "Brouillon");
		states.add(state);
		state = new State("active", "Actif");
		states.add(state);
		state = new State("inactive", "Inactif");
		states.add(state);
		return states;
	}

	@Override
	public String getEditTitle() {
		// TODO Auto-generated method stub
		return "Grille des Salaire";
	}

	@Override
	public String getListTitle() {
		// TODO Auto-generated method stub
		return "Grille des Salaire";
	}

	@Override
	public String getModuleName() {
		// TODO Auto-generated method stub
		return "kereneducation";
	}

	@Override
	public String getDesignation() {
		// TODO Auto-generated method stub
		return code +"";
	}



}
