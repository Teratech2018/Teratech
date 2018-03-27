
package com.keren.kerenpaie.dao.ifaces.employes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.employes.ContratTravail;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Mar 14 10:28:04 GMT+01:00 2018
 * 
 */
public interface ContratTravailDAO
    extends GenericDAO<ContratTravail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ContratTravailDAO";

}
