/**
 * 
 */
package com.core.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Nadege
 *
 */
public enum EnmHeureCours {
	PLAGEA("8:00","10:00"),
	PLAGEB("10:00","12:00"),
	PLAGEC("12:00","14:00"),
	PLAGED("14:00","16:00");
	
	
	  private final String hdeb;
	  
	  private final String hfin;

	    /**
	     * Constructeur parametre
	     *
	     * @param name Nom de l'état
	     */
	    private EnmHeureCours(String hdeb,String hfin) {

	        this.hdeb = hdeb;
	        this.hfin = hfin;

	    }

	    /**
	     * Methode d'obtention du nom du fichier de l'état (sans extension)
	     *
	     * @return Nom de l'etat
	     */
	    public String getHfin() {

	        return hfin;
	    }
	    public String getHdeb() {

	        return hdeb;
	    }
	private Map<String, EnmHeureCours> map;
    private static List<EnmHeureCours> list;

  

    public static List<EnmHeureCours> getList() {
     	list = new ArrayList<EnmHeureCours>();
        for (EnmHeureCours enm : EnmHeureCours.values()) {
            list.add(enm);
        }
        return list;
    }

}
