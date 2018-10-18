
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 18 05:36:43 WAT 2018
 * 
 */
public interface ValiderSalaireManager
    extends GenericManager<ValiderSalaire, Long>
{

    public final static String SERVICE_NAME = "ValiderSalaireManager";

}
