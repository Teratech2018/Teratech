
package com.kerenedu.notes;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Sat Jul 21 15:37:15 WAT 2018
 * 
 */
public interface CloseExamenManager
    extends GenericManager<CloseExamen, Long>
{

    public final static String SERVICE_NAME = "CloseExamenManager";

}
