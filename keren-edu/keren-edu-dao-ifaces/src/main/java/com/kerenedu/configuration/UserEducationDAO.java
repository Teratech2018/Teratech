
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jun 25 11:58:12 WAT 2018
 * 
 */
public interface UserEducationDAO
    extends GenericDAO<UserEducation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UserEducationDAO";

}
