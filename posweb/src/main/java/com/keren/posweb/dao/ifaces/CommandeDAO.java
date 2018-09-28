
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.Commande;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Sep 06 10:32:17 GMT+01:00 2018
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
