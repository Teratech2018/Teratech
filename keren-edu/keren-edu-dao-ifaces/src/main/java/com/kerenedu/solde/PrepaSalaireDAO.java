
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 11 14:48:37 WAT 2018
 * 
 */
public interface PrepaSalaireDAO
    extends GenericDAO<PrepaSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PrepaSalaireDAO";

}
