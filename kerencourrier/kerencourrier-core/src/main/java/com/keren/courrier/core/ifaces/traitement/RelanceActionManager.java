
package com.keren.courrier.core.ifaces.traitement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.traitement.RelanceAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Tue Jul 31 08:24:48 WAT 2018
 * 
 */
public interface RelanceActionManager
    extends GenericManager<RelanceAction, Long>
{

    public final static String SERVICE_NAME = "RelanceActionManager";

}
