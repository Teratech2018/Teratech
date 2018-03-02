
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 01 15:49:45 GMT+01:00 2018
 * 
 */
public interface LotDAO
    extends GenericDAO<Lot, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LotDAO";

}
