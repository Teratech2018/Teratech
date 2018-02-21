
package com.teratech.stock.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.operations.Transfert;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 20 15:00:49 GMT+01:00 2018
 * 
 */
public interface TransfertDAO
    extends GenericDAO<Transfert, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TransfertDAO";

}
