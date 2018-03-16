
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Mar 07 17:04:44 CET 2018
 * 
 */
public interface FichePaiementProfManager
    extends GenericManager<FichePaiementProf, Long>
{

    public final static String SERVICE_NAME = "FichePaiementProfManager";

}
