/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;

import com.kerenedu.notes.Examen;
import com.kerenedu.notes.ModelBulletin;
import com.kerenedu.personnel.Professeur;

/**
 * @author BEKO
 *
 */
public class CacheMemory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5380964887951103704L;
	private static PeriodeScolaire  periode = null ;
	private static Filiere filiere = null;
	private static Classe classe = null;
	private static Examen examen = null;
	private static ModelBulletin modelBulletin = null ;
	
	private static Professeur prof = null;

	/**
	 * 
	 */
	private  CacheMemory() {
		// TODO Auto-generated constructor stub
	}

	public static synchronized PeriodeScolaire getPeriode() {
		return periode;
	}

	public static synchronized void setPeriode(PeriodeScolaire periode) {
		CacheMemory.periode = periode;
	}

	public static synchronized Filiere getFiliere() {
		return filiere;
	}

	public static synchronized void   setFiliere(Filiere filiere) {
		CacheMemory.filiere = filiere;
	}

	public static synchronized Classe getClasse() {
		return classe;
	}

	public static synchronized void setClasse(Classe classe) {
		CacheMemory.classe = classe;
	}

	public static synchronized Professeur getProf() {
		return prof;
	}

	public static synchronized void   setProf(Professeur prof) {
		CacheMemory.prof = prof;
	}

	public static synchronized ModelBulletin getModelBulletin() {
		return modelBulletin;
	}

	public static synchronized  void setModelBulletin(ModelBulletin modelBulletin) {
		CacheMemory.modelBulletin = modelBulletin;
	}

	public static synchronized Examen getExamen() {
		return examen;
	}

	public static synchronized void setExamen(Examen examen) {
		CacheMemory.examen = examen;
	}
	
	
	

}
