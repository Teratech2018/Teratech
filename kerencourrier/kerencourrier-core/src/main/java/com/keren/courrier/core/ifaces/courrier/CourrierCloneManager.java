
package com.keren.courrier.core.ifaces.courrier;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.courrier.CourrierClone;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Jul 27 15:52:41 GMT+01:00 2018
 * 
 */
public interface CourrierCloneManager
    extends GenericManager<CourrierClone, Long>
{

    public final static String SERVICE_NAME = "CourrierCloneManager";

}
