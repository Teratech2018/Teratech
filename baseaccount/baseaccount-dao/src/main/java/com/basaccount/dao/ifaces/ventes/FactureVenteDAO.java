
package com.basaccount.dao.ifaces.ventes;

import com.basaccount.model.ventes.FactureVente;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 15 20:58:52 WAT 2019
 * 
 */
public interface FactureVenteDAO
    extends GenericDAO<FactureVente, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FactureVenteDAO";

}
