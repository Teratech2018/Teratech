
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface AppreciationManager
    extends GenericManager<Appreciation, Long>
{

    public final static String SERVICE_NAME = "AppreciationManager";

}
