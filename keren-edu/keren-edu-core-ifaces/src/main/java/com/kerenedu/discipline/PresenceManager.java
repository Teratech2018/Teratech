
package com.kerenedu.discipline;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface PresenceManager
    extends GenericManager<Presence, Long>
{

    public final static String SERVICE_NAME = "PresenceManager";

}
