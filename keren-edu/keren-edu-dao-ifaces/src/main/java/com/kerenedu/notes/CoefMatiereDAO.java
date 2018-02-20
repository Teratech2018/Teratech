
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
public interface CoefMatiereDAO
    extends GenericDAO<CoefMatiere, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CoefMatiereDAO";

}
