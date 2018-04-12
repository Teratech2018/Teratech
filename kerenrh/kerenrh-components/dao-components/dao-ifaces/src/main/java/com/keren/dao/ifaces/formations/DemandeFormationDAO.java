
package com.keren.dao.ifaces.formations;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.formations.DemandeFormation;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface DemandeFormationDAO
    extends GenericDAO<DemandeFormation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DemandeFormationDAO";

}
