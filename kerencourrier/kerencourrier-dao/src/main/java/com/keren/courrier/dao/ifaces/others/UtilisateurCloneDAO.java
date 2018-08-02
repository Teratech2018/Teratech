
package com.keren.courrier.dao.ifaces.others;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.others.UtilisateurClone;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 26 12:15:35 GMT+01:00 2018
 * 
 */
public interface UtilisateurCloneDAO
    extends GenericDAO<UtilisateurClone, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UtilisateurCloneDAO";

}
