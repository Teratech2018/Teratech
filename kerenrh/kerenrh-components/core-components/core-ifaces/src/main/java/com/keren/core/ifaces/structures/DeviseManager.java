
package com.keren.core.ifaces.structures;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.structures.Devise;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Feb 16 13:42:05 GMT+01:00 2018
 * 
 */
public interface DeviseManager
    extends GenericManager<Devise, Long>
{

    public final static String SERVICE_NAME = "DeviseManager";

}
