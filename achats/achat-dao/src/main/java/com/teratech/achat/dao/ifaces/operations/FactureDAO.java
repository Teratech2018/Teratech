
package com.teratech.achat.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.operations.Facture;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 02 08:22:57 GMT+01:00 2018
 * 
 */
public interface FactureDAO
    extends GenericDAO<Facture, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FactureDAO";

}
