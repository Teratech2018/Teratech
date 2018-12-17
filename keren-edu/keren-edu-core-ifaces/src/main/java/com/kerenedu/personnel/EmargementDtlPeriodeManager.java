
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Dec 06 15:23:28 WAT 2018
 * 
 */
public interface EmargementDtlPeriodeManager
    extends GenericManager<EmargementDtlPeriode, Long>
{

    public final static String SERVICE_NAME = "EmargementDtlPeriodeManager";

}
