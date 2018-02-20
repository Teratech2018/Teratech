
package com.kerenedu.personnel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jan 31 12:09:08 CET 2018
 * 
 */
public interface MatiereCoutProfDAO
    extends GenericDAO<MatiereCoutProf, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "MatiereCoutProfDAO";

}
