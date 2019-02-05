
package com.core.application;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Tue Jan 29 13:33:02 WAT 2019
 * 
 */
public interface ServiceRegistryManager
    extends GenericManager<ServiceRegistry, Long>
{

    public final static String SERVICE_NAME = "ServiceRegistryManager";
    
    /**
     * 
     * @param servicename
     * @return 
     */
    public ServiceRegistry getService(String servicename);

}
