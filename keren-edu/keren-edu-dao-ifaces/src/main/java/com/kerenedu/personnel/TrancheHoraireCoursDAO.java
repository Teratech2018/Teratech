
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jan 31 17:41:19 CET 2018
 * 
 */
public interface TrancheHoraireCoursDAO
    extends GenericDAO<TrancheHoraireCours, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TrancheHoraireCoursDAO";

}
