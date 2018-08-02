
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierARelancer;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 28 15:02:42 GMT+01:00 2018
 * 
 */
public interface CourrierARelancerDAO
    extends GenericDAO<CourrierARelancer, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierARelancerDAO";

}
