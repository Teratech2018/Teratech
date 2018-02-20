
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
public interface MatiereDAO
    extends GenericDAO<Matiere, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "MatiereDAO";

}
