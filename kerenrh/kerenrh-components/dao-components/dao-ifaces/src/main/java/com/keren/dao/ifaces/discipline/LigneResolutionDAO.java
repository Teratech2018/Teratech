
package com.keren.dao.ifaces.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.discipline.LigneResolution;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Feb 16 11:11:47 GMT+01:00 2018
 * 
 */
public interface LigneResolutionDAO
    extends GenericDAO<LigneResolution, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneResolutionDAO";

}
