
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.Devise;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Feb 16 13:42:05 GMT+01:00 2018
 * 
 */
public interface DeviseDAO
    extends GenericDAO<Devise, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DeviseDAO";

}
