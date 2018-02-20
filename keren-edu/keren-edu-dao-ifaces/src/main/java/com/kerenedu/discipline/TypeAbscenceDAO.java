
package com.kerenedu.discipline;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
public interface TypeAbscenceDAO
    extends GenericDAO<TypeAbscence, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TypeAbscenceDAO";

}
