
package com.keren.kerenpaie.dao.ifaces.employes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.employes.Fonction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 01 10:22:25 GMT+01:00 2018
 * 
 */
public interface FonctionDAO
    extends GenericDAO<Fonction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "FonctionDAO";

}
