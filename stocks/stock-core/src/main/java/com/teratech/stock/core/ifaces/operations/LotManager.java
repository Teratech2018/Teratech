
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 13:10:17 GMT+01:00 2018
 * 
 */
public interface LotManager
    extends GenericManager<Lot, Long>
{

    public final static String SERVICE_NAME = "LotManager";

}
