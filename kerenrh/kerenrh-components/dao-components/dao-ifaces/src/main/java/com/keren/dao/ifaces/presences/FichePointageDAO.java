
package com.keren.dao.ifaces.presences;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.presences.FichePointage;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
public interface FichePointageDAO
    extends GenericDAO<FichePointage, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FichePointageDAO";

}
