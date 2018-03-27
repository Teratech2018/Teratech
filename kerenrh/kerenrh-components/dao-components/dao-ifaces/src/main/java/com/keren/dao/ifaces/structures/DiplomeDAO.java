
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.Diplome;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 14:12:56 GMT+01:00 2018
 * 
 */
public interface DiplomeDAO
    extends GenericDAO<Diplome, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "DiplomeDAO";

}
