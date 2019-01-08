
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.Facture;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jan 05 23:43:04 WAT 2019
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
