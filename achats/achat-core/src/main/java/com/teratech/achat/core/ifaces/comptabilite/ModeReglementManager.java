
package com.teratech.achat.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.comptabilite.ModeReglement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Mar 05 23:39:42 GMT+01:00 2018
 * 
 */
public interface ModeReglementManager
    extends GenericManager<ModeReglement, Long>
{

    public final static String SERVICE_NAME = "ModeReglementManager";

}
