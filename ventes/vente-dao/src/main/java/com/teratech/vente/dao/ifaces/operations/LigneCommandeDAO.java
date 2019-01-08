
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.LigneCommande;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 13:43:20 WAT 2019
 * 
 */
public interface LigneCommandeDAO
    extends GenericDAO<LigneCommande, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneCommandeDAO";

}
