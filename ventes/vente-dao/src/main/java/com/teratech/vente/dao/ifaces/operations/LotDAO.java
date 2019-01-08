
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.Lot;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 08:13:34 WAT 2019
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
