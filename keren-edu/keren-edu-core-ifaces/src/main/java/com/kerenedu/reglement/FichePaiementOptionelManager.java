
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Aug 24 09:40:04 WAT 2018
 * 
 */
public interface FichePaiementOptionelManager
    extends GenericManager<FichePaiementOptionel, Long>
{

    public final static String SERVICE_NAME = "FichePaiementOptionelManager";

}
