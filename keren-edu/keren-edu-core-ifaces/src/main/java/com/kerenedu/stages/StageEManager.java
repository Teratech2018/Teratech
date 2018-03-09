
package com.kerenedu.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 21:14:58 CET 2018
 * 
 */
public interface StageEManager
    extends GenericManager<StageE, Long>
{

    public final static String SERVICE_NAME = "StageEManager";
    
    public StageCL terminer(StageE stage) ;

}
