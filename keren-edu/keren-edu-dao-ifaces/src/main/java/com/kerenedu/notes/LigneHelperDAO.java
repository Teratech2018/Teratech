
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Dec 14 14:50:32 WAT 2018
 * 
 */
public interface LigneHelperDAO
    extends GenericDAO<LigneHelper, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "LigneHelperDAO";

}
