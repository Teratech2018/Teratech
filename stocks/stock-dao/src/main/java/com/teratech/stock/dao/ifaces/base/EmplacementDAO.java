
package com.teratech.stock.dao.ifaces.base;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.stock.model.base.Emplacement;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 20 13:10:17 GMT+01:00 2018
 * 
 */
public interface EmplacementDAO
    extends GenericDAO<Emplacement, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EmplacementDAO";

}
