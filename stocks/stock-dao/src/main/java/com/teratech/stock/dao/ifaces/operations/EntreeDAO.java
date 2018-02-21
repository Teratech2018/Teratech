
package com.teratech.stock.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.operations.Entree;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 20 13:25:57 GMT+01:00 2018
 * 
 */
public interface EntreeDAO
    extends GenericDAO<Entree, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EntreeDAO";

}
