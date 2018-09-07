
package com.keren.posweb.dao.ifaces;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.posweb.model.User;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Sep 05 17:03:54 GMT+01:00 2018
 * 
 */
public interface UserDAO
    extends GenericDAO<User, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UserDAO";

}
