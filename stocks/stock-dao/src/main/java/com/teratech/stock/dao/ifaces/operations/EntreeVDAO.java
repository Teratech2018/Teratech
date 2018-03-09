
package com.teratech.stock.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.operations.EntreeV;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 22 09:04:43 GMT+01:00 2018
 * 
 */
public interface EntreeVDAO
    extends GenericDAO<EntreeV, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EntreeVDAO";

}
