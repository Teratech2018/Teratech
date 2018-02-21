
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.Sortie;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 13:26:04 GMT+01:00 2018
 * 
 */
public interface SortieManager
    extends GenericManager<Sortie, Long>
{

    public final static String SERVICE_NAME = "SortieManager";

}
