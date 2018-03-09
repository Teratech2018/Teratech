
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.LigneDocumentStock;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 01 15:22:49 GMT+01:00 2018
 * 
 */
public interface LigneDocumentStockDAO
    extends GenericDAO<LigneDocumentStock, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneDocumentStockDAO";

}
