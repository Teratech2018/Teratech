
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.LigneDocumentAchat;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 02 15:27:16 GMT+01:00 2018
 * 
 */
public interface LigneDocumentAchatDAO
    extends GenericDAO<LigneDocumentAchat, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneDocumentAchatDAO";

}
