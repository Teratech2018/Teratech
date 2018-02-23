
package com.teratech.stock.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.stock.model.operations.TransfertV;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 22 09:04:44 GMT+01:00 2018
 * 
 */
public interface TransfertVManager
    extends GenericManager<TransfertV, Long>
{

    public final static String SERVICE_NAME = "TransfertVManager";

}
