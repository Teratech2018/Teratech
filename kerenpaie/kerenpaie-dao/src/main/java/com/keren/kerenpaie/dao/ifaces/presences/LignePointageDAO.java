
package com.keren.kerenpaie.dao.ifaces.presences;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.presences.LignePointage;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Apr 24 13:58:37 GMT+01:00 2018
 * 
 */
public interface LignePointageDAO
    extends GenericDAO<LignePointage, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LignePointageDAO";

}
