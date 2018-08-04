
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 09 14:41:43 WAT 2018
 * 
 */
public interface ServiceFilliereDAO
    extends GenericDAO<ServiceFilliere, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ServiceFilliereDAO";

}
