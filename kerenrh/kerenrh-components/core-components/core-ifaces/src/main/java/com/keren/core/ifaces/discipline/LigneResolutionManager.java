
package com.keren.core.ifaces.discipline;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.discipline.LigneResolution;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Feb 16 11:11:47 GMT+01:00 2018
 * 
 */
public interface LigneResolutionManager
    extends GenericManager<LigneResolution, Long>
{

    public final static String SERVICE_NAME = "LigneResolutionManager";

}
