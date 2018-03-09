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
@DiscriminatorValue("CLO")
public class StageCL extends BaseStage {

	

	/**
	 * 
	 */
	public StageCL() {
		// TODO Auto-generated constructor stub
		state = "cloturé";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public StageCL(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public StageCL(BaseStage dc) {
		super(dc);
		// TODO Auto-generated constructor stub
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
