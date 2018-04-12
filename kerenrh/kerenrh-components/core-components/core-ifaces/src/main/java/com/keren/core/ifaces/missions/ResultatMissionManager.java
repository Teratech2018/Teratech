
package com.keren.core.ifaces.missions;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.missions.ResultatMission;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 11 11:50:58 GMT+01:00 2018
 * 
 */
public interface ResultatMissionManager
    extends GenericManager<ResultatMission, Long>
{

    public final static String SERVICE_NAME = "ResultatMissionManager";

}
