
package com.core.website;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Aug 22 13:33:13 GMT+01:00 2018
 * 
 */
public interface WebSiteModuleDAO
    extends GenericDAO<WebSiteModule, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "WebSiteModuleDAO";

}
