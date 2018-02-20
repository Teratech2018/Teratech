
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 08 14:05:19 CET 2018
 * 
 */
public interface ConfigMailDAO
    extends GenericDAO<ConfigMail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ConfigMailDAO";

}
