
package com.kerenedu.notes;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 09:44:41 CET 2018
 * 
 */
public interface CoefMatiereDetailDAO
    extends GenericDAO<CoefMatiereDetail, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CoefMatiereDetailDAO";

}
