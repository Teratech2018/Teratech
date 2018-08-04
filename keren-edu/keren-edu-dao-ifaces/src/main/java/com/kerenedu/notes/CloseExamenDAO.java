
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jul 21 15:37:15 WAT 2018
 * 
 */
public interface CloseExamenDAO
    extends GenericDAO<CloseExamen, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CloseExamenDAO";

}
