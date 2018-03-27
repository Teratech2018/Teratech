
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.Region;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 17:30:38 GMT+01:00 2018
 * 
 */
public interface RegionDAO
    extends GenericDAO<Region, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RegionDAO";

}
