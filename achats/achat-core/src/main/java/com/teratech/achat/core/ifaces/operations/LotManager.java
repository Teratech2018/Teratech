
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 15:49:45 GMT+01:00 2018
 * 
 */
public interface LotManager
    extends GenericManager<Lot, Long>
{

    public final static String SERVICE_NAME = "LotManager";

}
