
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.Pays;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 17:30:38 GMT+01:00 2018
 * 
 */
public interface PaysDAO
    extends GenericDAO<Pays, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "PaysDAO";

}
