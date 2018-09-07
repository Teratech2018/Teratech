
package com.keren.posweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.model.User;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Sep 05 17:03:54 GMT+01:00 2018
 * 
 */
public interface UserManager
    extends GenericManager<User, Long>
{

    public final static String SERVICE_NAME = "UserManager";

}
