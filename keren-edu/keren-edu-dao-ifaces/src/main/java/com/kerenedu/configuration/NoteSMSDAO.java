
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 08 11:01:55 CET 2018
 * 
 */
public interface NoteSMSDAO
    extends GenericDAO<NoteSMS, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NoteSMSDAO";

}
