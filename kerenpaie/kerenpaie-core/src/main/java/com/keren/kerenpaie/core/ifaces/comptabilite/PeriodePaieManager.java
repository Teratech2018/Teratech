
package com.keren.kerenpaie.core.ifaces.comptabilite;

import java.util.Date;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
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
