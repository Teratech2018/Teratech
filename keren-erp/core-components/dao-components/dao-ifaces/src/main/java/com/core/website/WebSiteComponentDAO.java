
package com.core.website;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Aug 22 20:59:02 GMT+01:00 2018
 * 
 */
public interface WebSiteComponentDAO
    extends GenericDAO<WebSiteComponent, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "WebSiteComponentDAO";

}
