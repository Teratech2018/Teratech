
package com.keren.posweb.core.ifaces;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.posweb.model.UniteAchat;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Sep 04 17:34:18 GMT+01:00 2018
 * 
 */
public interface UniteAchatManager
    extends GenericManager<UniteAchat, Long>
{

    public final static String SERVICE_NAME = "UniteAchatManager";

}
