
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.ValiderSalaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Tue Mar 13 16:31:04 GMT+01:00 2018
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
