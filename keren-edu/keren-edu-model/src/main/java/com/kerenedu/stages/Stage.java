/**
 * 
 */
package com.kerenedu.stages;

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
@DiscriminatorValue("BROU")
public class Stage extends BaseStage {

	

	/**
	 * 
	 */
	public Stage() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public Stage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public Stage(Stage dc) {
		super(dc);
	}
	
	
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "Brouillon");
			states.add(etat);
			etat = new State("encours", "EnCours");
			states.add(etat);
			etat = new State("terminer", "Cloturé");
			states.add(etat);
			
		return states;
	}


}
