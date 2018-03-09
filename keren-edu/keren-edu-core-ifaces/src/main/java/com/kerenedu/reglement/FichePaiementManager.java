
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Mar 06 16:43:58 CET 2018
 * 
 */
public interface FichePaiementManager
    extends GenericManager<FichePaiement, Long>
{

    public final static String SERVICE_NAME = "FichePaiementManager";

}
