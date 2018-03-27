
package com.keren.core.ifaces.discipline;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.discipline.ReponseDE;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Feb 15 16:33:29 GMT+01:00 2018
 * 
 */
public interface ReponseDEManager
    extends GenericManager<ReponseDE, Long>
{

    public final static String SERVICE_NAME = "ReponseDEManager";

}
