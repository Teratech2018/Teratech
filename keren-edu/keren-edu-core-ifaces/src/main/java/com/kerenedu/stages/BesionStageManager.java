
package com.kerenedu.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Mar 08 15:07:04 CET 2018
 * 
 */
public interface BesionStageManager
    extends GenericManager<BesionStage, Long>
{

    public final static String SERVICE_NAME = "BesionStageManager";
    
    public BesionStage valide(BesionStage stage);

}
