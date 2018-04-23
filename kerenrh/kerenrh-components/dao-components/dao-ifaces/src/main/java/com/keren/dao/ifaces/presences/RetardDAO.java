
package com.keren.dao.ifaces.presences;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.presences.Retard;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Apr 23 09:28:00 GMT+01:00 2018
 * 
 */
public interface RetardDAO
    extends GenericDAO<Retard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RetardDAO";

}
