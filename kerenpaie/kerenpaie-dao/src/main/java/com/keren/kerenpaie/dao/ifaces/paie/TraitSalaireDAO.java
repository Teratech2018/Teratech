
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.TraitSalaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Mon Mar 12 16:23:11 GMT+01:00 2018
 * 
 */
public interface TraitSalaireDAO
    extends GenericDAO<TraitSalaire, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "TraitSalaireDAO";

}
