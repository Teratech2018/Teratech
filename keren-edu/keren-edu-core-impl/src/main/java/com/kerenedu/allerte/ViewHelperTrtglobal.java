/**
 * 
 */
package com.kerenedu.allerte;

import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.personnel.EnseignantPM;
import com.kerenedu.personnel.EnseignantSecondaire;
import com.kerenedu.personnel.Professeur;
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
	 
	 public static String getMatricule(EnseignantPM eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
	 
	 public static String getMatricule(EnseignantSecondaire eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
	 public static String getMatricule(Professeur eleve , AnneScolaire annee){
		 String matricule = "M"+eleve.getId()+"/"+annee.getCode();
		 
		 return matricule;
	 }
}
