
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.Facture;


/**
 * Interface etendue par les interfaces locale et remote du manager

 * @since Fri Mar 02 11:43:27 GMT+01:00 2018
 * 
 */
public interface CMDEFactureTMPManager
    extends GenericManager<Facture, Long>
{

    public final static String SERVICE_NAME = "CMDEFactureTMPManager";

}
