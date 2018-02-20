
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 08 14:05:19 CET 2018
 * 
 */
public interface ConfigMailManager
    extends GenericManager<ConfigMail, Long>
{

    public final static String SERVICE_NAME = "ConfigMailManager";

}
