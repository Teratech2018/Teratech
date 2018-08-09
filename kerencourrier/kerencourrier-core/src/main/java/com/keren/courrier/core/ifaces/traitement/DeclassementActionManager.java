
package com.keren.courrier.core.ifaces.traitement;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.traitement.DeclassementAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Aug 01 17:08:49 GMT+01:00 2018
 * 
 */
public interface DeclassementActionManager
    extends GenericManager<DeclassementAction, Long>
{

    public final static String SERVICE_NAME = "DeclassementActionManager";

}
