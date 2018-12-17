
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Dec 14 14:50:33 WAT 2018
 * 
 */
public interface LigneHelperManager
    extends GenericManager<LigneHelper, Long>
{

    public final static String SERVICE_NAME = "LigneHelperManager";

}
