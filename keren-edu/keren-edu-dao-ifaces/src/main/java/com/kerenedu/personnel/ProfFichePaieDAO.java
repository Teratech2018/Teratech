
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Sep 07 17:10:43 WAT 2018
 * 
 */
public interface ProfFichePaieDAO
    extends GenericDAO<ProfFichePaie, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ProfFichePaieDAO";

}
