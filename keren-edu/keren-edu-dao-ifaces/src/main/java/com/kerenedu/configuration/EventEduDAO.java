
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jun 25 10:28:19 WAT 2018
 * 
 */
public interface EventEduDAO
    extends GenericDAO<EventEdu, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "EventEduDAO";

}
