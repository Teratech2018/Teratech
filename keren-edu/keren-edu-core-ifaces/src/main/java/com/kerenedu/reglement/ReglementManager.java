
package com.kerenedu.reglement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Mon Jan 22 15:28:57 WAT 2018
 * 
 */
public interface ReglementManager
    extends GenericManager<Reglement, Long>
{

    public final static String SERVICE_NAME = "ReglementManager";

}
