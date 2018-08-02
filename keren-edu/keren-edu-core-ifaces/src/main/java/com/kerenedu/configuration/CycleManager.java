
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jun 09 22:20:24 WAT 2018
 * 
 */
public interface CycleManager
    extends GenericManager<Cycle, Long>
{

    public final static String SERVICE_NAME = "CycleManager";

}
