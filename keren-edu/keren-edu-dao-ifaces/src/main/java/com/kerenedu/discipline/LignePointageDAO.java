
package com.kerenedu.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Oct 12 12:04:34 WAT 2018
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
