
package com.keren.dao.ifaces.formations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.formations.Formation;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Apr 11 16:28:46 GMT+01:00 2018
 * 
 */
public interface FormationDAO
    extends GenericDAO<Formation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FormationDAO";

}
