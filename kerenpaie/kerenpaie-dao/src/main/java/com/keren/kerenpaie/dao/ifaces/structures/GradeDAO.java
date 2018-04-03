
package com.keren.kerenpaie.dao.ifaces.structures;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.keren.kerenpaie.model.structures.Grade;


/**
 * Interface etendue par les interfaces locale et remote de la DAO
 * @since Fri Mar 30 16:53:39 GMT+01:00 2018
 * 
 */
public interface GradeDAO
    extends GenericDAO<Grade, Long>
{

    /**
     * Nom du service
     * 
     */
    public final static String SERVICE_NAME = "GradeDAO";

}
