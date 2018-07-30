
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierRecu;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jul 30 08:53:31 GMT+01:00 2018
 * 
 */
public interface CourrierRecuManager
    extends GenericManager<CourrierRecu, Long>
{

    public final static String SERVICE_NAME = "CourrierRecuManager";

}
