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
@DiscriminatorValue("ASOU")
public class DemandeConge extends BaseDemandeConge {

	

	/**
	 * 
	 */
	public DemandeConge() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeConge(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		state = "etabli";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public DemandeConge(BaseDemandeConge dc) {
		super(dc);
		// TODO Auto-generated constructor stub
		state = "etabli";
	}
	
	
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "A soumettre");
			states.add(etat);
			etat = new State("confirmer", "A approuvé");
			states.add(etat);
			
		return states;
	}


}
