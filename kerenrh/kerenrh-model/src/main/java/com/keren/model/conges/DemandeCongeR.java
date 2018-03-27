/**
 * 
 */
package com.keren.model.conges;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author BEKO
 *
 */
@Entity
@DiscriminatorValue("REJET")
public class DemandeCongeR extends BaseDemandeConge {

	

	/**
	 * 
	 */
	public DemandeCongeR() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param designation
	 * @param moduleName
	 */
	public DemandeCongeR(long id, String designation, String moduleName) {
		super(id, designation, moduleName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dc
	 */
	public DemandeCongeR(BaseDemandeConge dc) {
		super(dc);
		// TODO Auto-generated constructor stub
	}	
	


}
