
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.BonReception;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 28 21:40:29 GMT+01:00 2018
 * 
 */
public interface BonReceptionDAO
    extends GenericDAO<BonReception, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BonReceptionDAO";

}
