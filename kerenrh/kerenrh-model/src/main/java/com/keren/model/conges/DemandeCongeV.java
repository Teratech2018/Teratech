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
@DiscriminatorValue("VALID")
public class DemandeCongeV extends BaseDemandeConge {

	

	/**
	 * 
	 */
	public DemandeCongeV() {
		// TODO Auto-generated constructor stub
		super();
		state="valider";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeCongeV(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
		state="valider";
	}

	/**
	 * @param dc
	 */
	public DemandeCongeV(BaseDemandeConge dc) {
		super(dc);
		// TODO Auto-generated constructor stub
		state="valider";
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


}
