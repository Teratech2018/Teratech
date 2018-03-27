
package com.keren.kerenpaie.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieClose;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 15:05:28 GMT+01:00 2018
 * 
 */
public interface PeriodePaieCloseManager
    extends GenericManager<PeriodePaieClose, Long>
{

    public final static String SERVICE_NAME = "PeriodePaieCloseManager";

}
