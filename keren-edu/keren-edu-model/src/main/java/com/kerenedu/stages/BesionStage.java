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
public class BesionStage extends BaseBesionStage {

	

	/**
	 * 
	 */
	public BesionStage() {
		// TODO Auto-generated constructor stub
		state = "etabli";
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public BesionStage(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		state = "etabli";
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public BesionStage(BaseBesionStage dc) {
		super(dc);
		// TODO Auto-generated constructor stub
		//state = "etabli";
	}
	
	
	
	@Override
	public List<State> getStates() {
		// TODO Auto-generated method stub
			List<State> states = new ArrayList<State>();
			State etat = new State("etabli", "Brouillon");
			states.add(etat);
			etat = new State("valider", "Validé");
			states.add(etat);
			
		return states;
	}


}
