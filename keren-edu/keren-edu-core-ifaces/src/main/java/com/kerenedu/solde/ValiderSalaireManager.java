
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sun Nov 25 21:34:28 WAT 2018
 * 
 */
public interface ValiderSalaireManager
    extends GenericManager<ValiderSalaire, Long>
{

    public final static String SERVICE_NAME = "ValiderSalaireManager";

}
