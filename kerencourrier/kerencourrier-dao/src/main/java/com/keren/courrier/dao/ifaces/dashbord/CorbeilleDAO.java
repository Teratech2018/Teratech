
package com.keren.courrier.dao.ifaces.dashbord;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.dashbord.Corbeille;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 19 17:21:52 GMT+01:00 2018
 * 
 */
public interface CorbeilleDAO
    extends GenericDAO<Corbeille, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CorbeilleDAO";

}
