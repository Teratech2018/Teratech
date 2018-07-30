
package com.keren.courrier.dao.ifaces.workflow;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.workflow.WorkflowAction;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Jul 18 17:18:15 GMT+01:00 2018
 * 
 */
public interface WorkflowActionDAO
    extends GenericDAO<WorkflowAction, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "WorkflowActionDAO";

}
