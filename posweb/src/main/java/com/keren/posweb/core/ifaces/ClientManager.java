
package com.keren.posweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.model.Client;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Sep 06 10:58:46 GMT+01:00 2018
 * 
 */
public interface ClientManager
    extends GenericManager<Client, Long>
{

    public final static String SERVICE_NAME = "ClientManager";

}
