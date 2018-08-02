
package com.kerenedu.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Jul 20 20:36:57 WAT 2018
 * 
 */
public interface LigneAbscenceDAO
    extends GenericDAO<LigneAbscence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneAbscenceDAO";

}
