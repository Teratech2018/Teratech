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
public enum EnmJoursCours {
	LUNDI,
	MARDI,
	MERCREDI,
	JEUDI,
	VENDREDI,
	SAMEDI;
	
	private Map<String, EnmJoursCours> map;
    private static List<EnmJoursCours> list;

  

    public static List<EnmJoursCours> getList() {
    	list = new ArrayList<EnmJoursCours>();
        for (EnmJoursCours enm : EnmJoursCours.values()) {
            list.add(enm);
        }
        return list;
    }

}
