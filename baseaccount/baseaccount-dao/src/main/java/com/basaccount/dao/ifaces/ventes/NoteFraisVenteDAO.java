
package com.basaccount.dao.ifaces.ventes;

import com.basaccount.model.ventes.NoteFraisVente;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 15 23:13:05 WAT 2019
 * 
 */
public interface NoteFraisVenteDAO
    extends GenericDAO<NoteFraisVente, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "NoteFraisVenteDAO";

}
