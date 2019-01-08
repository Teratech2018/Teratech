
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.RetourClient;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jan 05 17:03:33 WAT 2019
 * 
 */
public interface RetourClientDAO
    extends GenericDAO<RetourClient, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RetourClientDAO";

}
