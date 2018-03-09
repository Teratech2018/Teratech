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
public enum EnmMois {
	JANVIER,
	FEVRIER,
	MARS,
	AVRIL,
	MAI,
	JUIN,
	JUIELLET,
	AOUT,
	SEPTEMBRE,
	OCTOBRE,
	NOVEMBRE,
	DECEMBRE;
	
	
	 
	private Map<String, EnmMois> map;
    private static List<EnmMois> list;

  

    public static List<EnmMois> getList() {
     	list = new ArrayList<EnmMois>();
        for (EnmMois enm : EnmMois.values()) {
            list.add(enm);
        }
        return list;
    }

}
