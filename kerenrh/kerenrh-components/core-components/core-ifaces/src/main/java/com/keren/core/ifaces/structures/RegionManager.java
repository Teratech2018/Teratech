
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.Region;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Feb 14 17:30:38 GMT+01:00 2018
 * 
 */
public interface RegionManager
    extends GenericManager<Region, Long>
{

    public final static String SERVICE_NAME = "RegionManager";

}
