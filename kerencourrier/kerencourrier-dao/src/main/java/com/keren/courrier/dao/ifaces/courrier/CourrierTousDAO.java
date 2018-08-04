
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierTous;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 31 15:26:58 GMT+01:00 2018
 * 
 */
public interface CourrierTousDAO
    extends GenericDAO<CourrierTous, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierTousDAO";

}
