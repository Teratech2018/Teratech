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
@DiscriminatorValue("VAL")
public class BesionStageV extends BaseBesionStage {

	

	/**
	 * 
	 */
	public BesionStageV() {
		// TODO Auto-generated constructor stub
		state = "valider";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BesionStageV(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		state = "valider";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public BesionStageV(BaseBesionStage dc) {
		super(dc);
		// TODO Auto-generated constructor stub
		state = "valider";
	}
	
	
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "Brouillon");
			states.add(etat);
			etat = new State("valider", "Validée");
			states.add(etat);
			
		return states;
	}


}
