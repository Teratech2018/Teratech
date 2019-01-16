
package com.core.application;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 15 09:12:52 WAT 2019
 * 
 */
public interface ConfigItemDAO
    extends GenericDAO<ConfigItem, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ConfigItemDAO";

}
