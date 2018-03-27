
package com.keren.dao.ifaces.conges;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.conges.DemandeCongeV;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
public interface DemandeCongeVDAO
    extends GenericDAO<DemandeCongeV, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DemandeCongeVDAO";

}
