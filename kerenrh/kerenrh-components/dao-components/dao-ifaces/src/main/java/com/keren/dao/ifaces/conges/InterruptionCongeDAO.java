
package com.keren.dao.ifaces.conges;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.conges.InterruptionConge;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Feb 15 11:54:14 GMT+01:00 2018
 * 
 */
public interface InterruptionCongeDAO
    extends GenericDAO<InterruptionConge, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "InterruptionCongeDAO";

}
