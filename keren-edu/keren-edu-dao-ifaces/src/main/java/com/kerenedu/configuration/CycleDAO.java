
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Jun 09 22:20:24 WAT 2018
 * 
 */
public interface CycleDAO
    extends GenericDAO<Cycle, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CycleDAO";

}
