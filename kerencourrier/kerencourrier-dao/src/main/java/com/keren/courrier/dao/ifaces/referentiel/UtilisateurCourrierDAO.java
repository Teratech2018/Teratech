
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 26 09:18:54 GMT+01:00 2018
 * 
 */
public interface UtilisateurCourrierDAO
    extends GenericDAO<UtilisateurCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UtilisateurCourrierDAO";

}
