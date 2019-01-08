
package com.teratech.vente.dao.ifaces.operations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.vente.model.operations.BonLivraison;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jan 04 21:35:59 WAT 2019
 * 
 */
public interface BonLivraisonDAO
    extends GenericDAO<BonLivraison, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "BonLivraisonDAO";

}
