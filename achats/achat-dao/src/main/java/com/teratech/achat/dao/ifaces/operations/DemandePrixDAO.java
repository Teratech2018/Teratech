
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.DemandePrix;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 27 14:29:37 GMT+01:00 2018
 * 
 */
public interface DemandePrixDAO
    extends GenericDAO<DemandePrix, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DemandePrixDAO";

}
