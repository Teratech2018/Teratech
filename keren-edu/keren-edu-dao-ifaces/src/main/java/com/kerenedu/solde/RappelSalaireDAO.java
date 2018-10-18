
package com.kerenedu.solde;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Oct 15 16:04:45 WAT 2018
 * 
 */
public interface RappelSalaireDAO
    extends GenericDAO<RappelSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "RappelSalaireDAO";

}
