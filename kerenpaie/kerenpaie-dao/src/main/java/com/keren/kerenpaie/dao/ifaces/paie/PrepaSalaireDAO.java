
package com.keren.kerenpaie.dao.ifaces.paie;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.paie.PrepaSalaire;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Thu Mar 08 16:41:23 GMT+01:00 2018
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
