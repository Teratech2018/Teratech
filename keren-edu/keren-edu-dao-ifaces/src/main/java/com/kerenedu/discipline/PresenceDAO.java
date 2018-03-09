
package com.kerenedu.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface PresenceDAO
    extends GenericDAO<Presence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PresenceDAO";

}
