
package com.keren.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.presences.FichePointage;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
public interface FichePointageManager
    extends GenericManager<FichePointage, Long>
{

    public final static String SERVICE_NAME = "FichePointageManager";

}
