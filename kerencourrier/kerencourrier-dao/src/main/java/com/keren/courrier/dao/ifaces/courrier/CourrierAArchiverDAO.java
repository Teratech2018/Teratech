
package com.keren.courrier.dao.ifaces.courrier;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.courrier.CourrierAArchiver;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Aug 23 14:35:50 WAT 2018
 * 
 */
public interface CourrierAArchiverDAO
    extends GenericDAO<CourrierAArchiver, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CourrierAArchiverDAO";

}
