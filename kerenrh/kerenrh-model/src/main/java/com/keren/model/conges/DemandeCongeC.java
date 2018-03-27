/**
 * 
 */
package com.keren.model.conges;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.core.base.State;

/**
 * @author BEKO
 *
 */
@Entity
@DiscriminatorValue("CONF")
public class DemandeCongeC extends BaseDemandeConge {

	

	/**
	 * 
	 */
	public DemandeCongeC() {
		// TODO Auto-generated constructor stub
		this.state = "confirmer";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeCongeC(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		this.state = "confirmer";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public DemandeCongeC(BaseDemandeConge dc) {
		super(dc);
		this.state = "confirmer";
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "A soumettre");
			states.add(etat);
			etat = new State("confirmer", "A approuvé");
			states.add(etat);
			etat = new State("valider", "Approuvé");
			states.add(etat);
		return states;
	}
	
	@Override
	public boolean isCreateonfield() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDesablecreate() {
		// TODO Auto-generated method stub
		return true;
	}


}
