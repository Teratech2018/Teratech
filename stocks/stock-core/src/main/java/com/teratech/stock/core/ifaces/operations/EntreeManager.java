
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.Entree;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 13:25:58 GMT+01:00 2018
 * 
 */
public interface EntreeManager
    extends GenericManager<Entree, Long>
{

    public final static String SERVICE_NAME = "EntreeManager";

}
