/**
 * 
 */
package com.kerenedu.configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.ModelBulletin;
import com.kerenedu.personnel.Professeur;
import com.kerenedu.reglement.Reglement;
import com.kerenedu.solde.PeriodePaie;

/**
 * @author BEKO
 *
 */
public class CacheMemory implements Serializable{

	/**
	 * 
	 */
	
	private static Map<Long, Map<TypeCacheMemory, Object>> cacheUser ;
	
	private static final long serialVersionUID = -5380964887951103704L;
	private static PeriodeScolaire  periode = null ;
	private static Filiere filiere = null;
	private static Classe classe = null;
	//private static ExamenP examenp = null;
	private static Examen examen = null;
	private static ModelBulletin modelBulletin = null ;
	private static List<Inscription> listdestinataire = null;
	
	private static Inscription incription =null;
	
	private static Reglement reglement =null;
	
	private static String currentannee = null;
	
	private static long curentcycle ;
	private static long currentuser =1;
	private static Etablissement currentSchool;
	
	private static Professeur prof = null;
	
	private static String currentNameStudent = new String();
	private static String currentMatricule = null;
	
	private static PeriodePaie periodepaie = null ;
	
	private static CacheMemory _instance ;

	/**
	 * 
	 */
	private  CacheMemory() {
		// TODO Auto-generated constructor stub
		cacheUser  = new HashMap<>();
	}
	public static void init(){
		filiere = null;
		classe = null;
		examen = null;
		incription =null;
		reglement =null;
		currentannee = null;
		curentcycle =0;
		currentuser =1;
		prof = null;
		currentNameStudent = null;
		currentMatricule = null;
	}

	/**
	 * 
	 * @param id
	 * @param type
	 * @param value
	 */
	public static synchronized void insert(long id , TypeCacheMemory type , Object value){
		getinstance();
		if(!cacheUser.containsKey(id)){
			Map<TypeCacheMemory,Object> map = new HashMap<TypeCacheMemory,Object>();
			map.put(type, value);
			cacheUser.put(id, map);
		}else{
			cacheUser.get(id).put(type, value);
		}//end if(!cacheUser.containsKey(id)){
	}
	
	private static synchronized CacheMemory getinstance(){
		if(_instance!=null) return _instance;
		//New instance if not exists
		_instance = new CacheMemory();
		return _instance;
	}
	/**
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public static synchronized Object getValue(long id , TypeCacheMemory type){
		if(!cacheUser.containsKey(id)) return null;
		if(cacheUser!=null){
			return cacheUser.get(id).get(type) ;
		}else{
			return null;
		}
		
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

	public static String getCurrentannee() {
		return currentannee;
	}

	public static void setCurrentannee(String currentannee) {
		CacheMemory.currentannee = currentannee;
	}

	public static List<Inscription> getListdestinataire() {
		return listdestinataire;
	}

	public static void setListdestinataire(List<Inscription> listdestinataire) {
		CacheMemory.listdestinataire = listdestinataire;
	}

	public static synchronized void setExamen(Examen examen) {
		CacheMemory.examen = examen;
	}

	public static Reglement getReglement() {
		return reglement;
	}

	public static Inscription getIncription() {
		return incription;
	}

	public static void setIncription(Inscription incription) {
		CacheMemory.incription = incription;
	}

	public static long getCurentcycle() {
		return curentcycle;
	}

	public static long getCurrentuser() {
		return currentuser;
	}

	public static void setCurrentuser(long currentuser) {
		CacheMemory.currentuser = currentuser;
	}

	public static void setCurentcycle(long curentcyclle) {
		CacheMemory.curentcycle = curentcyclle;
	}

	public static void setReglement(Reglement reglement) {
		CacheMemory.reglement = reglement;
	}
	
	public static String getCurrentNameStudent() {
		return currentNameStudent;
	}

	public static String getCurrentMatricule() {
		return currentMatricule;
	}

	public static void setCurrentMatricule(String currentMatricule) {
		CacheMemory.currentMatricule = currentMatricule;
	}

	public static void setCurrentNameStudent(String currentNameStudent) {
		CacheMemory.currentNameStudent = currentNameStudent;
	}




	public static PeriodePaie getPeriodepaie() {
		return periodepaie;
	}
	public static void setPeriodepaie(PeriodePaie periodepaie) {
		CacheMemory.periodepaie = periodepaie;
	}
	public static List<Predicat> defaultPredicats(){
		List<Predicat> predicats = new ArrayList<Predicat>();
	RestrictionsContainer container = RestrictionsContainer.newInstance();

	if (CacheMemory.getCurrentannee() != null) {
		System.out.println("CacheMemory.defaultPredicats() current date "+CacheMemory.getCurrentannee());
		container.addGe("anneScolaire",  CacheMemory.getCurrentannee());
	}
	predicats.addAll(container.getPredicats());
	return predicats ;
	}
	
	public static Etablissement getCurrentSchool() {
		return currentSchool;
	}
//
//	public static ExamenP getExamenp() {
//		return examenp;
//	}
//	public static void setExamenp(ExamenP examenp) {
//		CacheMemory.examenp = examenp;
//	}
	public static void setCurrentSchool(Etablissement currentSchool) {
		CacheMemory.currentSchool = currentSchool;
	}

	public static Map<Long, Map<TypeCacheMemory, Object>> getCacheUser() {
		return cacheUser;
	}
	public static void setCacheUser(Map<Long, Map<TypeCacheMemory, Object>> cacheUser) {
		CacheMemory.cacheUser = cacheUser;
	}
	public static List<Predicat> defaultPredicatsCycleAnnee(){
		List<Predicat> predicats = new ArrayList<Predicat>();
	RestrictionsContainer container = RestrictionsContainer.newInstance();
	System.out.println("CacheMemory.defaultPredicatsCycleAnnee() current exercice is "+CacheMemory.getCurrentannee());
	if (CacheMemory.getCurrentannee() != null) {
		container.addEq("anneScolaire",  CacheMemory.getCurrentannee());
	}
//	if (CacheMemory.getCurentcycle() != 0) {
//		container.addEq("cycle",  CacheMemory.getCurentcycle());
//	}
	
	predicats.addAll(container.getPredicats());
	return predicats ;
	}
	
	public static List<Predicat> defaultPredicatsCycle(){
	List<Predicat> predicats = new ArrayList<Predicat>();
	RestrictionsContainer container = RestrictionsContainer.newInstance();

	if (CacheMemory.getCurentcycle() != 0) {
		container.addEq("cycle",  CacheMemory.getCurentcycle());
	}
	predicats.addAll(container.getPredicats());
	return predicats ;
	}
	
	
	
	

}
