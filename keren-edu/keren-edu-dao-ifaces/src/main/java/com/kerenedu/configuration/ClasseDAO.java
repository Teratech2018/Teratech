
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 11 10:03:43 WAT 2018
 * 
 */
public interface ClasseDAO
    extends GenericDAO<Classe, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ClasseDAO";

}
