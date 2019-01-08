
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.RetourClient;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jan 05 17:03:33 WAT 2019
 * 
 */
public interface RetourClientManager
    extends GenericManager<RetourClient, Long>
{

    public final static String SERVICE_NAME = "RetourClientManager";

}
