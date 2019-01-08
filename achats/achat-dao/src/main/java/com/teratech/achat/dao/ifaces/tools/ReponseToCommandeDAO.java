
package com.teratech.achat.dao.ifaces.tools;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.teratech.achat.model.tools.ReponseToCommande;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 22 18:51:42 WAT 2018
 * 
 */
public interface ReponseToCommandeDAO
    extends GenericDAO<ReponseToCommande, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ReponseToCommandeDAO";

}
