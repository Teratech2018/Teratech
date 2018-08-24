
package com.core.website;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Aug 22 20:59:04 GMT+01:00 2018
 * 
 */
public interface WebSiteComponentManager
    extends GenericManager<WebSiteComponent, Long>
{

    public final static String SERVICE_NAME = "WebSiteComponentManager";

}
