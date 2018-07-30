
package com.keren.courrier.dao.ifaces.workflow;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.workflow.ActionCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jul 19 08:33:20 GMT+01:00 2018
 * 
 */
public interface ActionCourrierDAO
    extends GenericDAO<ActionCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ActionCourrierDAO";

}
