
package com.kerenedu.reglement;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Jan 25 00:49:48 CET 2018
 * 
 */
public interface CaisseDAO
    extends GenericDAO<Caisse, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "CaisseDAO";

}
