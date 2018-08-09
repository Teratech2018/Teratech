
package com.keren.courrier.dao.ifaces.referentiel;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.courrier.model.referentiel.EventCourrier;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Jul 31 12:08:43 WAT 2018
 * 
 */
public interface EventCourrierDAO
    extends GenericDAO<EventCourrier, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EventCourrierDAO";

}
