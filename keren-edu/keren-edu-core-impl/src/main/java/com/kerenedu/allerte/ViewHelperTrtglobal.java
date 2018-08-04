/**
 * 
 */
package com.kerenedu.allerte;

import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.school.Eleve;

/**
 * @author Nadege
 *
 */
public class ViewHelperTrtglobal {

	
	 
	 public static String getMatricule(Eleve eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
}
