
package com.core.application;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO

 * @since Tue Jan 29 13:33:02 WAT 2019
 * 
 */
public interface ServiceRegistryDAO
    extends GenericDAO<ServiceRegistry, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ServiceRegistryDAO";
    
//     public ServiceRegistry getService(String servicename);

}
