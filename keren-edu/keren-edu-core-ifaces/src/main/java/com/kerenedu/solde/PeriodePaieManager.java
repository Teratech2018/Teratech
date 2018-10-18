
package com.kerenedu.solde;

import java.util.Date;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Sep 10 15:39:11 WAT 2018
 * 
 */
public interface PeriodePaieManager
    extends GenericManager<PeriodePaie, Long>
{

    public final static String SERVICE_NAME = "PeriodePaieManager";
    /**
     * Retourne la periode contenant  
     * cette date
     * @param date
     * @return
     */
    public PeriodePaie getPeriodeFromDate(Date date);
}
