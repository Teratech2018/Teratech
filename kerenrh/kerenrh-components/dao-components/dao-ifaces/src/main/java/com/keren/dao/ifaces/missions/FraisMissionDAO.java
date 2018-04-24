
package com.keren.dao.ifaces.missions;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.missions.FraisMission;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 10 17:59:56 GMT+01:00 2018
 * 
 */
public interface FraisMissionDAO
    extends GenericDAO<FraisMission, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FraisMissionDAO";

}
