
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Sep 04 10:23:04 WAT 2018
 * 
 */
public interface FichePaiementRetardManager
    extends GenericManager<FichePaiementRetard, Long>
{

    public final static String SERVICE_NAME = "FichePaiementRetardManager";

}
