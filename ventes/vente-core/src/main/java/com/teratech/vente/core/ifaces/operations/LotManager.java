
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jan 04 08:13:37 WAT 2019
 * 
 */
public interface LotManager
    extends GenericManager<Lot, Long>
{

    public final static String SERVICE_NAME = "LotManager";

}
