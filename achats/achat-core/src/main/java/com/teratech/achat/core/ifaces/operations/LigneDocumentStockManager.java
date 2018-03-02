
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.LigneDocumentStock;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 01 15:22:49 GMT+01:00 2018
 * 
 */
public interface LigneDocumentStockManager
    extends GenericManager<LigneDocumentStock, Long>
{

    public final static String SERVICE_NAME = "LigneDocumentStockManager";

}
