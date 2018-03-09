
package com.teratech.achat.core.ifaces.operations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.teratech.achat.model.operations.LigneDocumentAchat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 02 15:27:17 GMT+01:00 2018
 * 
 */
public interface LigneDocumentAchatManager
    extends GenericManager<LigneDocumentAchat, Long>
{

    public final static String SERVICE_NAME = "LigneDocumentAchatManager";

}
