
package com.kerenedu.configuration;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Feb 12 14:36:23 CET 2018
 * 
 */
public interface UniteEnsDAO
    extends GenericDAO<UniteEns, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "UniteEnsDAO";

}
