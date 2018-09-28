
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Sep 25 15:48:42 WAT 2018
 * 
 */
public interface ClasseCycleDAO
    extends GenericDAO<ClasseCycle, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClasseCycleDAO";

}
