
package com.kerenedu.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 09 13:39:29 CET 2018
 * 
 */
public interface DivisionStageManager
    extends GenericManager<DivisionStage, Long>
{

    public final static String SERVICE_NAME = "DivisionStageManager";

}
