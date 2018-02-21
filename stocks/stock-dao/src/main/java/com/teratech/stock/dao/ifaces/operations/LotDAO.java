
package com.teratech.stock.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 20 13:10:17 GMT+01:00 2018
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
