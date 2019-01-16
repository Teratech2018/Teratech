
package com.core.application;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jan 15 09:12:53 WAT 2019
 * 
 */
public interface ConfigItemManager
    extends GenericManager<ConfigItem, Long>
{

    public final static String SERVICE_NAME = "ConfigItemManager";

}
