
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Jun 18 16:55:32 WAT 2018
 * 
 */
public interface TypeDepenseDAO
    extends GenericDAO<TypeDepense, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TypeDepenseDAO";

}
