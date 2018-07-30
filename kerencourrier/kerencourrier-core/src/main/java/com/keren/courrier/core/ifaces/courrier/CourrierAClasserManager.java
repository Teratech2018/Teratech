
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierAClasser;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 28 15:02:43 GMT+01:00 2018
 * 
 */
public interface CourrierAClasserManager
    extends GenericManager<CourrierAClasser, Long>
{

    public final static String SERVICE_NAME = "CourrierAClasserManager";

}
