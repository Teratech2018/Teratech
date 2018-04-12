
package com.keren.core.ifaces.formations;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.model.formations.GenererBesionFormation;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Apr 11 15:59:27 GMT+01:00 2018
 * 
 */
public interface GenererBesionFormationManager
    extends GenericManager<GenererBesionFormation, Long>
{

    public final static String SERVICE_NAME = "GenererBesionFormationManager";

}
