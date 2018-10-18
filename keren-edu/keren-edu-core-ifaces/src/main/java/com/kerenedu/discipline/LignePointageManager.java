
package com.kerenedu.discipline;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Oct 12 12:04:34 WAT 2018
 * 
 */
public interface LignePointageManager
    extends GenericManager<LignePointage, Long>
{

    public final static String SERVICE_NAME = "LignePointageManager";

}
