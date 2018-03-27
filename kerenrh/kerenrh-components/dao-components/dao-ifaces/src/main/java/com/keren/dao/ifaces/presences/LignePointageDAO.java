
package com.keren.dao.ifaces.presences;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.presences.LignePointage;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 14:18:53 GMT+01:00 2018
 * 
 */
public interface LignePointageDAO
    extends GenericDAO<LignePointage, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LignePointageDAO";

}
