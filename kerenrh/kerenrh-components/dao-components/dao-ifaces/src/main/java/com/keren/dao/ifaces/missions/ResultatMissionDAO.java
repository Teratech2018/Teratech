
package com.keren.dao.ifaces.missions;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.missions.ResultatMission;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 11 11:50:58 GMT+01:00 2018
 * 
 */
public interface ResultatMissionDAO
    extends GenericDAO<ResultatMission, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ResultatMissionDAO";

}
