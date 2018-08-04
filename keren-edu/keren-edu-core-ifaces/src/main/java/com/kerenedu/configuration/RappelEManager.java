
package com.kerenedu.configuration;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jun 26 10:30:40 WAT 2018
 * 
 */
public interface RappelEManager
    extends GenericManager<RappelE, Long>
{

    public final static String SERVICE_NAME = "RappelEManager";

}
