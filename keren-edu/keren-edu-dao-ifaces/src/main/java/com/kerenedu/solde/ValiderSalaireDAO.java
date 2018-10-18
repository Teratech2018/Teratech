
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Oct 18 05:36:43 WAT 2018
 * 
 */
public interface ValiderSalaireDAO
    extends GenericDAO<ValiderSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "ValiderSalaireDAO";

}
