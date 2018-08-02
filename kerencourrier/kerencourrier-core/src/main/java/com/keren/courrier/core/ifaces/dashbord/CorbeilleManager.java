
package com.keren.courrier.core.ifaces.dashbord;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.dashbord.Corbeille;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 19 17:21:53 GMT+01:00 2018
 * 
 */
public interface CorbeilleManager
    extends GenericManager<Corbeille, Long>
{

    public final static String SERVICE_NAME = "CorbeilleManager";

}
