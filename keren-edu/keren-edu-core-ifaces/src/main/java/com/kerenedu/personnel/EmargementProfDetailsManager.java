
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface EmargementProfDetailsManager
    extends GenericManager<EmargementProfDetails, Long>
{

    public final static String SERVICE_NAME = "EmargementProfDetailsManager";

}
