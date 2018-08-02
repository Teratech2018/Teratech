
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.Courrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jul 18 10:58:41 GMT+01:00 2018
 * 
 */
public interface CourrierDAO
    extends GenericDAO<Courrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierDAO";

}
