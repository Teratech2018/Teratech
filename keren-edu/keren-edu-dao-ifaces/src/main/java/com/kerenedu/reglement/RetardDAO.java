
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Mar 06 16:43:58 CET 2018
 * 
 */
public interface RetardDAO
    extends GenericDAO<Retard, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RetardDAO";

}
