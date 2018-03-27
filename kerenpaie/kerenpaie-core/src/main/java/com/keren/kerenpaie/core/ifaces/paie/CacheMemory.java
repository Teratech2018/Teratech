/**
 * 
 */
package com.keren.kerenpaie.core.ifaces.paie;

import java.io.Serializable;

import com.keren.kerenpaie.model.comptabilite.PeriodePaie;

/**
 * @author BEKO
 *
 */
public class CacheMemory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5330383985561898027L;
	
	private static PeriodePaie periode = null ;

	/**
	 * 
	 */
	public CacheMemory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get the currentPeriode
	 * @return
	 */
	public static synchronized PeriodePaie getPeriode() {
		return periode;
	}

	/**
	 * Set the currentPeriode
	 * @param periode
	 */
	public static synchronized void setPeriode(PeriodePaie periode) {
		CacheMemory.periode = periode;
	}
	
	

}
