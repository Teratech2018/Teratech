
package com.teratech.vente.core.ifaces.comptabilite;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.comptabilite.ModeReglement;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:37 WAT 2019
 * 
 */
public interface ModeReglementManager
    extends GenericManager<ModeReglement, Long>
{

    public final static String SERVICE_NAME = "ModeReglementManager";

}
