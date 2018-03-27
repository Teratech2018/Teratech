
package com.keren.dao.ifaces.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.discipline.TraitementDE;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 16:33:28 GMT+01:00 2018
 * 
 */
public interface TraitementDEDAO
    extends GenericDAO<TraitementDE, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TraitementDEDAO";

}
