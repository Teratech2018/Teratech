
package com.keren.dao.ifaces.formations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.formations.SeanceFormation;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface SeanceFormationDAO
    extends GenericDAO<SeanceFormation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SeanceFormationDAO";

}
