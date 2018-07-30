
package com.keren.courrier.core.ifaces.workflow;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.courrier.model.workflow.WorkflowAction;


/**
 * Interface etendue par les interfaces locale et remote du manager
 * @since Wed Jul 18 17:18:15 GMT+01:00 2018
 * 
 */
public interface WorkflowActionManager
    extends GenericManager<WorkflowAction, Long>
{

    public final static String SERVICE_NAME = "WorkflowActionManager";

}
