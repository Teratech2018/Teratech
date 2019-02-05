
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 31 10:33:46 WAT 2019
 * 
 */
public interface ParaCoutMatiereDAO
    extends GenericDAO<ParaCoutMatiere, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ParaCoutMatiereDAO";

}
