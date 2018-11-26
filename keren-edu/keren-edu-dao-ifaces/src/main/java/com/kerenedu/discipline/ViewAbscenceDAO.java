
package com.kerenedu.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Nov 26 15:38:38 WAT 2018
 * 
 */
public interface ViewAbscenceDAO
    extends GenericDAO<ViewAbscence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ViewAbscenceDAO";

}
