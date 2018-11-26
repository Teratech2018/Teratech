
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Sun Nov 25 21:34:28 WAT 2018
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
