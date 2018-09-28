
package com.kerenedu.personnel;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Sep 07 17:10:43 WAT 2018
 * 
 */
public interface ProfFichePaieManager
    extends GenericManager<ProfFichePaie, Long>
{

    public final static String SERVICE_NAME = "ProfFichePaieManager";

}
