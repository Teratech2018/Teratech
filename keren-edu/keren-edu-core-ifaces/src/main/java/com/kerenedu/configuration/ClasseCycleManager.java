
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Sep 25 15:48:42 WAT 2018
 * 
 */
public interface ClasseCycleManager
    extends GenericManager<ClasseCycle, Long>
{

    public final static String SERVICE_NAME = "ClasseCycleManager";

}
