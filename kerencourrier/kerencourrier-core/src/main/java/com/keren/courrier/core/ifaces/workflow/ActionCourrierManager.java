
package com.keren.courrier.core.ifaces.workflow;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.workflow.ActionCourrier;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Thu Jul 19 08:33:21 GMT+01:00 2018
 * 
 */
public interface ActionCourrierManager
    extends GenericManager<ActionCourrier, Long>
{

    public final static String SERVICE_NAME = "ActionCourrierManager";

}
