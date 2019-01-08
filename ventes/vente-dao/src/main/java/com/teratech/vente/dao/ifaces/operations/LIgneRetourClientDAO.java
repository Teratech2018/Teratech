
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.LIgneRetourClient;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jan 05 17:28:31 WAT 2019
 * 
 */
public interface LIgneRetourClientDAO
    extends GenericDAO<LIgneRetourClient, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LIgneRetourClientDAO";

}
