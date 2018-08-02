
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierRecu;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jul 30 08:53:31 GMT+01:00 2018
 * 
 */
public interface CourrierRecuDAO
    extends GenericDAO<CourrierRecu, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierRecuDAO";

}
