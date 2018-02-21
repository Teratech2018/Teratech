
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.Transfert;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Feb 20 15:00:49 GMT+01:00 2018
 * 
 */
public interface TransfertManager
    extends GenericManager<Transfert, Long>
{

    public final static String SERVICE_NAME = "TransfertManager";

}
