
package com.core.application;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 22 08:53:30 WAT 2019
 * 
 */
public interface ResourceRegistryDAO
    extends GenericDAO<ResourceRegistry, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ResourceRegistryDAO";

}
