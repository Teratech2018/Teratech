
package com.basaccount.dao.ifaces.achats;

import com.basaccount.model.achats.Facture;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Mar 14 21:10:26 GMT+01:00 2018
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
