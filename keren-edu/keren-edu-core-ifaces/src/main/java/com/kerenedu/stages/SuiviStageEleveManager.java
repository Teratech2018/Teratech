
package com.kerenedu.stages;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Fri Mar 09 15:56:30 CET 2018
 * 
 */
public interface SuiviStageEleveManager
    extends GenericManager<SuiviStageEleve, Long>
{

    public final static String SERVICE_NAME = "SuiviStageEleveManager";

}
