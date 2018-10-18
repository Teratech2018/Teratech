
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Oct 15 16:04:46 WAT 2018
 * 
 */
public interface RappelSalaireManager
    extends GenericManager<RappelSalaire, Long>
{

    public final static String SERVICE_NAME = "RappelSalaireManager";
    public RappelSalaire confirme(RappelSalaire entity,PeriodePaie periode);
}
