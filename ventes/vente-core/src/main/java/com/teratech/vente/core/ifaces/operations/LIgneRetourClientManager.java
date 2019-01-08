
package com.teratech.vente.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.vente.model.operations.LIgneRetourClient;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jan 05 17:28:31 WAT 2019
 * 
 */
public interface LIgneRetourClientManager
    extends GenericManager<LIgneRetourClient, Long>
{

    public final static String SERVICE_NAME = "LIgneRetourClientManager";

}
