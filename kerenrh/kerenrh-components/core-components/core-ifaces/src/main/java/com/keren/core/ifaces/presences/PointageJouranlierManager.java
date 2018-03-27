
package com.keren.core.ifaces.presences;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.presences.PointageJouranlier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
public interface PointageJouranlierManager
    extends GenericManager<PointageJouranlier, Long>
{

    public final static String SERVICE_NAME = "PointageJouranlierManager";

}
