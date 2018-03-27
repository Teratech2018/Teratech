
package com.keren.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.model.structures.Specialite;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Wed Feb 14 14:12:28 GMT+01:00 2018
 * 
 */
public interface SpecialiteDAO
    extends GenericDAO<Specialite, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "SpecialiteDAO";

}
