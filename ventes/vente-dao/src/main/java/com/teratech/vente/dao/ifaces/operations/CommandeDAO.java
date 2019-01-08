
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.Commande;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 12:32:04 WAT 2019
 * 
 */
public interface CommandeDAO
    extends GenericDAO<Commande, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CommandeDAO";

}
