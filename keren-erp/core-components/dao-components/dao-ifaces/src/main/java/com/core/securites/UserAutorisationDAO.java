
package com.core.securites;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jan 07 12:29:52 WAT 2019
 * 
 */
public interface UserAutorisationDAO
    extends GenericDAO<UserAutorisation, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UserAutorisationDAO";

}
