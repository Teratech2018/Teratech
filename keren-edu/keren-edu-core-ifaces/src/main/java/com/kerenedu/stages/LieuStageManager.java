
package com.kerenedu.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 15:07:04 CET 2018
 * 
 */
public interface LieuStageManager
    extends GenericManager<LieuStage, Long>
{

    public final static String SERVICE_NAME = "LieuStageManager";

}
