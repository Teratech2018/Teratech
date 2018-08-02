
package com.kerenedu.school;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jun 11 02:42:49 WAT 2018
 * 
 */
public interface ResponsableDAO
    extends GenericDAO<Responsable, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ResponsableDAO";

}
