
package com.core.website;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Aug 22 13:33:14 GMT+01:00 2018
 * 
 */
public interface WebSiteModuleManager
    extends GenericManager<WebSiteModule, Long>
{

    public final static String SERVICE_NAME = "WebSiteModuleManager";

}
