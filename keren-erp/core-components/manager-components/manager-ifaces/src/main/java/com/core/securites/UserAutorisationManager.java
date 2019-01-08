
package com.core.securites;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jan 07 12:29:52 WAT 2019
 * 
 */
public interface UserAutorisationManager
    extends GenericManager<UserAutorisation, Long>
{

    public final static String SERVICE_NAME = "UserAutorisationManager";

}
