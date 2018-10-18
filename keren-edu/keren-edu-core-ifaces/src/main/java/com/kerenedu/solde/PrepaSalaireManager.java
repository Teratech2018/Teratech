
package com.kerenedu.solde;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Oct 11 14:48:37 WAT 2018
 * 
 */
public interface PrepaSalaireManager
    extends GenericManager<PrepaSalaire, Long>
{

    public final static String SERVICE_NAME = "PrepaSalaireManager";

}
